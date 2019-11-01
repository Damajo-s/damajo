<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jqeury.js"></script>
<script type="text/javascript">
var i=0;
var j=0;
$(function(){
	// QnA 내용 보기
			$('.subject').click(function(){
				$('.content').show();
				$('.adminres').show();
			});
	// 답변하기
	$('#adminBtn').click(function(){
		  var pno=$('#pro').val();
		  var category=$('#cateno').val();
		  alert(pno);
		  
		window.open("../shop/admin_page.do?no="+pno+"&category="+category,"관리자 답변하기 ", "width=500, height=230, scrollbars=no");
	});
	
});
</script>
</head>
<body>
								<table class="table" >
									<c:forEach var="vo" items="${list }" >
												<tbody>
													<tr>
														<td class="text-center" width="5%">${vo.admintype }</td>
														<td class="text-center" class="subject" width="20%"><a><strong>${vo.subject }</strong></a></td>
														<td class="text-center" width="5%"></td>
														<td class="text-center" width="10%"><strong>${vo.id }</strong></td>
														<td class="text-center" width="10%"><strong>${vo.today }</strong></td>
													</tr>
													<tr class="content">
														<td class="text-center" width="10%"></td>
														<td class="text-center" width="20%">${vo.content }</td>
														<td class="text-center" width="5%"></td>
														<td class="text-center" width="20%"></td>
														<td class="text-center" width="10%"></td>
													</tr>
													<div class="adminres">
														<td class="text-center" width="10%"></td>
														<td class="text-center" width="15%"><font color=red>Re.&nbsp;&nbsp;</font>${vo.adminres }</td>
														<td class="text-center" width="5%"></td>
														<td class="text-center" width="20%"></td>
														<td class="text-center" width="10%">
															<input type=button value="답변하기 " id=adminBtn>
																<input type="hidden" id="pro" value="${product }" name="no">
																<input type="hidden" id="cateno" value="${category }" name="category">
																<input type="hidden" id="id" value="${id }" name="id">
														</td>
													</div>
												</tbody>
												</c:forEach>
											</table>
</body>
</html>