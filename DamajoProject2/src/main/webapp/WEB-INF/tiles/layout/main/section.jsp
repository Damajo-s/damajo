<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
			<div class="row">
				<!-- shop -->
				<div class="col-md-4 col-xs-6">
					<div class="shop">
						<div class="shop-img">
							<img src="../img/product01.png" alt="" width="360px" height="240px">
						</div>
						<div class="shop-body">
							<h3>
								CPU<br>Collection
							</h3>
							<a href="#" class="cta-btn">구매하기 <i class="fa fa-arrow-circle-right"></i></a>
						</div>
					</div>
				</div>
				<!-- /shop -->

				<!-- shop -->
				<div class="col-md-4 col-xs-6">
					<div class="shop">
						<div class="shop-img">
							<img src="../img/shop02.png" alt="" width="360px" height="240px">
						</div>
						<div class="shop-body">
							<h3>
								RAM<br>Collection
							</h3>
							<a href="#" class="cta-btn">구매하기 <i class="fa fa-arrow-circle-right"></i></a>
						</div>
					</div>
				</div>
				<!-- /shop -->

				<!-- shop -->
				<div class="col-md-4 col-xs-6">
					<div class="shop">
						<div class="shop-img">
							<img src="../img/shop03.png" alt="" width="360px" height="240px">
						</div>
						<div class="shop-body">
							<h3>
								MainBoard<br>Collection
							</h3>
							<a href="#" class="cta-btn">구매하기 <i class="fa fa-arrow-circle-right"></i></a>
						</div>
					</div>
				</div>
				<!-- /shop -->
			</div>
			<!-- /row -->
			
			<!-- row -->
			<div class="row">
				<!-- shop -->
				<div class="col-md-4 col-xs-6">
					<div class="shop">
						<div class="shop-img">
							<img src="../img/product03.png" alt="" width="360px"
								height="240px">
						</div>
						<div class="shop-body">
							<h3>
								VGA<br>Collection
							</h3>
							<a href="#" class="cta-btn">구매하기 <i class="fa fa-arrow-circle-right"></i></a>
						</div>
					</div>
				</div>
				<!-- /shop -->

				<!-- shop -->
				<div class="col-md-4 col-xs-6">
					<div class="shop">
						<div class="shop-img">
							<img src="../img/product04.png" alt="" width="360px"
								height="240px">
						</div>
						<div class="shop-body">
							<h3>
								SSD<br>Collection
							</h3>
							<a href="#" class="cta-btn">구매하기 <i
								class="fa fa-arrow-circle-right"></i></a>
						</div>
					</div>
				</div>
				<!-- /shop -->

				<!-- shop -->
				<div class="col-md-4 col-xs-6">
					<div class="shop">
						<div class="shop-img">
							<img src="../img/product05.png" alt="" width="360px"
								height="240px">
						</div>
						<div class="shop-body">
							<h3>
								Power<br>Collection
							</h3>
							<a href="#" class="cta-btn">구매하기 <i
								class="fa fa-arrow-circle-right"></i></a>
						</div>
					</div>
				</div>
				<!-- /shop -->
			</div>
			<!-- /row -->
			<!-- row -->
			<div class="row">
				<!-- shop -->
				<div class="col-md-4 col-xs-6">
					<div class="shop">
						<div class="shop-img">
							<img src="../img/product08.png" alt="" width="360px"
								height="240px">
						</div>
						<div class="shop-body">
							<h3>
								HDD<br>Collection
							</h3>
							<a href="#" class="cta-btn">구매하기 <i
								class="fa fa-arrow-circle-right"></i></a>
						</div>
					</div>
					<!-- /shop -->
				</div>
				<!-- /row -->
			</div>
			<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->

		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">

					<!-- section title -->
					<div class="col-md-12" style="margin-top: 1cm;">
						<div class="section-title">
							<h3 class="title">New Arrivals</h3>
							<div class="section-nav">
								<ul class="section-tab-nav tab-nav">
									<li class="active"><a data-toggle="tab" href="#tab1">CPU</a></li>
									<li><a data-toggle="tab" href="#tab2">SSD</a></li>
									<li><a data-toggle="tab" href="#tab3">RAM</a></li>
									<li><a data-toggle="tab" href="#tab4">메인보드</a></li>
									<li><a data-toggle="tab" href="#tab5">그래픽카드</a></li>
								</ul>
							</div>
						</div>
					</div>
					<!-- /section title -->

					<!-- Products tab & slick -->
					<div class="col-md-12">
						<div class="row">
							<div class="products-tabs">
								<!-- tab -->
								<div id="tab1" class="tab-pane active" >
									<div class="products-slick" data-nav="#slick-nav-1">
										<!-- product -->
										<c:forEach begin="1" end="6"  var="cpuN" items="${cnlist }">
										<div class="product">
											<div class="product-img">
												<img src="${cpuN.poster }" alt="">
												<div class="product-label">
													<span class="new">NEW</span>
												</div>
											</div>
											<div class="product-body">
												<p class="product-category">${cpuN.company }</p>
												<h3 class="product-name"><a href="../shop/cpu_detail.do?no=${cpuN.cpu_no }&category=${cpuN.category}">${cpuN.cpu_name }</a></h3>
												<h4 class="product-price">${cpuN.price } <del class="product-old-price">${cpuN.price }</del></h4>
												<div class="product-rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
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
										</c:forEach>
										<!-- /product -->
									</div>
								</div>
								<!-- /tab -->
								
								<!-- tab -->
								<div id="tab2" class="tab-pane">
									<div class="products-slick" data-nav="#slick-nav-2">
										<!-- product -->
										<c:forEach begin="1" end="6" items="${snlist }" var="ssdN" varStatus="s">
										<div class="product">
											<div class="product-img">
												<img src="${ssdN.poster }" alt="">
												<div class="product-label">
													<span class="new">NEW</span>
												</div>
											</div>
											<div class="product-body">
												<p class="product-category">${ssdN.company }</p>
												<h3 class="product-name"><a href="../shop/ssd_detail.do?no=${ssdN.ssd_no }&category=${ssdN.category}">${ssdN.ssd_name }</a></h3>
												<h4 class="product-price">${ssdN.price }<del class="product-old-price">${ssdN.price }</del></h4>
												<div class="product-rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
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
										</c:forEach>
										<!-- /product -->
									</div>
								</div>
								<!-- /tab -->
							
								<!-- tab -->
								<div id="tab3" class="tab-pane">
									<div class="products-slick" data-nav="#slick-nav-3">
										<!-- product -->
										<c:forEach begin="6" end="11" items="${rnlist }" var="ramN">
										<div class="product">
											<div class="product-img">
												<img src="${ramN.poster }" alt="">
												<div class="product-label">
													<span class="new">NEW</span>
												</div>
											</div>
											<div class="product-body">
												<p class="product-category">${ramN.company }  ${ramN.memory_capacity }</p>
												<h3 class="product-name"><a href="../shop/ram_detail.do?no=${ramN.ram_no }&category=${ramN.category}">${ramN.ram_name }</a></h3>
												<h4 class="product-price">${ramN.price} <del class="product-old-price">${ramN.price}</del></h4>
												<div class="product-rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
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
										</c:forEach>
										<!-- /product -->
									</div>
								</div>
								<!-- /tab -->
								
								<!-- tab -->
								<div id="tab4" class="tab-pane" >
									<div class="products-slick" data-nav="#slick-nav-4">
										<!-- product -->
										<c:forEach begin="1" end="6" items="${mnlist }" var="mN">
										<div class="product">
											<div class="product-img">
												<img src="${mN.poster }" alt="">
												<div class="product-label">
													<span class="new">NEW</span>
												</div>
											</div>
											<div class="product-body">
												<p class="product-category">${mN.company }</p>
												<h3 class="product-name"><a href="../shop/main_detail.do?no=${mN.main_no }&category=${mN.category}">${mN.main_name }</a></h3>
												<h4 class="product-price">${mN.price } <del class="product-old-price">${mN.price }</del></h4>
												<div class="product-rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
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
										</c:forEach>
										<!-- /product -->
									</div>
								</div>
								<!-- /tab -->
								
								<!-- tab -->
								<div id="tab5" class="tab-pane" >
									<div class="products-slick" data-nav="#slick-nav-5">
										<!-- product -->
										<c:forEach begin="1" end="6" items="${vnlist }" var="vn">
										<div class="product">
											<div class="product-img">
												<img src="${vn.poster }" alt="">
												<div class="product-label">
													<span class="new">NEW</span>
												</div>
											</div>
											<div class="product-body">
												<p class="product-category">${vn.company }</p>
												<h3 class="product-name"><a href="../shop/vag_detail.do?no=${vn.vga_no }&category=${vn.category}">${vn.vga_name }</a></h3>
												<h4 class="product-price">${vn.price } <del class="product-old-price">${vn.price }</del></h4>
												<div class="product-rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
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
										</c:forEach>
										<!-- /product -->
									</div>
								</div>
								<!-- /tab -->
								
							</div>
						</div>
					</div>
					<!-- Products tab & slick -->
						
					
					<!-- section title -->
					<div class="col-md-12" style="margin-top: 1cm;">
						<div class="section-title">
							<h3 class="title">MD<sup>'s</sup>  Recommend</h3>
							<div class="section-nav">
								<ul class="section-tab-nav tab-nav">
									<li class="active"><a data-toggle="tab" href="#tab6">CPU</a></li>
									<li><a data-toggle="tab" href="#tab7">SSD</a></li>
									<li><a data-toggle="tab" href="#tab8">RAM</a></li>
									<li><a data-toggle="tab" href="#tab9">메인보드</a></li>
									<li><a data-toggle="tab" href="#tab10">그래픽카드</a></li>
								</ul>
							</div>
						</div>
					</div>
					<!-- /section title -->

					<!-- Products tab & slick -->
					<div class="col-md-12">
						<div class="row">	
							<div class="products-tabs">
								<!-- tab -->
								<div id="tab6" class="tab-pane active" >
									<div class="products-slick" data-nav="#slick-nav-6">
										<!-- product -->
										<c:forEach begin="1" end="6" items="${crlist }" var="cpuR">
										<div class="product">
											<div class="product-img">
												<img src="${cpuR.poster }" alt="">
												<div class="product-label">
													<span class="new">HOT</span>
												</div>
											</div>
											<div class="product-body">
												<p class="product-category">${cpuR.company }</p>
												<h3 class="product-name"><a href="../shop/cpu_detail.do?no=${cpuR.cpu_no }&category=${cpuR.category}">${cpuR.cpu_name }</a></h3>
												<h4 class="product-price">${cpuR.price } <del class="product-old-price">${cpuR.price }</del></h4>
												<div class="product-rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
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
										</c:forEach>
										<!-- /product -->
									</div>
								</div>
								<!-- /tab -->
								
								<!-- tab -->
								<div id="tab7" class="tab-pane">
									<div class="products-slick" data-nav="#slick-nav-7">
										<!-- product -->
										<c:forEach begin="1" end="6" items="${srlist }" var="ssdR" >
										<div class="product">
											<div class="product-img">
												<img src="${ssdR.poster }" alt="">
												<div class="product-label">
													<span class="new">HOT</span>
												</div>
											</div>
											<div class="product-body">
												<p class="product-category">${ssdR.company }</p>
												<h3 class="product-name"><a href="../shop/ssd_detail.do?no=${ssdR.ssd_no }&category=${ssdR.category}">${ssdR.ssd_name }</a></h3>
												<h4 class="product-price">${ssdR.price } <del class="product-old-price">${ssdR.price }</del></h4>
												<div class="product-rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
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
										</c:forEach>
										<!-- /product -->
									</div>
								</div>
								<!-- /tab -->
							
								<!-- tab -->
								<div id="tab8" class="tab-pane">
									<div class="products-slick" data-nav="#slick-nav-8">
										<!-- product -->
										<c:forEach begin="27" end="32" items="${rrlist }" var="ramR">
										<div class="product">
											<div class="product-img">
												<img src="${ramR.poster }" alt="">
												<div class="product-label">
													<span class="new">HOT</span>
												</div>
											</div>
											<div class="product-body">
												<p class="product-category">${ramR.company } ${ramR.memory_capacity }</p>
												<h3 class="product-name"><a href="../shop/ram_detail.do?no=${ramR.ram_no }&category=${ramR.category}">${ramR.ram_name}</a></h3>
												<h4 class="product-price">${ramR.price}<del class="product-old-price">${ramR.price}</del></h4>
												<div class="product-rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
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
										</c:forEach>
										<!-- /product -->
									</div>
								</div>
								<!-- /tab -->
								
								<!-- tab -->
								<div id="tab9" class="tab-pane" >
									<div class="products-slick" data-nav="#slick-nav-9">
										<!-- product -->
										<c:forEach begin="1" end="6" items="${mrlist }" var="mR">
										<div class="product">
											<div class="product-img">
												<img src="${mR.poster }" alt="">
												<div class="product-label">
													<span class="new">HOT</span>
												</div>
											</div>
											<div class="product-body">
												<p class="product-category">${mR.company }</p>
												<h3 class="product-name"><a href="../shop/main_detail.do?no=${mR.main_no }&category=${mR.category}">${mR.main_name }</a></h3>
												<h4 class="product-price">${mR.price }<del class="product-old-price">${mR.price }</del></h4>
												<div class="product-rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
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
										</c:forEach>
										<!-- /product -->
									</div>
								</div>
								<!-- /tab -->
								
								<!-- tab -->
								<div id="tab10" class="tab-pane" >
									<div class="products-slick" data-nav="#slick-nav-10">
										<!-- product -->
										<c:forEach begin="1" end="6" items="${vrlist }" var="vr">
										<div class="product">
											<div class="product-img">
												<img src="${vr.poster }" alt="">
												<div class="product-label">
													<span class="new">HOT</span>
												</div>
											</div>
											<div class="product-body">
												<p class="product-category">${vr.company }</p>
												<h3 class="product-name"><a href="../shop/vga_detail.do?no=${vr.vga_no }&category=${vr.category}">${vr.vga_name}</a></h3>
												<h4 class="product-price">${vr.price}<del class="product-old-price">${vr.price}</del></h4>
												<div class="product-rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
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
										</c:forEach>
										<!-- /product -->
									</div>
								</div>
								<!-- /tab -->
								
							</div>
						</div>
					</div>
					<!-- Products tab & slick -->
					
					
					
					
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->
	
		<!-- HOT DEAL SECTION -->
		<div id="hot-deal" class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<div class="col-md-12">
						<div class="hot-deal">
							<a href="../shop/find_list.do?category=0&searchThis=삼성">
							<img alt="" src="http://image5.compuzone.co.kr/img/images/main2014/H/CenterLineFixBanner_53507.jpg">
							</a>
							<!-- 삼성 모음전 광고 이미지 -->
						</div>
					</div>
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /HOT DEAL SECTION -->

		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">

					<!-- section title -->
					<div class="col-md-12">
						<div class="section-title">
							<h3 class="title">cheaper price</h3>
							<div class="section-nav">
								<ul class="section-tab-nav tab-nav">
									<li><a data-toggle="tab" href="#tab11">그래픽카드</a></li>
									<li class="active"><a data-toggle="tab" href="#tab12">HDD</a></li>
									<li><a data-toggle="tab" href="#tab13">RAM</a></li>
									<li><a data-toggle="tab" href="#tab14">POWER</a></li>
								</ul>
							</div>
						</div>
					</div>
					<!-- /section title -->

					<!-- Products tab & slick  광고 밑 탭 -->
					<div class="col-md-12">
						<div class="row">
							<div class="products-tabs">
								<!-- tab -->
								<div id="tab11" class="tab-pane">
									<div class="products-slick" data-nav="#slick-nav-2">
										<!-- product -->
										<c:forEach begin="63" end="66" items="${vrlist }" var="vr">
										<div class="product">
											<div class="product-img">
												<img src="${vr.poster }" alt="">
											</div>
											<div class="product-body">
												<p class="product-category">${vr.company }</p>
												<h3 class="product-name"><a href="../shop/vga_detail.do?no=${vr.vga_no }&category=${vr.category}">${vr.vga_name}</a></h3>
												<h4 class="product-price">${vr.price}</h4>
												<div class="product-rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
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
										</c:forEach>
										<!-- /product -->
									</div>
								</div>
								<!-- /tab -->
								
								
								<!-- tab -->
								<div id="tab12" class="tab-pane active">
									<div class="products-slick" data-nav="#slick-nav-2">
										<!-- product -->
										<c:forEach begin="30" end="33" items="${hlist }" var="h">
										<div class="product">
											<div class="product-img">
												<img src="${h.poster }" alt="">
											</div>
											<div class="product-body">
												<p class="product-category">${h.company }</p>
												<h3 class="product-name"><a href="../shop/hdd_detail.do?no=${h.hdd_no }&category=${h.category}">${h.hdd_name }</a></h3>
												<h4 class="product-price">${h.price }</h4>
												<div class="product-rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
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
										</c:forEach>
										<!-- /product -->
									</div>
								</div>
								<!-- /tab -->
								
								
								<!-- tab -->
								<div id="tab13" class="tab-pane">
									<div class="products-slick" data-nav="#slick-nav-2">
										<!-- product -->
										<c:forEach begin="1" end="4" items="${rrlist }" var="ramR" >
										<div class="product">
											<div class="product-img">
												<img src="${ramR.poster }" alt="">
											</div>
											<div class="product-body">
												<p class="product-category">${ramR.company } ${ramR.memory_capacity }</p>
												<h3 class="product-name"><a href="../shop/ram_detail.do?no=${ramR.ram_no }&category=${ramR.category}">${ramR.ram_name}</a></h3>
												<h4 class="product-price">${ramR.price}</h4>
												<div class="product-rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
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
										</c:forEach>
										<!-- /product -->
									</div>
								</div>
								<!-- /tab -->
								
								
								<!-- tab -->
								<div id="tab14" class="tab-pane">
									<div class="products-slick" data-nav="#slick-nav-2">
										<!-- product -->
										<c:forEach begin="27" end="30" items="${plist }" var="p" >
										<div class="product">
											<div class="product-img">
												<img src="${p.poster }" alt="">
											</div>
											<div class="product-body">
												<p class="product-category">${p.company }</p>
												<h3 class="product-name"><a href="../shop/power_detail.do?no=${p.power_no }&category=${p.category}">${p.power_name }</a></h3>
												<h4 class="product-price">${p.price }</h4>
												<div class="product-rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
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
										</c:forEach>
										<!-- /product -->
									</div>
								</div>
								<!-- /tab -->
								
								
							</div>
						</div>
					</div>
					<!-- /Products tab & slick -->

				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->

		<!-- SECTION -->
		<!-- <div class="section">
			container
			<div class="container">
				row
				<div class="row">
					<div class="col-md-4 col-xs-6">
						<div class="section-title">
							<h4 class="title">Top selling1111</h4>
							<div class="section-nav">
								<div id="slick-nav-3" class="products-slick-nav"></div>
							</div>
						</div>

						<div class="products-widget-slick" data-nav="#slick-nav-3">
							<div>
								product widget
								<div class="product-widget">
									<div class="product-img">
										<img src="./img/product07.png" alt="">
									</div>
									<div class="product-body">
										<p class="product-category">Category</p>
										<h3 class="product-name"><a href="../shop/detail.do">product name goes here</a></h3>
										<h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
									</div>
								</div>
								/product widget

								product widget
								<div class="product-widget">
									<div class="product-img">
										<img src="./img/product08.png" alt="">
									</div>
									<div class="product-body">
										<p class="product-category">Category</p>
										<h3 class="product-name"><a href="../shop/detail.do">product name goes here</a></h3>
										<h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
									</div>
								</div>
								/product widget

								product widget
								<div class="product-widget">
									<div class="product-img">
										<img src="./img/product09.png" alt="">
									</div>
									<div class="product-body">
										<p class="product-category">Category</p>
										<h3 class="product-name"><a href="../shop/detail.do">product name goes here</a></h3>
										<h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
									</div>
								</div>
								product widget
							</div>

							<div>
								product widget
								<div class="product-widget">
									<div class="product-img">
										<img src="./img/product01.png" alt="">
									</div>
									<div class="product-body">
										<p class="product-category">Category</p>
										<h3 class="product-name"><a href="../shop/detail.do">product name goes here</a></h3>
										<h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
									</div>
								</div>
								/product widget

								product widget
								<div class="product-widget">
									<div class="product-img">
										<img src="./img/product02.png" alt="">
									</div>
									<div class="product-body">
										<p class="product-category">Category</p>
										<h3 class="product-name"><a href="../shop/detail.do">product name goes here</a></h3>
										<h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
									</div>
								</div>
								/product widget

								product widget
								<div class="product-widget">
									<div class="product-img">
										<img src="./img/product03.png" alt="">
									</div>
									<div class="product-body">
										<p class="product-category">Category</p>
										<h3 class="product-name"><a href="../shop/detail.do">product name goes here</a></h3>
										<h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
									</div>
								</div>
								product widget
							</div>
						</div>
					</div>

					<div class="col-md-4 col-xs-6">
						<div class="section-title">
							<h4 class="title">Top selling</h4>
							<div class="section-nav">
								<div id="slick-nav-4" class="products-slick-nav"></div>
							</div>
						</div>

						<div class="products-widget-slick" data-nav="#slick-nav-4">
							<div>
								product widget
								<div class="product-widget">
									<div class="product-img">
										<img src="./img/product04.png" alt="">
									</div>
									<div class="product-body">
										<p class="product-category">Category</p>
										<h3 class="product-name"><a href="../shop/detail.do">product name goes here</a></h3>
										<h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
									</div>
								</div>
								/product widget

								product widget
								<div class="product-widget">
									<div class="product-img">
										<img src="./img/product05.png" alt="">
									</div>
									<div class="product-body">
										<p class="product-category">Category</p>
										<h3 class="product-name"><a href="../shop/detail.do">product name goes here</a></h3>
										<h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
									</div>
								</div>
								/product widget

								product widget
								<div class="product-widget">
									<div class="product-img">
										<img src="./img/product06.png" alt="">
									</div>
									<div class="product-body">
										<p class="product-category">Category</p>
										<h3 class="product-name"><a href="../shop/detail.do">product name goes here</a></h3>
										<h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
									</div>
								</div>
								product widget
							</div>

							<div>
								product widget
								<div class="product-widget">
									<div class="product-img">
										<img src="./img/product07.png" alt="">
									</div>
									<div class="product-body">
										<p class="product-category">Category</p>
										<h3 class="product-name"><a href="../shop/detail.do">product name goes here</a></h3>
										<h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
									</div>
								</div>
								/product widget

								product widget
								<div class="product-widget">
									<div class="product-img">
										<img src="./img/product08.png" alt="">
									</div>
									<div class="product-body">
										<p class="product-category">Category</p>
										<h3 class="product-name"><a href="../shop/detail.do">product name goes here</a></h3>
										<h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
									</div>
								</div>
								/product widget

								product widget
								<div class="product-widget">
									<div class="product-img">
										<img src="./img/product09.png" alt="">
									</div>
									<div class="product-body">
										<p class="product-category">Category</p>
										<h3 class="product-name"><a href="../shop/detail.do">product name goes here</a></h3>
										<h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
									</div>
								</div>
								product widget
							</div>
						</div>
					</div>

					<div class="clearfix visible-sm visible-xs"></div>

					<div class="col-md-4 col-xs-6">
						<div class="section-title">
							<h4 class="title">Top selling</h4>
							<div class="section-nav">
								<div id="slick-nav-5" class="products-slick-nav"></div>
							</div>
						</div>

						<div class="products-widget-slick" data-nav="#slick-nav-5">
							<div>
								product widget
								<div class="product-widget">
									<div class="product-img">
										<img src="./img/product01.png" alt="">
									</div>
									<div class="product-body">
										<p class="product-category">Category</p>
										<h3 class="product-name"><a href="../shop/detail.do">product name goes here</a></h3>
										<h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
									</div>
								</div>
								/product widget

								product widget
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
								/product widget

								product widget
								<div class="product-widget">
									<div class="product-img">
										<img src="./img/product03.png" alt="">
									</div>
									<div class="product-body">
										<p class="product-category">Category</p>
										<h3 class="product-name"><a href="../shop/detail.do">product name goes here</a></h3>
										<h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
									</div>
								</div>
								product widget
							</div>

							<div>
								product widget
								<div class="product-widget">
									<div class="product-img">
										<img src="./img/product04.png" alt="">
									</div>
									<div class="product-body">
										<p class="product-category">Category</p>
										<h3 class="product-name"><a href="../shop/detail.do">product name goes here</a></h3>
										<h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
									</div>
								</div>
								/product widget

								product widget
								<div class="product-widget">
									<div class="product-img">
										<img src="./img/product05.png" alt="">
									</div>
									<div class="product-body">
										<p class="product-category">Category</p>
										<h3 class="product-name"><a href="../shop/detail.do">product name goes here</a></h3>
										<h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
									</div>
								</div>
								/product widget

								product widget
								<div class="product-widget">
									<div class="product-img">
										<img src="./img/product06.png" alt="">
									</div>
									<div class="product-body">
										<p class="product-category">Category</p>
										<h3 class="product-name"><a href="../shop/detail.do">product name goes here</a></h3>
										<h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
									</div>
								</div>
								product widget
							</div>
						</div>
					</div>

				</div>
				/row
			</div>
			/container
		</div> -->
		<!-- /SECTION -->
		
</body>
</html>