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

        List<Subject> list = new ArrayList<>();

        try {

            Connection conn = DriverManager.getConnection(
                "jdbc:h2:tcp://localhost/~/exam",
                "sa",
                ""
            );

            String sql = "SELECT * FROM SUBJECT";

            PreparedStatement ps = conn.prepareStatement(sql);

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

    // 削除
    public void delete(String schoolCd, String cd) {

        try {

            Connection conn = DriverManager.getConnection(
                "jdbc:h2:tcp://localhost/~/exam",
                "sa",
                ""
            );

            String sql =
                "DELETE FROM SUBJECT WHERE SCHOOL_CD = ? AND CD = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, schoolCd);
            ps.setString(2, cd);

            ps.executeUpdate();

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

public Subject findById(String schoolCd, String cd) {

    Subject subject = null;

    try {

        Connection conn = DriverManager.getConnection(
            "jdbc:h2:tcp://localhost/~/exam",
            "sa",
            ""
        );

        String sql =
            "SELECT * FROM SUBJECT WHERE SCHOOL_CD = ? AND CD = ?";

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

    } catch (Exception e) {
        e.printStackTrace();
    }

    return subject;
}
}