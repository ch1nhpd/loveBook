<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Quản trị</title>

<!-- Custom fonts for this template-->
<link href="<c:url value = '/template/admin/vendor/fontawesome-free/css/all.min.css'/>"  rel="stylesheet" type="text/css">

<!-- Page level plugin CSS-->
<link href="<c:url value = '/template/admin/vendor/datatables/dataTables.bootstrap4.css'/>"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="<c:url value = '/template/admin/css/sb-admin.css'/>" rel="stylesheet">

</head>

<body id="page-top">
	<!-- header -->
	<%@ include file="/common/admin/header.jsp"%>
	<div id="wrapper">

		<!-- Sidebar -->
		<%@ include file="/common/admin/sidebar.jsp"%>

		<div id="content-wrapper">


			<!-- body -->
			<dec:body />
			<!-- Sticky Footer -->
			<%@ include file="/common/admin/footer.jsp"%>

		</div>
		<!-- /.content-wrapper -->

	</div>
	<!-- /#wrapper -->


	<!-- bonus -->
	
	<%@ include file="/common/admin/bonus.jsp"%>

	<!-- Bootstrap core JavaScript--> 
	<script src="<c:url value = '/template/admin/vendor/jquery/jquery.min.js'/>"></script>
	<script src="<c:url value = '/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>

	<!-- Core plugin JavaScript-->
	<script src="<c:url value = '/template/admin/vendor/jquery-easing/jquery.easing.min.js'/>"></script>

	<!-- Page level plugin JavaScript-->
	<script src="<c:url value = '/template/admin/vendor/chart.js/Chart.min.js'/>"></script>
	<script src="<c:url value = '/template/admin/vendor/datatables/jquery.dataTables.js'/>"></script>
	<script src="<c:url value = '/template/admin/vendor/datatables/dataTables.bootstrap4.js'/>"></script>

	<!-- Custom scripts for all pages-->
	<script src="<c:url value = '/template/admin/js/sb-admin.min.js'/>"></script>

	<!-- Demo scripts for this page-->
	<script src="<c:url value = '/template/admin/js/demo/datatables-demo.js'/>"></script>
	<script src="<c:url value = '/template/admin/js/demo/chart-area-demo.js'/>"></script>

</body>

</html>
