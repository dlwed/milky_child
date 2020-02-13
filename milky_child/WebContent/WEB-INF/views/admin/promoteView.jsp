<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.vo.CarePet"%>
<%@page import="model.vo.Promote"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%
	Promote result = (Promote)request.getAttribute("result");
	Member member = (Member)request.getAttribute("member");
	String[] oldFileNameList = result.getOldPromoteFile().split(",");
	String[] renamedFileNameList = result.getRenamedPromoteFile().split(",");
	
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
	<article id="pjm-partner-table">
<% 
	if(null != oldFileNameList){
		for(int i = 0; i<oldFileNameList.length; i++){
		%><a href="javascript:fileDownload(<%=oldFileNameList[i]%>,<%=renamedFileNameList[i]%>);"><%=oldFileNameList[i]%></a><%
		}
	
	}else{
	%><p>첨부파일이 없습니다.</p>><%
	}
%>
	
<% %>
	<form action="<%=request.getContextPath()%>/admin/promoteUpdate" method="post">
		<input type="hidden" name="memberId" value='<%=member.getMemberId()%>'>
		<input type="hidden" name="promoteNum" value='<%=result.getPromoteNum()%>'>
		<fieldset>
            <legend>등급 선택</legend>
            <label for="resultGrade">등급</label>
            <select name="resultGrade">
                <option value="U1">1달 이상 입양 회원</option>
                <option value="U2">신규 입양 회원</option>
                <option value="U3">입양절차 시작 회원</option>
                <option value="U4">신규회원</option>
            </select>
        </fieldset>
		<br>
		<input type="submit" value="확인">
	</form>
	</article>
</section>
<script>
function fileDownload(oName,rName){
	oName = encodeURIComponent(oName);
	location.href = "<%=request.getContextPath()%>/admin/promoteFile" 
				  + "?oName=" + oName
				  + "&rName" + rName;
};

</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>