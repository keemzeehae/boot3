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
		<c:import url="../temp/header.jsp"></c:import>
	<form action="./update" method="POST" enctype="multipart/form-data">
	<input type="hidden" name="num" value="${vo.num}">
		<div class="container mt-4">
			<div class="row mt-4">
				<div class="alert alert-primary" role="alert">
					<h6 style="text-transform: uppercase;" class="text-center">${board}
						UPDATE</h6>
				</div>
				<div class="mb-3">
					<label for="Title" class="form-label">제목 </label> <input
						type="text" name="title" class="form-control" id="Contents"
						aria-describedby="emailHelp" value="${vo.title }">
				</div>
				<div class="mb-3">
					<label for="contents" class="form-label">내용</label> <input
						type="text" name="contents" class="form-control" id="contents"
						value="${vo.contents }">
				</div>

				<div class="mb-3">
					<label for="writer" class="form-label">작성자</label> <input
						type="text" readonly="readonly" name="writer" class="form-control"
						id="writer" value="${vo.writer }">
				</div>

			</div>
		</div>

		<div class="card" style="width: 18rem;">
			<c:forEach items="${vo.filesVO}" var="f">
				<img src="../resources/upload/board/${f.fileName}"
					class="card-img-top" alt="카드이미지">
				<div class="card-body">
					<h5 class="card-title">Image</h5>
					<p class="card-text">Show Image</p>
					<a href="../resources/upload/board/${f.fileName }"
						class="btn btn-primary">${f.oriName}</a>
				</div>
			</c:forEach>
		</div>
		<div class="col-12">
			<button type="submit" class="btn btn-primary">SUBMIT</button>
		</div>

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	</form>
</body>
</html>