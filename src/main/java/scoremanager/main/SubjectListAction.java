package scoremanager.main;

import java.util.List;

import bean.Subject;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class SubjectListAction extends Action {

    public void execute(HttpServletRequest req, HttpServletResponse res) {

        try {
            // DAO
            SubjectDAO dao = new SubjectDAO();
            List<Subject> list = dao.findAll();

            // データ渡す
            req.setAttribute("subjects", list);

            // JSPへ遷移
            req.getRequestDispatcher("/scoremanager/main/subjectList.jsp")
               .forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}