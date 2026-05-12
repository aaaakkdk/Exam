package scoremanager.main;

import java.util.List;

import bean.Teacher;
import bean.Test;
import dao.TestDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class TestRegistAction extends Action {

	@Override
	public void execute(
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {

		// パラメータ取得
		String entYearStr =
				request.getParameter(
						"entYear");

		String classNum =
				request.getParameter(
						"classNum");

		String subjectCd =
				request.getParameter(
						"subjectCd");

		String countStr =
				request.getParameter(
						"count");

		// 初回表示
		if(entYearStr == null) {

			request.getRequestDispatcher(
					"/scoremanager/main/test_regist.jsp")
					.forward(
							request,
							response);

			return;
		}

		// 未入力チェック
		if(entYearStr.equals("")
				|| classNum.equals("")
				|| subjectCd.equals("")
				|| countStr.equals("")) {

			request.setAttribute(
					"error",
					"入力されていない項目を選択してください");

			request.getRequestDispatcher(
					"/scoremanager/main/test_regist.jsp")
					.forward(
							request,
							response);

			return;
		}

		// int変換
		int entYear =
				Integer.parseInt(
						entYearStr);

		int count =
				Integer.parseInt(
						countStr);

		// ログインユーザー
		HttpSession session =
				request.getSession();

		Teacher teacher =
				(Teacher)session.getAttribute(
						"user");

		// DAO
		TestDao dao =
				new TestDao();

		// 検索
		List<Test> list =
				dao.filter(
						entYear,
						classNum,
						subjectCd,
						count,
						teacher.getSchool().getCd());

		// JSPへ渡す
		request.setAttribute(
				"scoreList",
				list);

		request.setAttribute(
				"subjectCd",
				subjectCd);

		request.setAttribute(
				"count",
				count);

		// JSP
		request.getRequestDispatcher(
				"/scoremanager/main/test_regist.jsp")
				.forward(
						request,
						response);
	}
}