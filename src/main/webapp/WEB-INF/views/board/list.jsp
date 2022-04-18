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
				<h6 style="text-transform: uppercase;" class="text-center">${board} List</h6>
			</div>
			<div class="row mt-4">
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">글번호</th>
							<th scope="col">제목</th>
							<th scope="col">내용</th>
							<th scope="col">작성자</th>
							<th scope="col">등록일</th>
							<th scope="col">조회</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${list}" var="board">
							<tr>
								<th scope="row">${board.num}
								<td>${board.title }</td>
								<td>${board.contents }</td>
								<td>${board.writer }</td>
								<td>${board.regDate }</td>
								<td>${board.hit }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="row row justify-content-end">
				<a href="./add" type="button" class="col-1 btn btn-outline-primary">WRITE</a>
			</div>
		</div>
	</div>


<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>