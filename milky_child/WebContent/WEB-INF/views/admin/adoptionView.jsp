<%@page import="model.vo.CarePet"%>
<%@page import="model.vo.Adopt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Adopt result = (Adopt)request.getAttribute("result");
	CarePet adPet = (CarePet)request.getAttribute("adPet");
%>
	<a href="javascript:fileDownload('<%=result.getAPAgreementFile()%>');">입양방침 동의서</a>
	<a href="javascript:fileDownload('<%=result.getPetApplicationFile()%>');">입양 신청서</a>
	
	
	<form action="<%=request.getContextPath()%>/admin/adoptionUpdate" method="post">
		<input type="hidden" name="adoptNum" value='<%=result.getAdoptNum()%>'>
		<label for="yes">허가</label><input type="radio" id="yes" name="adoptResult" value="Y">
		<label for="no">불가</label><input type="radio" id="no" name="adoptResult" value="N">
		<br>
		<input type="submit" value="확인">
	</form>
<script>
function fileDownload(fName){
	fName = encodeURIComponent(fName);
	location.href = "<%=request.getContextPath()%>/admin/adoptionFile" 
				  + "?fileName=" + fName;
};

</script>
</body>
</html>