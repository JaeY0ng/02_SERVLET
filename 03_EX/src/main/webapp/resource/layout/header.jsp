<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
	header{
		height:100px;background-color:blue;color:white;
		display:flex;
		justify-content : center;
		align-items : center;
		text-align:center;
	}
	nav{
		height:40px;
		background-color:purple;
	}
	nav>ul{
		height:100%;
		list-style:none;margin:0;padding:0;
		display:flex;
		justify-content:left;
		align-items:center;
	}
	nav>ul>li{
		padding : 0 20px;
	}
	nav>ul>li>a{
		display:block;
		text-decoration:none;
		color:white;
		font-weight:600;
	}
</style>
<header>
		<h1>쇼핑몰 회원관리 Ver 1.0</h1>
</header>
<nav>
	<ul>
		<li><a href="${pageContext.request.contextPath}/join.jsp">회원등록</a></li>
		<li><a href="${pageContext.request.contextPath}/memberInfo.jsp">회원목록조회/수정</a></li>
		<li><a href="${pageContext.request.contextPath}/sales.jsp">회원매출조회</a></li>
		<li><a href="${pageContext.request.contextPath}">홈으로.</a></li>
	</ul>
</nav>