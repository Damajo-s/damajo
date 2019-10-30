<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$.ajax({
			type : 'post',
			url : '../member/mydetail_page.do',
			data : {
				page : 1
			},
			success : function(res) {
				$('#print').html(res);
			}
		});
		//QnA 페이지 이동 
		$('.page').click(function() {
			var page = $(this).val();
			var product = $('#pro').val();
			$.ajax({
				type : 'post',
				url : '../member/mydetail_page.do',
				data : {
					page : page
				},
				success : function(res) {
					$('#print').html(res);
				}
			}); //ajax
		}); //page
	});
</script>
<style type="text/css">
/**
 * Vertical align anything with 3 lines of CSS (excluding vendor prefixes)
 *
 * .element {
 *   position: relative;
 *   top: 50%;
 *   transform: translateY(-50%);
 * }
 * -----------------------------------------
 * Read more at: zerosixthree.se/vertical-align-anything-with-just-3-lines-of-css/
 */
.page, .nextPage, .prePage {
	color: #2B2D42;
	font-weight: 500;
	-webkit-transition: 0.2s color;
	transition: 0.2s color;
	position: relative;
	width: 40px;
	height: 40px;
	line-height: 40px;
	background: transparent;
	border: none;
	-webkit-transition: 0.2s all;
	transition: 0.2s all;
}

.text p {
	position: relative;
	top: 50%;
	-webkit-transform: translateY(-50%);
	-ms-transform: translateY(-50%);
	transform: translateY(-50%);
}

.image img {
	position: relative;
	top: 50%;
	-webkit-transform: translateY(-50%);
	-ms-transform: translateY(-50%);
	transform: translateY(-50%);
}

.button-1 {
	width: 140px;
	height: 50px;
	border: 2px solid #34495e;
	float: left;
	text-align: center;
	cursor: pointer;
	position: relative;
	box-sizing: border-box;
	overflow: hidden;
	margin: 0 0 40px 0;
}

.button-1 a {
	font-family: arial;
	font-size: 16px;
	color: #34495e;
	text-decoration: none;
	line-height: 50px;
	transition: all .5s ease;
	z-index: 2;
	position: relative;
}

.block-of-text p {
	position: relative;
	top: 50%;
	-webkit-transform: translateY(-50%);
	-ms-transform: translateY(-50%);
	transform: translateY(-50%);
}

/* ====================================
   Base styling, to make the demo more fancy
   ==================================== */
@import
	url(https://fonts.googleapis.com/css?family=Roboto:400,300,700,100);

.admin1 {
	display: block;
	max-width: 1000px;
	border-style: solid;
	border-color: black;
	margin: 0 auto;
	height: 400px;
	border-radius: .2em;
	position: relative;
	color: black;
	-webkit-transform-style: preserve-3d;
	-moz-transform-style: preserve-3d;
	transform-style: preserve-3d; img , p { padding : 1em;
	margin: 0;
}

}
.admin2 {
	display: block;
	max-width: 1000px;
	border-style: solid;
	border-color: black;
	margin: 0 auto;
	height: 300px;
	border-radius: .2em;
	position: relative;
	color: black;
	-webkit-transform-style: preserve-3d;
	-moz-transform-style: preserve-3d;
	transform-style: preserve-3d; img , p { padding : 1em;
	margin: 0;
}

}
.block-of-text {
	height: 220px;
}
</style>
</head>
<body>
	<section class="admin2">
	<h2>회원정보</h2>
	<div class="button-1">
		<a href="../member/changepassword.do?id=${id }">비밀번호 수정</a>
	</div>
	<p></p>
	<div class="button-1">
		<a href="../member/deleteaccount.do">회원 탈퇴</a>
	</div>
	</section>
	<p></p>
	<section class="admin1">
	<h2>내가 작성한 후기</h2>
	</section>

	<p></p>
	<section class="admin1">
	<h2>내가 작성한 Q&A</h2>
	<!-- tab2 : Q&A  -->
	<div>
		<div class="col-md-12">
			<table class="table" width="80%" cellspacing="0">
				<thead>
					<tr>
						<th class="text-center" width="10%">답변상태</th>
						<th class="text-center" width="20%">제목</th>
						<th class="text-center" width="5%"></th>
						<th class="text-center" width="20%">작성자</th>
						<th class="text-center" width="10%">작성일</th>
					</tr>
				</thead>
			</table>
		</div>
		<div class="col-md-12" id="print"></div>
		<div>
			<ul class="reviews-pagination">
				<table>
					<c:if test="${curPage>BLOCK }">
						<li><input type=button value="◁"></li>
						<li><input type=button value="&lt;"></li>
					</c:if>
					<c:forEach var="i" begin="${startPage }" end="${endPage }">
						<li><input type=button class="page" value="${i }"></li>
					</c:forEach>
					<c:if test="${endPage<allPage }">
						<li><input type=button value="&gt;"></li>
						<li><input type=button value="▷"></li>
					</c:if>
				</table>
			</ul>
		</div>
	</div>
	<!-- /tab2  --> </section>
</body>
</html>