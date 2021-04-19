<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var = "userAPI" value ="/api/user"/>
<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<meta name="description" content="Anime Template">
<meta name="keywords" content="Anime, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Đăng ký</title>
</head>

<body>

	<!-- Normal Breadcrumb Begin -->
	<section class="normal-breadcrumb set-bg"
		data-setbg="img/normal-breadcrumb.jpg">
		
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="normal__breadcrumb__text">
						<h2>Sign Up</h2>
						<p>Welcome to the Love Book.</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Normal Breadcrumb End -->

	<!-- message -->
	<c:if test="${not empty message }">
		<div class="alert alert-${message.alert } container " style = "text-align: center;">
  			<strong>${message.message }</strong>
		</div>
	</c:if>
	<!-- Signup Section Begin -->
	<section class="signup spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-6">
					<div class="login__form">
						<h3>Sign Up</h3>
						<form action="#" id = "formSubmit">
							<div class="input__item">
								<input type="text" name = "email" placeholder="Email address"> <span
									class="icon_mail"></span>
							</div>
							<div class="input__item">
								<input type="text" name = "userName" placeholder="UserName"> <span
									class="icon_profile"></span>
							</div>
							<div class="input__item">
								<input type="password" name = "password" placeholder="Password"> <span
									class="icon_lock"></span>
							</div>
							<button type="submit" class="site-btn" id = "btnSignUp">Sign up</button>
						</form>
						<h5>
							Already have an account? <a href="/dang-nhap">Log In!</a>
						</h5>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="login__social__links">
						<h3>Login With:</h3>
						<ul>
							<li><a href="#" class="facebook"><i
									class="fa fa-facebook"></i> Sign in With Facebook</a></li>
							<li><a href="#" class="google"><i class="fa fa-google"></i>
									Sign in With Google</a></li>
							<li><a href="#" class="twitter"><i class="fa fa-twitter"></i>
									Sign in With Twitter</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Signup Section End -->

	<script >
	$('#btnSignUp').click(function (e) {
	    e.preventDefault();
	    var data = {};
	    var formData = $('#formSubmit').serializeArray();
	    $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
	    signUp(data);
	});
	
	function signUp(data) {
		$.ajax({
			url: '${userAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "/dang-nhap";
            },
            error: function (error) {
            	window.location.href = "/dang-ki?message=signup_fail";
            }
		});
	}
	</script>
</body>

</html>