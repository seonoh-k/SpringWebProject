<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/adminheader.jsp"%>

<div class="container product-list-page p-5">
    <h2> Invoice </h2><hr>
        <table class="table table-bordered text-center">
            <thead class="table-dark-header">
                <tr>
                    <th>기업명</th>
                    <th>기업 아이디</th>
                    <th>대표 전화</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="company" items="${companyList}">
                    <tr>
                        <td><a class="nav-link" href="/company/adminnonage?id=${company.id}">${company.company_name}</a></td>
                        <td>${company.id}</td>
                        <td>${company.phone}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
</div>

<%@include file="../includes/footer.jsp"%>
