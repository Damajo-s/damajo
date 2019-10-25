<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	<div class="row">
		<!-- product -->
		<c:forEach var="vo" items="${ramList }">
		<div class="col-md-4 col-xs-6">
			<div class="product">
				<div class="product-img">
					<img src="${vo.poster }" alt="">
				</div>
				<div class="product-body">
					<h3 class="product-name"><a href="#">${vo.ram_name }</a></h3>
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
		<span class="store-qty">Showing 20-100 products</span>
		<ul class="store-pagination">
			<li class="active">1</li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#"><i class="fa fa-angle-right"></i></a></li>
		</ul>
	</div>
	<!-- /store bottom filter -->
	<!-- /STORE -->
</body>
</html>