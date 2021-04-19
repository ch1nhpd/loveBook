<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ page import="vn.loveBook.util.SecurityUtils"%>
<c:url var="commentAPI" value="/api/comment" />
<c:url var="detailsURL" value="/sach?id=${book.id}" />
<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<meta name="description" content="Anime Template">
<meta name="keywords" content="Anime, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Love Book</title>
</head>

<body>
	<!-- Hero Section Begin -->
	<section class="hero">
		<div class="container">
			<div class="hero__slider owl-carousel">
				<c:forEach var="item" items="${listHero}">
					<div class="hero__items set-bg"
						data-setbg="<c:url value ='/template/web/img/cover/${item.cover.name}' />">
						<div class="row">
							<div class="col-lg-6">
								<div class="hero__text">
									<div class="label">Adventure</div>
									<h2>${item.name}</h2>
									<p>${item.author}</p>
									<a href="sach?id=${item.id}"><span>Xem ngay</span> <i
										class="fa fa-angle-right"></i></a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>
	<!-- Hero Section End -->

	<!-- main -->
	<div class="about-area">
		<div class="container" style="background-color: wheat;">
			<!-- Hot Aimated News Tittle-->
			<div class="row" style="padding: 5%">
				<div class="col-lg-12">
					<div class="trending-tittle">
						<strong>${book.name}</strong>
						<p>${book.author}</p>
					</div>
				</div>
			</div>
			<div class="row" style="padding: 5%">
				<div class="col-lg-8">
					<!-- Trending Tittle -->
					<div class="about-right mb-90">
						<div class="about-img">
							<img src="" alt="">
						</div>
						<div class="section-tittle mb-30 pt-30">
							<h3>Here come the moms in space</h3>
						</div>
						<div class="about-prea">${book.content }</div>
					</div>
					<security:authorize access="isAuthenticated()">
					<!-- From comments -->
					<div class="row">
						<div class="col-lg-8">
							<form class="form-contact contact_form mb-80"
								action="contact_process.php" method="post" id="commentForm"
								novalidate="novalidate">
								<div class="row">
									<div class="col-12">
										<div class="form-group">
											<textarea class="form-control w-100 error" name="content"
												id="message" cols="30" rows="9" placeholder="Bình luận"></textarea>
										</div>
									</div>

								</div>
								<textarea hidden name = "userId" id = "userId"><%=SecurityUtils.getPrincipal().getId()%></textarea>
								<textarea hidden name = "commentBy" id = "commentBy"><%=SecurityUtils.getPrincipal().getFullName()%></textarea>
								<div class="form-group mt-3">
									<button type="submit" id="btnComment"
										class="button button-contactForm boxed-btn">Send</button>
								</div>
								
							</form>
						</div>
					</div>
					</security:authorize>
					
				</div>
				<div class="col-lg-4">
					<!-- Section Tittle -->
					<div class="section-tittle mb-40">
						<h3>Chi tiết</h3>
					</div>
					<!-- Flow Socail -->
					<div class="single-follow mb-45">
						<div class="single-box">
							<div class="follow-us d-flex align-items-center">
								<div class="follow-social">
									<a href="#"><img src="assets/img/news/icon-fb.png" alt=""></a>
								</div>
								<div class="follow-count">
									<span>8,045</span>
									<p>Views</p>
								</div>
							</div>
							<div class="follow-us d-flex align-items-center">
								<div class="follow-social">
									<a href="#"><img src="assets/img/news/icon-tw.png" alt=""></a>
								</div>
								<div class="follow-count">
									<span>${book.publishYear }</span>
									<p>Năm xuất bản</p>
								</div>
							</div>
						</div>
					</div>
					<br> <br>
					<div class="section-tittle mb-40">
						<h3>Bình luận</h3>
					</div>
					<br>
					<div class="single-follow mb-45">
						<div class="single-box">
						<c:forEach var="item" items="${listComment}">
							<div class="follow-us d-flex align-items-center">
									<div class="follow-count"
										style="background-color: gray; border-radius: 10px; padding: 5px ; margin-bottom: 10px">
										<i class="fas fa-user-edit"><strong>${item.commentBy}</strong></i>
										<div class="label">
											<i class="far fa-comment-dots"></i>${item.content}
										</div>
									</div>
							</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
	$('#btnComment').click(function(e) {
		e.preventDefault();
		var data = {};
		var formData = $('#commentForm').serializeArray();
		$.each(formData, function(i, v) {
			data["" + v.name + ""] = v.value;
		});
		data["bookId"] = ${book.id};
		
		addComment(data);
	});

		function addComment(data) {
			$.ajax({
				url : '${commentAPI}',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "${detailsURL}";
				},
				error : function(error) {
					window.location.href = "${detailsURL}";
				}
			});
		}
	</script>
</body>



</html>