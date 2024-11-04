<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- link -->
	<%@include file="/resources/static/jsp/link.jsp" %>
	
	<!-- myinfo.css -->
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/static/css/user/myinfo.css" />
	
	<!-- myinfo.js -->
	<script src="${pageContext.request.contextPath}/resources/static/js/user/myinfo.js" defer></script>
	
	
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="wrapper">
		<header>
			<!-- topHeader -->
			<%@include file="/resources/static/jsp/topHeader.jsp" %>
			<!-- nav -->
			<%@include file="/resources/static/jsp/nav.jsp" %>
		</header>
		<main  class="layout" style="">
				<form style="width:400px;margin:50px auto;" action="${pageContext.request.contextPath}/book/add" method="post">
					<div class="m-3">
						<label for="">프로필 이미지 : </label>
						<input type="file" class="form-control"/>
					</div>
					<div class="m-3">
						<label for="">USERNAME : </label>
						<input type="text" class="form-control"/>
					</div>
					<div class="m-3">
						<label for="">PASSWORD : </label>
						<input type="text" class="form-control"/>
					</div>
					<div class="m-3">
						<label for="">ROLE : </label>
						<input type="text" class="form-control"/>
					</div>
					<div class="m-3">
						<a href="" class="btn btn-success me-2">수정 요청</a>
						<a href="" class="btn btn-secondary">이전으로</a>
					</div>
				</form>
		</main>
		
		
		<!-- footer -->
		<%@include file="/resources/static/jsp/footer.jsp" %>
	</div>

	
</body>
</html>