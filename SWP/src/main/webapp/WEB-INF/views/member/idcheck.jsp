<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>아이디 중복 체크</title>
    <link href="/resources/css/styles.css" rel="stylesheet" />
    <style type="text/css">
        #wrap {
          margin: 0 20px;
        }
        input[type=button], input[type=submit] {
          float: right;
        }
    </style>
    <script type="text/javascript">
        function idok(){
            // 부모 창의 formm에 id와 reid에 전달된 id 값을 설정하고 창을 닫음
            opener.formm.id.value = "${id}";
            opener.formm.reid.value = "${id}";
            self.close();
        }
    </script>
</head>
<body>
<div id="wrap">
    <h1>ID 중복확인</h1>
    <!-- GET 방식으로 현재 입력된 아이디를 검색 -->
    <form method="get" name="idcheckForm" style="margin-right:0;">
        User ID: <input type="text" name="id" value="${param.id != null ? param.id : id}">
        <input type="submit" value="검색" class="submit">
    </form>
    <br>
    <div style="margin-top: 20px">
        <!-- 중복일 경우: message 값이 1로 설정 -->
        <c:if test="${message == 1}">
            ${id}는 이미 사용중인 아이디입니다.
        </c:if>
        <!-- 사용 가능할 경우: message 값이 0로 설정 -->
        <c:if test="${message == 0}">
            ${id}는 사용 가능한 ID입니다.
            <input type="button" value="사용" class="cancel" onclick="idok()">
        </c:if>
    </div>
</div>
</body>
</html>
