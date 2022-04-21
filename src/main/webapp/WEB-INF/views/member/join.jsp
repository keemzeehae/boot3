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
				<h6 style="text-transform: uppercase;" class="text-center">JOIN</h6>
			</div>
			<form action="./join" method="post" enctype="multipart/form-data">

				<div class="mb-3">
					<label for="ID" class="form-label">ID </label> <input type="text"
						name="id" class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp">
					<div id="idHelp" class="form-text">세상에 단 하나뿐이 아이디를 만들어주세요.</div>
				</div>
				<div class="mb-3">
					<label for="exampleInputPassword1" class="form-label">Password</label>
					<input type="password" class="form-control" name="pw"
						id="exampleInputPassword1">
				</div>
				<div class="mb-3">
					<label for="name" class="form-label">NAME</label> <input
						type="text" class="form-control" name="name" id="name">
				</div>
				<div class="mb-3">
					<label for="email" class="form-label">EMAIL</label> <input
						type="text" class="form-control" name="email" id="email">
				</div>
				<div class="mb-3">
					<label for="exampleInputPassword1" class="form-label">PHONE</label>
					<input type="text" class="form-control" name="phone" id="phone">
				</div>
				<div class="mb-3">
					<label for="files" class="form-label">File</label> <input
						type="file" name="mf" class="form-control" id="file1">
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>
		<div class="row mt-4">
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="" name="ch"
					id="all"> <label class="form-check-label"
					for="all"> check All </label>
			</div>
			<div class="form-check">
				<input class="form-check-input ch" type="checkbox" value="" name="ch"
					id="ch1"> <label class="form-check-label"
					for="ch1">ch1 </label>
			</div>
			<div class="form-check">
				<input class="form-check-input ch" type="checkbox" value="" name="ch"
					id="ch2"> <label class="form-check-label"
					for="ch2">ch2 </label>
			</div>
			<div class="form-check">
				<input class="form-check-input ch" type="checkbox" value="" name="ch"
					id="ch3"> <label class="form-check-label"
					for="ch3"> ch3 </label>
			</div>

		</div>

	</div>
	<c:import url="../temp/header_script.jsp"></c:import>
	<script type="text/javascript">
	$("#all").click(function(){
		$(".ch").prop("checked",$("#all").prop("checked"))

	
	});
	
	$(".ch").on("click",function(){
		let check=true;
		$(".ch").each(function(index,item){
			if(!$(item).prop("checked")){
				check=false;
			}
		});
		$("#all").prop("checked",check);
		
	});
	</script>
	

</body>
</html>