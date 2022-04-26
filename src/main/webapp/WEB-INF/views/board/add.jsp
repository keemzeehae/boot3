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
				<h6 style="text-transform: uppercase;" class="text-center">${board}
					Write</h6>
			</div>
			<form action="./add" method="post" enctype="multipart/form-data">
				<div class="mb-3">
					<label for="Title" class="form-label">제목 </label> <input
						type="text" name="title" class="form-control" id="Contents"
						aria-describedby="emailHelp">
					<div id="emailHelp" class="form-text">100자 이하로 작성해주세요</div>
				</div>
				<div class="mb-3">
					<label for="contents" class="form-label">내용</label>
					<textarea rows="10" cols="10" name="contents" class="form-control"
						id="contents"></textarea>
				</div>

				<div class="mb-3">
					<label for="writer" class="form-label">작성자</label> <input
						type="text" name="writer" class="form-control" id="writer">
				</div>
				<button type="button" id="fileAdd"
					class="btn btn-outline-info d-block">파일추가</button>
				<div id="fileResult"></div>
				<button type="submit" class="btn btn-primary d-block">Submit</button>
			</form>
		</div>
	</div>




	<script type="text/javascript">

	$('#contents').summernote({
	height: 400,
	 placeholder:'내용을 입력하세요.',
	 callbacks: {
		 onImageUpload: function(files){
			 //files upload한 이미지 파일 객체
			// console.log("Image Upload"); 
			 let formData = new FormData();
			 
			 formData.append("files",files[0]);
			
			 // board/summerFileUpload 주소
			 $.ajax({
				type:"POST",
				url:"./summerFileUpload",
				data:formData,
				processData:false,
				contentType: false,
				success: function(data){
					$("#contents").summernote('editor.insertImage',data.trim())
						
						
					}
			
		});
	}, //onImageUpload 끝
	onMediaDelete:function(files){
		let fileName=$(files[0]).attr("src");
		console.log(fileName);
		$.ajax({
			type:"GET",
			url: "./summerFileDelete",
			data:{
				fileName:fileName
				},
				success:function(data){
					console.log(data)
				}
		});
	}// onMediaDelete 끝
}
	});
	
	
	
	let count =0;
	$("#fileAdd").click(function(){
		if(count>4){
			alert("최대 5개까지 가능합니다.")
			return;
		}
		let f='<div class="mb-3">';
		f=f+'<label for="files" class="form-label">File</label><input type="file" name="files" class="form-control files" id="file1"><button type="button" class="btn btn-light del">X</button>';
		f=f+'</div>';
		
		$("#fileResult").append(f);
		count++;
	});	
	
	$("#fileResult").on("click",".del",function(){
		$(this).parent().remove();
		count--;
	});
	
</script>
</body>
</html>