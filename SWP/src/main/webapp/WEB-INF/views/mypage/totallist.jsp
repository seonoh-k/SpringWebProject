<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/header.jsp"%>

<article>
    <h2> Order List </h2>
    <form name="formm" method="post">
        <c:choose>
            <c:when test="${totalList.size() == 0}">
                <h3 style="color: red; text-align: center">주문내역이 없습니다</h3>
            </c:when>
            <c:otherwise>
                <table id="cartList">
                    <tr>
                        <th>상품명</th> <th>수 량</th><th>가 격</th> <th>주문일</th> <th> 진행 상태 </th>
                    </tr>
                    <c:forEach  var="order" items="${totalList}">
                    <tr>
                        <td>
                           <a href="/product/productdetail?pseq=${order.pseq}">
                               <h3> ${order.pname} </h3>
                           </a>
                        </td>
                        <td> ${order.quantity} </td>
                        <td> <fmt:formatNumber value="${order.price2*order.quantity}" type="currency"/> </td>
                        <td> <fmt:formatDate value="${order.indate}" type="date"/></td>
                        <td> 처리 진행 중 </td>
                    </tr>
                    </c:forEach>
                    <tr>
                        <th colspan="2"> 총 액 </th>
                        <th colspan="2"> <fmt:formatNumber value="${totalPrice}" type="currency"/><br></th>
                        <th> 주문 처리가 완료되었습니다. </th>
                    </tr>
                </table>
            </c:otherwise>
        </c:choose>
        <div class="clear"></div>
        <div id="buttons" style="float: right">
            <input type="button"    value="쇼핑 계속하기"  class="cancel"  onclick="location.href='/main'">
        </div>
    </form>
</article>

<%@include file="../includes/footer.jsp"%>