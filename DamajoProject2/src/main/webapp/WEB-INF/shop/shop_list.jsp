<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#category-1').click(function(){
		$.ajax({
			type:'post',
			url:'../shop/cpu_list.do',
			success:function(res){
				$('#print').html(res);
			}
		})
	})
	$('#category-2').click(function(){
		$.ajax({
			type:'post',
			url:'../shop/ram_list.do',
			success:function(res){
				$('#print').html(res);
			}
		})
	})
	$('#category-3').click(function(){
		$.ajax({
			type:'post',
			url:'../shop/main_list.do',
			success:function(res){
				$('#print').html(res);
			}
		})
	})
	$('#category-4').click(function(){
		$.ajax({
			type:'post',
			url:'../shop/cpu_list.do',
			success:function(res){
				$('#print').html(res);
			}
		})
	})
})
</script>
</head>
<body>
	<!-- SECTION -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<!-- ASIDE -->
				<div id="aside" class="col-md-3">
					<!-- aside Widget -->
					<div class="aside">
						<h3 class="aside-title">Categories</h3>
						<c:forEach var="cate" items="${cateList }">
							<div class="checkbox-filter">
								<div class="input-checkbox">
									<label class="labelOn" id="category-${cate.category_no }">
										<span></span>
											${cate.category_name }
										<small>(120)</small>
									</label>
								</div>
							</div>
						</c:forEach>
					</div>
					<!-- /aside Widget -->

					<!-- aside Widget -->
					<div class="aside">
						<h3 class="aside-title">Brand</h3>
						<div class="checkbox-filter">
							<div class="input-checkbox">
								<input type="checkbox" id="brand-1">
								<label for="brand-1">
									<span></span>
									SAMSUNG
									<small>(578)</small>
								</label>
							</div>
							<div class="input-checkbox">
								<input type="checkbox" id="brand-2">
								<label for="brand-2">
									<span></span>
									LG
									<small>(125)</small>
								</label>
							</div>
							<div class="input-checkbox">
								<input type="checkbox" id="brand-3">
								<label for="brand-3">
									<span></span>
									SONY
									<small>(755)</small>
								</label>
							</div>
							<div class="input-checkbox">
								<input type="checkbox" id="brand-4">
								<label for="brand-4">
									<span></span>
									SAMSUNG
									<small>(578)</small>
								</label>
							</div>
							<div class="input-checkbox">
								<input type="checkbox" id="brand-5">
								<label for="brand-5">
									<span></span>
									LG
									<small>(125)</small>
								</label>
							</div>
							<div class="input-checkbox">
								<input type="checkbox" id="brand-6">
								<label for="brand-6">
									<span></span>
									SONY
									<small>(755)</small>
								</label>
							</div>
						</div>
					</div>
					<!-- /aside Widget -->
					
					<!-- aside Widget -->
					<div class="aside">
						<h3 class="aside-title">Top selling</h3>
						<div class="product-widget">
							<div class="product-img">
								<img src="./img/product01.png" alt="">
							</div>
							<div class="product-body">
								<p class="product-category">Category</p>
								<h3 class="product-name"><a href="#">product name goes here</a></h3>
								<h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
							</div>
						</div>

						<div class="product-widget">
							<div class="product-img">
								<img src="./img/product02.png" alt="">
							</div>
							<div class="product-body">
								<p class="product-category">Category</p>
								<h3 class="product-name"><a href="#">product name goes here</a></h3>
								<h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
							</div>
						</div>

						<div class="product-widget">
							<div class="product-img">
								<img src="./img/product03.png" alt="">
							</div>
							<div class="product-body">
								<p class="product-category">Category</p>
								<h3 class="product-name"><a href="#">product name goes here</a></h3>
								<h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
							</div>
						</div>
					</div>
					<!-- /aside Widget -->
				</div>
				<!-- /ASIDE -->

				<!-- STORE -->
				<!-- 출력 -->
				<div id="store" class="col-md-9">
					<div id="print">
					
					</div>
				</div>
				<!-- /STORE -->
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /SECTION -->
</body>
</html>