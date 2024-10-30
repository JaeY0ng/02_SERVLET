<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
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