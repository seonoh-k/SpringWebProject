<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>

<%@include file="../includes/header.jsp"%>

<div class="container p-5">
    <div class="row justify-content-center">
      <div class="col-md-4">
        <div class="card shadow-lg">
          <div class="card-body">
            <h3 class="card-title text-center mb-4">로그인</h3>
            <form action="/member/login" method="post">
              <div class="mb-3">
                <label for="username" class="form-label">아이디</label>
                <input type="text" class="form-control" name="id" id="id" placeholder="아이디를 입력하세요">
              </div>
              <div class="mb-3">
                <label for="password" class="form-label">비밀번호</label>
                <input type="password" class="form-control" name="pwd" id="pwd" placeholder="비밀번호를 입력하세요">
              </div>
              <c:if test="${loginFail}">
                  <div class="alert alert-danger mt-2">
                    아이디 또는 비밀번호가 일치하지 않습니다.
                  </div>
                </c:if>
              <div class="d-grid">
                <button type="submit" class="btn btn-dark">로그인</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>

<%@include file="../includes/footer.jsp"%>
