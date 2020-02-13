<%@page import="model.vo.CarePet"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%
	List<CarePet> list = (List<CarePet>)request.getAttribute("list");
%>

<style>
.pjm-section-Wrapper{
	background-color: white;
	text-align: center;
	padding: 50px 0;
}

#pjm-partner-table{
	width: 900px;
	margin: 0 auto;
}
</style>

<section class="pjm-section-Wrapper" >
	<article id="pjm-partner-table">
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
 	<tr><th><h1>요첯하신 부분을 찾을 수 없습니다.</h1></th></tr>
 <% } %>
 
 	
 	</table>
 	</article>
 </section>
 
 
 
 
 
 
 
<%@ include file="/WEB-INF/views/common/footer.jsp" %>