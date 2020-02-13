<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%

	Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn");
	// /mvc/index.jsp => memberLoggedIn = null;
	// /mvc/member/login => memberLoggedIn = member객체
	String grade="";
	String userId="";
	if(memberLoggedIn!=null){
	grade= memberLoggedIn.getGrade();
	userId=memberLoggedIn.getMemberId();
	System.out.println("유저 정보 "+userId);
	}
	//쿠키확인
	Cookie[] cookies = request.getCookies();
	boolean saveIdChecked = false;
	String memberId = "";

	if (cookies != null) {
		//System.out.println("cookies@header.jsp");
		//System.out.println("===================================");
		for (Cookie c : cookies) {
			String name = c.getName();
			String value = c.getValue();
			//System.out.println(name + " = " + value);

			if ("saveId".equals(name)) {
				saveIdChecked = true;
				memberId = value;
			}
		}
		//System.out.println("===================================");

	}
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<!-- 부트스트랩 css 호출 -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
	


	<!-- 채성이 css 자료들 -->
	<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
	<script src="<%=request.getContextPath()%>/layout/scripts/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/layout/scripts/jquery.backtotop.js"></script>
    <script src="<%=request.getContextPath()%>/layout/scripts/jquery.mobilemenu.js"></script>
    <link href="<%=request.getContextPath()%>/layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
    
		
	<!-- 정우 JS파일 호출 -->
	<script src="<%=request.getContextPath()%>/js/bootstrap.bundle.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.slim.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
    
    <!-- 메타 자료들. -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>

<body id="top">

    <!--회사정보-->
    <div class="wrapper row0">
      <div id="topbar" class="hoc clear"> 

        <ul>
          <li><i class="fa fa-clock-o"></i> Mon. - Fri. 8am - 5pm</li>
          <li><i class="fa fa-phone"></i> +00 (123) 456 7890</li>
          <li><i class="fa fa-envelope-o"></i> info@domain.com</li>
          <li><a href="#"><i class="fa fa-lg fa-home"></i></a></li>
          <li><a href="#" title="Login"><i class="fa fa-lg fa-sign-in"></i></a></li>
          <li><a href="#" title="Sign Up"><i class="fa fa-lg fa-edit"></i></a></li>
        </ul>
      </div>
    </div>
    <!--회사정보-->

				</button>
			</div>
		</div>







    <!--회사 로고 / 로그인-->
    
    <div class="wrapper row1">
      <header id="header" class="hoc clear"> 
        <div id="logo" class="fl_left">
          <h1><a href="<%=request.getContextPath()%>">MILKY WORLD</a></h1>
        </div>
        	<div class="login-container" style=" border-color: red;" >
					<%
						if (memberLoggedIn != null) {
					%>
					<!-- 로그인한 경우 -->
						<div class="fl_right">
					<table id="logged-in" style="padding: 0px;  border-color:red;">
						<tr>
							<td><span class="navbar-toggler" style="padding: 0px; " ><%=memberLoggedIn.getMemberName()%>님,
									안녕하세요.</span></td>
							<td rowspan="2" style="text-align: center;">
							<img src="<%=request.getContextPath() %>/images/usericon.png" alt="" onclick="location.href='<%=request.getContextPath()%>/member/memberView?memberId=<%=memberLoggedIn.getMemberId()%>'" style="cursor:pointer;"/>
							</td>
						</tr>
						<tr>
							<td style="text-align: center; ">
						<a class="btn"onclick="location.href='<%=request.getContextPath()%>/member/logout'">Log-Out</a></div>
							</td>
						</tr>
					</table>
					</div>
					<%
						} else {
					%>
					<!-- 로그인하지 않은 경우 -->
					<%-- <div class="fl_right"><a class="btn"onclick="location.href='<%=request.getContextPath() %>/member/srchid'">Search-ID</a></div> --%>
					<div class="fl_right"><a class="btn"onclick="location.href='<%=request.getContextPath()%>/member/signin'">Login-In</a></div>
					<%
						}
					%>
				</div>
        
        
      </header>
    </div>
     <!--회사 로고 / 로그인-->



         <!--menubar-->
        <nav id="mainav" class="hoc clear"> 
          <ul class="clear">
            <li class="active"><a href="<%=request.getContextPath() %>/company/companyIntroDesign">회사소개</a></li>
            <li><a class="drop" href="#">Pages</a>
              <ul>
                <li><a href="pages/gallery.html">Gallery</a></li>
                <li><a href="pages/full-width.html">Full Width</a></li>
                <li><a href="pages/sidebar-left.html">Sidebar Left</a></li>
                <li><a href="pages/sidebar-right.html">Sidebar Right</a></li>
                <li><a href="pages/basic-grid.html">Basic Grid</a></li>
              </ul>
            </li>
            <li><a class="drop" href="#">Pages</a>
                <ul>
                  <li><a href="pages/gallery.html">Gallery</a></li>
                  <li><a href="pages/full-width.html">Full Width</a></li>
                  <li><a href="pages/sidebar-left.html">Sidebar Left</a></li>
                  <li><a href="pages/sidebar-right.html">Sidebar Right</a></li>
                  <li><a href="pages/basic-grid.html">Basic Grid</a></li>
                </ul>
              </li>
              <li><a class="drop" href="#">Pages</a>
                <ul>
                  <li><a href="pages/gallery.html">Gallery</a></li>
                  <li><a href="pages/full-width.html">Full Width</a></li>
                  <li><a href="pages/sidebar-left.html">Sidebar Left</a></li>
                  <li><a href="pages/sidebar-right.html">Sidebar Right</a></li>
                  <li><a href="pages/basic-grid.html">Basic Grid</a></li>
                </ul>
              </li>
              <li><a class="drop" href="#">Pages</a>
                <ul>
                  <li><a href="pages/gallery.html">Gallery</a></li>
                  <li><a href="pages/full-width.html">Full Width</a></li>
                  <li><a href="pages/sidebar-left.html">Sidebar Left</a></li>
                  <li><a href="pages/sidebar-right.html">Sidebar Right</a></li>
                  <li><a href="pages/basic-grid.html">Basic Grid</a></li>
                </ul>
              </li>
              <%if(memberLoggedIn!=null && grade.contains("A")) {%>
              <li><a class="drop" href="#">ADMIN-PAGE</a>
                <ul>
                  <li><a href="pages/gallery.html">ADMIN-PAGE</a></li>
                  <li><a href="pages/full-width.html">ADMIN-PAGE</a></li>
                  <li><a href="pages/sidebar-left.html">ADMIN-PAGE</a></li>
                  <li><a href="pages/sidebar-right.html">ADMIN-PAGE</a></li>
                  <li><a href="pages/basic-grid.html">ADMIN-PAGE</a></li>
                  <%} %>
                </ul>
              </li>
          </ul> 
        </nav>
    <!--menubar-->

   

