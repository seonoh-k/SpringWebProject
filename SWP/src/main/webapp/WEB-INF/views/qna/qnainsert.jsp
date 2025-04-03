<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/header.jsp"%>

<div class="container py-5">
  <div class="row mb-4">
    <div class="col px-4">
      <h4 class="fw-bold" style="color: #212529;">문의 등록</h4>
    </div>
  </div>

  <form method="post" action="/qna/qnainsert">
    <div class="row border p-4 shadow-sm rounded-4" style="background-color: #fdfdfd;">
      <div class="col-md-2 d-flex align-items-center justify-content-center text-center mt-3">
        <div class="fw-semibold" style="color: #212529;">제목</div>
      </div>
      <div class="col-md-10 mt-3">
        <input type="text" name="subject" class="form-control border-dark-subtle text-dark" required>
      </div>
      <div class="col-md-2 d-flex align-items-center justify-content-center text-center mt-3">
        <div class="fw-semibold" style="color: #212529;">문의 내용</div>
      </div>
      <div class="col-md-10 mt-3">
        <textarea name="content" class="form-control border-dark-subtle text-dark" rows="4"></textarea>
      </div>
    <div class="text-center mt-5">
      <button type="submit" class="btn btn-dark px-5 me-2">등록</button>
      <input type="reset"  value="취소" class="btn btn-dark px-5 me-2">
      <a href="/main" class="btn btn-secondary">쇼핑 계속하기</a>
    </div>
  </form>
</div>

<%@include file="../includes/footer.jsp"%>