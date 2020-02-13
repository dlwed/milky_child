<%@page import="model.vo.Partner"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%
	List<Partner> list = (List<Partner>)request.getAttribute("list");
%>
<style>
#partner-img{
	width: 100px;
}
</style>
<section>
 	<table>
 <% 
 	if(list != null && list.size() > 0){
 		for(Partner p : list){
			%>
			<tr>
 				<td rowspan="4">
 					<img id='partner-img' src='<%=request.getContextPath()%>/upload/partner/<%=p.getCoopCode()%>.png'>
 				</td>
 				<td>
 					<span><%=p.getCoopName()%></span>
 				</td>
 			</tr>
 			<tr>
 				<td>
 					<span><%=p.getCoopCeoName()%></span>
 				</td>
 			</tr>
 			<tr>
 				<td>
 					<span><%=p.getCoopCall()%></span>
 				</td>
 			</tr>
 			<tr>
 				<td>
 				<%if(null != p.getCoopUrl()){ %>
 					<a href="<%=p.getCoopUrl()%>"><%=p.getCoopUrl()%></a>
 				<%}else{ %>
 					<span>없음</span>
 				<%} %>
 				</td>
 			</tr>
 <%
 		}
 %>
 <% }else{ %>
 <% } %>
 	</table>
</section>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>