<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../includes/adminheader.jsp"%>

<div class="container product-list-page p-5">
  <h4 class="mb-4">고객 민원 게시판</h4>

  <table class="table table-bordered text-center">
    <thead class="table-dark-header">
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>답변상태</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${adminQnaList}" var="qna">
        <tr>
          <td>${qna.qseq}</td>
          <td>
            <a href="/qna/adminqnadetail?qseq=${qna.qseq}" class="product-link">${qna.subject}</a>
          </td>
          <td>${qna.id}</td>
          <td><fmt:formatDate value="${qna.indate}" pattern="yyyy-MM-dd" /></td>
          <td>
            <c:choose>
              <c:when test="${qna.rep eq '1'}">미처리</c:when>
              <c:when test="${qna.rep eq '2'}">답변완료</c:when>
              <c:otherwise>-</c:otherwise>
            </c:choose>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>

<%@include file="../includes/footer.jsp"%>
