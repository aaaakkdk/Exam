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

		String entYear =
				request.getParameter(
						"entYear");

		String classNum =
				request.getParameter(
						"classNum");

		String subjectCd =
				request.getParameter(
						"subjectCd");

		HttpSession session =
				request.getSession();

		Teacher teacher =
				(Teacher)session.getAttribute(
						"user");

		TestDao dao =
				new TestDao();

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

		request.setAttribute(
				"list",
				list);

		request.setAttribute(
				"subjectCd",
				subjectCd);

		request.getRequestDispatcher(
				"/scoremanager/main/test_list_subject.jsp")
				.forward(
						request,
						response);
	}
}