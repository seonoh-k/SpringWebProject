<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/adminheader.jsp"%>

<div class="container product-list-page p-5">
    <h2> Invoice </h2><hr>
    <h4 class="mb-4">From</h4>
    <div class="row border p-4 shadow-sm rounded-4" style="background-color: #fdfdfd;">
        <div class="col-md-2 d-flex align-items-center justify-content-center text-center mt-3">
            <div class="fw-semibold" style="color: #212529;">기업명</div>
        </div>
        <div class="col-md-4 d-flex align-items-center justify-content-center text-center mt-3">
            <div class="fw-semibold" style="color: #212529;">${nonage.company_name}</div>
        </div><br>
        <div class="col-md-2 d-flex align-items-center justify-content-center text-center mt-3">
            <div class="fw-semibold" style="color: #212529;">사업자 번호</div>
        </div>
        <div class="col-md-4 d-flex align-items-center justify-content-center text-center mt-3">
            <div class="fw-semibold" style="color: #212529;">${nonage.registration_no}</div>
        </div>
        <div class="col-md-2 d-flex align-items-center justify-content-center text-center mt-3">
            <div class="fw-semibold" style="color: #212529;">소재지</div>
        </div>
        <div class="col-md-4 d-flex align-items-center justify-content-center text-center mt-3">
            <div class="fw-semibold" style="color: #212529;">${nonage.company_address}</div>
        </div>
        <div class="col-md-2 d-flex align-items-center justify-content-center text-center mt-3">
            <div class="fw-semibold" style="color: #212529;">대표 전화</div>
        </div>
        <div class="col-md-4 d-flex align-items-center justify-content-center text-center mt-3">
            <div class="fw-semibold" style="color: #212529;">${nonage.phone}</div>
        </div>
    </div><br>
    <h4 class="mb-4">To</h4>
    <div id="company" class="row border p-4 shadow-sm rounded-4" style="background-color: #fdfdfd;">

    </div><br>
    <div class="row border p-4 shadow-sm rounded-4" style="background-color: #fdfdfd;">
        <table class="table table-bordered text-center">
            <thead class="table-dark-header">
                <tr>
                    <th>상품명</th>
                    <th>수 량</th>
                    <th>가 격</th>
                    <th>주문일</th>
                </tr>
            </thead>
            <tbody id="companyorder">

            </tbody>
        </table>
    </div>
    <div id="buttons" class="text-center mt-5">
        <input type="button" value="목록으로" class='btn btn-outline-dark mt-auto' onclick="location.href='/company/invoicelist'">
    </div>
</div>

<%@include file="../includes/footer.jsp"%>