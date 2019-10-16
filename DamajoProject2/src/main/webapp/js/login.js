'use strict';

window.addEventListener('load', windowLoaded, false);

function windowLoaded() {
	// 네이버 로그인
	var naverLogin = new naver.LoginWithNaverId(
			{
				clientId: "GqW25713bZO4btcJ5qoU",
				callbackUrl: "http://localhost:8080/mvc/member/naverlogincallback.do",
				isPopup: false, /* 팝업을 통한 연동처리 여부 */
				loginButton: {color: "white", type: 2, height: 40,width:100} /* 로그인 버튼의 타입을 지정 */
			}
		);
		
		/* 설정정보를 초기화하고 연동을 준비 */
		naverLogin.init();

	var 
		tabs = document.querySelectorAll('.cd-tabs')[0],
		login = document.querySelectorAll('a[data-content=\'login\']')[0],
		signup = document.querySelectorAll('a[data-content=\'signup\']')[0],
		tabContentWrapper = document.querySelectorAll('ul.cd-tabs-content')[0],
		currentContent = document.querySelectorAll('li.selected')[0];

	login.addEventListener('click', clicked, false);
	signup.addEventListener('click', clicked, false);

	function clicked(event) {
		event.preventDefault();
    
		var selectedItem = event.currentTarget;
		if (selectedItem.className === 'selected') {
      // ...       
		} else {
			var selectedTab = selectedItem.getAttribute('data-content'),
				selectedContent = document.querySelectorAll('li[data-content=\'' + selectedTab + '\']')[0];

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
		var label = document.querySelectorAll('label[for=\''+ this.name +'\']')[0];
		label.className = 'focused';
	}
}	
