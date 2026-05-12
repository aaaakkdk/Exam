package scoremanager.main;

import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class SubjectDeleteExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
            throws Exception {

        // パラメータ取得
        String schoolCd = req.getParameter("schoolCd");
        String cd = req.getParameter("cd");

        // DAO
        SubjectDAO dao = new SubjectDAO();

        // 削除
        dao.delete(schoolCd, cd);

        // 削除完了画面へ
        req.getRequestDispatcher("subject_delete_done.jsp")
           .forward(req, res);
    }
}