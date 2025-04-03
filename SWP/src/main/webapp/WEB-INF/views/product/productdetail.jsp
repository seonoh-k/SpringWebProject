<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/header.jsp"%>

<div class="container py-5">
    <div class="row mb-4">
        <div class="col px-4">
            <h3 class="fw-bold" style="color: #212529;">상품 상세 보기</h3>
        </div>
    </div>

    <form method="post" name="formm">
        <div class="row border p-4 shadow-sm rounded-4" style="background-color: #fdfdfd;">
            <!-- 상품이미지 -->
            <div class="col-md-2 d-flex align-items-center justify-content-center text-center mt-3">
                <img src="/resources/product_images/${product.image}" alt="상품 이미지" class="img-fluid rounded border border-1 border-dark-subtle" style="max-height: 400px; object-fit: contain;">
                <input type="hidden" name="image" value="${product.image}">
            </div><br>
            <!-- 상품명 -->
            <div class="col-md-2 d-flex align-items-center justify-content-center text-center mt-3">
                <div class="fw-semibold" style="color: #212529;">상품명</div>&nbsp;&nbsp;
                <div class="fw-semibold" style="color: #212529;">${product.name}</div>
            </div>
            <!-- 가격 정보 -->
            <div class="col-md-2 d-flex align-items-center justify-content-center text-center mt-3">
                <div class="fw-semibold" style="color: #212529;">가격</div>&nbsp;&nbsp;
                <div class="fw-semibold" style="color: #212529;">${product.price2}</div>
            </div>
            <div class="col-md-2 d-flex align-items-center justify-content-center text-center mt-3">
                <div class="fw-semibold" style="color: #212529;">수량</div>&nbsp;&nbsp;
                <input type="text" name="quantity" size="2" value="1">
            </div>
            <input type="hidden" name="pseq" value="${product.pseq}">
        </div>
        <div id="buttons" class="text-center mt-5">
            <input type="button" value="장바구니에 담기" class='btn btn-outline-dark mt-auto' onclick="go_cart()">
            <input type="button" value="즉시 구매" class='btn btn-outline-dark mt-auto' onclick="go_order()">
            <input type="reset"  value="취소" class='btn btn-outline-dark mt-auto'>
        </div>
    </form>
</div>

<%@include file="../includes/footer.jsp"%>