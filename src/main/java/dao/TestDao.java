package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TestDao extends Dao {

	public boolean save(

			String studentNo,
			String subjectCd,
			int count,
			int point,
			String schoolCd)

			throws Exception {

		Connection connection =
				getConnection();

		PreparedStatement statement =
				null;

		int result = 0;

		try {

			statement =
					connection.prepareStatement(

							"insert into test "
							+ "(student_no,"
							+ "subject_cd,"
							+ "no,"
							+ "point,"
							+ "school_cd)"
							+ " values"
							+ "(?,?,?,?,?)"

					);

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
					schoolCd);

			result =
					statement.executeUpdate();

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
}