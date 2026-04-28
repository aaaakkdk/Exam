package scoremanager.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Subject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class SubjectUpdateAction extends Action {

	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		String schoolCd = req.getParameter("schoolCd");
		String cd = req.getParameter("cd");

		try (
			Connection con = DriverManager.getConnection(
				"jdbc:h2:tcp://localhost/~/exam", "sa", ""
			);
			PreparedStatement ps = con.prepareStatement(
				"SELECT * FROM SUBJECT WHERE SCHOOL_CD = ? AND CD = ?"
			)
		) {
			ps.setString(1, schoolCd);
			ps.setString(2, cd);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Subject subject = new Subject(
					rs.getString("SCHOOL_CD"),
					rs.getString("CD"),
					rs.getString("NAME")
				);

				req.setAttribute("subject", subject);
			}

			rs.close();
		}

		req.getRequestDispatcher("/scoremanager/main/subjectUpdate.jsp")
			.forward(req, res);
	}
}