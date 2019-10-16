'use strict';

window.addEventListener('load', windowLoaded, false);

function windowLoaded() {
	// 네이버 로그인
	var naverLogin = new naver.LoginWithNaverId({
		clientId : "GqW25713bZO4btcJ5qoU",
		callbackUrl : "http://localhost:8080/mvc/member/naverlogincallback.do",
		isPopup : false, /* 팝업을 통한 연동처리 여부 */
		loginButton : {
			color : "white",
			type : 2,
			height : 40,
			width : 100
		}
	/* 로그인 버튼의 타입을 지정 */
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
		label.className = 'focused';
	}
}