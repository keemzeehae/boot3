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

<c:import url="../temp/header_script.jsp"></c:import>
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<c:import url="../temp/header.jsp"></c:import>
	<div class="container mt-4">
		<div class="row mt-4">
			<div class="alert alert-primary" role="alert">
				<h6 style="text-transform: uppercase;" class="text-center">${product}
					ADD</h6>
			</div>
			<div class="row" id="list">
				<!-- 상품리스트 ajax, name, price, count -->

			</div>
			<form action="add" method="post" enctype="multipart/form-data">
				<div class="mb-3">
					<label for="productName" class="form-label">Character Name
					</label> <input type="text" name="productName" class="form-control"
						id="productName" aria-describedby="emailHelp">
					<div id="emailHelp" class="form-text">100자 이하로 작성해주세요.</div>
				</div>
				<div class="mb-3">
					<label for="productPrice" class="form-label">가격</label> <input
						type="text" name="productPrice" class="form-control"
						id="productPrice">
				</div>

				<div class="mb-3">
					<label for="productCount" class="form-label">수량</label> <input
						type="text" name="productCount" class="form-control"
						id="productCount">
				</div>
				<div class="mb-3">
					<label for="productDetail" class="form-label">캐릭터 정보</label>
					<textarea rows="10" cols="10" name="productDetail"
						class="form-control" id="productDetail"></textarea>
				</div>
				<button type="button" id="fileAdd"
					class="btn btn-outline-info d-block">파일추가</button>
				<div id="fileResult"></div>
				<button type="button" id="add" class="btn btn-primary d-block">Submit</button>
			</form>
		</div>
	</div>




	<script type="text/javascript">
		$('#productDetail').summernote({
			height : 400
		});

		let pn=1;

		$("#list").on("click", ".pager", function() {
			let checkPn = $(this).attr("data-pn");
			if (checkPn > 0) {
				pn=checkPn;
				getList();
				console.log(pn);
			} else {
				//이전 또는 다음 block이 없음
				console.log(pn);
				console.log(checkPn);
				alert("마지막 페이지 입니다.");
			}
		});

		getList();
		function getList() {
			$.ajax({

				type : "GET",
				url : "./ajaxList",
				data : {
					pn : pn,
					perPage : 5
				},
				success : function(data) {
					$("#list").html(data.trim());
				}
			});

		}

		$("#add").click(function() {
			let productName = $("#productName").val();
			let productPrice = $("#productPrice").val();
			let productCount = $("#productCount").val();
			let productDetail = $("#productDetail").summernote("code"); //$("#productDetail").val();
			$.ajax({
				type : "POST",
				url : "./add",
				data : {
					productName : productName,
					productPrice : productPrice,
					productCount : productCount,
					productDetail : productDetail
				},
				success : function(data) {
					if (data.trim() == '1') {
						alert("상품 등록 완료");
						getList();
						$("#productName").val("");
						$("#productPrice").val("");
						$("#productCount").val("");
						$("#productDetail").summernote("code", "");

					} else {
						alert("상품 등록 실패");
					}

				},
				error : function() {
					alert("error 발생");
				}
			});

		});

		let count = 0;
		$("#fileAdd")
				.click(
						function() {
							if (count > 4) {
								alert("최대 5개까지 가능합니다.")
								return;
							}
							let f = '<div class="mb-3">';
							f = f
									+ '<label for="files" class="form-label">File</label><input type="file" name="files" class="form-control" id="file1"><button type="button" class="btn btn-light del">X</button>';
							f = f + '</div>';

							$("#fileResult").append(f);
							count++;
						});

		$("#fileResult").on("click", ".del", function() {
			$(this).parent().remove();
			count--;
		});
		
		$("fileResult").on("click",function(){
			var form=$("#file1")[0].files[0];
			var formData= new FromData();
			formData.append('files',form);
			
			$.ajax({
				type: "POST",
				enctype:"multipart/form-data",
				url:"/upload/product",
				data:formData,
				processData:false,
				contentType:false,
				cache:false,
				timeout:600000,
				success:function(data){
					alert("성공");
					
				},
				error:function(e){
					alert("실패");
				}
			});
			
			
		});
	</script>
</body>
</html>