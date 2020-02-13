<%@page import="model.vo.Adopt"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%
	List<Adopt> list = (List<Adopt>)request.getAttribute("list");
	

%>
<section>
<table>
 <% 
 	if(list != null && list.size() > 0){
 		for(Adopt a : list){
			%>
			<tr>
 				<td>
 					<a href="<%=request.getContextPath()%>/admin/adoptionView?adoptNum=<%=a.getAdoptNum()%>">
 					<span><%=a.getAdoptNum()%></span>
 					</a>
 				</td>
 				<td>
 					<span><%=a.getMemberId()%></span>
 				</td>
 				<td>
 					<span><%=a.getCarePublicationNum()%></span>
 				</td>
 				<td>
 					<span><%=null == a.getAdoptResult()?"미확인":("Y".equals(a.getAdoptResult())?"허가":"불가")%></span>
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