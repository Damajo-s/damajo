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
		<!-- BREADCRUMB -->
		<div id="breadcrumb" class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<div class="col-md-12">
						<h3 class="breadcrumb-header">팁 게시판</h3>
						<ul class="breadcrumb-tree">
							<li><a href="../main/main.do">Home</a></li>
							<li class="active">팁게시판</li>
						</ul>
					</div>
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /BREADCRUMB -->
		
		<!-- /SECTION -->
					<div>
						<table class="table">
						 <c:forEach var="vo" items="${list }">
								<div class="col-md-4">
									<div class="text-center">
										<embed src="http://youtube.com/embed/${vo.youtubekey }" style="width: 400px;height:350px;">
										<div class="caption">
											<p><a href="../tipboard/tip_detail.do?no=${vo.no }">${vo.no}. (크게보기) ${vo.title }</a></p>
											<p>${vo.regdate }</p>
											<p>${vo.writer }</p><br>
										</div>
									</div>
								</div>
						  </c:forEach>
					 </table>
				</div>
</body>
</html>