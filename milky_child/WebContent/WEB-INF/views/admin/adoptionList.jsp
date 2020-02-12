<%@page import="model.vo.Adopt"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Adopt> list = (List<Adopt>)request.getAttribute("list"); 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
 <% 
 	if(list != null && list.size() > 0){
 		for(Adopt a : list){
			%>
			<tr>
 				<td>
 					<span><%=a.getAdoptNum()%></span>
 				</td>
 				<td>
 					<span><%=a.getMemberId()%></span>
 				</td>
 				<td>
 					<span><%=a.getCarePublicationNum()%></span>
 				</td>
 			</tr>
 <%
 		}
 %>
 <% }else{ %>
 <% } %>
 	</table>
</body>
</html>