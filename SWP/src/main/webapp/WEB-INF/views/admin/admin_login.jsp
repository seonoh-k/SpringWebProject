<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <style>
        p {
            margin: 0;
        }
        .main-container{
            display: flex;
            flex-direction: column;
            align-items: center;
            width: 980px;
            min-height: 800px;
        }
        .flex-container-column{
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100%;
            margin-bottom: 208px;
        }
        .form-design{
            box-shadow: 0.5px 0.5px 10px gray;
            border-radius: 6px;
            padding: 24px;
        }
        .form-intro{
            margin: 16px 0;
        }
        .input-container{
            margin: 4px 0px;
        }
        .login-input-design{
            width: 240px;
            font-size: 18px;
            padding: 4px 12px 4px 3px;
            border-radius: 6px;
            box-shadow: 0.5px 0.5px 10px gray;
        }
        .center{
            text-align: center;
        }
        .indecate-input{
            margin-bottom: 2px;
            color: gray;
            font-size: 12px;
        }
        .form-btn-container{
            margin: 12px 0px;
        }
    </style>
    <title>Admin Login</title>
</head>
<body>
<%@ include file="admin_header.html" %>
<!--관리자 로그인 페이지 시작-->
<div class="main-container">
    <article class="flex-container-column">
        <form method="post" action="/admin/login" class="form-design">
            <h1 class="center form-intro">Admin Login</h1>
            <div class="input-container">
                <p class="indecate-input">아이디 입력</p>
                <input name="id" type="text" class="login-input-design" placeholder="아이디 입력">
            </div>
            <div class="input-container">
                <p class="indecate-input">비밀번호 입력</p>
                <input name="pwd" type="password" class="login-input-design" placeholder="비밀번호 입력">
            </div>
            <div class="clear"></div>
            <div id="buttons" class="center form-btn-container">
                <input type="submit" value="로그인" class="submit btn-design">
            </div>
        </form>
    </article>
</div>
<!--관리자 로그인 페이지 끝-->
<%@ include file="admin_footer.html" %>
</body>
</html>
