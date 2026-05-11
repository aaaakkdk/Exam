package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Subject;


public class SubjectDao {

    private final String URL = "jdbc:mysql://localhost:3306/school";
    private final String USER = "root";
    private final String PASS = "password";

    public List<Subject> findBySchool(String schoolCd) {

        List<Subject> list = new ArrayList<>();

        String sql = "SELECT subject_id, subject_name FROM subject WHERE school_cd = ?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, schoolCd);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Subject subject = new Subject();
                subject.setSubjectId(rs.getString("subject_id"));
                subject.setSubjectName(rs.getString("subject_name"));

                list.add(subject);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

	public Object findAll() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public Object filter(School school) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}