<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<table class="text-center">
						<h3>[ ${vo.title } ]  상세보기</h3><br>
						<p class="text-right">조회수 : ${vo.hit }</p>
						<p class="text-right">제작일 : ${vo.regdate }</p><br>
						<div class="col-sm-8">
								<tr>
									<td rowspan="5" class="text-center">
										<embed src="http://youtube.com/embed/${vo.youtubekey }" width=1000px height=650px>
									</td>	
								</tr>
							</div>
						</table>
					</div>
				<!-- /row -->
				<div class="row">
					<table class="table">
						<div class="col-sm-12">
							<tr>
									<td class="text-right">
										<a href="../tipboard/list.do" class="btn btn-sm btn-primary">목록</a>
									</td>
								</tr>
						</div>
					</table>
				</div>
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->

</body>
</html>