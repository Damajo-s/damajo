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
		// alert(page);
		$.ajax({
			type:'POST',
			url:'../shop/ram_list.do',
			data:{page:page},
			success:function(res){
				// alert(res);
				$('#print').html(res);
			}
		})
	})
	$('.nextPage').click(function(){
		var nextPage=$(this).attr("data_page");
		// alert(nextPage);
		$.ajax({
			type:'POST',
			url:'../shop/ram_list.do',
			data:{page:nextPage},
			success:function(res){
				// alert(res);
				$('#print').html(res);
			}
		})
	})
	$('.prePage').click(function(){
		var prePage=$(this).attr("data_page");
		// alert(prePage);
		$.ajax({
			type:'POST',
			url:'../shop/ram_list.do',
			data:{page:prePage},
			success:function(res){
				// alert(res);
				$('#print').html(res);
			}
		})
	})
})
</script>
</head>
<body>
	<!-- STORE -->
	<!-- store top filter -->
	<!-- 
	<div class="store-filter clearfix">
		<ul class="store-grid">
			<li class="active"><i class="fa fa-th"></i></li>
			<li><a href="#"><i class="fa fa-th-list"></i></a></li>
		</ul>
	</div>
	 -->
	<!-- /store top filter -->

	<!-- store products -->
	<div class="row" id="print">
		<!-- product -->
		<c:forEach var="vo" items="${ramList }">
		<div class="col-md-4 col-xs-6">
			<div class="product">
				<div class="product-img">
					<img src="${vo.poster }" alt="">
				</div>
				<div class="product-body">
					<h3 class="product-name"><a href="ram_detail.do?no=${vo.ram_no }">${vo.ram_name }</a></h3>
					<h4 class="product-price">${vo.price }원</h4>
					<!-- <del class="product-old-price">${vo.price }원</del> -->
					<div class="product-rating">
						<i class="fa fa-star"></i>
						<i class="fa fa-star"></i>
						<i class="fa fa-star"></i>
						<i class="fa fa-star"></i>
						<i class="fa fa-star-o"></i>
					</div>
					<div class="product-btns">
						<button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
						<button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>
						<button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
					</div>
				</div>
				<div class="add-to-cart">
					<button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
				</div>
			</div>
		</div>
		</c:forEach>
		<!-- /product -->
	</div>
	<!-- /store products -->

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
		<c:if test="${endPage<ramTotalPage }">
			<li>
				<input type="button" class="nextPage" value="▷" data_page=${endPage+1 } onclick="goTop()">
			</li>
		</c:if>
		</ul>
	</div>
	<!-- /store bottom filter -->
	<!-- /STORE -->
</body>
</html>