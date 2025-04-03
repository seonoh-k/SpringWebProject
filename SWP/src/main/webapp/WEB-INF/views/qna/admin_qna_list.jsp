<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style><%@ include file="/css/admin_design_head_footer.css" %></style>
    <style><%@ include file="/css/default_design.css" %></style>
    <style>
        .table-link-text:hover {
            color: rgb(98, 54, 255);
        }
        .table-link-text:active {
            color: black;
        }
    </style>
    <title>Admin Q&A List</title>
</head>
<body>

<%@ include file="/WEB-INF/views/includes/admin_header.jsp" %>

<!-- Admin Q&A List 페이지 시작 -->
<div class="main-container">
    <div class="flex-container-center">
        <div class="left-navbar">
            <h2 class="navbar-intro">Admin Setting</h2>
            <ul class="navbar-list-wrapper">
                <li><a class="navbar-list-text-style" href="${pageContext.request.contextPath}/adminproductlist">상품리스트</a></li>
                <li><a class="navbar-list-text-style" href="#">주문리스트</a></li>
                <li><a class="navbar-list-text-style" href="#">회원리스트</a></li>
                <li><a class="navbar-list-text-style" href="${pageContext.request.contextPath}/adminqnalist">Q&A 리스트</a></li>
            </ul>
        </div>
        <article class="article">
            <h1 class="article-intro center">고객 민원 게시판</h1>
            <table id="qnaList" class="table-color-design">
                <tr>
                    <th class="table-th-design qna-list-padd">번호(답변여부)</th>
                    <th class="table-th-design qna-list-padd">제목</th>
                    <th class="table-th-design qna-list-padd">작성자</th>
                    <th class="table-th-design qna-list-padd">작성일</th>
                </tr>

                <c:forEach items="${adminQnaList}" var="adminQnaVO">
                    <tr>
                        <td>
                            ${adminQnaVO.qseq}
                            <c:choose>
                                <c:when test="${adminQnaVO.rep == '1'}">(미처리)</c:when>
                                <c:when test="${adminQnaVO.rep == '2'}">(답변완료)</c:when>
                            </c:choose>
                        </td>
                        <td>
                            <a class="table-link-text" href="${pageContext.request.contextPath}/adminqnadetail?qseq=${adminQnaVO.qseq}">
                                ${adminQnaVO.subject}
                            </a>
                        </td>
                        <td>${adminQnaVO.id}</td>
                        <td><fmt:formatDate value="${adminQnaVO.indate}" type="date" /></td>
                    </tr>
                </c:forEach>
            </table>
        </article>
    </div>
</div>
<!-- Admin Q&A List 페이지 끝 -->

<%@ include file="/WEB-INF/views/includes/admin_footer.jsp" %>

</body>
</html>
