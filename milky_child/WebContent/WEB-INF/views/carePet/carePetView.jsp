<%@page import="model.vo.CarePet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%
	CarePet result = (CarePet)request.getAttribute("result");
%>
<section class="mainelmWrapper" >
	<form action="<%=request.getContextPath()%>/adopt/adoptFrm" method="post">
		<input type="hidden" name="carePublicationNum" value="<%= result.getCarePublicationNum()%>">
		<input type="submit" value="입양신청">
	</form>
</section>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>