<%-- 

<!DOCTYPE html>
<!-- saved from url=(0049)https://getbootstrap.com/docs/4.4/examples/album/ -->
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v3.8.6">

<title>Album example · Bootstrap</title>

<!-- <link rel="stylesheet" href="assets_1/css/main.css" /> -->
<link rel="stylesheet" href="assets_1/css/ie9.css" />
<link rel="canonical"
	href="https://getbootstrap.com/docs/4.4/examples/album/">



<!-- Bootstrap core CSS -->
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<!-- Favicons -->
<link rel="apple-touch-icon"
	href="https://getbootstrap.com/docs/4.4/assets/img/favicons/apple-touch-icon.png"
	sizes="180x180">
<link rel="icon"
	href="https://getbootstrap.com/docs/4.4/assets/img/favicons/favicon-32x32.png"
	sizes="32x32" type="image/png">
<link rel="icon"
	href="https://getbootstrap.com/docs/4.4/assets/img/favicons/favicon-16x16.png"
	sizes="16x16" type="image/png">
<link rel="manifest"
	href="https://getbootstrap.com/docs/4.4/assets/img/favicons/manifest.json">
<link rel="mask-icon"
	href="https://getbootstrap.com/docs/4.4/assets/img/favicons/safari-pinned-tab.svg"
	color="#563d7c">
<link rel="icon"
	href="https://getbootstrap.com/docs/4.4/assets/img/favicons/favicon.ico">
<meta name="theme-color" content="#563d7c">


<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<link href="<%=request.getContextPath()%>/css/album.css"
	rel="stylesheet">
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script>
	window.jQuery
			|| document
					.write(
							'<script src="/docs/4.4/assets/js/vendor/jquery.slim.min.js"><\/script>')
</script>
<script src="<%=request.getContextPath()%>/js/bootstrap.bundle.min.js"
	integrity="sha384-6khuMg9gaYr5AxOqhkVIODVIvm9ynTT5J4V1cfthmT+emCG6yVmEZsRHdxlotUnm"
	crossorigin="anonymous"></script>



