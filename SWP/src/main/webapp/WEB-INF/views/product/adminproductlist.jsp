<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../includes/adminheader.jsp"%>

<div class="container product-list-page p-5">
  <h4 class="mb-4">상품리스트</h4>

  <form class="row mb-3 g-2" method="get" action="/product/productsearch">
    <div class="col-auto">
      <label for="searchName" class="col-form-label">상품명</label>
    </div>
    <div class="col-auto">
      <input type="text" class="form-control" id="searchName" name="name" placeholder="상품명을 입력하세요" value="${name}">
    </div>
    <div class="col-auto">
      <button type="submit" class="btn btn-custom">검색</button>
      <a href="/product/adminproductlist" class="btn btn-custom">전체보기</a>
      <a href="/product/productinsert?page=${pageVO.page}" class="btn btn-custom">상품등록</a>
    </div>
  </form>

  <table class="table table-bordered text-center">
    <thead class="table-dark-header">
      <tr>
        <th>번호</th>
        <th>상품명</th>
        <th>원가</th>
        <th>판매가</th>
        <th>등록일</th>
        <th>사용유무</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="product" items="${list}">
        <tr>
          <td>${product.pseq}</td>
          <td><a href="/product/adminproductdetail?pseq=${product.pseq}&page=${pageVO.page}" class="product-link">${product.name}</a></td>
          <td>${product.price1}</td>
          <td>${product.price2}</td>
          <td><fmt:formatDate value="${product.indate}" pattern="yyyy-MM-dd" /></td>
          <td><c:choose>
            <c:when test="${product.useyn eq 'y'}">사용</c:when>
            <c:otherwise>미사용</c:otherwise>
          </c:choose></td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

  <nav>
    <ul class="pagination justify-content-center py-3">
      <c:if test="${pageVO.prev}">
        <li class="page-item">
          <a class="page-link" href="?page=${pageVO.startPage - 1}&name=${name}">이전</a>
        </li>
      </c:if>

      <c:forEach begin="${pageVO.startPage}" end="${pageVO.endPage}" var="i">
        <li class="page-item ${pageVO.page == i ? 'active' : ''}">
          <a class="page-link" href="?page=${i}&name=${name}">${i}</a>
        </li>
      </c:forEach>

      <c:if test="${pageVO.next}">
        <li class="page-item">
          <a class="page-link" href="?page=${pageVO.endPage + 1}&name=${name}">다음</a>
        </li>
      </c:if>
    </ul>
  </nav>
</div>

<%@include file="../includes/footer.jsp"%>
