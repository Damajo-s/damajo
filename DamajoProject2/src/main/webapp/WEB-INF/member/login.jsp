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
			<li><a href="#" data-content="login" class="selected">login</a></li>
			<li><a href="#" data-content="signup">signup</a></li>
		</ul>
		</nav>
		<ul class="cd-tabs-content">
			<li data-content="login" class="selected">
				<div class="form-fild">
					<input type="text" name="username" id="login-username"
						placeholder="아이디를 입력해주세요">
				</div>
				<div class="form-fild">
					<input type="password" name="password" id="login-password"
						placeholder="비밀번호를 입력해주세요">
				</div> <input type="hidden" name="type" value="1" id="logintype">
				<span class="error"></span>
				<div>
					<p>
					<div id="naverIdLogin" style="display: inline-block;"></div>
					<a id="kakao-login-btn"></a> <input type="button" id="login-button"
						class="button-1" value="Login">
					<p>
				<div class="button-1"><a href = "../member/findpassword.do">&nbsp;비밀번호 찾기</a></div>
				</div>
			</li>
			<li data-content="signup">
				<div class="form-fild">
					<input type="text" name="susername" id="signup-username"
						placeholder="아이디를 입력해주세요">
				</div>
				<div class="form-fild">
					<input type="password" name="spassword" id="signup-password"
						placeholder="비밀번호를 입력해주세요">
				</div>
				<div class="form-fild">
					<input type="password" name="spassword2" id="signup-passwordcheck"
						placeholder="비밀번호를 다시 입력해주세요">
				</div>
				<div class="form-fild">
					<input type="text" name="password-hint" id="signup-hint"
						placeholder="비밀번호 힌트를 입력해주세요">
				</div>
				<div class="form-fild">
					<input type="text" name="password-hintanswer"
						id="signup-hintanswer" placeholder="비밀번호 힌트에 대한 답을 입력해주세요">
				</div> <input type="button" id="signup-button" class="button-1"
				value="submit">
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