package partner.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.vo.Partner;
import partner.service.PartnerService;

@WebServlet("/partner/partnerList")
public class PartnerListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PartnerListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String field =  request.getParameter("field");
//		System.out.println("field@servlet="+field);
		
		List<Partner> list = new PartnerService().partnerList(field);
		
		System.out.println(list.toString());
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/partner/partnerList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost@PartnerListController");
		doGet(request, response);
	}

}
