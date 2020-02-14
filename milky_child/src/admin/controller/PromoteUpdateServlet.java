package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import promote.service.PromoteService;

@WebServlet("/admin/promoteUpdate")
public class PromoteUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PromoteUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		String promoteNum = request.getParameter("promoteNum");
		String resultGrade = request.getParameter("resultGrade");
		System.out.println(memberId+promoteNum+resultGrade);
		int result = new PromoteService().promotedUpdate(promoteNum, resultGrade);
			System.out.println("result@promoteupdate"+result);
		
		if(result>0) {
			result = new MemberService().promoteMember(memberId,resultGrade);
			System.out.println("result@promoteMember"+result);
		}
		String msg = "";
		String loc = "";
		if(result >0) {
			msg = "업데이트 완료";
			loc = "/admin/promoteList;";
		}else {
			msg = "업데이트 실패";
			loc = "/admin/promoteView?promoteNum="+promoteNum;
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
