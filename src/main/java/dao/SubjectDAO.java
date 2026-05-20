package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Subject;

public class SubjectDAO {

	// 一覧取得
	public List<Subject> findAll() {
		return search(null, null, null);
	}

	// 検索
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

	// 1件取得
	public Subject findById(String schoolCd, String cd) throws Exception {

		Subject subject = null;

		Connection conn = DriverManager.getConnection(
			"jdbc:h2:tcp://localhost/~/exam", "sa", ""
		);

		String sql = "SELECT * FROM SUBJECT WHERE SCHOOL_CD = ? AND CD = ?";

		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, schoolCd);
		ps.setString(2, cd);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			subject = new Subject(
				rs.getString("SCHOOL_CD"),
				rs.getString("CD"),
				rs.getString("NAME")
			);
		}

		rs.close();
		ps.close();
		conn.close();

		return subject;
	}

	// 登録
	public boolean save(Subject subject) throws Exception {

		Connection conn = DriverManager.getConnection(
			"jdbc:h2:tcp://localhost/~/exam", "sa", ""
		);

		String sql =
			"INSERT INTO SUBJECT (SCHOOL_CD, CD, NAME) VALUES (?, ?, ?)";

		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, subject.getSchoolCd());
		ps.setString(2, subject.getCd());
		ps.setString(3, subject.getName());

		int count = ps.executeUpdate();

		ps.close();
		conn.close();

		return count > 0;
	}

	// 削除
	public boolean delete(String schoolCd, String cd) throws Exception {

		Connection conn = DriverManager.getConnection(
			"jdbc:h2:tcp://localhost/~/exam", "sa", ""
		);

		String sql =
			"DELETE FROM SUBJECT WHERE SCHOOL_CD = ? AND CD = ?";

		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, schoolCd);
		ps.setString(2, cd);

		int count = ps.executeUpdate();

		ps.close();
		conn.close();

		return count > 0;
	}
}