<%@page import="model.vo.CarePet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>보호 동물 뷰</h1>
<%
	CarePet result = (CarePet)request.getAttribute("result");
%>
	<form action="<%=request.getContextPath()%>/adopt/adoptFrm" method="post">
		<input type="hidden" name="carePublicationNum" value="<%= result.getCarePublicationNum()%>">
		<input type="submit" value="입양신청">
	</form>
</body>
</html>