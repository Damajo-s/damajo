<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	  $('#insertbtn').on("click", function(){
		  var pno=$('#pro').val();
		  var category=$('#cateno').val();
		  var id=$('#id').val();
		  //alert(category);
		  //alert(pno);
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
					/* 	alert(res);
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
					<!-- Product main img -->
					<div class="col-md-5 col-md-push-2">
						<div id="product-main-img">
							<div class="product-preview">
								<img src="${maindetail.poster }" alt="">
							</div>
						</div>
					</div>
					<!-- /Product main img -->

					<!-- Product thumb imgs -->
					<div class="col-md-2  col-md-pull-5">
						<div id="product-imgs">
						</div>
					</div>
					<!-- /Product thumb imgs -->

					<!-- Product details -->
					<div class="col-md-5">
						<div class="product-details">
							<h2 class="product-name">${maindetail.main_name }</h2>
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
							<c:choose>
							<c:when test="${maindetail.price == '일시품절' }">
								<h3 class="product-price">${maindetail.price }</h3>	
							</c:when>
							<c:when test="${maindetail.price != '일시품절' }">
								<h3 class="product-price">${maindetail.price } 원</h3>	
							</c:when>
							</c:choose>							
							</div>
							<table class="table">
								<tr>
									<td colspan=4 >
											<table id="lowPriceInfo" class="table table-borderless" >
										<tr>
											<td>
										<c:forEach var="svo" items="${compare }" varStatus="s" >
												<span class="feed_detail feed_title" style="color:#FF0000; ">
												<c:choose>
													<c:when test="${maindetail.price == '일시품절' }">
													<br/>&nbsp;최저가 ${cpudetail.price }
													</c:when>
													<c:when test="${s.index == 0 }">
													<br/>&nbsp;최저가 ${svo.price }원
													</c:when>
												</c:choose>
												</span>
										</c:forEach>
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
										<c:forEach var="vo" items="${overseas }" varStatus="s" >
										<tr>
											<td width=60% class="feed_detail simpleInfo" >
												<a href="${vo.link }" >&nbsp;&nbsp;${vo.mall_name }</a>
											</td>
											<td width=40% class="feed_detail simpleInfo" >
												${vo.price }
											</td>
										</tr>
										</c:forEach>
									</table>
								</td>
							</tr>
						</table>

						</div>
					</div>
					<!-- /Product details -->

					<!-- Product tab -->
					<div class="col-md-12">
						<div id="product-tab">
							<!-- product tab nav -->
							<ul class="tab-nav">
								<li class="active"><a data-toggle="tab" href="#tab1">상세정보</a></li>
								<li><a data-toggle="tab" href="#tab2" id="qnaBtn">Q&A</a></li>
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
										          <td class="text-left" width=30%>${maindetail.company}</td>
 										          <th class="text-center" width=20%>등록년월</th>
 										          <td class="text-left" width=30%>${maindetail.regdate }</td>
   										   	   </tr>
   										       <tr>
 										       	<th class="row" colspan="4" style="font-size: medium;">기본 사양</th>
 										       </tr>
  										       <tr>
 										         <th class="text-center" width=20%>제품 분류</th>
      										     <td class="text-left" width=30%>${maindetail.product_type }</td>
    										     <th class="text-center" width=20%>CPU 소켓</th>
									   		     <td class="text-left" width=30%>${maindetail.cpu_socket }</td>
 										       </tr>
 										       <tr>
										         <th class="text-center" width=20%>Main 칩셋</th>
										         <td class="text-left" width=30%>${maindetail.main_chipset }</td>
 										         <th class="text-center" width=20%>세부 칩셋</th>
      									 	     <td class="text-left"  width=30%>${maindetail.detail_chipset }</td>
   										   	   </tr>
  										       <tr>
										         <th class="text-center" width=20%>CPU 칩셋</th>
										         <td class="text-left" width=30%>${maindetail.cpu_cnt }</td>  										       
 										         <th class="text-center" width=20%>폼팩터</th>
      										     <td class="text-left"  width=30%>${maindetail.formFactor }</td>
 										       </tr>
  										       <tr>
 										         <th class="text-center" width=20%>전원부</th>
      										     <td class="text-left" colspan="3">${maindetail.power_supply }</td>
 										       </tr>
 										       <tr>
 										       	<th class="row" colspan="4" style="font-size: medium;">메모리 사양</th>
 										       </tr>
 										       <tr>
										         <th class="text-center" width=20%>메모리 종류</th>
										         <td class="text-left" width=30%>${maindetail.memory_kind }</td>  										       
 										         <th class="text-center" width=20%>메모리 속도</th>
      										     <td class="text-left"  width=30%>${maindetail.memory_speed }</td>
 										       </tr> 										          										   	   
 										       <tr>
										         <th class="text-center" width=20%>메모리 슬롯</th>
										         <td class="text-left" width=30%>${maindetail.memory_slot }</td>  										       
 										         <th class="text-center" width=20%>메모리 채널</th>
      										     <td class="text-left"  width=30%>${maindetail.memory_channel }</td>
 										       </tr>
 										       <tr>
 										         <th class="text-center" width=20%>메모리 용량</th>
      										     <td class="text-left" colspan="3">${maindetail.memory_capacity }</td>
 										       </tr>
 										       <tr>
 										       	<th class="row" colspan="4" style="font-size: medium;">그래픽</th>
 										       </tr>
 										       <tr>
										         <th class="text-center" width=20%>멀티 VGA</th>
										         <td class="text-left" width=30%>${maindetail.multi_vga }</td>  										       
 										         <th class="text-center" width=20%>VGA 연결</th>
      										     <td class="text-left"  width=30%>${maindetail.vga_connection }</td>
 										       </tr> 										        										          										   	   
 										       <tr>
 										       	<th class="row" colspan="4" style="font-size: medium;">그래픽 출력</th>
 										       </tr>
 										       <tr>
										         <th class="text-center" width=20%>D-SUB</th>
										         <td class="text-left" width=30%>${maindetail.d_sub }</td>  										       
 										         <th class="text-center" width=20%>DVI</th>
      										     <td class="text-left"  width=30%>${maindetail.dvi }</td>
 										       </tr> 										        										          										   	   
 										       <tr>
										         <th class="text-center" width=20%>HDMI</th>
										         <td class="text-left" width=30%>${maindetail.hdmi }</td>  										       
 										         <th class="text-center" width=20%>DP</th>
      										     <td class="text-left"  width=30%>${maindetail.dp }</td>
 										       </tr>
 										       <tr>
 										       	<th class="row" colspan="4" style="font-size: medium;">확장슬롯</th>
 										       </tr>
 										       <tr>
										         <th class="text-center" width=20%>PCIE_X16</th>
										         <td class="text-left" width=30%>${maindetail.pcie_x16 }</td>  										       
 										         <th class="text-center" width=20%>PCIE_X8</th>
      										     <td class="text-left"  width=30%>${maindetail.pcie_x8 }</td>
 										       </tr> 										        										        										          										   	   
 										       <tr>
										         <th class="text-center" width=20%>PCIE_X4</th>
										         <td class="text-left" width=30%>${maindetail.pcie_x4 }</td>  										       
 										         <th class="text-center" width=20%>PCIE_X1</th>
      										     <td class="text-left"  width=30%>${maindetail.pcie_x1 }</td>
 										       </tr>
 										       <tr>
 										       	<th class="row" colspan="4" style="font-size: medium;">저장장치</th>
 										       </tr>
 										       <tr>
										         <th class="text-center" width=20%>M2</th>
										         <td class="text-left" width=30%>${maindetail.m2 }</td>  										       
 										         <th class="text-center" width=20%>SATA3</th>
      										     <td class="text-left"  width=30%>${maindetail.sata3 }</td>
 										       </tr> 										        										        										        										          										   	   
 										       <tr>
 										       	<th class="row" colspan="4" style="font-size: medium;">사운드</th>
 										       </tr>
 										       <tr>
										         <th class="text-center" width=20%>내장오디오</th>
										         <td class="text-left" width=30%>${maindetail.built_in_sound }</td>  										       
 										         <th class="text-center" width=20%>ANALOG</th>
      										     <td class="text-left"  width=30%>${maindetail.analog }</td>
 										       </tr>
 										       <tr>
 										         <th class="text-center" width=20%>SPDIF 출력</th>
      										     <td class="text-left" colspan="3">${maindetail.spdif }</td>
 										       </tr>
 										       <tr>
 										       	<th class="row" colspan="4" style="font-size: medium;">USB 타입</th>
 										       </tr>
 										       <tr>
										         <th class="text-center" width=20%>USB 3.1 Gen2</th>
										         <td class="text-left" width=30%>${maindetail.usb_31_gen2 }</td>  										       
 										         <th class="text-center" width=20%>USB 3.1 Gen1</th>
      										     <td class="text-left"  width=30%>${maindetail.usb_31_gen1 }</td>
 										       </tr> 										        										        										        										        										          										   	   
 										       <tr>
										         <th class="text-center" width=20%>Type-C Gen2</th>
										         <td class="text-left" width=30%>${maindetail.type_c_gen2 }</td>  										       
 										         <th class="text-center" width=20%>Type-A Gen2</th>
      										     <td class="text-left"  width=30%>${maindetail.type_a_gen2 }</td>
 										       </tr>
 										       <tr>
 										         <th class="text-center" width=20%>Type-C Gen1</th>
      										     <td class="text-left" colspan="3">${maindetail.type_c_gen1 }</td>
 										       </tr>
 										       <tr>
 										       	<th class="row" colspan="4" style="font-size: medium;">네트워크</th>
 										       </tr>
 										       <tr>
										         <th class="text-center" width=20%>네트워크 칩셋</th>
										         <td class="text-left" width=30%>${maindetail.network_chipset }</td>  										       
 										         <th class="text-center" width=20%>RJ-45 포트</th>
      										     <td class="text-left"  width=30%>${maindetail.rj_45port }</td>
 										       </tr> 										        										        										        										        										        										        										          										   	   
 										       <tr>
 										       	<th class="row" colspan="4" style="font-size: medium;">LAN 구성</th>
 										       </tr>
 										       <tr>
										         <th class="text-center" width=20%>기가비트 LAN</th>
										         <td class="text-left" width=30%>${maindetail.gigabit_lan }</td>  										       
 										         <th class="text-center" width=20%>무선 LAN</th>
      										     <td class="text-left"  width=30%>${maindetail.wireless_lan }</td>
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