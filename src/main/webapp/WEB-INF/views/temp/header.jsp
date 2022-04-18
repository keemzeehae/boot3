<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<header class="container-fluid">
	<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Navbar</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/">Home</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="/board/list">Board</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							Dropdown </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="#">Action</a></li>
							<li><a class="dropdown-item" href="#">Another action</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Something else
									here</a></li>
						</ul></li>
					<li class="nav-item"><a class="nav-link disabled">Disabled</a>
					</li>
				</ul>
				<form class="d-flex">
					<fieldset>
						<select name="kind">
							<option value="col1">본문</option>
							<option value="col2">제목</option>
						</select> <input class="form-control me-2" type="text"
							placeholder="Search" aria-label="Search" name="search" value="${pager.search}">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</fieldset>
				</form>
			</div>
		</div>
	</nav>
</header>