<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
				<c:forEach var="vo" items="${powerdetail }">
					<!-- Product main img -->
					<div class="col-md-5 col-md-push-2">
						<div id="product-main-img">
							<div class="product-preview">
								<img src="${vo.poster }" alt="">
							</div>

<!-- 							<div class="product-preview">
								<img src="./img/product03.png" alt="">
							</div>

							<div class="product-preview">
								<img src="./img/product06.png" alt="">
							</div>

							<div class="product-preview">
								<img src="./img/product08.png" alt="">
							</div> -->
						</div>
					</div>
					<!-- /Product main img -->

					<!-- Product thumb imgs -->
					<div class="col-md-2  col-md-pull-5">
						<div id="product-imgs">
<!-- 							<div class="product-preview">
								<img src="./img/product01.png" alt="">
							</div>

							<div class="product-preview">
								<img src="./img/product03.png" alt="">
							</div>

							<div class="product-preview">
								<img src="./img/product06.png" alt="">
							</div>

							<div class="product-preview">
								<img src="./img/product08.png" alt="">
							</div> -->
						</div>
					</div>
					<!-- /Product thumb imgs -->

					<!-- Product details -->
					<div class="col-md-5">
						<div class="product-details">
							<h2 class="product-name">${vo.power_name }</h2>
							<div>
								<div class="product-rating">
									<i class="fa fa-star"></i>
									<i class="fa fa-star"></i>
									<i class="fa fa-star"></i>
									<i class="fa fa-star"></i>
									<i class="fa fa-star-o"></i>
								</div>
								<a class="review-link" href="#">10 Review(s) | Add your review</a>
							</div>
							<div>
								<h3 class="product-price">${vo.price } <del class="product-old-price">$990.00</del></h3>
								<span class="product-available">In Stock</span>
							</div>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>

							<div class="product-options">
								<label>
									Size
									<select class="input-select">
										<option value="0">X</option>
									</select>
								</label>
								<label>
									Color
									<select class="input-select">
										<option value="0">Red</option>
									</select>
								</label>
							</div>

							<div class="add-to-cart">
								<div class="qty-label">
									Qty
									<div class="input-number">
										<input type="number">
										<span class="qty-up">+</span>
										<span class="qty-down">-</span>
									</div>
								</div>
								<button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
							</div>

							<ul class="product-btns">
								<li><a href="#"><i class="fa fa-heart-o"></i> add to wishlist</a></li>
								<li><a href="#"><i class="fa fa-exchange"></i> add to compare</a></li>
							</ul>

							<ul class="product-links">
								<li>Category:</li>
								<li><a href="#">Headphones</a></li>
								<li><a href="#">Accessories</a></li>
							</ul>

							<ul class="product-links">
								<li>Share:</li>
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
								<li><a href="#"><i class="fa fa-envelope"></i></a></li>
							</ul>

						</div>
					</div>
					<!-- /Product details -->

					<!-- Product tab -->
					<div class="col-md-12">
						<div id="product-tab">
							<!-- product tab nav -->
							<ul class="tab-nav">
								<li class="active"><a data-toggle="tab" href="#tab1">상세정보</a></li>
								<li><a data-toggle="tab" href="#tab2">Q&A</a></li>
								<li><a data-toggle="tab" href="#tab3">구매후기</a></li>
							</ul>
							<!-- /product tab nav -->

							<!-- product tab content -->
							<div class="tab-content">
								<!-- tab1 : 상세보기  -->
								<div id="tab1" class="tab-pane fade in active">
									<div class="row">
										<div class="col-md-12">										
											<table class="table">												
 										       <tr>
										          <th class="text-center" width=20%>제조회사</th>
										          <td class="text-left" width=30%>${vo.company }</td>
 										          <th class="text-center" width=20%>등록년월</th>
 										          <td class="text-left" width=30%>${vo.regdate }</td>
   										   	   </tr>
  										       <tr>
 										         <th class="text-center" width=20%>제품 분류</th>
      										     <td class="text-left" width=30%>${vo.product_type }</td>
    										     <th class="text-center" width=20%>정격 출력</th>
									   		     <td class="text-left" width=30%>${vo.rated_power }</td>
 										       </tr>
 										       <tr>
										          <th class="text-center" width=20%>메인 전원커넥터</th>
										          <td class="text-left" width=30%>${vo.main_connector }</td>
 										          <th class="text-center" width=20%>쿨링팬 크기</th>
 										          <td class="text-left" width=30%>${vo.fan_size }</td>
   										   	   </tr>
 										       <tr>
										          <th class="text-center" width=20%>쿨링팬 갯수</th>
										          <td class="text-left" width=30%>${vo.fan_cnt }</td>
 										          <th class="text-center" width=20%>베어링</th>
 										          <td class="text-left" width=30%>${vo.bearing }</td>
   										   	   </tr>
 										       <tr>
										          <th class="text-center" width=20%>PFC 회로</th>
										          <td class="text-left" width=30%>${vo.pfc_circuit }</td>
 										          <th class="text-center" width=20%>깊이</th>
 										          <td class="text-left" width=30%>${vo.depth }</td>
   										   	   </tr>
   										   	   <tr>
 										       	<th class="row" colspan="4" style="font-size: medium;">전압 규격</th>
 										       </tr>										       
 										       <tr>
										          <th class="text-center" width=20%>ATX12V 규격</th>
										          <td class="text-left" colspan="3">${vo.voltage_specification }</td>
   										   	   </tr>
   										   	   <tr>
 										       	<th class="row" colspan="4" style="font-size: medium;">전류 용량</th>
 										       </tr>	   										   	   
 										       <tr>
										          <th class="text-center" width=20%>12V 출력방식</th>
										          <td class="text-left" width=30%>${vo.way_to_output_12v }</td>
 										          <th class="text-center" width=20%>12V 출력</th>
 										          <td class="text-left" width=30%>${vo.output12v }</td>
   										   	   </tr>
 										       <tr>
										          <th class="text-center" width=20%>5V 출력</th>
										          <td class="text-left" width=30%>${vo.output5v }</td>
 										          <th class="text-center" width=20%>3.3V 출력</th>
 										          <td class="text-left" width=30%>${vo.output3_3v }</td>
   										   	   </tr>
 										       <tr>
 										       	<th class="row" colspan="4" style="font-size: medium;">커넥터</th>
 										       </tr> 										       
 										       <tr>
										          <th class="text-center" width=20%>4핀 IDE 커넥터</th>
										          <td class="text-left" width=30%>${vo.connector_4pinIDE }</td>
 										          <th class="text-center" width=20%>SATA 커넥터</th>
 										          <td class="text-left" width=30%>${vo.connector_sata }</td>
   										   	   </tr>								        										       
 										       <tr>
										          <th class="text-center" width=20%>6핀 PCI-E 커넥터</th>
										          <td class="text-left" width=30%>${vo.connector_6pinPCIe }</td>
 										          <th class="text-center" width=20%>8(6+2)핀 PCI-E 커넥터</th>
 										          <td class="text-left" width=30%>${vo.connector_8pinPCIe }</td>
   										   	   </tr>								        										       
 										       <tr>
										          <th class="text-center" width=20%>보조 8핀(4+4) 커넥터</th>
										          <td class="text-left" width=30%>${vo.connector_4by4pinSub }</td>
 										          <th class="text-center" width=20%>보조 8핀 커넥터</th>
 										          <td class="text-left" width=30%>${vo.connector_8pinSub }</td>
   										   	   </tr>								        										       
 										       <tr>
										          <th class="text-center" width=20%>보조 4핀 커넥터</th>
										          <td class="text-left" width=30%>${vo.connector_4pinSub }</td>
 										          <th class="text-center" width=20%>FDD 커넥터</th>
 										          <td class="text-left" width=30%>${vo.connector_fdd }</td>
   										   	   </tr>
 										       <tr>
										          <th class="text-center" width=20%>LED 커넥터</th>
										          <td class="text-left" colspan="3">${vo.connector_led }</td>
   										   	   </tr>
 										       <tr>
 										       	<th class="row" colspan="4" style="font-size: medium;">부가 기능</th>
 										       </tr>
 										       <tr>
										          <th class="text-center" width=20%>케이블 연결식</th>
										          <td class="text-left" width=30%>${vo.cable_attached }</td>
 										          <th class="text-center" width=20%>대기전력</th>
 										          <td class="text-left" width=30%>${vo.stanby_power }</td>
   										   	   </tr>   										   	      										   	   								        										       
 										       <tr>
										          <th class="text-center" width=20%>플랫 케이블</th>
										          <td class="text-left" colspan="3">${vo.flat_cable }</td>
   										   	   </tr>  
 										       <tr>
 										       	<th class="row" colspan="4" style="font-size: medium;">제품 보증</th>
 										       </tr>   										   	    										   	      										   	   								        										       
 										       <tr>
										          <th class="text-center" width=20%>A/S 보증기간</th>
										          <td class="text-left" colspan="3">${vo.warranty }</td>
   										   	   </tr>   										   	      										   	   								        										       
 										       </table> 										       
										</div>
									</div>
								</div>
								<!-- /tab1  -->

								<!-- tab2 : Q&A  -->
								<div id="tab2" class="tab-pane fade in">
									<div class="row">
										<h3 class="text-left">Q&A <font color="blue">(0)</font></h3>
										<div class="text-left">
											&nbsp;<a href="#">전체(0)</a>&nbsp;|&nbsp;<a href="#">답변완료(0)</a>&nbsp;|&nbsp;<a href="#">답변대기(0)</a>
											<span style="float:right"><input type=button value="상품 Q&A작성하기" class="btn btn-sm btn-info"></span>
										</div>
										<div class="col-md-12">
											<table class="table">
												<tr>
													<th>답변상태</th>
													<th>제목</th>
													<th>구매/비구매</th>
													<th>작성자</th>
													<th>작성일</th>
												</tr>
											</table>
										</div>
									</div>
								</div>
								<!-- /tab2  -->

								<!-- tab3 : 구매후기  -->
								<div id="tab3" class="tab-pane fade in">
									<div class="row">
										<!-- Rating -->
										<div class="col-md-3">
											<div id="rating">
												<div class="rating-avg">
													<span>4.5</span>
													<div class="rating-stars">
														<i class="fa fa-star"></i>
														<i class="fa fa-star"></i>
														<i class="fa fa-star"></i>
														<i class="fa fa-star"></i>
														<i class="fa fa-star-o"></i>
													</div>
												</div>
												<ul class="rating">
													<li>
														<div class="rating-stars">
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
														</div>
														<div class="rating-progress">
															<div style="width: 80%;"></div>
														</div>
														<span class="sum">3</span>
													</li>
													<li>
														<div class="rating-stars">
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star-o"></i>
														</div>
														<div class="rating-progress">
															<div style="width: 60%;"></div>
														</div>
														<span class="sum">2</span>
													</li>
													<li>
														<div class="rating-stars">
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star-o"></i>
															<i class="fa fa-star-o"></i>
														</div>
														<div class="rating-progress">
															<div></div>
														</div>
														<span class="sum">0</span>
													</li>
													<li>
														<div class="rating-stars">
															<i class="fa fa-star"></i>
															<i class="fa fa-star"></i>
															<i class="fa fa-star-o"></i>
															<i class="fa fa-star-o"></i>
															<i class="fa fa-star-o"></i>
														</div>
														<div class="rating-progress">
															<div></div>
														</div>
														<span class="sum">0</span>
													</li>
													<li>
														<div class="rating-stars">
															<i class="fa fa-star"></i>
															<i class="fa fa-star-o"></i>
															<i class="fa fa-star-o"></i>
															<i class="fa fa-star-o"></i>
															<i class="fa fa-star-o"></i>
														</div>
														<div class="rating-progress">
															<div></div>
														</div>
														<span class="sum">0</span>
													</li>
												</ul>
											</div>
										</div>
										<!-- /Rating -->

										<!-- Reviews -->
										<div class="col-md-6">
											<div id="reviews">
												<ul class="reviews">
													<li>
														<div class="review-heading">
															<h5 class="name">John</h5>
															<p class="date">27 DEC 2018, 8:0 PM</p>
															<div class="review-rating">
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star-o empty"></i>
															</div>
														</div>
														<div class="review-body">
															<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua</p>
														</div>
													</li>
													<li>
														<div class="review-heading">
															<h5 class="name">John</h5>
															<p class="date">27 DEC 2018, 8:0 PM</p>
															<div class="review-rating">
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star-o empty"></i>
															</div>
														</div>
														<div class="review-body">
															<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua</p>
														</div>
													</li>
													<li>
														<div class="review-heading">
															<h5 class="name">John</h5>
															<p class="date">27 DEC 2018, 8:0 PM</p>
															<div class="review-rating">
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star-o empty"></i>
															</div>
														</div>
														<div class="review-body">
															<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua</p>
														</div>
													</li>
												</ul>
												<ul class="reviews-pagination">
													<li class="active">1</li>
													<li><a href="#">2</a></li>
													<li><a href="#">3</a></li>
													<li><a href="#">4</a></li>
													<li><a href="#"><i class="fa fa-angle-right"></i></a></li>
												</ul>
											</div>
										</div>
										<!-- /Reviews -->

										<!-- Review Form -->
										<div class="col-md-3">
											<div id="review-form">
												<form class="review-form">
													<input class="input" type="text" placeholder="Your Name">
													<input class="input" type="email" placeholder="Your Email">
													<textarea class="input" placeholder="Your Review"></textarea>
													<div class="input-rating">
														<span>Your Rating: </span>
														<div class="stars">
															<input id="star5" name="rating" value="5" type="radio"><label for="star5"></label>
															<input id="star4" name="rating" value="4" type="radio"><label for="star4"></label>
															<input id="star3" name="rating" value="3" type="radio"><label for="star3"></label>
															<input id="star2" name="rating" value="2" type="radio"><label for="star2"></label>
															<input id="star1" name="rating" value="1" type="radio"><label for="star1"></label>
														</div>
													</div>
													<button class="primary-btn">Submit</button>
												</form>
											</div>
										</div>
										<!-- /Review Form -->
									</div>
								</div>
								<!-- /tab3  -->
							</div>
							<!-- /product tab content  -->
						</div>
					</div>
					<!-- /product tab -->
				</div>
				</c:forEach>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->

		<!-- Section -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">

					<div class="col-md-12">
						<div class="section-title text-center">
							<h3 class="title">Related Products</h3>
						</div>
					</div>

					<!-- product -->
					<div class="col-md-3 col-xs-6">
						<div class="product">
							<div class="product-img">
								<img src="./img/product01.png" alt="">
								<div class="product-label">
									<span class="sale">-30%</span>
								</div>
							</div>
							<div class="product-body">
								<p class="product-category">Category</p>
								<h3 class="product-name"><a href="#">product name goes here</a></h3>
								<h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
								<div class="product-rating">
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
					<!-- /product -->

					<!-- product -->
					<div class="col-md-3 col-xs-6">
						<div class="product">
							<div class="product-img">
								<img src="./img/product02.png" alt="">
								<div class="product-label">
									<span class="new">NEW</span>
								</div>
							</div>
							<div class="product-body">
								<p class="product-category">Category</p>
								<h3 class="product-name"><a href="#">product name goes here</a></h3>
								<h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
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
					</div>
					<!-- /product -->

					<div class="clearfix visible-sm visible-xs"></div>

					<!-- product -->
					<div class="col-md-3 col-xs-6">
						<div class="product">
							<div class="product-img">
								<img src="./img/product03.png" alt="">
							</div>
							<div class="product-body">
								<p class="product-category">Category</p>
								<h3 class="product-name"><a href="#">product name goes here</a></h3>
								<h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
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
					<!-- /product -->

					<!-- product -->
					<div class="col-md-3 col-xs-6">
						<div class="product">
							<div class="product-img">
								<img src="./img/product04.png" alt="">
							</div>
							<div class="product-body">
								<p class="product-category">Category</p>
								<h3 class="product-name"><a href="#">product name goes here</a></h3>
								<h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
								<div class="product-rating">
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
					<!-- /product -->

				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /Section -->

</body>
</html>