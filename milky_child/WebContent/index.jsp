<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<%=request.getContextPath()%>/carePet/carePetList">test1</a>
	<a href="<%=request.getContextPath()%>/WEB-INF/views/carePet/carePetList.jsp">test1-1</a><!-- 접근 불가능 -->
	<a href="<%=request.getContextPath()%>/partner/partnerList?field=테스트영역">test2</a>
	
</body>
</html>