<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="container-fluid">
	<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Navbar</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<c:if test="${ not empty member}">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/">Home</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="/board/list">Board</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							Dropdown </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="/member/mypage">마이페이지</a></li>
							<li><a class="dropdown-item" href="/member/logout">로그아웃</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Something else
									here</a></li>
						</ul>
						<li class="nav-item"><a class="nav-link active"
							href="/product/list">Character</a></li>
							
						<c:forEach items="${member.roleVOs}" var="vo">
							<c:if test="${vo.roleName eq 'ROLE_ADMIN' }">
						<li class="nav-item"><a class="nav-link active"
							href="/product/manage">Character 관리</a></li>
							</c:if>
						</c:forEach>
					</ul>
				</c:if>

				
				<c:if test="${ empty member}">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/">Home</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="/board/list">Board</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							Dropdown </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="/member/join">회원가입</a></li>
							<li><a class="dropdown-item" href="/member/login">로그인</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Something else
									here</a></li>
						</ul></li>
					<li class="nav-item"><a class="nav-link active"
							href="/product/list">Character</a></li>
				</ul>
				</c:if>
				
				<form class="d-flex">
					<div class="d-flex align-items-center">
						<select class="form-select" aria-label="Default select example" name="kind">
							<option value="col1">내용</option>
							<option value="col2">제목</option>
							<option value="col3">작성자</option>
						</select> <input class="form-control me-2" type="text"
							placeholder="Search" aria-label="Search" name="search" value="${pager.search}">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</div>>
				</form>
			</div>
		</div>
	</nav>
</header>