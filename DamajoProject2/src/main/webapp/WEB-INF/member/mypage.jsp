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
<style>
/*
CSS for the main interaction
*/
.tabset>input[type="radio"] {
	position: absolute;
	left: -200vw;
}

.tabset .tab-panel {
	display: none;
}

.tabset>input:first-child:checked ~ .tab-panels>.tab-panel:first-child,
	.tabset>input:nth-child(3):checked ~ .tab-panels>.tab-panel:nth-child(2),
	.tabset>input:nth-child(5):checked ~ .tab-panels>.tab-panel:nth-child(3),
	.tabset>input:nth-child(7):checked ~ .tab-panels>.tab-panel:nth-child(4),
	.tabset>input:nth-child(9):checked ~ .tab-panels>.tab-panel:nth-child(5),
	.tabset>input:nth-child(11):checked ~ .tab-panels>.tab-panel:nth-child(6)
	{
	display: block;
}

/*
Styling
*/
body {
	font: 16px/1.5em "Overpass", "Open Sans", Helvetica, sans-serif;
	color: #333;
	font-weight: 300;
}

.tabset>label {
	position: relative;
	display: inline-block;
	padding: 15px 15px 25px;
	border: 1px solid transparent;
	border-bottom: 0;
	cursor: pointer;
	font-weight: 600;
}

.tabset>label::after {
	content: "";
	position: absolute;
	left: 15px;
	bottom: 10px;
	width: 22px;
	height: 4px;
	background: #8d8d8d;
}

.tabset>label:hover, .tabset>input:focus+label {
	color: #06c;
}

.tabset>label:hover::after, .tabset>input:focus+label::after, .tabset>input:checked+label::after
	{
	background: #06c;
}

.tabset>input:checked+label {
	border-color: #ccc;
	border-bottom: 1px solid #fff;
	margin-bottom: -1px;
}

.tab-panel {
	padding: 30px;
	border-top: 1px solid #ccc;
}

.change {
	display: inline-block;
	width: 150x;
	height: 50px;
	border: 2px solid #426FC5;
	text-align: center;
	font-size: 12px;
	position: relative;
	box-sizing: border-box;
}

.change a {
	font-size: 12px;
	text-align: center;
	text-decoration: none;
	line-height: 40px;
	transition: all .5s ease;
	z-index: 2;
	position: relative;
	font-family: 'Open Sans', sans-serif;
}

.delete {
	display: inline-block;
	width: 150px;
	height: 50px;
	border: 2px solid #e94043;
	text-align: center;
	font-size: 12px;
	position: relative;
	box-sizing: border-box;
	width: 150px;
}

.delete a {
	font-size: 12px;
	text-align: center;
	text-decoration: none;
	line-height: 40px;
	transition: all .5s ease;
	z-index: 2;
	position: relative;
	font-family: 'Open Sans', sans-serif;
}

/*
Demo purposes only
*/
*, *:before, *:after {
	box-sizing: border-box;
}

#total {
	padding: 100px 200px;
}

/* #review{
	width: 500px;
}

#qna{
	width: 500px;
	}
	
#myinfo{
	width: 500px;
	} */
.tabset {
	max-width: 65em;
}
</style>
</head>
<body>
	<section id="total">
	<div class="tabset">
		<!-- Tab 1 -->
		<input type="radio" name="tabset" id="tab1" aria-controls="marzen"
			checked> <label for="tab1">Review</label>
		<!-- Tab 2 -->
		<input type="radio" name="tabset" id="tab2" aria-controls="rauchbier">
		<label for="tab2">Q&A</label>
		<!-- Tab 3 -->
		<input type="radio" name="tabset" id="tab3" aria-controls="dunkles">
		<label for="tab3">My Info</label>

		<div class="tab-panels">
			<section id="review" class="tab-panel">
			<h5>내가 작성한 후기</h5>
			<hr>

			</section>
			<section id="qna" class="tab-panel"> <!-- tab2 : Q&A  -->
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
			<section id="myinfo" class="tab-panel">
			<h5 style="text-align: center;">내 정보</h5>
			<hr>
			<div class="change">
				<a href="../member/changepassword.do?id=${id }">비밀번호 수정</a>
			</div>
			<div class="delete">
				<a href="../member/deleteaccount.do">회원 탈퇴</a>
			</div>
			</section>
		</div>
	</div>
	</section>
</body>