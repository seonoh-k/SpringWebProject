<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style><%@include file="/css/admin_design_head_footer.css"%></style>
    <style><%@include file="/css/default_design.css"%></style>
    <style>
    .input-design{
        width: 280px;
        font-size: 18px;
        padding: 8px 12px 8px 3px;
        border-radius: 6px;
        box-shadow: 0.5px 0.5px 10px gray ;
    }
    .search-bar{
        margin-bottom: 6px;
    }
    .admin-title{
        margin: 8px 0px;
    }
    table > thead > tr > th{
        padding: 10px 0px;
    table > admin_footer{
        padding: 100px 100px;
    }
    .table-link-text:hover{
        color: rgb(98, 54, 255);
    }
    .table-link-text:active{
        color: black;
    }
    .page-link:hover{
        color: rgb(98, 54, 255);
    }
    .page-link:active{
        color: black;
    }
    </style>

    <title>Document</title>
</head>
<body>
<%@ include file="/admin/admin_header.html" %>
<!-- Product List -->
<div class="main-container">
    <div class="flex-container-center">
        <div class="left-navbar">
            <h2 class="navbar-intro">Admin Setting</h2>
            <ul class="navbar-list-wrapper">
                <li class=""><a class="navbar-list-text-style" href="NonageServlet?command=admin_product_list">상품리스트</a></li>
                <li class=""><a class="navbar-list-text-style" href="#">주문리스트</a></li>
                <li class=""><a class="navbar-list-text-style" href="#">회원리스트</a></li>
                <li class=""><a class="navbar-list-text-style" href="NonageServlet?command=admin_qna_list">Q&A리스트</a></li>
            </ul>
        </div>
        <article class="article">
            <h2 class="admin-title center">상품 리스트</h2>
            <form name="formm" method="post" class="search-bar center" action="NonageServlet?command=admin_product_search">
                <input type="text" name="pname" placeholder="상품명" class="search-input input-design" min-length="1"></input>
                <input type="submit" class="search-btn btn-design center" value="검색"></input>
                <button type="button" class="view-all-btn btn-design" onclick="window.history.back()">전체보기</button>
                <button type="button" class="add-product-btn btn-design"
                onclick="location.href='NonageServlet?command=admin_product_insert_form'">상품등록</button>
            </form>

            </form>

            <table class="table-color-design">
                <thead>
                    <tr>
                        <th class="table-th-design">번호</th>
                        <th class="table-th-design">상품명</th>
                        <th class="table-th-design">원가</th>
                        <th class="table-th-design">판매가</th>
                        <th class="table-th-design">등록일</th>
                        <th class="table-th-design">사용유무</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${adminProductList}" var="adminproductVO">
                        <tr>
                            <td>${adminproductVO.pseq}</td>
                            <td>
                                <a class="table-link-text" href="NonageServlet?command=admin_product_detail&pseq=${adminproductVO.pseq}">
                                    ${adminproductVO.name}
                                </a>
                            </td>
                            <td>${adminproductVO.price1}</td>
                            <td>${adminproductVO.price2}</td>
                            <td>${adminproductVO.indate}</td>
                            <td>${adminproductVO.useyn}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <div class="pagination center">
                <a href="#" class="page-link">1</a>
                <a href="#" class="page-link">2</a>
                <a href="#" class="page-link">3</a>
            </div>
        </article>
    </div>
</div>
<!-- Product List -->
<%@ include file="/admin/admin_footer.html" %>
<script src="admin/product/adminProduct.js"></script>


</body>
</html>