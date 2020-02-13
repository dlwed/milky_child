<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PetList</title>
<script src="<%=request.getContextPath() %>/js/jquery-3.4.1.js"></script>
<script>

$(function() {
	let getData = {
		srchCode : "abandoned",	<%--필수값 [sido, sigungu, shelter, breed, abandoned] --%>
		sido : "",		<%--srchCode=={sigungu, shelter}에서 필수값 sigungu 입력할때는 [서울특별시, 부산광역시 etc] // 그 외에는 srchCode sido로 검색한 결과 입력 --%>
		sigungu : "",	<%--srchCode==shelter에서 필수값 srchCode에서 sigungu로 검색한 결과로 입력 --%>
		bgnDate : "",	<%-- YYYYMMDD --%>
		endDate : "",	<%-- YYYYMMDD --%>
		upkind : "고양이",	<%--srchCode==breed 에서 필수값 [개, 고양이, 기타] --%>
		kind : "",		<%-- srchCode에서 breed로 검색한 결과로 입력 --%>
		shelter : "",	<%-- srchCode에서 shelter로 검색한 결과로 입력 --%>
		state : "",		<%-- [공고중, 보호중] --%>
		neuter : "",	<%-- [예, 아니오, 모름] --%>
		pageNo : "",	<%-- 페이지 번호 --%>
		numOfRow : ""	<%-- 페이지 당 출력 건수 --%>
	}
	$.ajax({
		url : "<%=request.getContextPath()%>/common/useApi",
		dataType : "xml",
		data : getData,
		type : "GET",
		success : function(data) {
			console.log(data);
			let $root = $(data).find(":root");
			let $item = $root.find("item");
			console.log($item);
			var $html = "";
			$item.each(function(idx, data) {
				$html += "<span>" + $(data).find("orgCd").text()+", "+$(data).find("orgdownNm").text()+"</span><br>";
			});
			$("#petList").html($html);
		},
		error : function(x,s,e) {
			alert("알 수 없는 오류가 발생했습니다. 다시 시도해 주십시오.");
			history.go(-1);
		}
	});
});
</script>
</head>
<body>
<h1>보호동물 리스트</h1>
<div id="petList">
	
</div>
</body>
</html>