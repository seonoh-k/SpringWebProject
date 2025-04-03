<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/header.jsp"%>
<div class="container py-5">
    <h4 class="mb-4">1:1 고객 문의</h4>
    <h6> 고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h6>
    <div class="row border p-4 shadow-sm rounded-4" style="background-color: #fdfdfd;">
        <div class="col-md-2 d-flex align-items-center justify-content-center text-center mt-3">
            <div class="fw-semibold" style="color: #212529;">제목</div>
        </div>
        <div class="col-md-10 mt-3">
            <div class="fw-semibold" style="color: #212529;">${qna.subject}</div>
        </div>
        <div class="col-md-2 d-flex align-items-center justify-content-center text-center mt-3">
            <div class="fw-semibold" style="color: #212529;">작성자</div>
        </div>
        <div class="col-md-10 mt-3">
            <div class="fw-semibold" style="color: #212529;">${qna.id}</div>
        </div>
        <div class="col-md-2 d-flex align-items-center justify-content-center text-center mt-3">
            <div class="fw-semibold" style="color: #212529;">작성일</div>
        </div>
        <div class="col-md-10 mt-3">
            <div class="fw-semibold" style="color: #212529;"><fmt:formatDate value="${qna.indate}" pattern="yyyy-MM-dd" /></div>
        </div>
        <div class="col-md-2 d-flex align-items-center justify-content-center text-center mt-3">
            <div class="fw-semibold" style="color: #212529;">문의 내용</div>
        </div>
        <div class="col-md-10 mt-3">
            <div class="fw-semibold" style="color: #212529;">${qna.content}</div>
        </div>
        <div class="col-md-2 d-flex align-items-center justify-content-center text-center mt-3">
            <div class="fw-semibold" style="color: #212529;">답변</div>
        </div>
        <div class="col-md-10 mt-3">
            <c:choose>
                <c:when test="${empty qna.reply}">
                    <div class="fw-semibold" style="color: #212529;"></div>
                </c:when>
                <c:otherwise>
                    <div class="fw-semibold" style="color: #212529;">${qna.reply}</div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <div id="buttons" class="text-center mt-5">
        <a href="/qna/qnalist" class="btn btn-secondary">목록으로</a>
        <a href="/main" class="btn btn-secondary">쇼핑 계속하기</a>
    </div>
</div>

<%@include file="../includes/footer.jsp"%>