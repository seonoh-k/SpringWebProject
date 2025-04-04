<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>아이디 중복 체크</title>
    <link href="/resources/css/styles.css" rel="stylesheet" />
    <style type="text/css">
        #popup{
           padding: 0 10px;
        }
        .form-control:focus {
            border-color: #212529 !important;
            box-shadow: 0 0 0.15rem 0.15rem #212529 !important; /* #212529 with alpha */
            outline: none;
        }
        .form-select:focus {
            border-color: #212529 !important;
            box-shadow: 0 0 0.15rem 0.15rem #212529 !important; /* #212529 with alpha */
            outline: none;

        .product-list-page .table-dark-header {
            background-color: #343a40;
            color: white;

        .product-list-page .btn-custom {
            background-color: #495057;
            color: white;

        .product-list-page .btn-custom:hover {
            background-color: #343a40;

        .product-list-page .pagination .page-link {
            color: #343a40;

        .product-list-page .pagination .page-link:hover {
            color: #212529;

        .product-list-page .product-link {
            text-decoration: none;
            color: #212529;
            transition: color 0.2s ease;

        .product-list-page .product-link:hover {
            color: #212529;
            text-decoration: underline;
        }
        .active>.page-link, .page-link.active{
            border-color: #212529;
            box-shadow: 0 0 0.25rem 0.05rem #212529;
            background : #ffff
        }
        .product-list-page .pagination .page-link {
            color: #212529;
        }
        .nav-link:hover{
            border-color: #212529;
            box-shadow: 0 0 0.25rem 0.05rem #212529;
        }
        .nav-link:active{
            border-color: #212529;
            background-color : #212529;
            color: #ffff
        }
    </style>
    <script type="text/javascript">
        function idok(){
            // 부모 창의 formm에 id와 reid에 전달된 id 값을 설정하고 창을 닫음
            opener.formm.id.value = "${id}";
            opener.formm.reid.value = "${id}";
            self.close();
        }
    </script>
</head>
<body>
<div id="popup">
    <div class="container py-5">
        <div class="row mb-4">
            <div class="col px-3">
                <h3 class="fw-bold" style="color: #212529;">ID 중복확인</h3>
            </div>
        </div>
        <!-- GET 방식으로 현재 입력된 아이디를 검색 -->
        <div class="row border p-4 shadow-sm rounded-4" style="background-color: #fdfdfd;">
            <form method="get" name="idcheckForm" style="margin-right:0;">
                <div class="col-md-1 d-flex align-items-center justify-content-center text-center mt-2">
                    <input type="text" name="id" class="form-control border-dark-subtle text-dark" value="${param.id != null ? param.id : id}" size="10">&nbsp;&nbsp;
                    <input type="submit" value="검색" class='btn btn-outline-dark mt-auto'>
                </div>
            </form>
            <br>
            <div style="margin-top: 20px">
                <!-- 중복일 경우: message 값이 1로 설정 -->
                <c:if test="${message == 1}">
                    <div class="col-md-1 d-flex align-items-center justify-content-center text-center mt-3">
                        <div class="fw-semibold" style="color: #212529;">${id}는 이미 사용중인 아이디입니다.</div>
                    </div>
                </c:if>
                <!-- 사용 가능할 경우: message 값이 0로 설정 -->
                <c:if test="${message == 0}">
                    <div class="col-md-1 d-flex align-items-center justify-content-center text-center mt-3">
                        <div class="fw-semibold" style="color: #212529;">${id}는 사용 가능한 ID입니다.</div>&nbsp;&nbsp;
                        <input type="button" value="사용" class='btn btn-outline-dark mt-auto' onclick="idok()">
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</div>
</body>
</html>
