<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>LOGIN</h1>
	<h2>(/WEB-INF/view/login.jsp)</h2>
	
		<form action="${pageContext.request.contextPath}/login.do"
		method="post">
		<input type="text" name="userid" placeholder="username..." /><br> <input type="password"
			name="password" placeholder="password..."/><br> <input type="submit" value="로그인" /><br>
			
	</form>
</body>
</html>