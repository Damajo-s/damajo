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
	$(function() {
		$('#find').click(function() {
			var id = $('#username').val();
			$.ajax({
				type : 'get',
				url : '../member/findpassword_ok.do',
				data : {
					id : id,
					type : 1
				},
				success : function(response) {
					if (response > 0) {
						location.href="../member/checkhint.do?id="+id;
					} else {
						alert("아이디가 존재하지 않습니다. 다시 입력해주세요");
						$('#username').val("");
					}
				}
			});
		})
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
					<h3 class="breadcrumb-header">비밀번호 찾기</h3>
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
					<input type="text" name="username" id="username"
						placeholder="아이디를 입력해주세요">
					<button type="button" id="find">찾기</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>