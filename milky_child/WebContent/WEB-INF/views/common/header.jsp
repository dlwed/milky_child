<%@page import="model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//Member memberLoggedIn = (Member)request.getAttribute("memberLoggedIn");
	// /mvc/index.jsp => memberLoggedIn = null;
	// /mvc/member/login => memberLoggedIn = member 객체;
	Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn");
	
	//쿠키확인
	Cookie[] cookies = request.getCookies();
	boolean saveIdChecked = false;
	String memberId = "";
	
	if(cookies != null){
		//System.out.println("cookies@header.jsp");
		//System.out.println("======================================");
		for(Cookie c : cookies){
			String name = c.getName();
			String value = c.getValue();
			//System.out.println(name + ": " +value);
			
			if("saveId".equals(name)){
				saveIdChecked = true;
				memberId = value;
			}
		}
		
		//System.out.println("======================================");
		
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello MVC</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css" />
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
<script>
function loginValidate(){
	let $memberId = $("#login-memberId");
	let $password = $("#login-password");
	
	//1.아이디 검사
	if($memberId.val().trim().length<4){
		alert("올바른 아이디를 입력하세요.");
		$memberId.focus();
		return false;
	}
	
	//2.비밀번호 검사
	if($password.val().trim().length<4){
		alert("올바른 비밀번호를 입력하세요.");
		$memberId.focus();
		return false;
	}
	
	return true;
}
</script>
</head>
<body>
	<div id="container">
		<header>
			<h1>Hello MVC</h1>
			<!-- 로그인 메뉴 -->
			<div class="login-container">
			<% if(memberLoggedIn == null){ %>
				<%--로그인 하지 않은 경우 --%>
				<form action="<%=request.getContextPath() %>/member/login" 
					  id="loginFrm" method="POST" 
					  onsubmit="return loginValidate()">
					<table>
						<tr>
							<td><input type="text" name="memberId" 
										id="login-memberId" placeholder="아이디"
										tabindex="1" value="<%=memberId%>"></td>
							<td><input type="submit" value="로그인" 
										tabindex="3"/></td>
						</tr>
						<tr>
							<td><input type="password" name="password" 
										id="login-password" placeholder="비밀번호"
										tabindex="2"/></td>
							<td></td>
						</tr>
						<tr>
							<td colspan="2"><input type="checkbox" name="saveId" id="saveId" <%=saveIdChecked?"checked":"" %>/>
							<label for="saveId">아이디 저장</label>&nbsp;&nbsp;
							<input type="button" value="회원가입" onclick="location.href='<%=request.getContextPath()%>/member/memberEnroll'"></td>
						</tr>
					</table>
				</form>
			<%}else{ %>
				<%-- 로그인 한 경우 --%>
				<table id="logged-in">
					<tr>
						<td><%=memberLoggedIn.getMemberName() %>님, 안녕하세요.</td>
					</tr>
					<tr>
						<td>
							<button onclick="location.href='<%=request.getContextPath()%>/member/memberView?memberId=<%=memberLoggedIn.getMemberId()%>'">내 정보 보기</button>
							<button onclick="location.href='<%=request.getContextPath()%>/member/logout'">로그아웃</button>
						</td>
					</tr>
				</table>
			<%} %>
				
			</div>
			<!-- 로그인 메뉴 끝-->
			<!-- 메인 메뉴 -->
			<nav>
				<ul class="main-nav">
					<li><a href="<%=request.getContextPath()%>">Home</a></li>
					<li><a href="<%=request.getContextPath()%>/board/boardList">게시판</a></li>
					<%if(memberLoggedIn != null && "A1".equals(memberLoggedIn.getMemberGrade())){ %>
					<li><a href="<%=request.getContextPath()%>/admin/memberList">회원관리</a></li>
					<%} %>
				</ul>
			</nav>
			<!-- 메인 메뉴 끝-->	
		</header>
		
		<section id="content">