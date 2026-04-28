package scoremanager.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Subject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class SubjectCreateExecuteAction extends Action {

	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		req.setCharacterEncoding("UTF-8");

		String schoolCd = req.getParameter("schoolCd");
		String cd = req.getParameter("cd");
		String name = req.getParameter("name");

		req.setAttribute("schoolCd", schoolCd);
		req.setAttribute("cd", cd);
		req.setAttribute("name", name);

		if (schoolCd == null || schoolCd.isEmpty()
				|| cd == null || cd.isEmpty()
				|| name == null || name.isEmpty()) {

			req.setAttribute("error", "すべて入力してください。");
			req.getRequestDispatcher("/scoremanager/main/subjectCreate.jsp")
				.forward(req, res);
			return;
		}

		try (
			Connection con = DriverManager.getConnection(
				"jdbc:h2:tcp://localhost/~/exam", "sa", ""
			);
			PreparedStatement checkPs = con.prepareStatement(
				"SELECT * FROM SUBJECT WHERE SCHOOL_CD = ? AND CD = ?"
			)
		) {
			checkPs.setString(1, schoolCd);
			checkPs.setString(2, cd);

			ResultSet rs = checkPs.executeQuery();

			if (rs.next()) {
				req.setAttribute("error", "科目コードが重複しています。");
				req.getRequestDispatcher("/scoremanager/main/subjectCreate.jsp")
					.forward(req, res);
				return;
			}

			rs.close();
		}

		Subject subject = new Subject(schoolCd, cd, name);

		try (
			Connection con = DriverManager.getConnection(
				"jdbc:h2:tcp://localhost/~/exam", "sa", ""
			);
			PreparedStatement ps = con.prepareStatement(
				"INSERT INTO SUBJECT (SCHOOL_CD, CD, NAME) VALUES (?, ?, ?)"
			)
		) {
			ps.setString(1, subject.getSchoolCd());
			ps.setString(2, subject.getCd());
			ps.setString(3, subject.getName());

			ps.executeUpdate();
		}

		res.sendRedirect("SubjectList.action");
	}
}