package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adopt.service.AdoptService;
import model.vo.Adopt;


@WebServlet("/admin/adoptionList")
public class AdoptionListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdoptionListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Adopt> list = new AdoptService().getAdoptList();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/admin/adoptionList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
