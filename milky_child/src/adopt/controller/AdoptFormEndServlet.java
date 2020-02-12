package adopt.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import adopt.service.AdoptService;
import model.vo.Adopt;

@WebServlet("/adopt/adoptFrmEnd")
public class AdoptFormEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdoptService adoptService = new AdoptService();
	
    public AdoptFormEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.saveDirctory: 업로드한 파일의 절대경로
		String saveDirectory = getServletContext().getRealPath("/upload/adoptApplication");
		System.out.println("saveDirectory=" + saveDirectory);

		// 2.maxPostSize: 업로드한 파일의 최대크기 10MB 1kb*1Mb*10
		int maxPostSize = 1024 * 1024 * 10;

		// 3.encoding: UTF-8
		String encoding = "utf-8";

		// 4.fileRenamPolicy: 중복 파일 리네임 정책 DefaultFileRenamePolicy a.txt -> a1.txt ->
		// a2.txt
		FileRenamePolicy fileRenamePolicy = new AdoptRenamePolicy();

		MultipartRequest multiReq = new MultipartRequest(request, saveDirectory, maxPostSize, encoding, fileRenamePolicy);
		
		String carePublicationNum = multiReq.getParameter("carePublicationNum");
		String memberId = multiReq.getParameter("memberId");
		
		String APAgreement = multiReq.getFilesystemName("APAgreement");
		String petApplication = multiReq.getFilesystemName("petApplication");
		
		String adoptNum = adoptService.getAdoptNum();
		
		if(adoptNum == null) {
			adoptNum = "0000000001";
		}else {
			char[] temp = adoptNum.toCharArray();
			
			for(int i = 0 ;i<temp.length;i++) {
				if('Z' == temp[temp.length-1-i]) {
					temp[temp.length-1-i] = '0';
				}else if('9' == temp[temp.length-1-i]) {
					temp[temp.length-1-i] = 'A';
					break;
				}else {
					temp[i]++;
					break;
				}
			}
		}
		System.out.println(adoptNum);
		
		Adopt adopt =  new Adopt(adoptNum, memberId, carePublicationNum, APAgreement, petApplication, null, null, null);
		
		int result = adoptService.insertAdoptApplication(adopt);

		String msg = "";
		String loc = "";
		if(result >0) {
			msg = "입양 신청 완료";
			loc = "/carePet/carePetView?carePublicationNum="+adopt.getCarePublicationNum();
		}else {
			msg = "입양 신청 실패";
			loc = "/carePet/carePetView?carePublicationNum="+adopt.getCarePublicationNum();
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost@AdoptFormEndServlet");
		doGet(request, response);
	}

}

class AdoptRenamePolicy implements FileRenamePolicy{

	public File rename(File oldFile) {
		File newFile = null;
		do {
			//파일명 생성코드
			//기존파일의 확장자
			String oldName = oldFile.getName();
			String ext = "";
			int dotIndex = oldName.lastIndexOf(".");
			if(dotIndex>-1)
				ext =  oldName.substring(dotIndex);//.txt등
			
			//새파일명:yyyyMMdd_HHmmssSSS_rnd.txt
			String newName 
				= new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date())
				+ "_" + (int)(Math.random()*1000)
				+ ext;
			//새 파일객체 생성
			newFile =  new File(oldFile.getParent(), newName);
			
			
		}while(!createNewFile(newFile));
		
		System.out.println("newFile@MvcFileRenamePolicy="+newFile);
		return newFile;
	}
	
	private boolean createNewFile(File f) {
	    try {
	    	/*
	    	 * 파일이 존재하지 않으면, 파일을 생성하고 true를 리턴
	    	 * 파일이 존재하면, 파일을 생성하지 않고 false를 리턴
	    	 */
	    	
	      return f.createNewFile();
	    }
	    catch (IOException ignored) {
	      return false;
	    }
	  }
}