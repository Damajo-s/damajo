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
var id = '<%=request.getParameter("id")%>';
	$(function() {
		$('#find').click(function() {
			var hintAnswer = $('#hint-answer').val();
			$.ajax({
				type : 'get',
				data : {
					id : id,
					hint_answer : hintAnswer
				},
				url : '../member/checkhint_ok.do',
				success : function(res) {
					if (res == "true") {
						location.href = "../member/changepassword.do?id=" + id;
					} else {
						alert("일치하지 않습니다. 다시 입력해주세요");
						$('#hint-answer').val("");
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
					<p>내 질문: ${hint }</p>
					<input type="text" name="username" id="hint-answer"
						placeholder="답을 입력해주세요">
					<button type="button" id="find">찾기</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>