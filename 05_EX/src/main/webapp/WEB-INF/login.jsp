<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	body{
		margin:0;padding:0;
	}
	section{height : calc(100vh - 250px );}
</style>

</head>
<body>


	<div class="wrapper">
		<!-- header -->
		<%@include file="/resources/layout/header.jsp" %>
		<section>
			<h2>LOGIN</h2>
			<form action="${pageContext.request.contextPath}/login.do" method="post">
				<input type="text" name="custname" />
				<input type="password" name="password" />
				<input type="submit" value="로그인" />
			</form>
		
		</section>

		<!-- footer -->
		<%@include file="/resources/layout/footer.jsp" %>
	</div>


</body>
</html>