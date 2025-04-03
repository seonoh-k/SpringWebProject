<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>우편 번호 검색</title>
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" />
    <style type="text/css">
        #popup{
            padding: 0 10px;
        }
        table#zipcode {
            border-collapse: collapse; /* border 사이의 간격 없앰 */
            border-top: 3px solid #fff;
            border-bottom: 3px solid #fff;
            width: 100%;
            margin-top: 15px;
        }
        table#zipcode th, table#zipcode td{
            text-align: center;
            border-bottom: 1px dotted #fff;
            color: #FFF;
        }
        table th, td{
            padding: 10px;
        }
        table#zipcode a{
            display: block;
            height: 20px;
            text-decoration: none;
            color: #fff;
            padding: 10px;
        }
        table#zipcode a:hover{
            color: #F90;
            font-weight: bold;
        }
    </style>
    <script type="text/javascript">
        function result(zipNum, sido, gugun, dong) {
            // 부모 창의 formm의 필드에 검색 결과를 설정하고, 팝업을 닫음
            opener.document.formm.zipNum.value = zipNum;
            opener.document.formm.addr1.value = sido + " " + gugun + " " + dong;
            self.close();
        }
    </script>
</head>
<body>
<div id="popup">
    <h1>우편번호 검색</h1>
    <!-- form의 action 속성을 컨텍스트 경로를 포함하여 지정합니다. -->
    <form method="post" action="${pageContext.request.contextPath}/member/findzipnum" name="formm">
        동 이름 : <input name="dong" type="text">
        <input type="submit" value="찾기" class="submit">
    </form>
    <table id="zipcode">
        <tr>
            <th>우편번호</th>
            <th>주소</th>
        </tr>
        <c:forEach items="${addressList}" var="address">
        <tr>
            <td>${address.zipNum}</td>
            <td>
                <a href="#" onclick="return result('${address.zipNum}', '${address.sido}', '${address.gugun}', '${address.dong}')">
                    ${address.sido}&nbsp;${address.gugun}&nbsp;${address.dong}
                </a>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
