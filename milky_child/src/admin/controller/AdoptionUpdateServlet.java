package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adopt.service.AdoptService;

@WebServlet("/admin/adoptionUpdate")
public class AdoptionUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdoptionUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adoptNum = request.getParameter("adoptNum");
		String adoptResult = request.getParameter("adoptResult");
		
		int result = new AdoptService().adoptionUpdate(adoptNum, adoptResult);
		
		String msg = "";
		String loc = "";
		if(result >0) {
			msg = "업데이트 완료";
			loc = "/admin/adoptionList;";
		}else {
			msg = "업데이트 실패";
			loc = "/admin/adoptionView?adoptNum="+adoptNum;
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
