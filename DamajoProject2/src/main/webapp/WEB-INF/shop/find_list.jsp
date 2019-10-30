<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.page, .nextPage, .prePage{
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
	<!-- partial:index.partial.html -->
	<div class="section" id="print">
		<!-- container -->
		<div class="container">
			<h2 class="product-name">"${searchThis }" 검색 결과</h2>
			<c:forEach var="vo" items="${searchList }">
			<input type="hidden" id="category" value="${vo.category }">
			<input type="hidden" id="searchThis" value="${searchThis }">
			<div class="row">
				<ul class="CalendarList">
					<li>
						<a class="Media Top NoStyle" href="#">
							<img alt="${vo.pname }" src="${vo.poster }"/>
							<div>
								<h4 class="PrimaryFont Blue">${vo.pname }</h4>
							</div>
						</a>
					</li>
				</ul>
			</div>
			</c:forEach>
		</div>
	</div>
	<!-- store bottom filter -->
	<div class="store-filter clearfix">
		<ul class="store-pagination">
		<c:if test="${curpage>BLOCK }">
			<li>
				<input type="button" class="prePage" value="◁" data_page=${startPage-1 } onclick="goTop()">
			</li>
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }" varStatus="s">
			<li id="list${i }" class=${curpage==i? "active":"" }>
				<input type="button" class="page" value="${i }" onclick="goTop()">
			</li>
		</c:forEach>
		<c:if test="${endPage<searchTotalPage }">
			<li>
				<input type="button" class="nextPage" value="▷" data_page=${endPage+1 } onclick="goTop()">
			</li>
		</c:if>
		</ul>
	</div>
	<!-- /store bottom filter -->
<!-- partial -->
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
function goTop(){
	$('html').scrollTop(0);
	// scrollTop 메서드에 0 을 넣어서 실행하면 끝 !!
	// 간혹 이 소스가 동작하지 않는다면
	// $('html, body') 로 해보세요~
}
$(function(){
	$('.page').click(function(){
		var page=$(this).val();
		var category=$("#category").val();
		var searchThis=$("#searchThis").val();
		// alert(category);
		$.ajax({
			type:'POST',
			url:'../shop/find_list_page.do',
			data:{
				page:page,
				category:category,
				searchThis:searchThis
			},
			success:function(res){
				// alert(res);
				$('#print').html(res);
			}
		})
	})
	$('.nextPage').click(function(){
		var nextPage=$(this).attr("data_page");
		var category=$("#category").val();
		var searchThis=$("#searchThis").val();
		// alert(nextPage);
		$.ajax({
			type:'POST',
			url:'../shop/find_list_page.do',
			data:{
				page:nextPage,
				category:category,
				searchThis:searchThis
			},
			success:function(res){
				// alert(res);
				$('#print').html(res);
			}
		})
	})
	$('.prePage').click(function(){
		var prePage=$(this).attr("data_page");
		var category=$("#category").val();
		var searchThis=$("#searchThis").val();
		// alert(prePage);
		$.ajax({
			type:'POST',
			url:'../shop/find_list.do',
			data:{
				page:prePage,
				category:category,
				searchThis:searchThis
			},
			success:function(res){
				// alert(res);
				$('#print').html(res);
			}
		})
	})
})
</script>
<!-- jQuery Plugins -->
<!-- <script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/slick.min.js"></script>
<script src="../js/nouislider.min.js"></script>
<script src="../js/jquery.zoom.min.js"></script>
<script src="../js/main.js"></script> -->
</body>
</html>