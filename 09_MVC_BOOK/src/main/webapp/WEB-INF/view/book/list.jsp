<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- link -->
	<%@include file="/resources/static/jsp/link.jsp" %>
	
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
		<main  class="layout">
				
			<section  class="show-book">
				<h1>도서 조회 페이지</h1>
				<%@page import="Domain.Common.DTO.*" %>
				<%
					PageDTO pageDto =  (PageDTO)request.getAttribute("pageDto");
				%>
				<div>
					페이지 : <%=pageDto.getCriteria().getPageno() %> / <%=pageDto.getTotalpage() %> (현재페이지 / 전체페이지)
				</div>
				<table class="table w-100" style="margin:20px 0;">
					<thead>
						<tr class="bg-dark text-light">
							<th>BOOKCODE</th>
							<th>BOOKNAME</th>
							<th>PUBLISHER</th>
							<th>ISBN</th>
						</tr>
					</thead>
					<tbody>
						<%@page import="java.util.*,Domain.Common.DTO.*" %>
						<% 
							List<BookDTO> list = (List<BookDTO>)request.getAttribute("list");
							for(BookDTO dto : list)
							{
						%>
						<tr>
							<td><%=dto.getBookCode() %></td>
							<td><%=dto.getBookName() %></td>
							<td><%=dto.getPublisher() %></td>
							<td><%=dto.getIsbn() %></td>
						</tr>
						<%
							}
						%>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="3">
								<!-- 페이지네이션 -->
								<nav aria-label="Page navigation example">
								  <ul class="pagination">
								    <!-- 이전버튼(PREV)  -->
								    <% 
								    	if(pageDto.isPrev())
								    	{
								    %>
									    <li class="page-item">
									      <a class="page-link" href="${pageContext.request.contextPath}/book/list?pageno=<%=pageDto.getStartPage() -1%>" aria-label="Previous">
									        <span aria-hidden="true">&laquo;</span>
									      </a>
									    </li>
								    <%
								    	}
								    %>
								    
								    
								    <%
								    	int startPage = pageDto.getStartPage();
								    	int endPage = pageDto.getEndPage();
								    	for(int i=startPage;i<=endPage;i++)
								    	{
								    %>
								    	<li class="page-item">
								    		<a class="page-link" href="${pageContext.request.contextPath}/book/list?pageno=<%=i%>"><%=i%></a>
								    	</li>
								    <%
								    	}
								    %>
								    
								    <!-- 다음버튼(NEXT) -->
								    
								    <%
								    if(pageDto.isNext())
								    {
								    %>
									    <li class="page-item">
									      <a class="page-link" href="${pageContext.request.contextPath}/book/list?pageno=<%=pageDto.getEndPage() +1%>" aria-label="Next">
									        <span aria-hidden="true">&raquo;</span>
									      </a>
									    </li>
								    <%
								    }
								    %>
								    
								  </ul>
								  
								</nav>
							
							</td>
							<td style="text-align:right">
								<!-- 글쓰기/처음으로 버튼 -->
								<a class="btn btn-success m-2" href="">글쓰기</a>
								<a class="btn btn-secondary m-2" href="">처음으로</a>
							</td>
						</tr>
					</tfoot>
				</table>

			</section>
		</main>
		
		
		<!-- footer -->
		<%@include file="/resources/static/jsp/footer.jsp" %>
	</div>

	
</body>
</html>