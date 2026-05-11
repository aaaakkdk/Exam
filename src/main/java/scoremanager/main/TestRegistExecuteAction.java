package scoremanager.main;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/TestRegistExecuteAction")
public class TestRegistExecuteAction
		extends HttpServlet {

	@Override
	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response)

			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String[] studentNo =
				request.getParameterValues(
						"studentNo");

		String[] point =
				request.getParameterValues(
						"point");

		for(int i = 0;
				i < studentNo.length;
				i++) {

			System.out.println(

					studentNo[i]
					+ ":"
					+ point[i]

			);
		}

		response.sendRedirect(
				"test_regist_done.jsp");
	}
}