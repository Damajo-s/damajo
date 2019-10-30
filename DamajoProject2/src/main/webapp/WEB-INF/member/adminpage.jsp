<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<title>Insert title here</title>
</head>
<body>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>가입경로</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="member"  items="${member }">
				<tr>
					<td>${member.id }</td>
					<td>${member.type }</td>
					<td>
						<p>
							<c:url var=""/>
							<a href="#" class="btn btn-default">정보보기</a>
							<a href="#" class="btn btn-default">계정탈퇴</a>
						</p>
					<td>
				</tr>
			</c:forEach>
	</table>
	</tbody>
</body>
</html>