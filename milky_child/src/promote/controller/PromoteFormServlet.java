package promote.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/promote/promoteFrm")
public class PromoteFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PromoteFormServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String carePublicationNum = request.getParameter("carePublicationNum");
		System.out.println(carePublicationNum);
		request.setAttribute("carePublicationNum", carePublicationNum);
		request.getRequestDispatcher("/WEB-INF/views/promote/Promote.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost@promoteFormServlet");
		doGet(request, response);
	}

}
