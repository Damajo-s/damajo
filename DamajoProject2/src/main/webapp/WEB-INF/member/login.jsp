<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/login.js"></script>
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js"
	charset="utf-8"></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<link type="text/css" rel="stylesheet" href="../css/login.css">
</head>
<body>
	<img src="http://image005.flaticon.com/1/svg/74/74229.svg"
		alt="user icon" class="logo">
	<div class="cd-tabs">
		<nav>
		<ul class="cd-tabs-navigation">
			<li><a href="#" data-content="login" class="selected">Login</a></li>
			<li><a href="#" data-content="signup">SingUp</a></li>
		</ul>
		</nav>
		<ul class="cd-tabs-content">
			<li data-content="login" class="selected">
				<div class="form-fild">
					<input type="text" name="username" id="login-username"
						placeholder="E-mail">
				</div>
				<div class="form-fild">
					<input type="password" name="password" id="login-password"
						placeholder="Password">
				</div> <input type="hidden" name="type" value="1" id="logintype">
				<span class="error"></span>
					<!-- <div id="naverIdLogin" style="display: inline-block;"></div>
					<a id="kakao-login-btn"></a>  -->
				<div id="loginAndFind" >
					<input type="button" id="loginBtn" class="loginBtn" value="Login">
				<div class="FindBtn"><a href = "../member/findpassword.do">ForGet Password</a></div>
				</div>
				<hr>
				<div id="apiLogin">
					<div id="naverIdLogin"></div>
					<a id="kakao-login-btn"></a>
				</div>
			</li>
			
			<li data-content="signup">
				<div class="form-fild">
					<input type="text" name="susername" id="signup-username"
						placeholder="E-mail">
				</div>
				<div class="form-fild">
					<input type="password" name="spassword" id="signup-password"
						placeholder="Password">
				</div>
				<div class="form-fild">
					<input type="password" name="spassword2" id="signup-passwordcheck"
						placeholder="Retype Password">
				</div>
				<div class="form-fild">
					<input type="text" name="password-hint" id="signup-hint"
						placeholder="Hint Question (Find Password)">
				</div>
				<div class="form-fild">
					<input type="text" name="password-hintanswer"
						id="signup-hintanswer" placeholder="Hint Answer (Find Password)">
				</div> 
				
				<div id="SignIn">
					<input type="button" id="signin" class="signin"
					value="SIGNIN">
				</div>
				
			</li>
		</ul>
	</div>
	<!-- end cd-tabs -->
	<footer>
	<div>
		Icons made by <a href="http://www.freepik.com" title="Freepik">Freepik</a>
		from <a href="http://www.flaticon.com" title="Flaticon">www.flaticon.com</a>
		is licensed by <a href="http://creativecommons.org/licenses/by/3.0/"
			title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a>
	</div>
	</footer>
</body>
</html>