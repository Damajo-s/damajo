<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="admininsert" target="admininsert" method="post" action="../shop/adminInsert.do" >
		<input type="hidden" id="pro" value="${no }" name="no">
		<input type="hidden" id="cateno" value="${category }" name="category">
		<div class="container">
			<h3>&nbsp;&nbsp;관리자 답변 하기</h3>
			<hr width="470">
			<div class="row">
				<table class="table">
						<td width=20%>&nbsp;&nbsp;답변 : </td>
						<td>
							<textarea rows="5" cols="40" name="admincontent" class=admincotent ></textarea>
						</td>
					</tr>
				</table>
			</div><br>
			<div class="text-center">
				<input type=button value="취소" class="btn btn-sm btn-danger" onclick="window.close();">
				<input type=submit value="등록" class="btn btn-sm btn-danger" id="insertBtn" onclick="window.close();" >
			</div>
		</div>
	</form>
</body>
</html>