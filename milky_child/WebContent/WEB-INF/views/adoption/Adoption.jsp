<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String memberId = "user000";
	String carePublicationNum = (String)request.getAttribute("carePublicationNum");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="javascript:fileDownload('Korean_Adoption_Policy_Agreement.pdf');">입양방침 동의서</a>
	<br>
	<a href="javascript:fileDownload('Korean_Cat_Application.docx');">고양이 입양 신청서</a>
	<br>
	<a href="javascript:fileDownload('Korean_Dog_Application.docx');">강아지 입양 신청서</a>
	
	

	<form action="<%=request.getContextPath()%>/adopt/adoptFrmEnd" method="post" enctype="multipart/form-data">
		<input type="hidden" name="carePublicationNum" value="<%=carePublicationNum%>">
		<input type="hidden" name="memberId" value="<%=memberId%>">
		<label for="APAgreement">입양방침 동의서</label><input type="file" name="APAgreement">
		<br>
		<label for="petApplication">입양 신청서</label><input type="file" name="petApplication">
		<br>
		<input type="submit" value="입양 신청">
	</form>
	
<script>
function fileDownload(fName){
	fName = encodeURIComponent(fName);
	location.href = "<%=request.getContextPath()%>/adopt/adoptFileDownload" 
				  + "?fileName=" + fName;
};

</script>
</body>
</html>