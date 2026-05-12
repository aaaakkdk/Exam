package scoremanager.main;

import java.util.List;

import bean.Teacher;
import bean.Test;
import dao.TestDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class TestListSubjectExecuteAction
	extends Action {

	@Override
	public void execute(
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {

		// パラメータ取得
		String entYear =
				request.getParameter(
						"entYear");

		String classNum =
				request.getParameter(
						"classNum");

		String subjectCd =
				request.getParameter(
						"subjectCd");

		// 値保持
		request.setAttribute(
				"entYear",
				entYear);

		request.setAttribute(
				"classNum",
				classNum);

		request.setAttribute(
				"subjectCd",
				subjectCd);

		// 未入力チェック
		if(entYear == null
				|| entYear.equals("")
				|| classNum == null
				|| classNum.equals("")
				|| subjectCd == null
				|| subjectCd.equals("")) {

			request.setAttribute(
					"error",
					"入学年度とクラスと科目を選択してください");

			request.getRequestDispatcher(
					"/scoremanager/main/test_list.jsp")
					.forward(
							request,
							response);

			return;
		}

		// セッション
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

						Integer.parseInt(
								entYear),

						classNum,

						subjectCd,

						1,

						teacher.getSchool()
						.getCd()
				);

		// データなし
		if(list == null
				|| list.size() == 0) {

			request.setAttribute(
					"error",
					"学生情報が存在しませんでした");

			request.getRequestDispatcher(
					"/scoremanager/main/test_list.jsp")
					.forward(
							request,
							response);

			return;
		}

		// 一覧表示
		request.setAttribute(
				"list",
				list);

		request.getRequestDispatcher(
				"/scoremanager/main/test_list_subject.jsp")
				.forward(
						request,
						response);
	}
}