<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/header.jsp"%>

<div class="container product-list-page p-5">
    <h2> Cart List </h2>
    <form name="formm" method="post">
        <c:choose>
            <c:when test="${cartList.size() == 0}">
                <h3 style="color: red; text-align: center">장바구니가 비었습니다</h3>
            </c:when>
            <c:otherwise>
            <table class="table table-bordered text-center">
                <thead class="table-dark-header">
                    <tr>
                        <th>상품명</th>
                        <th>수 량</th>
                        <th>가 격</th>
                        <th>주문일</th>
                        <th>삭 제</th>
                    </tr>
                </thead>
                <c:forEach var="cart" items="${list}">
                <tr>
                    <td>
                        <a class="nav-link" href="/product/productdetail?pseq=${cart.pseq}">
                            <h4> ${cart.pname} </h4>
                        </a>
                    </td>
                    <td> ${cart.quantity} </td>
                    <td>
                        <fmt:formatNumber value="${cart.price2*cart.quantity}" type="currency"/>
                    </td>
                    <td> <fmt:formatDate value="${cart.indate}" type="date"/> </td>
                    <td> <input type="checkbox" name="cseq" value= "${cart.cseq}"> </td>
                </tr>
                </c:forEach>
                <tr>
                    <th colspan="2"> 총 액 </th>
                    <th colspan="2">
                        <fmt:formatNumber value="${totalPrice}" type="currency"/><br>
                    </th>
                    <th><a class="nav-link" href="#" onclick="go_cart_delete()"><h4 class="mb-4">삭제하기</h4></a></th>
                </tr>
            </table>
            </c:otherwise>
        </c:choose>

        <div id="buttons" class="text-center mt-5">
            <input type="button" value="쇼핑 계속하기" class='btn btn-outline-dark mt-auto' onclick="location.href='/main'">
            <c:if test= "${cartList.size() != 0}">
                <input type="button" value="주문하기"  class='btn btn-outline-dark mt-auto' onclick="go_order_insert()">
            </c:if>
        </div>
    </form>
</div>

<%@include file="../includes/footer.jsp"%>