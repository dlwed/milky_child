<%@page import="model.vo.CarePet"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
</head>
<body>
 	<h1>보호동물 리스트</h1>
<%
	List<CarePet> list = (List<CarePet>)request.getAttribute("list");
%>
 	<table>
 <% 
 	if(list != null && list.size() > 0){
 		for(int i = 0 ; i<list.size();){
			%><tr><%
 			for(int k = 0; k<5 && i<list.size(); k++, i++){
 				%>
 				<td class="carePetBtn">
 					<a href="<%=request.getContextPath()%>/carePet/carePetView?carePublicationNum=<%=list.get(i).getCarePublicationNum()%>">
 					<div>
 					<p><%=list.get(i).getCarePublicationNum()%></p>
 					<p><%=list.get(i).getCareName()%></p>
 					<p><%=list.get(i).getCareCha()%></p>
 					</div>
 					</a>
 				</td>
 				<%				
 			}
			%></tr><%
 		}
 %>
 <% }else{ %>
 <% } %>
 	</table>
</body>
</html>