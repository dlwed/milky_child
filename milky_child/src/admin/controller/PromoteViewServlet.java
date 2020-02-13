package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carePet.service.CarePetService;
import member.model.service.MemberService;
import member.model.vo.Member;
import model.vo.Promote;
import promote.service.PromoteService;
import model.vo.CarePet;

@WebServlet("/admin/adoptionView")
public class PromoteViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PromoteViewServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String promoteNum = request.getParameter("promoteNum");
		Promote result = new PromoteService().getPromote(promoteNum);
		Member member = new MemberService().selectOne(result.getMemberId());
		
		
		request.setAttribute("result", result);
		request.setAttribute("member", member);
		request.getRequestDispatcher("/WEB-INF/views/admin/promoteView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
