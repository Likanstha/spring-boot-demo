<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
										<li><a href='<c:url value="/"/>'><i
												class="fa fa-home"></i> Home</a></li>
									</ul>
								</div>
								<div class="col-md-2">
									<ul class="nav nav-pills nav-stacked">
										<li><a href='<c:url value="/employee/create"/>'><i
												class="fa fa-plus"></i> Add Employee</a></li>
									</ul>
								</div>
								<div class="col-md-2">
									<ul class="nav nav-pills nav-stacked">
										<li><a href='<c:url value="/employee/list"/>'><i
												class="fa fa-list"></i> All Employee</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-12">
						<div class="info d-flex align-items-center">
							<div class="content text-center"
								style="width: 80%; margin: 0 auto;">
								<c:if test="${!empty info}">
									<div class="alert alert-warning alert-white rounded">
										<c:out value="${info}" />
									</div>
								</c:if>
								<c:if test="${!empty success}">
									<div class="alert alert-success alert-white rounded">
										<c:out value="${success}" />
									</div>
								</c:if>
								<c:if test="${!empty error}">
									<div class="alert alert-danger alert-white rounded">
										<c:out value="${error}" />
									</div>
								</c:if>
								<div class="clearfix"></div>
								<div class="card">
									<div class="card-header d-flex align-items-center">
										<h3 class="h4" style="color: #000;">Add Employee</h3>
									</div>
									<div class="card-body">
										<c:url var="createUrl" value="/employee/create" />
										<form:form method="post" modelAttribute="employee" style="margin: 0 auto;"
											cssClass="col-lg-6" action="${createUrl}" role="form">
											<div class="form-group">
												<label>Full Name</label>
												<div class="input-group">
													<span class="input-group-addon"><i
														class="fa fa-bars"></i></span>
													<form:input path="name" type="text"
														placeholder="Enter your name" cssClass="form-control"
														required="required" />
												</div>
												<form:errors path="name" cssClass="error-msg" />
											</div>
											<div class="form-group">
												<label>Email</label>
												<div class="input-group">
													<span class="input-group-addon"><i
														class="fa fa-book"></i></span>
													<form:input path="email" type="text"
														placeholder="Enter your email address" cssClass="form-control"
														required="required" />
												</div>
												<form:errors path="email" cssClass="error-msg" />
											</div>
											
											<div class="form-group">
												<label>Phone</label>
												<div class="input-group">
													<span class="input-group-addon"><i
														class="fa fa-book"></i></span>
													<form:input path="phone" type="number"
														placeholder="Enter your phone number" cssClass="form-control"
														required="required" />
												</div>
												<form:errors path="phone" cssClass="error-msg" />
											</div>
											
											<div class="form-group">
												<label>Address</label>
												<div class="input-group">
													<span class="input-group-addon"><i
														class="fa fa-book"></i></span>
													<form:input path="address" type="text"
														placeholder="Enter your address" cssClass="form-control"
														required="required" />
												</div>
												<form:errors path="address" cssClass="error-msg" />
											</div>
											
											<div class="form-group">
												<label>Designation</label>
												<div class="input-group">
													<span class="input-group-addon"><i
														class="fa fa-book"></i></span>
													<form:input path="designation" type="text"
														placeholder="Enter job level" cssClass="form-control"
														required="required" />
												</div>
												<form:errors path="designation" cssClass="error-msg" />
											</div>
											
											<div class="form-group">
												<label>Salary</label>
												<div class="input-group">
													<span class="input-group-addon"><i
														class="fa fa-book"></i></span>
													<form:input path="salary" type="number"
														placeholder="Enter your address" cssClass="form-control"
														required="required" />
												</div>
												<form:errors path="salary" cssClass="error-msg" />
											</div>
											
											
											<div class="box-footer">
												<button type="submit" class="btn btn-success submitButton">
													<i class="fa fa-plus"></i> Create
												</button>
											</div>
										</form:form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="copyrights text-center">
			<p>&copy; 2020</p>
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