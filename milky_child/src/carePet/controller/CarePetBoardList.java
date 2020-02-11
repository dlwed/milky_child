package carePet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carePet.service.CarePetService;
import model.vo.CarePet;


@WebServlet("/carePet/carePetList")
public class CarePetBoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CarePetBoardList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CarePet> list =  new CarePetService().carePetBoardList();
		
		System.out.println(list);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/carePet/carePetList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost@CarePetBoardList");
		doGet(request, response);
	}

}
