<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<nav class="layout navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid p-0">
    <a class="navbar-brand" href="#">HOME</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
   
        <li class="nav-item dropdown m-4 " >
          <a class="nav-link dropdown-toggle " s href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            도서관리
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/book/add">도서등록</a></li>
            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/book/list">도서조회</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown m-4">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            도서대여
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="#">대여신청</a></li>
            <li><a class="dropdown-item" href="#">대여조회</a></li>
          </ul>
        </li>
        
      </ul>
      <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>