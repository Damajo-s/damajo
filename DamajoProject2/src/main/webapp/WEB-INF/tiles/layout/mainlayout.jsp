<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Damajo 가격비교 사이트</title>
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
		<title>Electro - HTML Ecommerce Template</title>
		<!-- Google font -->
		<link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">
		<!-- Bootstrap -->
		<link type="text/css" rel="stylesheet" href="../css/bootstrap.min.css"/>
		<!-- Slick -->
		<link type="text/css" rel="stylesheet" href="../css/slick.css"/>
		<link type="text/css" rel="stylesheet" href="../css/slick-theme.css"/>
		<!-- nouislider -->
		<link type="text/css" rel="stylesheet" href="../css/nouislider.min.css"/>
		<!-- Font Awesome Icon -->
		<link rel="stylesheet" href="../css/font-awesome.min.css">
		<!-- Custom stlylesheet -->
		<link type="text/css" rel="stylesheet" href="../css/style.css"/>
		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
</head>
	<body>
		<!-- HEADER -->
		<tiles:insertAttribute name="header"/>
		<!-- /HEADER -->
		
		<!-- NAVIGATION -->
		<tiles:insertAttribute name="navigation"/>
		<!-- /NAVIGATION -->
		
		<!-- SECTION_1  -->
		<tiles:insertAttribute name="section"/>
	
		<!-- SECTION_2 -->
		<tiles:insertAttribute name="newsletter"/>
		
	
		<!-- FOOTER -->
		<tiles:insertAttribute name="footer"/>
	</body>
	<!-- jQuery Plugins -->
	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/slick.min.js"></script>
	<script src="../js/nouislider.min.js"></script>
	<script src="../js/jquery.zoom.min.js"></script>
	<script src="../js/main.js"></script>
</html>
