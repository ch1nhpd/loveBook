<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ page import="vn.loveBook.util.SecurityUtils"%>
<header class="header">
	<div class="container">
		<div class="row">
			<div class="col-lg-2">
				<div class="header__logo">
					<a href="/trang-chu"> <img
						src='<c:url value ="/template/web/img/logo.png"/>' alt="">
					</a>
				</div>
			</div>
			<div class="col-lg-8">
				<div class="header__nav">
					<nav class="header__menu mobile-menu">
						<ul>
							<li class="active"><a href="/trang-chu">Trang chủ</a></li>
							<li><a href="#">Thể loại <span
									class="arrow_carrot-down"></span></a>
								<ul class="dropdown">
									<c:forEach var="item" items="${listCategory}">
										<li><a href="/the-loai?id=${item.id}">${item.name }</a></li>
									</c:forEach>
								</ul></li>
							<li><a href="/tat-ca-sach">Tất cả sách</a></li>
							<li><a href="#">Đóng góp</a></li>
						</ul>
					</nav>
				</div>
			</div>
			<div class="col-lg-2">
				<div class="header__right">
					<a href="#" class="search-switch"><span class="icon_search"></span></a>
					<security:authorize access="isAnonymous()">
						<a href="/dang-nhap"><span class="icon_profile"
							title="Đăng nhập"></span></a>
					</security:authorize>
					<security:authorize access="isAuthenticated()">
						<a href="#" title="edit profile"><%=SecurityUtils.getPrincipal().getFullName()%>
						</a>
						<a href="/dang-xuat"><span class="icon_profile"
							title="Đăng xuất"></span></a>
					</security:authorize>
				</div>
			</div>
		</div>
		<div id="mobile-menu-wrap"></div>
	</div>
</header>