<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="../includes/header.jsp" %>

<article>
    <h2>Join Us</h2>
    <!-- action 속성을 제거하면 폼은 현재 URL로 제출됩니다. -->
    <form id="join" method="post" name="formm">
        <fieldset>
            <legend>Basic Info</legend>
            <label>User ID</label>
            <input type="text" name="id" size="12">
            <input type="hidden" name="reid">
            <input type="button" value="중복 체크" class="dup" onclick="idcheck()"><br>
            <label>Password</label>
            <input type="password" name="pwd"><br>
            <label>Retype Password</label>
            <input type="password" name="pwdCheck"><br>
            <label>Name</label>
            <input type="text" name="name"><br>
            <label>E-Mail</label>
            <input type="text" name="email"><br>
        </fieldset>
        <fieldset>
            <legend>Optional</legend>
            <label>Zip Code</label>
            <input type="text" name="zipNum" size="10">
            <input type="button" value="주소 찾기" class="dup" onclick="post_zip()"><br>
            <label>Address</label>
            <input type="text" name="addr1" size="50">
            <input type="text" name="addr2" size="25"><br>
            <label>Phone Number</label>
            <input type="text" name="phone"><br>
        </fieldset>

        <input type="hidden" name="useyn" value="Y">
        <div class="clear"></div>
        <div id="buttons">
            <input type="button" value="회원가입" class="submit" onclick="go_save()">
            <input type="reset" value="취소" class="cancel">
        </div>
    </form>
</article>

<script>
function go_save() {
    if (document.formm.id.value == "") {
        alert("아이디를 입력하여 주세요.");
        document.formm.id.focus();
    } else if (document.formm.id.value != document.formm.reid.value) {
        alert("중복확인을 클릭하여 주세요.");
        document.formm.id.focus();
    } else if (document.formm.pwd.value == "") {
        alert("비밀번호를 입력해 주세요.");
        document.formm.pwd.focus();
    } else if (document.formm.pwd.value != document.formm.pwdCheck.value) {
        alert("비밀번호가 일치하지 않습니다.");
        document.formm.pwd.focus();
    } else if (document.formm.name.value == "") {
        alert("이름을 입력해 주세요.");
        document.formm.name.focus();
    } else if (document.formm.email.value == "") {
        alert("이메일을 입력해 주세요.");
        document.formm.email.focus();
    } else {
        // action이 없으므로 폼은 현재 URL (예: /member/join)으로 POST 요청됩니다.
        document.formm.submit();
    }
}

function idcheck() {
    if (document.formm.id.value == "") {
        alert("아이디를 입력하여 주십시오.");
        document.formm.id.focus();
        return;
    }
    var url = "${pageContext.request.contextPath}/member/idcheck?id=" + document.formm.id.value;
    window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=530, height=350");
}

function post_zip() {
    var url = "${pageContext.request.contextPath}/member/findzipnum";
    window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=550, height=300");
}
</script>

<%@ include file="../includes/footer.jsp" %>
