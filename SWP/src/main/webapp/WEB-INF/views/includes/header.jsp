<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Shop Homepage - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="/assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="/resources/css/styles.css" rel="stylesheet" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script type="text/javascript" src="/member/member.js"></script>
    </head>
    <body>
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="/main">NONAGE SHOP</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="/main">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="/about">About</a></li>
                        <li class="nav-item"><a class="nav-link" href="/qna/list">Q&A</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="/product/kindlist?kind=1">Heels</a></li>
                                <li><a class="dropdown-item" href="/product/kindlist?kind=2">Boots</a></li>
                                <li><a class="dropdown-item" href="/product/kindlist?kind=3">Sandals</a></li>
                                <li><a class="dropdown-item" href="/product/kindlist?kind=4">Sneakers</a></li>
                                <li><a class="dropdown-item" href="/product/kindlist?kind=5">On Sale</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="navbar-nav" style="align:center">
                    <c:if test="${not empty sessionScope.loginUser}">
                        <!-- 로그인한 경우: Logout 메뉴 표시 -->
                        <li class="nav-item">
                            <a class="nav-link" href="/member/logout">Logout</a>
                        </li>
                    </c:if>
                    <c:if test="${empty sessionScope.loginUser}">
                        <!-- 로그인하지 않은 경우: Login과 Join 메뉴 표시 -->
                        <li class="nav-item">
                            <a class="nav-link" href="/member/login">Login</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/member/contract">Join</a>
                        </li>
                    </c:if>
                    <li class="nav-item">
                        <a class="nav-link" href="/admin/login">Admin</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/order/totallist">Orders</a>
                    </li>
                </ul>
                <form class="d-flex" action="/cart/cartlist" method="get">
                    <button class="btn btn-outline-dark" type="submit">
                        <i class="bi-cart-fill me-1"></i>
                        Cart
                    </button>
                </form>
                </div>
            </div>
        </div>
    </nav>

    <!-- Header Section -->
    <header class="bg-dark py-5">
        <div class="container px-4 px-lg-5 my-5">
            <div class="text-center text-white">
                <h1 class="display-4 fw-bolder">NONAGE SHOP</h1>
                <p class="lead fw-normal text-white-50 mb-0">Shop the latest trends</p>
            </div>
        </div>
    </header>

    <!-- 콘텐츠 영역은 개별 페이지에서 채워집니다. -->
