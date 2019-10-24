<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" href="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
/* $(function(){
	$('#insertBtn').click(function(){
		$.ajax({
			type:'post',
			url:'../shop/qainsert_ok.do',
			data:{subject:subject,content:content},
			success:function(response){
				
			}
		});
	});
}); */
</script>
</head>
<body>
	<form name="qainsert" target="qainsert" method="post" action="../shop/qainsert_ok.do" >
		<input type=hidden name="id" value="a">
		<input type=hidden name= value="b">
		<div class="container">
			<h3>&nbsp;&nbsp;상품 Q&A 작성하기</h3>
			<hr width="470">
			<div class="row">
				<table class="table">
					<tr>
						<td width=20>&nbsp;&nbsp;제목</td>
						<td>
							<input type=text width=10 name="subject" class="subject" id=subject>
						</td>
					</tr>
					<tr>
						<td width=20%>&nbsp;&nbsp;내용</td>
						<td>
							<textarea rows="10" cols="40" name=content id=content ></textarea>
						</td>
					</tr>
				</table>
			</div>
			<div>
				<pre><font size=1>※ 상품 Q&A 내역은 “마이페이지>상담내역”에서 확인할 수 있습니다.</font></pre>
				<pre><font size=1>※ 상품 상세페이지에 노출되므로 문의 내용에 개인정보가 포함되지 않도록 유의해주세요</font></pre>
				<pre><font size=1>※ 문의 내용에 따라 등록자에게 통보 없이 1:1문의로 전환될 수 있습니다.</font></pre>
				<pre><font size=1>※ 상품 상세페이지에 노출되므로 문의 내용에 개인정보가 포함되지 않도록 유의해주세요.</font></p><br>
			</div>
			<div class="text-center">
				<input type=button value="취소" class="btn btn-sm btn-danger"onclick="window.close();">
				<input type=submit value="등록" class="btn btn-sm btn-danger" id=insertBtn>
			</div>
		</div>
	</form>
</body>
</html>