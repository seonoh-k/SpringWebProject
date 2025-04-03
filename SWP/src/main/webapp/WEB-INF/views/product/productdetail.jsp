<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/header.jsp"%>

<section class="py-5">
    <div class="container px-4 px-lg-5 mt-5">
        <h3>${product.name}</h3>
        <hr><br>
        <form  method="post" name="formm">
            <fieldset>
                <span style="float: left;">
                  <img  src="/resources/product_images/${product.image}" />
                </span>
                <label> 가 격 : ${product.price2} 원 </label><br>
                <label> 수 량 : </label>
                <input  type="text"      name="quantity"  size="2"      value="1"><br>
                <input  type="hidden"    name="pseq"       value="${product.pseq}"><br>
                <input  type="hidden"    name="id"       value="ks123"><br>
            </fieldset>
            <br>
            <div id="buttons">
                <input type="button" value="장바구니에 담기"   class="submit"    onclick="go_cart()">
                <input type="button" value="즉시 구매"       class="submit"    onclick="go_order()">
                <input type="reset"  value="취소"           class="cancel">
            </div>
        </form>
    </div>
</section>

<%@include file="../includes/footer.jsp"%>