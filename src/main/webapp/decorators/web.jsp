<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<meta name="description" content="Anime Template">
<meta name="keywords" content="Anime, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Love Book</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;400;500;600;700&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Mulish:wght@300;400;500;600;700;800;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href='<c:url value="/template/web/css/bootstrap.min.css" />' type="text/css">
<link rel="stylesheet" href='<c:url value="/template/web/css/font-awesome.min.css" />' type="text/css">
<link rel="stylesheet" href='<c:url value="/template/web/css/elegant-icons.css" />' type="text/css">
<link rel="stylesheet" href='<c:url value="/template/web/css/plyr.css" />' type="text/css">
<link rel="stylesheet" href='<c:url value="/template/web/css/nice-select.css" />' type="text/css">
<link rel="stylesheet" href='<c:url value="/template/web/css/owl.carousel.min.css" />' type="text/css">
<link rel="stylesheet" href='<c:url value="/template/web/css/slicknav.min.css" />' type="text/css">
<link rel="stylesheet" href='<c:url value="/template/web/css/style.css" />' type="text/css">

<!-- thêm  cái này để chạy jquery-->
	<script src="<c:url value='/template/web/assets/js/ace-extra.min.js' />"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type='text/javascript' src='<c:url value="/template/web/js/jquery-2.2.3.min.js" />'></script>
    <script src="<c:url value='/template/web/assets/js/jquery.2.1.1.min.js' />"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


</head>

<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Header Section Begin -->
	<%@ include file="/common/web/header.jsp"%>
	<!-- Header End -->

	<dec:body />


	<!-- Footer Section Begin -->
	<%@ include file="/common/web/footer.jsp"%>
	<!-- Footer Section End -->



	<!-- Js Plugins -->
	<script src='<c:url value="template/web/js/jquery-3.3.1.min.js"/>'></script>
	<script src='<c:url value="template/web/js/bootstrap.min.js"/>'></script>
	<script src='<c:url value="template/web/js/player.js"/>'></script>
	<script src='<c:url value="template/web/js/jquery.nice-select.min.js"/>'></script>
	<script src='<c:url value="template/web/js/mixitup.min.js"/>'></script>
	<script src='<c:url value="template/web/js/jquery.slicknav.js"/>'></script>
	<script src='<c:url value="template/web/js/owl.carousel.min.js"/>'></script>
	<script src='<c:url value="template/web/js/main.js"/>'></script>


</body>

</html>