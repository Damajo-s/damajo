'use strict';
document
		.write('<script src="https://unpkg.com/axios/dist/axios.min.js"></script>');
window.addEventListener('load', windowLoaded, false);

function windowLoaded() {
	// 네이버 로그인
	var naverLogin = new naver.LoginWithNaverId({
		clientId : "GqW25713bZO4btcJ5qoU",
		callbackUrl : "http://localhost:8080/mvc/member/naverlogincallback.do",
		isPopup : false, /* 팝업을 통한 연동처리 여부 */
		callbackHandle: false,
		loginButton : {
			color : "white",
			type : 3,
			width : 222,
			height: 50
		}
	});
	

	/* 설정정보를 초기화하고 연동을 준비 */
	naverLogin.init();
	
	// 카카오 로그인
	Kakao.init('c444dd0ac65fe591c10736f6c0dc3f97'); // 사용할 앱의 JavaScript키 설정
	Kakao.Auth.createLoginButton({
		container : '#kakao-login-btn',
		success : function(authObj) {
			Kakao.API.request({ // 로그인 성공시, API를 호출
				url : '/v1/user/me', // 사용자 정보 요청
				success : function(res) {
					var userEmail = res.kaccount_email; // 유저의 이메일
					console.log(userEmail);
					axios.get('../member/api_login_ok.do', {
						params : {
							id : userEmail,
							type : 3
						}
					}).then(function(response) {
						window.location.replace("http://localhost:8080/mvc/main/main.do");
					});
				},
				fail : function(error) {
					alert(JSON.stringify(error));
				}
			});
		},
		fail : function(err) {
			alert(JSON.stringify(err));
		}
	});
	// codepen 자체 js
	var tabs = document.querySelectorAll('.cd-tabs')[0], login = document
			.querySelectorAll('a[data-content=\'login\']')[0], signup = document
			.querySelectorAll('a[data-content=\'signup\']')[0], tabContentWrapper = document
			.querySelectorAll('ul.cd-tabs-content')[0], currentContent = document
			.querySelectorAll('li.selected')[0];

	login.addEventListener('click', clicked, false);
	signup.addEventListener('click', clicked, false);

	var loginButton = document.getElementById('loginBtn');
	loginButton.addEventListener("click", function() {
		var id = document.getElementById('login-username').value;
		var pwd = document.getElementById('login-password').value;
		if (id == '' || pwd == '') {
			alert("아이디와 패스워드를 입력해주세요");
			return;
		}
		axios({
			method : 'POST',
			url : '../member/damajo_login_ok.do',
			params : {
				id : id,
				pwd : pwd,
				type : 1
			}
			}).then(function(response) {
				if(response.data ==1){	
				window.location.replace("http://localhost:8080/mvc/main/main.do");
			}else if(response.data==4){
				alert("잘못된 아이디 혹은 패스워드 입니다.");
			}else if(response.data==5){
				alert("아이디가 없습니다");
			}
		});
	});
	
	var signupButton = document.getElementById('signin');
	signupButton.addEventListener("click", function() {
		var id = document.getElementById('signup-username').value;
		var pwd = document.getElementById('signup-password').value;
		var pwdCheck = document.getElementById('signup-passwordcheck').value;
		var hintAnswer = document.getElementById('signup-hintanswer').value;
		var hint = document.getElementById('signup-hint').value;
		console.log(hintAnswer);
		if (id == '' || pwd == '') {
			alert("아이디와 패스워드를 입력해주세요");
			return;
		}
		if(pwd != pwdCheck){
			alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			return;
		}

		axios({
			method : 'POST',
			url : '../member/damajo_signup_ok.do',
			params : {
				id : id,
				pwd : pwd,
				hint : hint,
				hint_answer : hintAnswer,
				type : 1
			}
		
			}).then(function(response) {
			if(response.data ==1){
				window.location.replace("http://localhost:8080/mvc/main/main.do");
			}else if(response.data==4){
				alert("잘못된 아이디 혹은 패스워드 입니다.")
			}else if(response.data ==5){
				alert("이미 존재하는 아이디입니다.");
			}
		});
	});
	function clicked(event) {
		event.preventDefault();
		var selectedItem = event.currentTarget;
		if (selectedItem.className === 'selected') {
			// ...
		} else {
			var selectedTab = selectedItem.getAttribute('data-content'), selectedContent = document
					.querySelectorAll('li[data-content=\'' + selectedTab
							+ '\']')[0];
			if (selectedItem == login) {
				signup.className = '';
				login.className = 'selected';
			} else {
				login.className = '';
				signup.className = 'selected';
			}
			currentContent.className = '';
			currentContent = selectedContent;
			selectedContent.className = 'selected';

		}
	}

	var inputs = document.querySelectorAll('input');
	for (var i = 0; i < inputs.length; i++) {
		inputs[i].addEventListener('focus', inputFocused, false);
	}

	function inputFocused(event) {
		var label = document.querySelectorAll('label[for=\'' + this.name
				+ '\']')[0];
		label.className = 'focusd';
	}
}