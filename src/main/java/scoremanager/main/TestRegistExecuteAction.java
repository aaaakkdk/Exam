package scoremanager.main;

import java.util.HashMap;
import java.util.Map;

import bean.Teacher;
import dao.TestDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class TestRegistExecuteAction
	extends Action {

	@Override
	public void execute(
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {

		// パラメータ取得
		String[] studentNo =
				request.getParameterValues(
						"studentNo");

		String[] point =
				request.getParameterValues(
						"point");

		String subjectCd =
				request.getParameter(
						"subjectCd");

		String classNum =
				request.getParameter(
						"classNum");

		String countStr =
				request.getParameter(
						"count");

		String entYear =
				request.getParameter(
						"entYear");

		int count =
				Integer.parseInt(
						countStr);

		// セッション
		HttpSession session =
				request.getSession();

		Teacher teacher =
				(Teacher)session.getAttribute(
						"user");

		// DAO
		TestDao dao =
				new TestDao();

		// エラー格納
		Map<String,String> errors =
				new HashMap<>();

		// 点数チェック
		for(int i = 0;
				i < point.length;
				i++) {

			// 未入力はOK
			if(point[i] == null
					|| point[i].equals("")) {

				continue;
			}

			try {

				int p =
						Integer.parseInt(
								point[i]);

				// 0～100チェック
				if(p < 0
						|| p > 100) {

					errors.put(
							studentNo[i],
							"0～100の範囲で入力してください");
				}

			} catch(Exception e) {

				errors.put(
						studentNo[i],
						"0～100の範囲で入力してください");
			}
		}

		// エラーある場合
		if(!errors.isEmpty()) {

			// エラーメッセージ
			request.setAttribute(
					"errors",
					errors);

			// 入力値保持
			request.setAttribute(
					"pointList",
					point);

			request.setAttribute(
					"subjectCd",
					subjectCd);

			request.setAttribute(
					"classNum",
					classNum);

			request.setAttribute(
					"count",
					count);

			request.setAttribute(
					"entYear",
					entYear);

			// 検索結果再表示
			request.setAttribute(
					"scoreList",

					dao.filter(
							Integer.parseInt(
									entYear),

							classNum,

							subjectCd,

							count,

							teacher.getSchool()
							.getCd()
					)
			);

			request.getRequestDispatcher(
					"/scoremanager/main/test_regist.jsp")
					.forward(
							request,
							response);

			return;
		}

		// 登録
		for(int i = 0;
				i < studentNo.length;
				i++) {

			// 未入力スキップ
			if(point[i] == null
					|| point[i].equals("")) {

				continue;
			}

			dao.save(

					studentNo[i],

					subjectCd,

					count,

					Integer.parseInt(
							point[i]),

					classNum,

					teacher.getSchool()
					.getCd()
			);
		}

		// 完了画面
		request.getRequestDispatcher(
				"/scoremanager/main/test_regist_done.jsp")
				.forward(
						request,
						response);
	}
}