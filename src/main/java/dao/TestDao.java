package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import bean.Test;

public class TestDao extends Dao {

	/**
	 * 成績登録
	 */
	public boolean save(
			String studentNo,
			String subjectCd,
			int count,
			int point,
			String classNum,
			String schoolCd)
			throws Exception {

		Connection connection =
				getConnection();

		PreparedStatement statement =
				null;

		int result = 0;

		try {

			// 既存確認
			String checkSql =
					"select * from test "
					+ "where student_no=? "
					+ "and subject_cd=? "
					+ "and no=?";

			statement =
					connection.prepareStatement(
							checkSql);

			statement.setString(
					1,
					studentNo);

			statement.setString(
					2,
					subjectCd);

			statement.setInt(
					3,
					count);

			ResultSet rs =
					statement.executeQuery();

			// UPDATE
			if(rs.next()) {

				statement.close();

				String updateSql =
						"update test "
						+ "set point=? "
						+ "where student_no=? "
						+ "and subject_cd=? "
						+ "and no=?";

				statement =
						connection.prepareStatement(
								updateSql);

				statement.setInt(
						1,
						point);

				statement.setString(
						2,
						studentNo);

				statement.setString(
						3,
						subjectCd);

				statement.setInt(
						4,
						count);

				result =
						statement.executeUpdate();
			}

			// INSERT
			else {

				statement.close();

				String insertSql =
						"insert into test "
						+ "(student_no,"
						+ "subject_cd,"
						+ "no,"
						+ "point,"
						+ "class_num,"
						+ "school_cd)"
						+ " values "
						+ "(?,?,?,?,?,?)";

				statement =
						connection.prepareStatement(
								insertSql);

				statement.setString(
						1,
						studentNo);

				statement.setString(
						2,
						subjectCd);

				statement.setInt(
						3,
						count);

				statement.setInt(
						4,
						point);

				statement.setString(
						5,
						classNum);

				statement.setString(
						6,
						schoolCd);

				result =
						statement.executeUpdate();
			}

		} finally {

			if(statement != null) {
				statement.close();
			}

			if(connection != null) {
				connection.close();
			}
		}

		return result > 0;
	}

	/**
	 * 成績登録画面検索
	 */
	public List<Test> filter(
			int entYear,
			String classNum,
			String subjectCd,
			int count,
			String schoolCd)
			throws Exception {

		List<Test> list =
				new ArrayList<>();

		Connection connection =
				getConnection();

		PreparedStatement statement =
				null;

		ResultSet rs =
				null;

		try {

			String sql =
					"select "
					+ "s.no,"
					+ "s.name,"
					+ "s.ent_year,"
					+ "s.class_num,"
					+ "t.point "
					+ "from student s "
					+ "left join test t "
					+ "on s.no=t.student_no "
					+ "and t.subject_cd=? "
					+ "and t.no=? "
					+ "where s.ent_year=? "
					+ "and s.class_num=? "
					+ "and s.school_cd=? "
					+ "order by s.no";

			statement =
					connection.prepareStatement(
							sql);

			statement.setString(
					1,
					subjectCd);

			statement.setInt(
					2,
					count);

			statement.setInt(
					3,
					entYear);

			statement.setString(
					4,
					classNum);

			statement.setString(
					5,
					schoolCd);

			rs =
					statement.executeQuery();

			while(rs.next()) {

				Test test =
						new Test();

				Student student =
						new Student();

				student.setNo(
						rs.getString(
								"no"));

				student.setName(
						rs.getString(
								"name"));

				student.setEntYear(
						rs.getInt(
								"ent_year"));

				student.setClassNum(
						rs.getString(
								"class_num"));

				test.setStudent(
						student);

				int p =
						rs.getInt(
								"point");

				if(rs.wasNull()) {

					test.setPoint(
							0);

				} else {

					test.setPoint(
							p);
				}

				list.add(
						test);
			}

		} finally {

			if(rs != null) {
				rs.close();
			}

			if(statement != null) {
				statement.close();
			}

			if(connection != null) {
				connection.close();
			}
		}

		return list;
	}

	/**
	 * 成績参照一覧
	 */
	public List<Test> filterAll(
			int entYear,
			String classNum,
			String subjectCd,
			String schoolCd)
			throws Exception {

		List<Test> list =
				new ArrayList<>();

		Connection connection =
				getConnection();

		PreparedStatement statement =
				null;

		ResultSet rs =
				null;

		try {

			String sql =
					"select "
					+ "s.no as student_no,"
					+ "s.name,"
					+ "s.ent_year,"
					+ "s.class_num,"

					+ "max(case when t.no=1 "
					+ "then t.point end) as point1,"

					+ "max(case when t.no=2 "
					+ "then t.point end) as point2 "

					+ "from student s "

					+ "left join test t "
					+ "on s.no=t.student_no "
					+ "and t.subject_cd=? "

					+ "where s.ent_year=? "
					+ "and s.class_num=? "
					+ "and s.school_cd=? "

					+ "group by "
					+ "s.no,"
					+ "s.name,"
					+ "s.ent_year,"
					+ "s.class_num "

					+ "order by s.no";

			statement =
					connection.prepareStatement(
							sql);

			statement.setString(
					1,
					subjectCd);

			statement.setInt(
					2,
					entYear);

			statement.setString(
					3,
					classNum);

			statement.setString(
					4,
					schoolCd);

			rs =
					statement.executeQuery();

			while(rs.next()) {

				Test test =
						new Test();

				Student student =
						new Student();

				student.setNo(
						rs.getString(
								"student_no"));

				student.setName(
						rs.getString(
								"name"));

				student.setEntYear(
						rs.getInt(
								"ent_year"));

				student.setClassNum(
						rs.getString(
								"class_num"));

				test.setStudent(
						student);

				// 1回目
				if(rs.getObject(
						"point1") != null) {

					test.setPoint(
							rs.getInt(
									"point1"));
				}

				// 2回目
				if(rs.getObject(
						"point2") != null) {

					test.setPoint2(
							rs.getInt(
									"point2"));
				}

				list.add(
						test);
			}

		} finally {

			if(rs != null) {
				rs.close();
			}

			if(statement != null) {
				statement.close();
			}

			if(connection != null) {
				connection.close();
			}
		}

		return list;
	}
}