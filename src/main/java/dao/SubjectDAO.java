package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Subject;

public class SubjectDAO {

	public List<Subject> findAll() {
		return search(null, null, null);
	}

	public List<Subject> search(String schoolCd, String cd, String name) {

		List<Subject> list = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(
				"jdbc:h2:tcp://localhost/~/exam", "sa", ""
			);

			String sql = "SELECT * FROM SUBJECT WHERE 1 = 1";

			if (schoolCd != null && !schoolCd.isEmpty()) {
				sql += " AND SCHOOL_CD LIKE ?";
			}

			if (cd != null && !cd.isEmpty()) {
				sql += " AND CD LIKE ?";
			}

			if (name != null && !name.isEmpty()) {
				sql += " AND NAME LIKE ?";
			}

			PreparedStatement ps = conn.prepareStatement(sql);

			int index = 1;

			if (schoolCd != null && !schoolCd.isEmpty()) {
				ps.setString(index, "%" + schoolCd + "%");
				index++;
			}

			if (cd != null && !cd.isEmpty()) {
				ps.setString(index, "%" + cd + "%");
				index++;
			}

			if (name != null && !name.isEmpty()) {
				ps.setString(index, "%" + name + "%");
				index++;
			}

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Subject(
					rs.getString("SCHOOL_CD"),
					rs.getString("CD"),
					rs.getString("NAME")
				));
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}