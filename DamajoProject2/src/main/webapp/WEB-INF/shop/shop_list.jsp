<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
div.col-xs-6 {
	width: 290px;
	height: 450px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#category-1').click(function(){
		var category=$(this).attr('id');
		$.ajax({
			type:'post',
			url:'../shop/cpu_list.do',
			success:function(res){
				$('#print').html(res);
				$('#brand').show();
				$('#recommPrint').hide();
			}
		})
	})
	$('#category-2').click(function(){
		var category=$(this).attr('id');
		$.ajax({
			type:'post',
			url:'../shop/ram_list.do',
			data:{category:category},
			success:function(res){
				$('#print').html(res);
				$('#brand').show();
				$('#recommPrint').hide();
			}
		})
	})
	$('#category-3').click(function(){
		var category=$(this).attr('id');
		$.ajax({
			type:'post',
			url:'../shop/main_list.do',
			data:{category:category},
			success:function(res){
				$('#print').html(res);
				$('#brand').show();
				$('#recommPrint').hide();
			}
		})
	})
	$('#category-4').click(function(){
		var category=$(this).attr('id');
		$.ajax({
			type:'post',
			url:'../shop/vga_list.do',
			data:{category:category},
			success:function(res){
				$('#print').html(res);
				$('#brand').show();
				$('#recommPrint').hide();
			}
		})
	})
	$('#category-5').click(function(){
		var category=$(this).attr('id');
		$.ajax({
			type:'post',
			url:'../shop/ssd_list.do',
			data:{category:category},
			success:function(res){
				$('#print').html(res);
				$('#brand').show();
				$('#recommPrint').hide();
			}
		})
	})
	$('#category-6').click(function(){
		var category=$(this).attr('id');
		$.ajax({
			type:'post',
			url:'../shop/hdd_list.do',
			data:{category:category},
			success:function(res){
				$('#print').html(res);
				$('#brand').show();
				$('#recommPrint').hide();
			}
		})
	})
	$('#category-7').click(function(){
		var category=$(this).attr('id');
		$.ajax({
			type:'post',
			url:'../shop/power_list.do',
			data:{category:category},
			success:function(res){
				$('#print').html(res);
				$('#brand').show();
				$('#recommPrint').hide();
			}
		})
	})
	
	$('.add-to-cart-btn').click(function(){
		alert("관심상품 추가완료")
		//location.href="shop/shop_list.jsp"
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
						<c:forEach var="cate" items="${cateList }" varStatus="s">
							<div class="checkbox-filter">
								<div class="input-checkbox">
									<label class="labelOn" id="category-${cate.category_no }">
										<span></span>
											${cate.category_name }
										<small>(${severalTotalCount[s.index] })</small>
									</label>
								</div>
							</div>
						</c:forEach>
					</div>
					<!-- /aside Widget -->
				</div>
				<!-- /ASIDE -->

				<!-- STORE -->
				<!-- 출력 -->
				<div id="store" class="col-md-9">
					<div class="row"  id="recommPrint" style="display:block">
						<h2> 고객님께 추천드리는 제품 </h2>
						<!-- product -->
						<c:forEach var="recomm" items="${recommList }">
						<form method="post" action="../cart/cartAdd.do">
						<input type="hidden" name="pno" value="${recomm.pno }">
						<input type="hidden" name="pcate" value="${recomm.category }">
						<input type="hidden" name="img" value="${recomm.poster }">
							<div class="col-md-4 col-xs-6">
								<div class="product">
									<div class="product-img">
										<img src="${recomm.poster }" alt="${recomm.pname }">
									</div>
									<div class="product-body">
									<c:if test="${recomm.category==1 }">
										<h3 class="product-name"><a href="cpu_detail.do?no=${recomm.pno }&category=${recomm.category}">${recomm.pname }</a></h3>
									</c:if>
									<c:if test="${recomm.category==2 }">
										<h3 class="product-name"><a href="ram_detail.do?no=${recomm.pno }&category=${recomm.category}">${recomm.pname }</a></h3>
									</c:if>
									<c:if test="${recomm.category==3 }">
										<h3 class="product-name"><a href="main_detail.do?no=${recomm.pno }&category=${recomm.category}">${recomm.pname }</a></h3>
									</c:if>
									<c:if test="${recomm.category==4 }">
										<h3 class="product-name"><a href="vga_detail.do?no=${recomm.pno }&category=${recomm.category}">${recomm.pname }</a></h3>
									</c:if>
									<c:if test="${recomm.category==5 }">
										<h3 class="product-name"><a href="ssd_detail.do?no=${recomm.pno }&category=${recomm.category}">${recomm.pname }</a></h3>
									</c:if>
									<c:if test="${recomm.category==6 }">
										<h3 class="product-name"><a href="hdd_detail.do?no=${recomm.pno }&category=${recomm.category}">${recomm.pname }</a></h3>
									</c:if>
									<c:if test="${recomm.category==7 }">
										<h3 class="product-name"><a href="power_detail.do?no=${recomm.pno }&category=${recomm.category}">${recomm.pname }</a></h3>
									</c:if>
										<h4 class="product-price">${recomm.price }</h4>
										<!-- <div class="product-rating">
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
										</div> -->
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
						</form>
						</c:forEach>
						<!-- /product -->
					</div>
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