package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adopt.service.AdoptService;
import model.vo.Adopt;

@WebServlet("/AdoptionViewServlet")
public class AdoptionViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdoptionViewServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adoptNum = request.getParameter("adoptNum");
		Adopt result = new AdoptService().getAdopt(adoptNum);
		
		request.setAttribute("result", result);
		request.getRequestDispatcher("/WEB-INF/views/admin/adoptionView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
