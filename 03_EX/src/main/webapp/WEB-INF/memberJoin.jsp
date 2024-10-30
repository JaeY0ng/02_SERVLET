<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>홈쇼핑 회원 등록</h1>
	<section>
	<!-- header -->
		<%@include file="/resource/layout/header.jsp" %>
		<form action="${pageContext.request.contextPath}/memberJoin.do"
			method="post" name="memberInsertForm" onSubmit="return false">
			<table border="1" align="center" width="800px">
				<caption>
					<h2>쇼핑몰 회원 정보 수정</h2>
				</caption>
				<tr>
					<th>회원번호</th>
					<td><input type="text" name="custno" value="${maxCustno+1}"></td>
				</tr>
				<tr>
					<th>회원성명</th>
					<td><input type="text" name="custname"></td>
				</tr>
				<tr>
					<th>회원전화</th>
					<td><input type="text" name="phone"></td>
				</tr>
				<tr>
					<th>회원주소</th>
					<td><input type="text" name="address"></td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td><input type="date" name="joindate" value="${fmtToday}"></td>
				</tr>
				<tr>
					<th>고객등급[A:VIP,B:일반,C:직원]</th>
					<td><input type="text" name="grade"></td>
				</tr>
				<tr>
					<th>도시코드</th>
					<td><input type="text" name="city"></td>
				</tr>
				<tr>
					<td colspan=2 style="text-align: center;">
						<button onClick="reqInsert()">등록</button>
						<button onClick="location.href='memberInfo.jsp'">조회</button>
					</td>

				</tr>
			</table>
		</form>
	</section>
	<!-- footer -->
		<%@include file="/resource/layout/footer.jsp" %>
</body>


<script>
	function reqInsert() {
		alert("회원 정보가 등록 되었습니다!")
		const form = document.memberInsertForm;
		form.submit();
	}
</script>
</html>