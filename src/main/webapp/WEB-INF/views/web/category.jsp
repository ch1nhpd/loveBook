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

	<!-- Product Section Begin -->
	<section class="product spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-8">
					<div class="trending__product">
						<div class="row">
							<div class="col-lg-8 col-md-8 col-sm-8">
								<div class="section-title">
									<h4>${nameCategory}</h4>
								</div>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-4">
								<div class="btn__all">
									<a href="#" class="primary-btn">View All <span
										class="arrow_right"></span></a>
								</div>
							</div>
						</div>
						<div class="row">
							<!-- trending -->
							<c:forEach var="item" items="${books}">
								<div class="col-lg-4 col-md-6 col-sm-6">
									<div class="product__item">
										
											<div class="product__item__pic set-bg"
												data-setbg="<c:url value ='/template/web/img/avatar/${item.avatar.name}' />">
												<div class="ep fas fa-star-half-alt">${item.vote }</div>
												<div class="comment">
													<i class="fa fa-comments"></i> 11
												</div>
												<div class="view">
													<i class="fa fa-eye"></i> 9141
												</div>
											</div>
											<div class="product__item__text">
												<h5><a href="sach?id=${item.id}">${item.name }</a></h5>
											</div>
										
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 col-sm-8">
					<div class="product__sidebar">
						<div class="product__sidebar__view">
							<div class="section-title">
								<h5>Top Views</h5>
							</div>
							<ul class="filter__controls">
								<!-- <li class="active" data-filter="*">Day</li> -->
								<li data-filter=".week" class="active">Week</li>
								<li data-filter=".month">Month</li>
								<li data-filter=".years">Years</li>
							</ul>
							<div class="filter__gallery">
								<c:forEach var="item" items="${listHero}">
									<div class="product__sidebar__view__item set-bg mix week"
										data-setbg="<c:url value ='/template/web/img/cover/${item.cover.name}' />">
										<div class="ep">
											<i class="fas fa-star-half-alt"></i>${item.vote }</div>
										<div class="view">
											<i class="fa fa-eye"></i> 7
										</div>
										<h5>
											<a href="#">${item.name }</a>
										</h5>
									</div>
								</c:forEach>
								<c:forEach var="item" items="${listHero}">
									<div class="product__sidebar__view__item set-bg mix month"
										data-setbg="<c:url value ='/template/web/img/cover/${item.cover.name}' />">
										<div class="ep">${item.vote }</div>
										<div class="view">
											<i class="fa fa-eye"></i> 31
										</div>
										<h5>
											<a href="#">${item.name }</a>
										</h5>
									</div>
								</c:forEach>
								<c:forEach var="item" items="${listTrending}">
									<div class="product__sidebar__view__item set-bg mix years"
										data-setbg="<c:url value ='/template/web/img/cover/${item.cover.name}' />">
										<div class="ep">${item.vote }</div>
										<div class="view">
											<i class="fa fa-eye"></i> 360
										</div>
										<h5>
											<a href="#">${item.name }</a>
										</h5>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Product Section End -->

</body>

</html>