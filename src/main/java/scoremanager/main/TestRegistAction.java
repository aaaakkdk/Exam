package scoremanager.main;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class TestRegistAction extends Action {

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

		String count =
				request.getParameter(
						"count");

		// 検索ボタン押下後のみチェック
		if(entYear != null
				|| classNum != null
				|| subjectCd != null
				|| count != null) {

			// 未入力チェック
			if(entYear.equals("")
					|| classNum.equals("")
					|| subjectCd.equals("")
					|| count.equals("")) {

				request.setAttribute(
						"error",
						"入力されていない項目を選択してください");
			}
		}

		// JSPへ遷移
		request.getRequestDispatcher(
				"/scoremanager/main/test_regist.jsp")
				.forward(
						request,
						response);
	}
}