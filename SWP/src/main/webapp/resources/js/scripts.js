/*!
* Start Bootstrap - Shop Homepage v5.0.6 (https://startbootstrap.com/template/shop-homepage)
* Copyright 2013-2023 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-shop-homepage/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project
$(function() {
    (function(){

        $.getJSON("/product/getnewlist", function(arr){
            var str = "";

            $(arr).each(function(i, newList){
                str += "<div class='col mb-5'><div class='card h-100'>";
                str += "<img class='card-img-top' src='/resources/product_images/" + newList.image + "' />";
                str += "<div class='card-body p-4'><div class='text-center'>";
                str += "<h5 class='fw-bolder'>" + newList.name + "</h5>" + newList.price2 + "</div></div>";
                str += "<div class='card-footer p-4 pt-0 border-top-0 bg-transparent'>";
                str += "<div class='text-center'><a class='btn btn-outline-dark mt-auto' href='/product/productdetail?pseq="+ newList.pseq +"'>View Detail</a></div>";
                str += "</div></div></div>";
            });
            $("#newList").html(str);
        });

        $.getJSON("/product/getbestlist", function(arr){
            var str = "";

            $(arr).each(function(i, bestList){
                str += "<div class='col mb-5'><div class='card h-100'>";
                str += "<img class='card-img-top' src='/resources/product_images/" + bestList.image + "' />";
                str += "<div class='card-body p-4'><div class='text-center'>";
                str += "<h5 class='fw-bolder'>" + bestList.name + "</h5>" + bestList.price2 + "</div></div>";
                str += "<div class='card-footer p-4 pt-0 border-top-0 bg-transparent'>";
                str += "<div class='text-center'><a class='btn btn-outline-dark mt-auto' href='/product/productdetail?pseq="+ bestList.pseq +"'>View Detail</a></div>";
                str += "</div></div></div>";
            });
            $("#bestList").html(str);
        });
    })();
});

function go_cart() {
  if (document.formm.quantity.value == "") {
    alert("수량을 입력하여 주세요.");
    document.formm.quantity.focus();
  } else {
    document.formm.action = "/cart/cartinsert";
    document.formm.submit();
  }
}

function go_order() {
  location.href = "/order/totallist";
}

function go_cart_delete() {
  var count = 0;

  if (!document.formm.cseq.length) {
    if (document.formm.cseq.checked) {
      count++;
    }
  }

  for ( var i = 0; i < document.formm.cseq.length; i++) {
    alert("" + document.formm.cseq[i].checked);
    if (document.formm.cseq[i].checked == true) {
      count++;
      alert("" + count);
    }
  }
  if (count == 0) {
    alert("삭제할 항목을 선택해 주세요.");

  } else {
    document.formm.action = "/cart/cartdelete";
    document.formm.submit();
  }
}

function go_order_insert() {
  document.formm.action = "/order/orderinsert";
  document.formm.submit();
}

function cCheck() {
    $.getJSON("/company/ccheck", function(result) {
        if (result == 1) {
            window.location.href = "/company/getnonage"; // 조건이 참일 경우 이동
        } else {
            window.location.href = "/order/totallist"; // 조건이 거짓일 경우 이동
        }
    });
}

$(function() {
    (function(){

        $.getJSON("/company/getcompany", function(company){
            var str = "";

            console.log(company);

            str += `<div class='col-md-2 d-flex align-items-center justify-content-center text-center mt-3'>`;
            str += `<div class='fw-semibold' style='color: #212529;'>기업명</div></div>`;
            str += `<div class='col-md-4 d-flex align-items-center justify-content-center text-center mt-3'>`;
            str += `<div class='fw-semibold' style='color: #212529;'>${company.company_name}</div></div>`;
            str += `<div class='col-md-2 d-flex align-items-center justify-content-center text-center mt-3'>`;
            str += `<div class='fw-semibold' style='color: #212529;'>사업자 번호</div></div>`;
            str += `<div class='col-md-4 d-flex align-items-center justify-content-center text-center mt-3'>`;
            str += `<div class='fw-semibold' style='color: #212529;'>${company.registration_no}</div></div>`;
            str += `<div class='col-md-2 d-flex align-items-center justify-content-center text-center mt-3'>`;
            str += `<div class='fw-semibold' style='color: #212529;'>소재지</div></div>`;
            str += `<div class='col-md-4 d-flex align-items-center justify-content-center text-center mt-3'>`;
            str += `<div class='fw-semibold' style='color: #212529;'>${company.company_address}</div></div>`;
            str += `<div class='col-md-2 d-flex align-items-center justify-content-center text-center mt-3'>`;
            str += `<div class='fw-semibold' style='color: #212529;'>대표 전화</div></div>`;
            str += `<div class='col-md-4 d-flex align-items-center justify-content-center text-center mt-3'>`;
            str += `<div class='fw-semibold' style='color: #212529;'>${company.phone}</div></div>`;

            $("#company").html(str);
        });

        $.getJSON("/order/companyorder", function(arr){
            var str = "";
            var totalPrice = 0;

            $(arr).each(function(i, companyOrder){
                totalPrice += companyOrder.price2 * companyOrder.quantity;
                str += `<tr><td>`;
                str += `<a class='nav-link' href='/product/productdetail?pseq=${companyOrder.pseq}'><h4> ${companyOrder.pname} </h4></a></td>`;
                str += `<td> ${companyOrder.quantity} </td>`;
                str += `<td> ${new Intl.NumberFormat('ko-KR', { style: 'currency', currency: 'KRW' })
                                         .format(companyOrder.price2 * companyOrder.quantity)} </td>`;
                str += `<td> ${new Date(companyOrder.indate).toLocaleDateString('ko-KR')}</td>`;
            });
            str += `<tr><th colspan='2'> 총 액 </th>`;
            str += `<th colspan='2'> ${new Intl.NumberFormat('ko-KR', { style: 'currency', currency: 'KRW' })
                                                                              .format(totalPrice)} </th>`;
            $("#companyorder").html(str);
        });
    })();
});