<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<a href="<%=request.getContextPath()%>/promote/promoteFrm">test1</a>
	<!--<a href="<%=request.getContextPath()%>/WEB-INF/views/carePet/carePetList.jsp">test1-1</a> 접근 불가능 -->
	<a href="<%=request.getContextPath()%>/partner/partnerList?field=테스트영역">test2</a>
	<a href="<%=request.getContextPath()%>/admin/promoteList">test2</a>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>