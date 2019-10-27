<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jqeury.js"></script>
<script type="text/javascript">
	var i = 0;
	var j = 0;
	$(function() {
		// QnA 내용 보기
		$('.subject').click(function() {
			$('.content').show();
			$('.adminres').show();
		});
	});
</script>
</head>
<body>
	<div>
		<table class="table">
			<c:forEach var="vo" items="${list }" varStatus="s">
				<tbody>
					<tr>
						<td class="text-center" width="5%"></td>
						<td class="text-center" class="subject" width="20%"><a>${vo.subject }</a></td>
						<td class="text-center" width="5%"></td>
						<td class="text-center" width="10%">${vo.id }</td>
						<td class="text-center" width="10%">${vo.today }</td>
					</tr>
					<tr class="content" style="display: none">
						<td class="text-center" width="10%"></td>
						<td class="text-center" width="20%">${vo.content }</td>
						<td class="text-center" width="5%"></td>
						<td class="text-center" width="20%"></td>
						<td class="text-center" width="10%"></td>
					</tr>
					<tr class="adminres" style="display: none">
						<td class="text-center" width="10%"></td>
						<td class="text-center" width="20%"><font color=red>Re.&nbsp;</font>${vo.adminres }</td>
						<td class="text-center" width="5%"></td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>
</body>
</html>