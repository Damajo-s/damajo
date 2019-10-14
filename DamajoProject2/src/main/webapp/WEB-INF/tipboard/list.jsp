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

		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row" id="root">
					
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->
		<script type="text/babel">
			class TipBoardListData extends React.Component{ // 클래스 
				constructor(props){ // 생성자(메모리할당)
					super(props);   // 변수설정 (불변)
					this.state={
						video:[]    
					}
				}
				componentWillMount(){
					var _this:this;
					axios.get('http://localhost:8080/mvc/tipboard/list_json.do').then((response=>{
						_this.setState({video:response.data}); // 조회된 결과를 video배열에 담는다. 
						console.log(response);
					});
				}
				//화면 출력
				render(){
					const html=this.state.video.map((m)=>
						<table class="table">
						 <c:forEach var="vo" items="${list }">
								<div class="col-md-4">
									<div>
										<embed src="http://youtube.com/embed/${vo.youtubekey }" style="width: 350px;height:330px;">
										<div class="caption">
											<p><a href="../tipboard/detail.do?no=${vo.no }">${vo.no}. (크게보기) ${vo.title }</a></p>
											<p>${vo.regdate }</p>
											<p>${vo.writer }</p><br>
										</div>
									</div>
								</div>
						  </c:forEach>
					 </table>

					));
				}
				componentDidMount(){ //onload

				}
			}
			ReactDOM.render(<TipBoardListData/>,document.getElementById('root'));
		</script>
</body>
</html>