<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>NONAGE SHOP Navbar</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <style>
        .form-control:focus {
            border-color: #212529 !important;
            box-shadow: 0 0 0.15rem 0.15rem #212529 !important; /* #212529 with alpha */
            outline: none;
        }
        .form-select:focus {
            border-color: #212529 !important;
            box-shadow: 0 0 0.15rem 0.15rem #212529 !important; /* #212529 with alpha */
            outline: none;
        }


        .product-list-page .table-dark-header {
            background-color: #343a40;
            color: white;
        }

        .product-list-page .btn-custom {
            background-color: #495057;
            color: white;
        }

        .product-list-page .btn-custom:hover {
            background-color: #343a40;
        }

        .product-list-page .pagination .page-link {
            color: #343a40;
        }

        .product-list-page .pagination .page-link:hover {
            color: #212529;
        }

        .product-list-page .product-link {
            text-decoration: none;
            color: #212529;
            transition: color 0.2s ease;
        }

        .product-list-page .product-link:hover {
            color: #212529;
            text-decoration: underline;
        }
        .active>.page-link, .page-link.active{
            border-color: #212529;
            box-shadow: 0 0 0.25rem 0.05rem #212529;
            background : #ffffff;

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
            color: #ffffff;


        }

    </style>
</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container px-4 px-lg-5">
      <!-- 왼쪽: 로고 -->
      <a class="navbar-brand" href="/main">NONAGE SHOP</a>

      <!-- 모바일 토글 버튼 -->
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarContent"
        aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <!-- 내부 컨텐츠 -->
      <div class="collapse navbar-collapse" id="navbarContent">
        <!-- 가운데 메뉴 -->
        <ul class="navbar-nav mx-auto mb-2 mb-lg-0 d-flex flex-row gap-4">
          <li class="nav-item">
            <a class="nav-link" href="/product/adminproductlist">상품리스트</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/company/invoicelist">기업주문리스트</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/#">회원리스트</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/qna/adminqnalist">Qna리스트</a>
          </li>
        </ul>

        <!-- 오른쪽: 로그아웃 -->
        <form class="d-flex ms-auto" action="/admin/adminlogout">
          <button class="btn btn-outline-dark" type="submit">Logout</button>
        </form>
      </div>
    </div>
  </nav>