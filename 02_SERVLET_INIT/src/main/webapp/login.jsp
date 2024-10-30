<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
		<h1>GET</h1>
		<form action="${pageContext.request.contextPath}/login.do" method="get">
			<input type="text" name="userid"/><br>
			<input type="password" name="password"/><br>
			<input type="submit" value="로그인"/><br>
			
		</form>
		
		<h1>POST</h1>
		<form action="${pageContext.request.contextPath}/login.do" method="post">
			<input type="text" name="userid"/><br>
			<input type="password" name="password"/><br>
			<input type="submit" value="로그인"/><br>
			
		</form>
	
</body>
</html>