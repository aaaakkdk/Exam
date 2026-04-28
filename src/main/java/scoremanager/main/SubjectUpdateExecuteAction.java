package scoremanager.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Subject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class SubjectUpdateExecuteAction extends Action {

	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		req.setCharacterEncoding("UTF-8");

		String oldSchoolCd = req.getParameter("oldSchoolCd");
		String oldCd = req.getParameter("oldCd");

		String schoolCd = req.getParameter("schoolCd");
		String cd = req.getParameter("cd");
		String name = req.getParameter("name");

		Subject subject = new Subject(schoolCd, cd, name);
		req.setAttribute("subject", subject);

		if (schoolCd == null || schoolCd.isEmpty()
				|| cd == null || cd.isEmpty()
				|| name == null || name.isEmpty()) {

			req.setAttribute("error", "すべて入力してください。");
			req.getRequestDispatcher("/scoremanager/main/subjectUpdate.jsp")
				.forward(req, res);
			return;
		}

		if (cd.length() != 3) {
			req.setAttribute("error", "科目コードは3文字で入力してください。");
			req.getRequestDispatcher("/scoremanager/main/subjectUpdate.jsp")
				.forward(req, res);
			return;
		}

		boolean keyChanged = !oldSchoolCd.equals(schoolCd) || !oldCd.equals(cd);

		if (keyChanged) {
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
					req.getRequestDispatcher("/scoremanager/main/subjectUpdate.jsp")
						.forward(req, res);
					return;
				}

				rs.close();
			}
		}

		try (
			Connection con = DriverManager.getConnection(
				"jdbc:h2:tcp://localhost/~/exam", "sa", ""
			);
			PreparedStatement ps = con.prepareStatement(
				"UPDATE SUBJECT SET SCHOOL_CD = ?, CD = ?, NAME = ? WHERE SCHOOL_CD = ? AND CD = ?"
			)
		) {
			ps.setString(1, schoolCd);
			ps.setString(2, cd);
			ps.setString(3, name);
			ps.setString(4, oldSchoolCd);
			ps.setString(5, oldCd);

			ps.executeUpdate();
		}

		res.sendRedirect("SubjectList.action");
	}
}