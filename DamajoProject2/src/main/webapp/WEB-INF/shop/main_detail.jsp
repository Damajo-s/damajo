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
				<c:forEach var="vo" items="${maindetail }">
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
							<h2 class="product-name">${vo.main_name }</h2>
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
								<h3 class="product-price">${vo.price } 원<!-- <del class="product-old-price">$990.00</del> --></h3>
								<!-- <span class="product-available">In Stock</span> -->
							</div>
							<table class="table">
								<tr>
									<td colspan=4 >
											<table id="lowPriceInfo" class="table table-borderless" >
										<tr>
											<td>
												<span class="feed_detail feed_title" style="color:#FF0000; ">
												<br/>&nbsp;최저가 ${vo.price } 원
												</span>
											</td>
											<td>
												<span class="feed_detail simpleInfo">
												 <%-- <br/><br/><a href="${slist[0].link }" >바로가기 ▶</a>  --%>
												</span>
											</td>
										</tr>
										<tr >
											<th width=60% class="feed_detail simpleInfo" ><br/>&nbsp;&nbsp;판매처</th>
											<th width=40% class="feed_detail simpleInfo" ><br/>판매가</th>
										</tr>
										<c:forEach var="svo" items="${compare }" varStatus="s" >
										<tr>
											<td width=60% class="feed_detail simpleInfo" >
												<a href="${svo.link }" >&nbsp;&nbsp;${svo.mall_name }</a>
											</td>
											<td width=40% class="feed_detail simpleInfo" >
												${svo.price } 원
											</td>
										</tr>
										</c:forEach>
									</table>
								</td>
							</tr>
						</table>
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
										          <td class="text-left" width=30%>${vo.company}</td>
 										          <th class="text-center" width=20%>등록년월</th>
 										          <td class="text-left" width=30%>${vo.regdate }</td>
   										   	   </tr>
   										       <tr>
 										       	<th class="row" colspan="4" style="font-size: medium;">기본 사양</th>
 										       </tr>
  										       <tr>
 										         <th class="text-center" width=20%>제품 분류</th>
      										     <td class="text-left" width=30%>${vo.product_type }</td>
    										     <th class="text-center" width=20%>CPU 소켓</th>
									   		     <td class="text-left" width=30%>${vo.cpu_socket }</td>
 										       </tr>
 										       <tr>
										         <th class="text-center" width=20%>Main 칩셋</th>
										         <td class="text-left" width=30%>${vo.main_chipset }</td>
 										         <th class="text-center" width=20%>세부 칩셋</th>
      									 	     <td class="text-left"  width=30%>${vo.detail_chipset }</td>
   										   	   </tr>
  										       <tr>
										         <th class="text-center" width=20%>CPU 칩셋</th>
										         <td class="text-left" width=30%>${vo.cpu_cnt }</td>  										       
 										         <th class="text-center" width=20%>폼팩터</th>
      										     <td class="text-left"  width=30%>${vo.formFactor }</td>
 										       </tr>
  										       <tr>
 										         <th class="text-center" width=20%>전원부</th>
      										     <td class="text-left" colspan="3">${vo.power_supply }</td>
 										       </tr>
 										       <tr>
 										       	<th class="row" colspan="4" style="font-size: medium;">메모리 사양</th>
 										       </tr>
 										       <tr>
										         <th class="text-center" width=20%>메모리 종류</th>
										         <td class="text-left" width=30%>${vo.memory_kind }</td>  										       
 										         <th class="text-center" width=20%>메모리 속도</th>
      										     <td class="text-left"  width=30%>${vo.memory_speed }</td>
 										       </tr> 										          										   	   
 										       <tr>
										         <th class="text-center" width=20%>메모리 슬롯</th>
										         <td class="text-left" width=30%>${vo.memory_slot }</td>  										       
 										         <th class="text-center" width=20%>메모리 채널</th>
      										     <td class="text-left"  width=30%>${vo.memory_channel }</td>
 										       </tr>
 										       <tr>
 										         <th class="text-center" width=20%>메모리 용량</th>
      										     <td class="text-left" colspan="3">${vo.memory_capacity }</td>
 										       </tr>
 										       <tr>
 										       	<th class="row" colspan="4" style="font-size: medium;">그래픽</th>
 										       </tr>
 										       <tr>
										         <th class="text-center" width=20%>멀티 VGA</th>
										         <td class="text-left" width=30%>${vo.multi_vga }</td>  										       
 										         <th class="text-center" width=20%>VGA 연결</th>
      										     <td class="text-left"  width=30%>${vo.vga_connection }</td>
 										       </tr> 										        										          										   	   
 										       <tr>
 										       	<th class="row" colspan="4" style="font-size: medium;">그래픽 출력</th>
 										       </tr>
 										       <tr>
										         <th class="text-center" width=20%>D-SUB</th>
										         <td class="text-left" width=30%>${vo.d_sub }</td>  										       
 										         <th class="text-center" width=20%>DVI</th>
      										     <td class="text-left"  width=30%>${vo.dvi }</td>
 										       </tr> 										        										          										   	   
 										       <tr>
										         <th class="text-center" width=20%>HDMI</th>
										         <td class="text-left" width=30%>${vo.hdmi }</td>  										       
 										         <th class="text-center" width=20%>DP</th>
      										     <td class="text-left"  width=30%>${vo.dp }</td>
 										       </tr>
 										       <tr>
 										       	<th class="row" colspan="4" style="font-size: medium;">확장슬롯</th>
 										       </tr>
 										       <tr>
										         <th class="text-center" width=20%>PCIE_X16</th>
										         <td class="text-left" width=30%>${vo.pcie_x16 }</td>  										       
 										         <th class="text-center" width=20%>PCIE_X8</th>
      										     <td class="text-left"  width=30%>${vo.pcie_x8 }</td>
 										       </tr> 										        										        										          										   	   
 										       <tr>
										         <th class="text-center" width=20%>PCIE_X4</th>
										         <td class="text-left" width=30%>${vo.pcie_x4 }</td>  										       
 										         <th class="text-center" width=20%>PCIE_X1</th>
      										     <td class="text-left"  width=30%>${vo.pcie_x1 }</td>
 										       </tr>
 										       <tr>
 										       	<th class="row" colspan="4" style="font-size: medium;">저장장치</th>
 										       </tr>
 										       <tr>
										         <th class="text-center" width=20%>M2</th>
										         <td class="text-left" width=30%>${vo.m2 }</td>  										       
 										         <th class="text-center" width=20%>SATA3</th>
      										     <td class="text-left"  width=30%>${vo.sata3 }</td>
 										       </tr> 										        										        										        										          										   	   
 										       <tr>
 										       	<th class="row" colspan="4" style="font-size: medium;">사운드</th>
 										       </tr>
 										       <tr>
										         <th class="text-center" width=20%>내장오디오</th>
										         <td class="text-left" width=30%>${vo.built_in_sound }</td>  										       
 										         <th class="text-center" width=20%>ANALOG</th>
      										     <td class="text-left"  width=30%>${vo.analog }</td>
 										       </tr>
 										       <tr>
 										         <th class="text-center" width=20%>SPDIF 출력</th>
      										     <td class="text-left" colspan="3">${vo.spdif }</td>
 										       </tr>
 										       <tr>
 										       	<th class="row" colspan="4" style="font-size: medium;">USB 타입</th>
 										       </tr>
 										       <tr>
										         <th class="text-center" width=20%>USB 3.1 Gen2</th>
										         <td class="text-left" width=30%>${vo.usb_31_gen2 }</td>  										       
 										         <th class="text-center" width=20%>USB 3.1 Gen1</th>
      										     <td class="text-left"  width=30%>${vo.usb_31_gen1 }</td>
 										       </tr> 										        										        										        										        										          										   	   
 										       <tr>
										         <th class="text-center" width=20%>Type-C Gen2</th>
										         <td class="text-left" width=30%>${vo.type_c_gen2 }</td>  										       
 										         <th class="text-center" width=20%>Type-A Gen2</th>
      										     <td class="text-left"  width=30%>${vo.type_a_gen2 }</td>
 										       </tr>
 										       <tr>
 										         <th class="text-center" width=20%>Type-C Gen1</th>
      										     <td class="text-left" colspan="3">${vo.type_c_gen1 }</td>
 										       </tr>
 										       <tr>
 										       	<th class="row" colspan="4" style="font-size: medium;">네트워크</th>
 										       </tr>
 										       <tr>
										         <th class="text-center" width=20%>네트워크 칩셋</th>
										         <td class="text-left" width=30%>${vo.network_chipset }</td>  										       
 										         <th class="text-center" width=20%>RJ-45 포트</th>
      										     <td class="text-left"  width=30%>${vo.rj_45port }</td>
 										       </tr> 										        										        										        										        										        										        										          										   	   
 										       <tr>
 										       	<th class="row" colspan="4" style="font-size: medium;">LAN 구성</th>
 										       </tr>
 										       <tr>
										         <th class="text-center" width=20%>기가비트 LAN</th>
										         <td class="text-left" width=30%>${vo.gigabit_lan }</td>  										       
 										         <th class="text-center" width=20%>무선 LAN</th>
      										     <td class="text-left"  width=30%>${vo.wireless_lan }</td>
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