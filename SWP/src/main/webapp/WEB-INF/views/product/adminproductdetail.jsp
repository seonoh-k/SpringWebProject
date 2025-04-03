<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../includes/adminheader.jsp"%>
    <div class="container py-5">
      <div class="row mb-4">
        <div class="col px-4">
          <h3 class="fw-bold" style="color: #212529;">상품 상세 보기</h3>
        </div>
      </div>

      <form method="post" action="/product/adminproductmodify">
        <input type="hidden" name="pseq" value="${product.pseq}">

        <div class="row border p-4 shadow-sm rounded-4" style="background-color: #fdfdfd;">
          <!-- 상품분류 -->
          <div class="col-md-2 d-flex align-items-center justify-content-center text-center">
            <div class="fw-semibold" style="color: #212529;">상품분류</div>
          </div>
          <div class="col-md-10">
            <select name="kind" class="form-select border-dark-subtle text-dark" disabled>
              <option value="1" ${product.kind == '1' ? 'selected' : ''}>Heel</option>
              <option value="2" ${product.kind == '2' ? 'selected' : ''}>Boots</option>
              <option value="3" ${product.kind == '3' ? 'selected' : ''}>Sandals</option>
              <option value="4" ${product.kind == '4' ? 'selected' : ''}>Sneakers</option>
              <option value="5" ${product.kind == '5' ? 'selected' : ''}>On Sale</option>
              <option value="6" ${product.kind == '6' ? 'selected' : ''}>노나지6</option>
              <option value="7" ${product.kind == '7' ? 'selected' : ''}>노나지7</option>
              <option value="8" ${product.kind == '8' ? 'selected' : ''}>노나지8</option>
              <option value="9" ${product.kind == '9' ? 'selected' : ''}>노나지9</option>
            </select>
          </div>

          <!-- 상품명 -->
          <div class="col-md-2 d-flex align-items-center justify-content-center text-center mt-3">
            <div class="fw-semibold" style="color: #212529;">상품명</div>
          </div>
          <div class="col-md-10 mt-3">
            <input type="text" name="name" class="form-control border-dark-subtle text-dark" value="${product.name}" disabled>
          </div>

          <!-- 상세설명 -->
          <div class="col-md-2 d-flex align-items-center justify-content-center text-center mt-3">
            <div class="fw-semibold" style="color: #212529;">상세설명</div>
          </div>
          <div class="col-md-10 mt-3">
            <textarea name="content" class="form-control border-dark-subtle text-dark" rows="4" disabled>${product.content}</textarea>
          </div>

          <!-- 상품 추가 정보 -->
          <div class="col-md-2 d-flex align-items-center justify-content-center text-center mt-3">
            <div class="fw-semibold" style="color: #212529;">상품 추가 정보</div>
          </div>
          <div class="col-md-10 mt-3">
            <div class="row g-3">
              <div class="col">
                <label class="form-label small text-muted">사용 여부 (USEYN)</label>
                <select name="useyn" class="form-select border-dark-subtle text-dark" disabled>
                  <option value="y" ${product.useyn == 'y' ? 'selected' : ''}>사용</option>
                  <option value="n" ${product.useyn == 'n' ? 'selected' : ''}>삭제됨</option>
                </select>
              </div>
              <div class="col">
                <label class="form-label small text-muted">베스트 여부 (BESTYN)</label>
                <select name="bestyn" class="form-select border-dark-subtle text-dark" disabled>
                  <option value="y" ${product.bestyn == 'y' ? 'selected' : ''}>베스트</option>
                  <option value="n" ${product.bestyn == 'n' ? 'selected' : ''}>일반</option>
                </select>
              </div>
              <div class="col">
                <label class="form-label small text-muted">등록일</label>
                <input type="text" class="form-control border-dark-subtle text-dark" value="<fmt:formatDate value='${product.indate}' pattern='yyyy-MM-dd'/>" disabled>
              </div>
            </div>
          </div>

          <!-- 가격 정보 -->
          <div class="col-md-2 d-flex align-items-center justify-content-center text-center mt-3">
            <div class="fw-semibold" style="color: #212529;">가격 정보</div>
          </div>
          <div class="col-md-10 mt-3">
            <div class="row g-3">
              <div class="col">
                <label class="form-label small text-muted">원가 [PRICE1]</label>
                <input type="text" class="form-control border-dark-subtle text-dark" name="price1" value="${product.price1}" disabled>
              </div>
              <div class="col">
                <label class="form-label small text-muted">판매가 [PRICE2]</label>
                <input type="text" class="form-control border-dark-subtle text-dark" name="price2" value="${product.price2}" disabled>
              </div>
              <div class="col">
                <label class="form-label small text-muted">[PRICE2 - PRICE1]</label>
                <input type="text" class="form-control border-dark-subtle text-dark" value="${product.price2 - product.price1}" disabled>
              </div>
            </div>
          </div>

        <!-- 상품이미지 -->
        <div class="col-md-2 d-flex align-items-center justify-content-center text-center mt-3">
          <div class="fw-semibold" style="color: #212529;">상품이미지</div>
        </div>
        <div class="col-md-10 mt-3">
          <img id="previewImage" src="/resources/product_images/${product.image}" alt="상품 이미지" class="img-fluid rounded border border-1 border-dark-subtle" style="max-height: 400px; object-fit: contain;">
          <input type="hidden" name="image" id="imageInput" value="${product.image}">

        </div>

        </div>

        <div class="text-center mt-5">
          <a href="/product/productmodify?pseq=${product.pseq}&page=${page}" class="btn btn-dark px-5 me-2">수정</a>
          <a href="/product/adminproductlist?page=${page}" class="btn btn-secondary px-5">목록</a>
        </div>
      </form>
    </div>
<%@include file="../includes/footer.jsp"%>