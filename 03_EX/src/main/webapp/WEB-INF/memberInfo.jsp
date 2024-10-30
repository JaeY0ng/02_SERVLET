<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	margin: 0;
	padding: 0;
}

section {
	height: clac(100vh - 250px)
}

section td, section th {
	border: 1px solid;
}
</style>

</head>
<body>
	<div class="wrapper">
		<!-- header -->
		<%@include file="/resource/layout/header.jsp"%>
		<section>
			<table
				style="width: 80vw; height: 500px; margin: 50px auto; border: 1px solid;">
				<caption>
					<h2>회원목록조회/수정</h2>
				</caption>
				<thead>
					<tr>
						<th>회원번호</th>
						<th>회원성명</th>
						<th>전화번호</th>
						<th>주소</th>
						<th>가입일자</th>
						<th>고객등급</th>
						<th>거주지역</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (int i = 0; i < list.size(); i++) {
					%>
					<tr>
						<td><a
							href="memberUpdate.jsp?custno=<%=list.get(i).getCustno()%>">
								<%=list.get(i).getCustno()%>
						</a></td>
						<td><%=list.get(i).getCustname()%></td>
						<td><%=list.get(i).getPhone()%></td>
						<td><%=list.get(i).getAddress()%></td>
						<td><%=list.get(i).getJoinDate()%></td>
						<td><%=list.get(i).getGrade()%></td>
						<td><%=list.get(i).getCity()%></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</section>
		
		<!-- footer -->
		<%@include file="/resource/layout/footer.jsp" %>
	</div>
</body>
</html>