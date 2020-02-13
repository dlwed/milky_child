package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApiPet
 */
@WebServlet("/common/useApi")
public class UseAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UseAPI() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UseAPI API = new UseAPI();
		
		/*
		 * 보호소를 검색하기 위해서는 시도와 시군구 코드를 입력해야 함.
		 * 품종을 검색하기 위해서는 축종을 입력해야 함.
		 * 유기동물 검색을 위해서는 아무것도 입력하지 않아도 무방.
		 */
		String srchCode = request.getParameter("srchCode");
		String apiUrl = "http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/";
		String svKey = "rfABmUOp25mTYLiuUn3IKXXVQYyM45H6bqp4pqoWjnb2l01FBN8g2fBZCxfNxvD660skTXLBuoyK2PF1Y6WQkw%3D%3D";
		try {
			switch(srchCode) {
			case "sido" : 
				apiUrl += API.sido();
				break;
			case "sigungu" : 
				String sido = request.getParameter("sido");
				String sigungu = API.sigungu(sido);
				if("".equals(sigungu)) {
					API.end(request, response);
				}
				apiUrl += sigungu;
				break;
			case "shelter" : 
				sido = request.getParameter("sido");
				sigungu = request.getParameter("sigungu");
				apiUrl += API.shelter(sido, sigungu);
				break;
			case "breed" : 
				String kind = request.getParameter("upkind");
				switch(kind) {
				case "개" : kind = "417000"; break;
				case "고양이" : kind = "422400"; break;
				case "기타" : kind = "429900"; break;
				default : API.end(request, response);
				}
				apiUrl += API.breed(kind);
				break;
			case "abandoned" : 
				String bgnDate = request.getParameter("bgnDate");	//검색 시작날짜
				if(bgnDate == null) bgnDate = "";
				String endDate = request.getParameter("endDate");	//검색 종료날짜
				if(endDate == null) endDate = "";
				String upkind = request.getParameter("upkind");		//축종코드
				if(upkind == null) bgnDate = "";
				String kindCd = request.getParameter("kind");		//품종코드
				if(kindCd == null) kindCd = "";
				String uprCd = request.getParameter("sido");		//시도코드
				if(uprCd == null) uprCd = "";
				String orgCd = request.getParameter("sigungu");		//시군구코드
				if(orgCd == null) orgCd = "";
				String shelter = request.getParameter("shelter");	//보호소 번호
				if(shelter == null) shelter = "";
				String state = request.getParameter("state");		//상태
																	/*
																	 * 전체는 빈값으로 두면 됨.
																	 * 공고중 / 보호중 둘 중 하나로 지정할 것.
																	 */
				if(state == null) state = "";
				String neuter = request.getParameter("neuter");		//중성화 여부
																	/*
																	 * 전체는 빈값으로 두면 됨.
																	 * 예 / 아니오 / 모름 셋 중 하나로 지정할 것.
																	 */
				if(neuter == null) neuter = "";
				String pageNo = request.getParameter("pageNo");		//페이지 번호
				if(pageNo == null) pageNo = "";
				String numOfRow = request.getParameter("numOfRow");	//페이지 당 출력 건수
				if(numOfRow == null) numOfRow = "";
				apiUrl += API.animal(bgnDate, endDate, upkind, kindCd, uprCd, orgCd, shelter, state, neuter, pageNo, numOfRow);
				break;
			default : API.end(request, response);
			}
		} catch(NullPointerException e) {
			e.printStackTrace();
			API.end(request, response);
		}
		apiUrl += svKey;
		HttpURLConnection urlconnection = null;
		BufferedReader br = null;
		String result = "";
		try{
            URL url = new URL(apiUrl);
            urlconnection = (HttpURLConnection)url.openConnection();
            urlconnection.setRequestMethod("GET");
            br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));
            String line = "";
            while((line = br.readLine()) != null) {
                result += line + "\n";
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        } finally {
        	urlconnection.disconnect();
        	br.close();
        }
		
		response.setContentType("text/xml; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(result);
	}

	private String animal(String bgnDate, String endDate, String upkind, String kindCd, String uprCd, String orgCd,
			String shelter, String state, String neuter, String pageNo, String numOfRow) {
		String result = "abandonmentPublic?";
		
		if(!("".equals(bgnDate))) result += "bgnde=" + bgnDate + "&";
		
		if(!("".equals(endDate))) result += "endde=" + endDate + "&";
		
		if(!("".equals(upkind))) {
			if(upkind.equals("개"))
				upkind = "417000";
			else if(upkind.equals("고양이"))
				upkind = "422400";
			else if(upkind.equals("기타"))
				upkind = "429900";
			result += "upkind=" + upkind + "&";
		}
		
		if(!("".equals(kindCd))) result += "kind=" + kindCd + "&";
		
		if(!("".equals(uprCd))) result += "uprCd=" + uprCd + "&";
		
		if(!("".equals(orgCd))) result += "orgCd=" + orgCd + "&";
		
		if(!("".equals(shelter))) result += "care_reg_no=" + shelter + "&";
		
		if(!("".equals(state))) {
			if(state.equals("공고중"))
				state = "notice";
			else if(state.equals("보호중"))
				state = "protect";
			result += "state=" + state + "&";
		}
		
		if(!("".equals(neuter))) {
			if(neuter.equals("예"))
				neuter = "Y";
			else if(neuter.equals("아니오"))
				neuter = "N";
			else if(neuter.equals("모름"))
				neuter = "U";
			result += "neuter_yn=" + neuter + "&";
		}
		
		if(!("".equals(pageNo))) result += "pageNo=" + pageNo + "&";
		
		if(!("".equals(numOfRow))) result += "numOfRows=" + numOfRow + "&";
		
		result += "ServiceKey=";
		
		return result;
	}

	private String breed(String kind) {
		return "kind?up_kind_cd=" + kind + "&ServiceKey=";
	}

	private String shelter(String sido, String sigungu) {
		return "shelter?upr_cd=" + sido + "&org_cd=" + sigungu + "&ServiceKey=";
	}

	private String sido() {
		return "sido?numOfRows=20&ServiceKey=";
	}

	private void end(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("").forward(request, response);
	}

	private String sigungu(String sido) {
		String result = "sigungu?upr_cd=";
		switch(sido) {
		case "서울특별시" : result += "6110000"; break;
		case "부산광역시" : result += "6260000"; break;
		case "대구광역시" : result += "6270000"; break;
		case "인천광역시" : result += "6280000"; break;
		case "광주광역시" : result += "6290000"; break;
		case "세종특별자치시" : result += "5690000"; break;
		case "대전광역시" : result += "6300000"; break;
		case "울산광역시" : result += "6310000"; break;
		case "경기도" : result += "6410000"; break;
		case "강원도" : result += "6420000"; break;
		case "충청북도" : result += "6430000"; break;
		case "충청남도" : result += "6440000"; break;
		case "전라북도" : result += "6450000"; break;
		case "전라남도" : result += "6460000"; break;
		case "경상북도" : result += "6470000"; break;
		case "경상남도" : result += "6480000"; break;
		case "제주특별자치도" : result += "6500000"; break;
		default : return "";
		}
		result += "&numOfRows=50&ServiceKey=";
		
		return result;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
