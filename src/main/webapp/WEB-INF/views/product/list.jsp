<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<form action="./list" method="get">
		<c:import url="../temp/header.jsp"></c:import>
	</form>
	<div class="container mt-4">
		<div class="row mt-4">
			<div class="alert alert-primary" role="alert">
				<h6 style="text-transform: uppercase;" class="text-center">${product}
					List</h6>
			</div>

			<c:forEach items="${list}" var="pro">
				<div class="card" style="width: 18rem;">
					<img src="../resources/upload/product/${pro.productFilesVO.fileName}"
						class="card-img-top" alt="카드이미지">

					<div class="card-body">
						<h5 class="card-title">
							<a href="./detail?productNum=${pageScope.pro.productNum }">
								${pro.productName}</a>
						</h5>
						<p class="card-text">price: ${pro.productPrice }</p>
						<p class="card-text">count: ${pro.productCount }</p>
						<p class="card-text">detail: ${pro.productDetail }</p>


					</div>
				</div>
			</c:forEach>

			<div class="row row justify-content-end">
				<a href="./add" type="button" class="col-1 btn btn-outline-primary">캐릭터추가</a>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row justify-content-center">
			<div class="col-4">
				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<li class="page-item"><a class="page-link"
							href="./list?pn=${pager.pre?pager.startNum-1:1}"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
						<c:forEach begin="${pager.startNum}" end="${pager.lastNum }"
							step="1" var="i">
							<li class="page-item"><a class="page-link"
								href="./list?pn=${i}">${i}</a></li>
						</c:forEach>
						<li class="page-item"><a class="page-link"
							href="./list?pn=${pager.next?pager.lastNum+1:pager.lastNum}"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>