package carePet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carePet.service.CarePetService;
import model.vo.CarePet;

@WebServlet("/carePet/carePetView")
public class CarePetBoardView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CarePetBoardView() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String carePublicationNum = request.getParameter("carePublicationNum");
		
		CarePet result = new CarePetService().CarePetBoardView(carePublicationNum);
		
		System.out.println(result);
		
		if(result == null) {
			
		}
		else {
			request.setAttribute("result", result);
			request.getRequestDispatcher("/WEB-INF/views/carePet/carePetView.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost@CarePetBoardView");
		doGet(request, response);
	}

}
