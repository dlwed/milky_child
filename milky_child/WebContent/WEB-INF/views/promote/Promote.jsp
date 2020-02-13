<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
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
	<a href="javascript:fileDownload('Korean_Cat_Application.docx');">승급 안내서</a>
	<br>
	<a href="javascript:fileDownload('Korean_Dog_Application.docx');">승급 신청자료 목록</a>
	
	

	<form action="<%=request.getContextPath()%>/promote/promoteFrmEnd" method="post" enctype="multipart/form-data">
		<input type="hidden" name="memberId" value="<%=memberId%>">
		<label for="promoteFile1">첨부자료</label><input type="file" name="promoteFile1">
		<br>
		<input type="submit" value="승급 신청">
	</form>
	</article>
</section>
<script>
let index = 1;
function fileDownload(fName){
	fName = encodeURIComponent(fName);
	location.href = "<%=request.getContextPath()%>/promote/promoteFileDownload" 
				  + "?fileName=" + fName;
};

$("[name=promoteFile1]").change(addInputFile);

function addInputFile(){
	
	
	index= index + 1;
	console.log(index);
	if(index >10){
		
		alert("파일 10개 이상 추가 불가");
		
	}else{
		let input = $("<input type='file' name='promoteFile"+index+"'><br>");
		input.change(addInputFile);
	
		//input.append($("<br>"));
	
		console.log(input);
	
		input.insertAfter($(this).next()).show();
	}
	
	$(this).off("change");
}
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>