<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>우편 번호 검색</title>
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
        function result(zipNum, sido, gugun, dong) {
            // 부모 창의 formm의 필드에 검색 결과를 설정하고, 팝업을 닫음
            opener.document.formm.zipNum.value = zipNum;
            opener.document.formm.addr1.value = sido + " " + gugun + " " + dong;
            self.close();
        }
    </script>
</head>
<body>
<div id="popup">
    <div class="container py-5">
        <div class="row mb-4">
            <div class="col px-3">
                <h3 class="fw-bold" style="color: #212529;">우편번호 검색</h3>
            </div>
        </div>
        <!-- GET 방식으로 현재 입력된 아이디를 검색 -->
        <div class="row border p-4 shadow-sm rounded-4" style="background-color: #fdfdfd;">
            <form method="post" action="/member/findzipnum" name="formm">
                <label class="form-label small text-muted">동 이름</label>
                <div class="col-md-1 d-flex align-items-center justify-content-center text-center mt-2">
                    <input name="dong" type="text" class="form-control border-dark-subtle text-dark">&nbsp;
                    <input type="submit" value="찾기" class='btn btn-outline-dark mt-auto'>
                </div>
            </form>
            <div class="col-md-1 d-flex align-items-center justify-content-center text-center mt-2">
                <div class="col-2">
                    <div class="fw-semibold" style="color: #212529;">우편번호</div>
                </div>
                <div class="col">
                    <div class="fw-semibold" style="color: #212529;">주소</div>
                </div>
            </div>
            <c:forEach items="${addressList}" var="address">
                <div class="col-md-1 d-flex align-items-center justify-content-center text-center mt-2">
                    <div class="col-2">
                        <div class="fw-semibold" style="color: #212529;">${address.zipNum}</div>
                    </div>
                    <div class="col">
                        <div class="fw-semibold" style="color: #212529;">
                            <a href="#" class="nav-link" onclick="return result('${address.zipNum}', '${address.sido}', '${address.gugun}', '${address.dong}')">
                                ${address.sido}&nbsp;${address.gugun}&nbsp;${address.dong}
                            </a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
