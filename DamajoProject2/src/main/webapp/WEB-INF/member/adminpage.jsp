<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script>

var id = '';
	$(function() {
		$('.infoBtn').click(function() {
			var no = $(this).attr('data-no');
			id = $(this).attr('data-id');
			$.ajax({
				type : 'post',
				url : '../member/admindetail_page.do',
				data : {
					page : 1,
					id : id
				},
				success : function(res) {
					$('#print').html(res);
					$('#show').appendTo('#detail' + no);
					$('#show').show();
				}
			});
		});


	});
</script>
<style type="text/css">
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
</style>
<title>Insert title here</title>

</head>
<body>
	<div style="margin: 0px auto;">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>가입경로</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="memberInfo" items="${member }">
					<tr>
						<td>${memberInfo.id }</td>
						<td>${memberInfo.type }</td>
						<td>
							<p>
								<button class="infoBtn" data-no="${memberInfo.no }"
									data-id="${memberInfo.id }">정보보기</button>
								<a href="#" class="btn btn-default">계정탈퇴</a>
							</p>
						<td>
					</tr>
					<tr><td><div id="detail${memberInfo.no }"></div><td></tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
				<ul class="reviews-pagination">
					<table>
						<c:if test="${curPage>BLOCK }">
							<li><input type=button value="◁"></li>
							<li><input type=button value="&lt;"></li>
						</c:if>
						<c:forEach var="i" begin="${startPage }" end="${endPage }">
							<li><a type=button class="page" href="../member/adminpage.do?page=${i}">${i }</a></li>
						</c:forEach>
						<c:if test="${endPage<allPage }">
							<li><input type=button value="&gt;"></li>
							<li><input type=button value="▷"></li>
						</c:if>
					</table>
				</ul>
			</div>
	</div>
	<div id="show" style="display: none;">
		<section class="admin1">
		<h2>작성한 Q&A</h2>
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

		</div>
		<!-- /tab2  --> </section>
	</div>
</body>
</html>