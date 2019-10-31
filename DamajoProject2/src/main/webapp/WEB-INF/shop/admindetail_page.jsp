<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jqeury.js"></script>
<script type="text/javascript">
	var i = 0;
	var j = 0;
	$(function() {
		// QnA 내용 보기
		$('.subject').click(function() {

			$('.content').show();
			$('.adminres').show();
		});
		//QnA 페이지 이동 
		$('.pageAdmin').click(function() {
			var page = $(this).val();
			$.ajax({
				type : 'post',
				url : '../member/admindetail_page.do',
				data : {
					page : page,
					id : id
				},
				success : function(res) {
					$('#print').html(res);
				}
			}); //ajax
		});
var no;
		$('.adminres').click(function() {
			 no = $(this).attr('data-no');
			$('#result').appendTo('#adminres-input' + no);
			$('#result').show();
		});

		$('#resultsubmit').click(function() {
			var text = $('#qnatext').val();
			console.log(text);
			if (text == '') {
				alert("답변을 작성해주세요")
			}else{
				$.ajax({
					type : 'post',
					url : '../member/qnaresult_ok.do',
					data : {
						adminres : text,
						no : no
					},
					success : function(res) {
						location.href = "../member/adminpage.do";
					}
			});
		}
		});
	});
</script>
<style type="text/css">
.pageAdmin, .nextPage, .prePage {
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
</head>
<body>
	<div>
		<table class="table">
			<c:forEach var="vo" items="${list }" varStatus="s">
				<tbody>
					<tr>
						<td class="text-center" width="10%"></td>
						<td class="text-center" class="subject" width="20%"><a>${vo.subject }</a></td>
						<td class="text-center" width="20%">${vo.id }</td>
						<td class="text-center" width="10%">${vo.today }</td>
						<td class="text-cetner" width="10%"><button
								data-no="${vo.no }" class="adminres">답변하기</button></td>
					</tr>
					<tr>
						<td>
							<div id="adminres-input${vo.no }"></div>
						</td>
					</tr>
				</tbody>
			</c:forEach>
			<div>
				<ul class="reviews-pagination">
					<table>
						<c:if test="${curPage>BLOCK }">
							<li><input type=button value="◁"></li>
							<li><input type=button value="&lt;"></li>
						</c:if>
						<c:forEach var="i" begin="${startPage }" end="${endPage }">
							<input type=button class="pageAdmin" value="${i }">
						</c:forEach>
						<c:if test="${endPage<allPage }">
							<li><input type=button value="&gt;"></li>
							<li><input type=button value="▷"></li>
						</c:if>
					</table>
				</ul>
			</div>
		</table>
	</div>
	<div id="result" style="display: none; width: 200px">
		답변 :
		<textarea cols="100" rows="10" id="qnatext"></textarea>
		<button id=resultsubmit>작성</button>

	</div>
</body>
</html>