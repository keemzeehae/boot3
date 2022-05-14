<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<div class="container">
	<h1>Detail Page</h1>
	<div class="row">
		<!-- items에 있는 거는 모델에 담겨있는 것 items ="${requestScope.files}" -->
		<!-- var에 있는 files는 pageScope  -->
		<!-- ${pageScope.files} pageScope가 생명주기가 가장 짧음 -->
		<c:forEach items="${vo.productFilesVOs}" var="fileVO">
			<img alt="" src="../resources/upload/product/${fileVO.fileName}">
		</c:forEach>
	
	</div>
	<div class="row">
		<div class="card">
			<ul class="list-group list-group-flush">
			   	<li class="list-group-item">${vo.productName}</li>
		   		<li class="list-group-item">${vo.id} </li>
			</ul>
		  
			<div class="card-body">
				${vo.productDetail}
	    	</div>
	    	    	 
		</div>
	
	</div> 
</div>