package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.vo.Promote;
import promote.service.PromoteService;


@WebServlet("/admin/promoteList")
public class PromoteListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PromoteListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Promote> list = new PromoteService().getPromoteList();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/admin/promoteList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
