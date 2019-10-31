<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	  $('#insertbtn').on("click", function(){
		  var pno=$('#pro').val();
		  var category=$('#cateno').val();
		  var id=$('#id').val();
		  //alert(category);
		  //alert(pno);
		  if(id.trim()==null || id.trim()==""){
			  alert("로그인 후 이용 가능합니다.");
			  location.href="../member/login.do";
		  }
	    window.open("../shop/qainsert.do?no="+pno+"&category="+category,"상품 Q&A 작성하기", "width=500, height=450, scrollbars=no");
	  });
	  // tab2 : Q&A 버튼
	  $('#qnaBtn').click(function(){
		  	var page=$(this).val(); 
			var no=$('.qnapro').val();  
			var category=$('#qnacateno').val();
		 $.ajax({
				type:'post',
				url:'../shop/cpu_detail_page.do',  
				data:{page:1,no:no,category:category},
				success:function(res){ 
					$('#print').html(res); 
				}
			}); //ajax
	  });	
	//QnA 페이지 이동 
		$('.qnapage').click(function(){ 
			var page=$(this).val(); 
			var no=$('.qnapro').val();  
			var category=$('#qnacateno').val();
			$.ajax({
				type:'post',
				url:'../shop/cpu_detail_page.do',  
				data:{page:page,no:no,category:category},
				success:function(res){ 
					$('#print').html(res); 
				}
			}); //ajax
		}); //page
		  // tab3 : 리뷰 버튼
		  $('#reviewBtn').click(function(){
			  var id=$('#id').val();
				 //alert(id);
				  if(id.trim()==null || id.trim()==""){
					  alert("로그인 후 이용 가능합니다.");
					  location.href="../member/login.do";
				  }
			  	var page=$(this).val(); 
				var no=$('.rpno').val();  
				var category=$('#rcateno').val();
			 $.ajax({
					type:'post',
					url:'../shop/cpu_detail_reviewpage2.do',  
					data:{page:1,no:no,category:category},
					success:function(res){ 
						/* alert(res);
						alert(no);
						alert(category); */
						$('#review_print').html(res); 
					}
				}); //ajax
		  });	
  		  $('.rpage').click(function(){
			  	var page=$(this).val(); 
				var no=$('.rpno').val();  
				var category=$('#rcateno').val();
			 $.ajax({
					type:'post',
					url:'../shop/cpu_detail_reviewpage2.do',  
					data:{page:page,no:no,category:category},
					success:function(res){ 
						//alert("이번엔 여기?"+page)
						$('#review_print').html(res); 
					}
				}); //ajax
		  });  
});
</script>
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
		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
				<c:forEach var="vo" items="${ssddetail }">
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
							<h2 class="product-name">${vo.ssd_name }</h2>
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
								<li><a data-toggle="tab" href="#tab2" id=qnaBtn>Q&A</a></li>
								<li><a data-toggle="tab" href="#tab3" id="reviewBtn">구매후기</a></li>
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
 										       	<th class="row" colspan="4" style="font-size: medium;">기본 사양</th>
 										       </tr>										       
  										       <tr>
 										         <th class="text-center" width=20%>제품 분류</th>
      										     <td class="text-left" width=30%>${vo.product_type }</td>
    										     <th class="text-center" width=20%>디스크 타입</th>
									   		     <td class="text-left" width=30%>${vo.disk_type }</td>
 										       </tr>
 										       <tr>
										          <th class="text-center" width=20%>인터페이스</th>
										          <td class="text-left" width=30%>${vo.ssd_interface }</td>
 										          <th class="text-center" width=20%>프로토콜</th>
 										          <td class="text-left" width=30%>${vo.protocol }</td>
   										   	   </tr>
   										   	   <tr>
 										         <th class="text-center" width=20%>디스크 용량</th>
      										     <td class="text-left" colspan="3">${vo.disk_capacity }</td>
 										       </tr>
 										       <tr>
 										       	<th class="row" colspan="4" style="font-size: medium;">하드웨어 정보</th>
 										       </tr> 										       
 										       <tr>
										          <th class="text-center" width=20%>메모리 타입</th>
										          <td class="text-left" width=30%>${vo.memory_type }</td>
 										          <th class="text-center" width=20%>낸드 구조</th>
 										          <td class="text-left" width=30%>${vo.nand_structure }</td>
   										   	   </tr>
   										   	   <tr>
										          <th class="text-center" width=20%>메모리 유무</th>
										          <td class="text-left" width=30%>${vo.ram_mount }</td>
 										          <th class="text-center" width=20%>메모리 타입</th>
 										          <td class="text-left" width=30%>${vo.ram_type }</td>
   										   	   </tr>
   										   	   <tr>
 										         <th class="text-center" width=20%>컨트롤러</th>
      										     <td class="text-left" colspan="3">${vo.controller }</td>
 										       </tr>
 										       <tr>
 										       	<th class="row" colspan="4" style="font-size: medium;">내구성</th>
 										       </tr>
   										   	   <tr>
										          <th class="text-center" width=20%>TBW</th>
										          <td class="text-left" width=30%>${vo.tbw }</td>
 										          <th class="text-center" width=20%>사용보증 시간</th>
 										          <td class="text-left" width=30%>${vo.warranty_time }</td>
   										   	   </tr> 								        										       
 										       </table> 										       
										</div>
									</div>
								</div>
								<!-- /tab1  -->

								<!-- tab2 : Q&A  -->
								<div id="tab2" class="tab-pane fade in">
									<div class="row">
										<h3 class="text-left">Q&A <font color="blue" size="3">(${qPnoCount })</font></h3>
										<div class="text-left">
											&nbsp;<a class="allCount">전체(${qPnoCount })</a>&nbsp;|&nbsp;<a class=>답변완료(0)</a>&nbsp;|&nbsp;<a href="#">답변대기(0)</a>
											<span style="float:right"><input type=button value="상품 Q&A작성하기" class="btn btn-sm btn-info" id=insertbtn></span>
											<input type="hidden" id="pro" value="${product }">
											<input type="hidden" id="cateno" value="${category }">
											<input type="hidden" id="id" value="${id }">
										</div>
										<div class="col-md-12">
											<table class="table" width="100%" cellspacing="0">
												<thead>
												<tr>
													<th class="text-center" width="10%">답변상태</th>
													<th class="text-center" width="20%">제목</th>
													<th class="text-center" width="5%"></th>
													<th class="text-center" width="20%">작성자</th>
													<th class="text-center" width="10%">작성일</th>
												</tr>
												</thead>
											</table>
										</div>
										<div class="col-md-12" id="print" >
											
										</div>
										<div >
											<ul class="reviews-pagination" >
											<table class="table">
												<c:if test="${curPage>BLOCK }">
													<li><input type=button value="◁"></li>
													<li><input type=button value="&lt;" ></li>
												</c:if>
												<c:forEach var="i" begin="${startPage }" end="${endPage }">
													<li class=${curPage==i? "active":"" }>
														<input type=button class="qnapage" value="${i }">
														<input type=hidden class="qnapro" value="${product }">
														<input type=hidden id="qnacateno" value="${category }">
													</li>
												</c:forEach>
													<c:if test="${endPage<allPage }">
														<li><input type=button value="&gt;"></li>
														<li><input type=button value="▷"></li>
													</c:if>
											</table>
											</ul>
										</div>
									</div>
								</div>
								<!-- /tab2  -->

								<!-- tab3 : 구매후기  -->
								<div id="tab3" class="tab-pane fade in">
									<div class="row">
										<!-- Reviews 리스트 출력 -->
										<div class="col-md-9">
											<div id="reviews" >
												<ul class="reviews"   id="review_print">
												
												</ul>
											</div>	
										<!-- 페이지  -->
										<div class="col-md-6">
												<ul class="reviews-pagination" >
														<table class="table">
															<c:if test="${curPage>BLOCK }">
																<li><input type=button value="◁"></li>
																<li><input type=button value="&lt;" ></li>
															</c:if>
															<c:forEach var="i" begin="${startPage }" end="${endPage }">
																<li class=${curPage==i? "active":"" }>
																	<input type=button class="rpage" value="${i }">
																	<input type=hidden class="rpno" value="${product }">
																	<input type=hidden id="rcateno" value="${category }">
																</li>
															</c:forEach>
																<c:if test="${endPage<allPage }">
																	<li><input type=button value="&gt;"></li>
																	<li><input type=button value="▷"></li>
																</c:if>
														</table>
													</ul>
											</div>
										</div>
										<!-- /Reviews -->

										<!-- Review Form -->
										<div class="col-md-3">
											<div id="review-form">
												<form class="review-form" action="../shop/cpu_detail_reviewInsert.do" method="post">
													<input type=hidden id="no" value="${product }" name=no>
													<input type=hidden id="cateno" value="${category }" name=category>
													<!-- <input class="input" type="text" placeholder="아이디" name="id" > -->
													<input class="input" type="text" placeholder="제목" name=subject id="subject">
													<textarea class="input" placeholder="리뷰 작성해주세요." name=content id="content"></textarea>
													<div class="input-rating">
														<span>별점: </span>
<!-- 														<div class="stars">
															<input id="star5" name="rating" value="5" type="radio"><label for="star5"></label>
															<input id="star4" name="rating" value="4" type="radio"><label for="star4"></label>
															<input id="star3" name="rating" value="3" type="radio"><label for="star3"></label>
															<input id="star2" name="rating" value="2" type="radio"><label for="star2"></label>
															<input id="star1" name="rating" value="1" type="radio"><label for="star1"></label>
														</div> -->
													</div>
													<button type="submit" class="primary-btn" id="rInsertBtn">등록</button>
													<input type="hidden" id="id" value="${id }">
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