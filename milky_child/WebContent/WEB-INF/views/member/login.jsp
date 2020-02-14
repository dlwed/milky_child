<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn");
	// /mvc/index.jsp => memberLoggedIn = null;
	// /mvc/member/login => memberLoggedIn = member객체
			
			
	//쿠키확인
	Cookie[] cookies = request.getCookies();
	boolean saveIdChecked = false;
	String memberId = "";
	
	if(cookies != null){
		//System.out.println("cookies@header.jsp");
		//System.out.println("===================================");
		for(Cookie c : cookies){
			String name = c.getName();
			String value = c.getValue();
			//System.out.println(name + " = " + value);
			
			if("saveId".equals(name)){
				saveIdChecked = true;
				memberId = value;
			}
		}
		//System.out.println("===================================");
		
	}
	
%>
<!DOCTYPE html>
<!-- saved from url=(0051)https://getbootstrap.com/docs/4.4/examples/sign-in/ -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.6">
    <title>Signin Template · Bootstrap</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.4/examples/sign-in/">

    <!-- Bootstrap core CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <!-- Favicons -->
<link rel="apple-touch-icon" href="https://getbootstrap.com/docs/4.4/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
<link rel="icon" href="https://getbootstrap.com/docs/4.4/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
<link rel="icon" href="https://getbootstrap.com/docs/4.4/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
<link rel="manifest" href="https://getbootstrap.com/docs/4.4/assets/img/favicons/manifest.json">
<link rel="mask-icon" href="https://getbootstrap.com/docs/4.4/assets/img/favicons/safari-pinned-tab.svg" color="#563d7c">
<link rel="icon" href="https://getbootstrap.com/docs/4.4/assets/img/favicons/favicon.ico">
<meta name="msapplication-config" content="/docs/4.4/assets/img/favicons/browserconfig.xml">
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

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    
    
    
    
    
    
    
    <!-- Custom styles for this template -->
    <link href="../css/signin.css" rel="stylesheet">
  </head>
  <body class="text-center">
    <form class="form-signin" action="<%=request.getContextPath() %>/member/login"
    method="POST"
    onsubmit="return loginValidate();">
    <!-- 로고 -->
  <img class="mb-4" src="../css/bootstrap-solid.svg" alt="" width="72" height="72">
  
  
  
  <script>
function loginValidate(){
	let $memberId = $("#login-memberId");
	let $password = $("#login-password");
	console.log($memberId);
	
	//1.아이디검사
	if($memberId.val().trim().length < 4){
		alert("올바른 아이디를 입력하세요.");
		$memberId.focus();
		return false;
	}
	
	//2.비밀번호검사
	if($password.val().trim().length < 4){
		alert("올바른 비밀번호를 입력하세요.");
		$password.select();
		return false;
	}
	
	
	return true;
}


</script>
  
  
  
  
  
  
  
  <!-- 실질적인 form진행부분 -->
  <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
  <label for="inputEmail" class="sr-only">ID</label>
  <input type="memberId" id="inputEmail" class="form-control" placeholder="ID" name="memberId" required="" autofocus=""
		id="login-memberId"   value="<%=saveIdChecked?memberId:"" %>"
  >
  <label for="inputPassword" class="sr-only">Password</label>
  <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" required="">
  <div class="checkbox mb-3">
    <label>
      <input type="checkbox" value="remember-me"
      name="saveId"  id="saveId" <%=saveIdChecked?"checked":"" %>> Remember ID
    </label>
  </div>
  <button class="btn btn-lg btn-primary btn-block" type="submit">Sign In</button>
  <button style="background: orange"class="btn btn-lg btn-primary btn-block" type="button" onclick="location.href='<%=request.getContextPath() %>/member/srchid'">ID/PW Search</button>
  <button class="btn btn-lg btn-primary btn-block" type="button" onclick="location.href='<%=request.getContextPath() %>/member/memberEnroll'">Sign Up</button>
  <p class="mt-5 mb-3 text-muted">© 2017-2019</p>
</form>


</body></html>