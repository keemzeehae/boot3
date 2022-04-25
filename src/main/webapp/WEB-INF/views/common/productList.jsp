<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<table class="table table-striped table-hover">
	<thead>
		<tr>
			<th>Num</th>
			<th>Name</th>
			<th>Price</th>
			<th>Count</th>
		</tr>
	</thead>
	<c:forEach items="${list }" var="vo">

		<tr>
			<td>${vo.productNum }</td>
			<td>${vo.productName }</td>
			<td>${vo.productPrice}</td>
			<td>${vo.productDetail }</td>
		</tr>
	</c:forEach>
</table>

<div class="container">
	<div class="row justify-content-center">
		<div class="col-4">
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<li class="page-item"><a class="page-link pager" href="#" data-pn="${pager.pre?pager.startNum-1:0}"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
					<c:forEach begin="${pager.startNum}" end="${pager.lastNum }"
						step="1" var="i">
						<li class="page-item"><a data-pn="${i}" class="page-link pager" href="#">${i}</a></li>
					</c:forEach>
					<li class="page-item"><a class="page-link pager" href="#"  data-pn="${pager.next?pager.lastNum+1:0}"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</div>
</div>