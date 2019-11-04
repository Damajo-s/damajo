<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/style-cart.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
</head>
<body>
	<!-- BREADCRUMB -->
	<div id="breadcrumb" class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<div class="col-md-12">
					<h3 class="breadcrumb-header">관심상품 목록</h3>
				</div>
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	
	<!-- 관심상품 -->
	<div class="shopping-cart">
		<!-- Title -->
		<div class="title">${sessionScope.id } 님의 관심상품 </div>

		<!-- Product #1 -->
		<div class="item">
			<div class="buttons">
				<span class="delete-btn"></span> <span class="like-btn"></span>
			</div>

			<div class="image">
				<img src="item-1.png" alt="" />
			</div>

			<div class="description">
				<span>Common Projects</span> <span>Bball High</span> <span>White</span>
			</div>

			<div class="total-price">$549</div>
		</div>

	</div>
</body>
<script type="text/javascript">
		$('.like-btn').on('click', function() {
			$(this).toggleClass('is-active');
		});
</script>


</html>