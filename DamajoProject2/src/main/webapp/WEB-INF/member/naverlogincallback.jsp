<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>NaverLoginSDK</title>
</head>

<body>
	로그인 중입니다...
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
	<!-- (1) LoginWithNaverId Javscript SDK -->
	<script type="text/javascript"
		src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js"
		charset="utf-8"></script>
	<!-- (2) LoginWithNaverId Javscript 설정 정보 및 초기화 -->
	<script>
		var naverLogin = new naver.LoginWithNaverId(
				{
					clientId : "GqW25713bZO4btcJ5qoU",
					callbackUrl : "http://localhost:8080/mvc/member/naverlogincallback.do",
					isPopup : false,
					callbackHandle : true
				/* callback 페이지가 분리되었을 경우에 callback 페이지에서는 callback처리를 해줄수 있도록 설정합니다. */
				});

		/* (3) 네아로 로그인 정보를 초기화하기 위하여 init을 호출 */
		naverLogin.init();

		/* (4) Callback의 처리. 정상적으로 Callback 처리가 완료될 경우 main page로 redirect(또는 Popup close) */
		window.addEventListener('load', function() {
			naverLogin.getLoginStatus(function(status) {
				if (status) {
					/* (5) 필수적으로 받아야하는 프로필 정보가 있다면 callback처리 시점에 체크 */
					var userEmail = naverLogin.user.getEmail();
					axios.get('../member/api_login_ok.do', {
						params : {
							id : userEmail,
							type : 2
						}
					}).then(function(response) {
						if (response.data == 1) {
						window.location.replace("http://localhost:8080/mvc/main/main.do");
						} else if (response.data == 2) {
						alert("이미 존재하는 아이디입니다.");
						window.location.replace("http://localhost:8080/mvc/member/login.do");
						} else if (response.data == 3) {
							window.location.replace("http://localhost:8080/mvc/main/main.do");
						}
					});
				} else {
					console.log("callback 처리에 실패하였습니다.");
				}
			});
		});
	</script>
</body>

</html>