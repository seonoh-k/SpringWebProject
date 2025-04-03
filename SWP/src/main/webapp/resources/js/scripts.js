/*!
* Start Bootstrap - Shop Homepage v5.0.6 (https://startbootstrap.com/template/shop-homepage)
* Copyright 2013-2023 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-shop-homepage/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project
(function() {
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
  document.formm.action = "/order/totallist";
  document.formm.submit();
}

function go_cart_delete() {
  var count = 0;
  for ( var i = 0; i < document.formm.cseq.length; i++) {
    if (document.formm.cseq[i].checked == true) {
      count++;
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