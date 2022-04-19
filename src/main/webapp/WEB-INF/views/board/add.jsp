<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="container mt-4">
	<div class="row mt-4">
			<div class="alert alert-primary" role="alert">
				<h6 style="text-transform: uppercase;" class="text-center">${board} Write</h6>
			</div>
	<form action="./add" method="post">
		<div class="mb-3">
			<label for="Title" class="form-label">제목
			</label> <input type="text" name="title" class="form-control"
				id="Contents" aria-describedby="emailHelp">
			<div id="emailHelp" class="form-text">100자 이하로 작성해주세요</div>
		</div>
		<div class="mb-3">
			<label for="contents" class="form-label">내용</label>
			<input type="text" name="contents" class="form-control"
				id="exampleInputPassword1">
		</div>
		
		<div class="mb-3">
			<label for="writer" class="form-label">작성자</label>
			<input type="text" name="writer" class="form-control"
				id="exampleInputPassword1">
		</div>
		
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>


	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>