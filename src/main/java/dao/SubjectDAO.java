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
                "jdbc:h2:tcp://localhost/~/exam", "sa", ""
            );

            String sql = "SELECT * FROM SUBJECT";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Subject(
                    rs.getString("SCHOOL_CD"),
                    rs.getString("CD"),   // ← ここが重要
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