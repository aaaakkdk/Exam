package scoremanager.main;

import bean.Subject;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class SubjectDeleteAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        // パラメータ取得
        String schoolCd = req.getParameter("schoolCd");
        String cd = req.getParameter("cd");

        // DAO
        SubjectDAO dao = new SubjectDAO();

        // 科目取得
        Subject subject = dao.findById(schoolCd, cd);

        // requestへ
        req.setAttribute("subject", subject);

        // JSPへ
        req.getRequestDispatcher("/scoremanager/main/subject_delete.jsp")
           .forward(req, res);
    }
}