<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header>
	<!-- TOP HEADER -->
	<div id="top-header">
		<div class="container">
			<ul class="header-links pull-left">
				<li><a href="#"><i class="fa fa-phone"></i> 02-336-8546</a></li>
				<li><a href="#"><i class="fa fa-envelope-o"></i>
						https://www.sist.co.kr</a></li>
				<li><a href="#"><i class="fa fa-map-marker"></i> 서울특별시 마포구 서교동 447-5</a></li>
			</ul>
			<c:if test="${SessionScope.id != null }">
				<ul class="header-links pull-right">	
						<li style="color: white;">${sessionScope.id }님 환영합니다</li>
					<!-- <li><a href="#"><i class="fa fa-dollar"></i>  원</a></li> -->
					<!-- c:if 문 들어갈 자리 (관리자/ 일반 멤버) -->
	
					<li><a href="../member/login.do"><i class="fa fa-user-o"></i>
							회원정보</a></li>
				</ul>
			</c:if>
			<c:if test="${SessionScope.id == null }">
				<ul class="header-links pull-right">	
						<li style="color: white;"><i class="fa fa-user-o"></i>
							<a href="../member/login.do">로그인</a></li>
				</ul>
			</c:if>
		</div>
	</div>
	<!-- /TOP HEADER -->

	<!-- MAIN HEADER -->
	<div id="header">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<!-- LOGO 미사용 삭제-->
				<!-- <div class="col-md-3">
							<div class="header-logo">
								<a href="#" class="logo">
									<img src="./img/logo.png" alt="">
								</a>
							</div>
						</div> -->
				<!-- /LOGO -->

				<!-- SEARCH BAR -->
				<div class="col-md-9">
					<div class="header-search">
					<!-- 폼태그==> 검색 옵션 줘야함 -->
						<form>
							<select class="input-select">
								<option value="0">All</option>
								<option value="1">CPU</option>
								<option value="2">RAM</option>
								<option value="3">메인보드</option>
								<option value="4">VGA</option>
								<option value="5">SSD</option>
								<option value="6">HDD</option>
								<option value="7">파워</option>
							</select> <input class="input" placeholder="Search here">
							<button class="search-btn">Search</button>
						</form>
					</div>
				</div>
				<!-- /SEARCH BAR -->

				<c:if test="${sessionScope.id != null }">	
				<!-- 로그인해야 장바구니 및 관심상품 활성화됨 -->
				<!-- ACCOUNT -->
				<div class="col-md-3 clearfix">
					<div class="header-ctn">
						<!-- Wishlist -->
						<div>
							<a href="#"> <i class="fa fa-heart-o"></i> <span>관심상품</span>
								<div class="qty">2</div> <!-- 배지 넣을 자리 즉, 카운트를 받아와야함-->
							</a>
						</div>
						<!-- /Wishlist -->

						<!-- Cart -->
						<div class="dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown"
								aria-expanded="true"> <i class="fa fa-shopping-cart"></i> <span>장바구니</span>
								<div class="qty">3</div> <!-- 배지 넣을 자리 -->
							</a>
							
							<div class="cart-dropdown">
								<div class="cart-list">
									<div class="product-widget">
										<div class="product-img">
											<img src="../img/product01.png" alt="">
										</div>
										<div class="product-body">
											<h3 class="product-name">
												<a href="#">product name goes here</a>
											</h3>
											<h4 class="product-price">
												<span class="qty">1x</span>$980.00
											</h4>
										</div>
										<button class="delete">
											<i class="fa fa-close"></i>
										</button>
									</div>
					
									<!-- <div class="product-widget">
												<div class="product-img">
													<img src="./img/product02.png" alt="">
												</div>
												<div class="product-body">
													<h3 class="product-name"><a href="#">product name goes here</a></h3>
													<h4 class="product-price"><span class="qty">3x</span>$980.00</h4>
												</div>
												<button class="delete"><i class="fa fa-close"></i></button>
											</div> -->
								</div>
								<div class="cart-summary">
									<small>3 Item(s) selected</small>
									<h5>SUBTOTAL: $2940.00</h5>
								</div>
								<div class="cart-btns">
									<a href="#">View Cart</a> <a href="#">Checkout <i
										class="fa fa-arrow-circle-right"></i></a>
								</div>
							</div>
							
						</div>
						<!-- /Cart -->

						<!-- Menu Toogle -->
						<div class="menu-toggle">
							<a href="#"> <i class="fa fa-bars"></i> <span>Menu</span>
							</a>
						</div>
						<!-- /Menu Toogle -->
					</div>
				</div>
				<!-- /ACCOUNT -->
				</c:if>
			</div>
			<!-- row -->
		</div>
		<!-- container -->
	</div>
	<!-- /MAIN HEADER -->
</header>