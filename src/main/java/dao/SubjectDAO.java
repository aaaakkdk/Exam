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

        List<Subject> list = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:h2:~/exam", "sa", ""
            );

            // ★ SCHOOL_CDで絞る
            String sql = "SELECT * FROM SUBJECT WHERE SCHOOL_CD = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "S1");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Subject(
                    rs.getString("SCHOOL_CD"),
                    rs.getInt("CD"),
                    rs.getString("NAME")
                ));
            }

            System.out.println(list); // 確認用

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}