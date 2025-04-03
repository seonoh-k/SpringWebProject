<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>

<%@include file="../includes/header.jsp"%>

<article>
    <h1>Login</h1>
    <form method="post">
        <fieldset>
        <legend></legend>
            <label>User ID</label>
            <input name="id" type="text" value="${id}"><br>
            <label>Password</label>
            <input name="pwd" type="password" value=""><br>
        </fieldset>
        <div class="clear"></div>
        <div id="buttons">
            <input type="submit" value="로그인" class="submit">
            <input type="button" value="회원가입" class="cancel"
                 onclick="location.href='NonageServlet?command=contract'">
            <input type="button" value="아이디 비밀번호 찾기" class="submit"
                 onclick="location.href='NonageServlet?command=find_id_form'">
        </div>
    </form>
</article>

<%@include file="../includes/footer.jsp"%>
