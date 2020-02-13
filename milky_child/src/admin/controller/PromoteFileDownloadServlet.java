package admin.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/promoteFile")
public class PromoteFileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PromoteFileDownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.파라미터 핸들링
		String oName = request.getParameter("oName");
		String rName = request.getParameter("rName");
//		System.out.println("Name="+fileName);
		
		//2.입출력 스트림
		String saveDirectory = getServletContext().getRealPath("/upload/promoteFile");
//		System.out.println("saveDirectory="+saveDirectory);
		
		//입력
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(saveDirectory+"/"+rName));
		
		//출력
		ServletOutputStream sos = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(sos);
		
		//3.response header작성
		String resFileName = "";
		String userAgent = request.getHeader("user-agent");//브라우저 정보
		boolean isMSIE = userAgent.indexOf("MSIE") != -1 || userAgent.indexOf("Trident") != -1;
//		System.out.println("userAgent="+userAgent);
		
		if(isMSIE) {
			//유니코드 퍼센트문자변환
			resFileName = URLEncoder.encode(oName,"utf-8");
			//공백 + => %20
			resFileName = resFileName.replaceAll("\\+", "%20");
		}else {
			//String(utf-8) => byte[](utf=8) => String(iso-8859-1)
			resFileName = new String(oName.getBytes("utf-8"),"iso-8859-1");
		}
//		System.out.println("resFileName=" + resFileName);
		
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition", "attachment;filename="+resFileName);
		
		//4.파일입출력 & 자원반납
		int read = -1;//읽어올 값 없음 => -1
		while((read = bis.read()) != -1) {
			bos.write(read);
		}
		
		bos.close();
		bis.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("doPost@AdoptFileDownloadServlet");
		doGet(request, response);
	}

}