</head>
	<header>
		<div class="navbar navbar-dark bg-dark shadow-sm" style="height: 150px; border-color: rgba(255,255,255,0);">
			<div class="container d-flex justify-content-between" style=" border-color: rgba(255,255,255,0);">
				<a href="<%=request.getContextPath()%>" style=""
					class="navbar-brand d-flex align-items-center"> <svg
						xmlns="http://www.w3.org/2000/svg" width="20" height="20"
						fill="none" stroke="currentColor" stroke-linecap="round"
						stroke-linejoin="round" stroke-width="2" aria-hidden="true"
						class="mr-2" viewBox="0 0 24 24" focusable="false">
						<path
							d="M23 19a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h4l2-3h6l2 3h4a2 2 0 0 1 2 2z"></path>
						<circle cx="12" cy="13" r="4"></circle></svg> <strong>Milky
						World</strong>
				</a>


				<div class="login-container" style=" border-color: red;" >
					<%
						if (memberLoggedIn != null) {
					%>
					<!-- 로그인한 경우 -->
					<table id="logged-in" style="padding: 0px;  border-color:red;">
						<tr>
							<td><span class="navbar-toggler" style="padding: 0px; " ><%=memberLoggedIn.getMemberName()%>님,
									안녕하세요.</span></td>
							<td rowspan="2" style="text-align: center;">
							<img src="<%=request.getContextPath() %>/images/usericon.png" alt="" onclick="location.href='<%=request.getContextPath()%>/member/memberView?memberId=<%=memberLoggedIn.getMemberId()%>'" style="cursor:pointer;"/>
							</td>
						</tr>
						<tr>
							<td style="text-align: center; ">
							<button class="navbar-toggler" 
									onclick="location.href='<%=request.getContextPath()%>/member/logout'">
									<h3>Log-Out</h3>
								</button>
							</td>
						</tr>
					</table>
					<%
						} else {
					%>
					<!-- 로그인하지 않은 경우 -->
					<button class="navbar-toggler" type="button"
						onclick="location.href='<%=request.getContextPath()%>/member/signin'">
						<span>Sign-In</span>
					</button>
					  <input type="button" value="찾기" tableindex="3" onclick="location.href='<%=request.getContextPath() %>/member/srchid'" >
					<%
						}
					%>
				</div>
				</button>
			</div>
		</div>




	</header>
	<body>



<style>
body, ol, ul {
	margin: 0;
	padding: 0;
}
ol, ul, li {
	list-style: none;
}
a {
	text-decoration: none;
}
.clearfix::before, .clearfix::after {
	content: "";
	display: block;
}
.clearfix::after {
	clear: both;
}
body {
	font-family: "Open Sans", sans-serif;
	font-size: 1em;
}
nav {
	position: absolute;
	z-index: 100;
	width: 100%;
	height: 40px;
	font-size: 0.875em;
	background-color: #fff;
}
nav > ul {
	height: 40px;
	text-align: center;
	overflow: hidden;
	-webkit-transition: height 0.4s;
	transition: height 0.4s;
}
nav > ul > li {
	display: inline-block;
}
nav > ul > li > a {
	display: block;
	padding: 0 40px;
	height: 40px;
	line-height: 40px;
	font-weight: 600;
	background-color: #fff;
	color: #666;
}
nav ul ul a {
	display: block;
	/* padding: 0 35px 0 40px; */
	line-height: 38px;
	font-weight: 400;
	color: #ccc;
	-webkit-transition: all 300ms;
	transition: all 300ms;
}
nav ul ul li:first-child a {
	padding-top: 5px;
}
nav ul ul li:last-child a {
	padding-bottom: 5px;
}
.sub_shadow {
	 position: absolute; 
	left: 0;
	 top: 237px; 
	z-index: 10;
	width: 100%;
	height: 0;
	background-color: #999;
	transition: height 0.4s;
}
nav:hover > ul {
	height: 202px;
}
nav:hover .sub_shadow {
	height: 162px;
}
nav > ul > li:hover ul li {
	background-color: #888;
}
nav ul ul a:hover {
	text-decoration: underline;
	color: #fff;
}
</style>
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
</head>
<div><div class="sub_shadow"></div>
	<nav>
	
		<ul>
			<li>
				<a href="<%=request.getContextPath() %>/company/companyIntroDesign">회사소개</a>
				<ul>
					<li><a href="">2depth</a></li>
					<li><a href="">2depth</a></li>
					<li><a href="">2depth</a></li>
					<li><a href="">2depth</a></li>
				</ul>
			</li>
			<li>
				<a href="">보호소</a>
				<ul>
					<li><a href="<%=request.getContextPath() %>/selter/selterList">보호소 조회</a></li>
					<li><a href="">2depth</a></li>
					<li><a href="">2depth</a></li>
					<li><a href="">2depth</a></li>
				</ul>
			</li>
			<li>
				<a href="">1DEPTH</a>
				<ul>
					<li><a href="">2depth</a></li>
					<li><a href="">2depth</a></li>
					<li><a href="">2depth</a></li>
					<li><a href="">2depth</a></li>
				</ul>
			</li>
			<li>
				<a href="">1DEPTH</a>
				<ul>
					<li><a href="">2depth</a></li>
					<li><a href="">2depth</a></li>
					<li><a href="">2depth</a></li>
					<li><a href="">2depth</a></li>
				</ul>
			</li>
			<li>
				<a href="">1DEPTH</a>
				<ul>
					<li><a href="">2depth</a></li>
					<li><a href="">2depth</a></li>
					<li><a href="">2depth</a></li>
					<li><a href="">2depth</a></li>
				</ul>
			</li>
			
			<% if(memberLoggedIn != null && grade.contains("A")){ %>
			<li> 
				<a href="">허파고야 여기다 .</a>
				<ul>
					<li><a href="">2depth</a></li>
					<li><a href="">2depth</a></li>
					<li><a href="">2depth</a></li>
					<li><a href="">2depth</a></li>
				</ul>
			</li>
				<% }%>
		</ul>
	</nav>
</div>
 --%>