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
	<div class="container mt-4">
		<div class="row mt-4">
			<div class="alert alert-primary" role="alert">
				<h6 style="text-transform: uppercase;" class="text-center">${sessionScope.member.name }님
					마이페이지</h6>
			</div>
			<form>
				<div class="mb-3">
					<label for="ID" class="form-label">ID </label> <input type="text"
						name="id" readonly="readonly" value="${dto.id }"
						class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp">
				</div>
				<div class="mb-3">
					<label for="exampleInputPassword1" class="form-label">Password</label>
					<input type="password" class="form-control" name="pw"
						readonly="readonly" value="${dto.pw }" id="exampleInputPassword1">
				</div>
				<div class="mb-3">
					<label for="name" class="form-label">NAME</label> <input
						type="text" class="form-control" name="name" readonly="readonly"
						value="${dto.name }" id="name">
				</div>
				<div class="mb-3">
					<label for="email" class="form-label">EMAIL</label> <input
						type="text" class="form-control" name="email" readonly="readonly"
						value="${dto.email }" id="email">
				</div>
				<div class="mb-3">
					<label for="exampleInputPassword1" class="form-label">PHONE</label>
					<input type="text" class="form-control" name="phone"
						readonly="readonly" value="${dto.phone }" id="phone">
				</div>

				<div class="card" style="width: 18rem;">

					<img src="../resources/upload/member/${dto.memberFilesVO.fileName}"
						class="card-img-top" alt="카드이미지">
					<div class="card-body">
						<h5 class="card-title">Image</h5>
						<p class="card-text">Show Image</p>
						<a href="./fileDown?fileNum=${dto.memberFilesVO.fileNum }"
							class="btn btn-primary">${dto.memberFilesVO.oriName}</a>
					</div>

				</div>

	<button type="button" class="btn btn-outline-light"><a href="./infoUpdate?id=${dto.id }">정보수정</a></button>
	<button type="button" class="btn btn-outline-light"><a href="./delete?id=${dto.id }">탈퇴하기</a></button>

				<!-- Option 1: Bootstrap Bundle with Popper -->
				<script
					src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
					integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
					crossorigin="anonymous"></script>
</body>
</html>