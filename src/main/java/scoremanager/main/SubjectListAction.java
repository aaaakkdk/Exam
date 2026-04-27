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

            SubjectDAO dao = new SubjectDAO();
            List<Subject> list = dao.findAll();

            req.setAttribute("subjects", list);

            req.getRequestDispatcher("/scoremanager/main/subjectList.jsp")
               .forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}