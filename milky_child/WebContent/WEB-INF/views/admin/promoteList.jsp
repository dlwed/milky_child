<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.vo.Promote"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%
	List<Promote> list = (List<Promote>)request.getAttribute("list");
	SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
%>
<style>
.pjm-section-Wrapper{
	background-color: white;
	padding: 50px 0;
}

#pjm-partner-table{
	width: 900px;
	margin: 0 auto;
}
</style>

<section class="pjm-section-Wrapper" >
	<article id="pjm-partner-table"><table>
 <%
 	if(list != null && list.size() > 0){
  		for(Promote p : list){
 %>
			<tr>
 				<td>
 					<a href="<%=request.getContextPath()%>/admin/promoteView?promoteNum=<%=p.getPromoteNum()%>">
 					<span><%=p.getPromoteNum()%></span>
 					</a>
 				</td>
 				<td>
 					<span><%=p.getMemberId()%></span>
 				</td>
 				<td>
 					<span><%=format.format(p.getPromoteApplyDate())%></span>
 				</td>
 				<td>
 					<span><%=null != p.getCheckDate()?format.format(p.getCheckDate()):"확인 안 됨"%></span>
 				</td>
 			</tr>
 <%
 		}
 %>
 <% }else{ %>
 <% } %>
 	</table>
	</article>
</section>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>