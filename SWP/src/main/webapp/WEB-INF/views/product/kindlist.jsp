<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/header.jsp"%>

<section class="py-5">
    <div class="container px-4 px-lg-5 mt-5">
        <c:choose>
            <c:when test="${kind == 1}">
                <h3>Heels</h3>
            </c:when>
            <c:when test="${kind == 2}">
                <h3>Boots</h3>
            </c:when>
            <c:when test="${kind == 3}">
                <h3>Sandals</h3>
            </c:when>
            <c:when test="${kind == 4}">
                <h3>Sneakers</h3>
            </c:when>
            <c:when test="${kind == 5}">
                <h3>On Sale</h3>
            </c:when>
        </c:choose>
        <hr><br>
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
            <c:forEach var="list" items="${kindList}">
                <div class="col mb-5">
                    <div class="card h-100">
                        <!-- Product image-->
                        <img class="card-img-top" src="/resources/product_images/${list.image}" alt="${list.name}" />
                        <!-- Product details-->
                        <div class="card-body p-4">
                            <div class="text-center">
                                <!-- Product name-->
                                <h5 class="fw-bolder">${list.name}</h5>
                                <!-- Product price-->
                                ${list.price2}
                            </div>
                        </div>
                        <!-- Product actions-->
                        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                            <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="/product/productdetail?pseq=${list.pseq}">View options</a></div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>

<%@include file="../includes/footer.jsp"%>