<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	<form action="./infoUpdate" method="POST" enctype="multipart/form-data">
		<div class="container mt-4">
			<div class="row mt-4">
				<div class="alert alert-primary" role="alert">
					<h6 style="text-transform: uppercase;" class="text-center">${sessionScope.member.name }님
						정보수정</h6>
				</div>

				<div class="mb-3">
					<label for="ID" class="form-label">ID </label> <input type="text"
						name="id" readonly="readonly" value="${member.id }"
						class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp">
				</div>
				<div class="mb-3">
					<label for="exampleInputPassword1" class="form-label">Password</label>
					<input type="password" class="form-control" name="pw"
						readonly="readonly" value="${member.pw }"
						id="exampleInputPassword1">
				</div>
				<div class="mb-3">
					<label for="name" class="form-label">NAME</label> <input
						type="text" class="form-control" name="name"
						value="${member.name }" id="name">
				</div>
				<div class="mb-3">
					<label for="email" class="form-label">EMAIL</label> <input
						type="text" class="form-control" name="email"
						value="${member.email }" id="email">
				</div>
				<div class="mb-3">
					<label for="exampleInputPassword1" class="form-label">PHONE</label>
					<input type="text" class="form-control" name="phone"
						value="${member.phone }" id="phone">
				</div>

				<div class="card" style="width: 18rem;">

					<img
						src="../resources/upload/member/${member.memberFilesVO.fileName}"
						class="card-img-top" alt="카드이미지">
					<div class="card-body">
						<h5 class="card-title">Image</h5>
						<p class="card-text">Show Image</p>
						<a href="./fileDown?fileNum=${member.memberFilesVO.fileNum }"
							class="btn btn-primary">${member.memberFilesVO.oriName}</a>
					</div>

				</div>
			</div>

			<div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
	</form>

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>