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
<title>Đăng nhập</title>
</head>

<body>
	<!-- Normal Breadcrumb Begin -->
	<section class="normal-breadcrumb set-bg"
		data-setbg="img/normal-breadcrumb.jpg">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="normal__breadcrumb__text">
						<h2>Login</h2>
						<p>Welcome to the official Anime blog.</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Normal Breadcrumb End -->

	<!-- Login Section Begin -->
	<section class="login spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-6">
					<div class="login__form">
						<c:if test="${param.incorrectAccount != null}">
							<div class="alert alert-danger" style = "text-align: center;">Username or password
								incorrect</div>
						</c:if>
						<c:if test="${param.accessDenied != null}">
							<div class="alert alert-danger" style = "text-align: center;">you Not authorize</div>
						</c:if>
						<h3>Login</h3>
						<form action="j_spring_security_check" id="formLogin"
							method="post">
							<div class="input__item">
								<input type="text" placeholder="UserName" name="j_username">
								<span class="icon_profile"></span>
							</div>
							<div class="input__item">
								<input type="password" placeholder="Password" name="j_password">
								<span class="icon_lock"></span>
							</div>
							<button type="submit" class="site-btn">Login Now</button>
						</form>
						<a href="#" class="forget_pass">Forgot Your Password?</a>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="login__register">
						<h3>Dont’t Have An Account?</h3>
						<a href="/dang-ki" class="primary-btn">Register Now</a>
					</div>
				</div>
			</div>
			<div class="login__social">
				<div class="row d-flex justify-content-center">
					<div class="col-lg-6">
						<div class="login__social__links">
							<span>or</span>
							<ul>
								<li><a href="#" class="facebook"><i
										class="fa fa-facebook"></i> Sign in With Facebook</a></li>
								<li><a href="#" class="google"><i class="fa fa-google"></i>
										Sign in With Google</a></li>
								<li><a href="#" class="twitter"><i
										class="fa fa-twitter"></i> Sign in With Twitter</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Login Section End -->

</body>

</html>