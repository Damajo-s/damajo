<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link type="text/css" rel="stylesheet" href="../css/login.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script>
var id = '<%=session.getAttribute("id")%>';
	$(function() {
		$('#delete').click(function() {
			var pwd = $('#password').val();
			var pwdCheck = $('#password-check').val();
			if (pwd != pwdCheck) {
				alert("입력값을 다시 확인해주세요");
				$('#password-check').val("");
				$('#password').val("");
			}
			$.ajax({
				type : 'get',
				data : {
					id : id,
					pwd : pwd
				},
				url : '../member/deleteaccount_ok.do',
				success : function(res) {
					if (res == 'true')
						location.href = "../member/logout.do";
					else {
						alert("잘못된 비밀번호 입니다.");
						$('#password').val();
						$('#password-check').val();
					}
				}
			});
		});
	});
</script>
</head>
<body>
	<!-- BREADCRUMB -->
	<div id="breadcrumb" class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<div class="col-md-12">
					<h3 class="breadcrumb-header">계정 삭제</h3>
				</div>
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /BREADCRUMB -->

	<div class="cd-tabs">
		<form method="post" action="/find/password.do?action=daumid-check">
			<div class="box_detail">
				<div class="form-fild">
					<p>계정 삭제를 위해 비밀번호를 입력해주세요</p>
					<input type="text" name="username" id="password"
						placeholder="비밀번호를 입력해주세요"> <input type="text"
						name="username" id="password-check" placeholder="비밀번호를 다시 입력해주세요">
					<button type="button" id="delete">삭제</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>