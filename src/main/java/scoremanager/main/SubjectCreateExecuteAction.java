package scoremanager.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Subject;
import dao.Dao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class SubjectCreateExecuteAction extends Action {

	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		req.setCharacterEncoding("UTF-8");

		String cdStr = req.getParameter("cd");
		String name = req.getParameter("name");

		req.setAttribute("cd", cdStr);
		req.setAttribute("name", name);

		if (cdStr == null || cdStr.isEmpty() || name == null || name.isEmpty()) {
			req.setAttribute("error", "科目コードと科目名を入力してください。");
			req.getRequestDispatcher("/scoremanager/main/subjectCreate.jsp")
				.forward(req, res);
			return;
		}

		int cd;

		try {
			cd = Integer.parseInt(cdStr);
		} catch (NumberFormatException e) {
			req.setAttribute("error", "科目コードは数字で入力してください。");
			req.getRequestDispatcher("/scoremanager/main/subjectCreate.jsp")
				.forward(req, res);
			return;
		}

		Dao dao = new Dao();

		try (
			Connection con = dao.getConnection();
			PreparedStatement checkPs = con.prepareStatement(
				"SELECT * FROM SUBJECT WHERE SCHOOL_CD = ? AND CD = ?"
			)
		) {
			checkPs.setString(1, "S1");
			checkPs.setInt(2, cd);

			ResultSet rs = checkPs.executeQuery();

			if (rs.next()) {
				req.setAttribute("error", "科目コードが重複しています。");
				req.getRequestDispatcher("/scoremanager/main/subjectCreate.jsp")
					.forward(req, res);
				return;
			}
		}

		Subject subject = new Subject("S1", cd, name);

		try (
			Connection con = dao.getConnection();
			PreparedStatement ps = con.prepareStatement(
				"INSERT INTO SUBJECT (SCHOOL_CD, CD, NAME) VALUES (?, ?, ?)"
			)
		) {
			ps.setString(1, subject.getSchoolCd());
			ps.setInt(2, subject.getCd());
			ps.setString(3, subject.getName());

			ps.executeUpdate();
		}

		res.sendRedirect("SubjectList.action");
	}
}