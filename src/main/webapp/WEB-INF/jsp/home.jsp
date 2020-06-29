<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Employee</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="robots" content="all,follow">
<link rel="stylesheet" href='<c:url value="/css/bootstrap.min.css"/>'>
<link rel="stylesheet" href='<c:url value="/css/fontastic.css"/>'>
<link rel="stylesheet" href='<c:url value="/css/font-awesome.min.css"/>'>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
<link rel="stylesheet" href='<c:url value="/css/style.green.css"/>'>
<link rel="stylesheet" href='<c:url value="/css/custom.css"/>'>
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<body>
	<div class="page login-page">
		<div class="container d-flex align-items-center">
			<div class="form-holder has-shadow">
				<div class="row">
					<div class="col-lg-12">
						<div class="nav-bar-wrapper">
							<div class="row">
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<ul class="nav nav-pills nav-stacked">
										<li><a href='<c:url value="/"/>'><i class="fa fa-home"></i> Home</a></li>
									</ul>
								</div>
								<div class="col-md-2">
									<ul class="nav nav-pills nav-stacked">
										<li><a href='<c:url value="/employee/create"/>'><i class="fa fa-plus"></i> Add
												Employee</a></li>
									</ul>
								</div>
								<div class="col-md-2">
									<ul class="nav nav-pills nav-stacked">
										<li><a href='<c:url value="/employee/list"/>'><i class="fa fa-list"></i> All
												Employee</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-12">
						<div class="info d-flex align-items-center">
							<div class="content text-center"
								style="width: 80%; margin: 0 auto;">
								<div class="logo">
									<h1>Employee</h1>
								</div>
								<p>Total No Of Employee</p>
								<h1>${totalEmployee}</h1>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="copyrights text-center">
			<p>&copy; 2017</p>
		</div>
	</div>
	<!-- Javascript files-->
	<script src='<c:url value="/js/jquery-3.2.1.min.js"/>'></script>
	<script src='<c:url value="/js/popper.js"/>'></script>
	<script src='<c:url value="/js/bootstrap.js"/>'></script>
	<script src='<c:url value="/js/jquery.cookie.js"/>'></script>
	<script src='<c:url value="/js/jquery.validate.min.js"/>'></script>
	<script src='<c:url value="/js/front.js"/>'></script>
	<script src='<c:url value="/js/common.js"/>'></script>
</body>
</html>