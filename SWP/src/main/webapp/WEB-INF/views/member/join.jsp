<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="../includes/header.jsp" %>

<div class="container py-5">
    <div class="row mb-4">
        <div class="col px-4">
            <h3 class="fw-bold" style="color: #212529;">Join Us</h3>
        </div>
    </div>
    <!-- action 속성을 제거하면 폼은 현재 URL로 제출됩니다. -->
    <form method="post" action="/member/join" name="formm">
        <div class="row border p-4 shadow-sm rounded-4" style="background-color: #fdfdfd;">
            <h4 class="fw-bold" style="color: #212529;">Basic Info</h4>

            <div class="col-md-2 d-flex align-items-center justify-content-center text-center mt-3">
                <div class="fw-semibold" style="color: #212529;">아이디</div>
            </div>
            <div class="col-md-2 mt-3">
                <input type="text" name="id" class="form-control border-dark-subtle text-dark">
                <input type="hidden" name="reid">
            </div>
            <div class="col-md-2 mt-3">
                <input type="button" value="중복 체크" class='btn btn-outline-dark mt-auto' onclick="idcheck()">
            </div>
            <div class="col-md-6 mt-3"></div>
            <div class="col-md-2 d-flex align-items-center justify-content-center text-center mt-3">
                <div class="fw-semibold" style="color: #212529;">비밀번호</div>
            </div>
            <div class="col-md-2 mt-3">
                <input type="password" name="pwd" class="form-control border-dark-subtle text-dark">
            </div>
            <div class="col-md-8 mt-3"></div>
            <div class="col-md-2 d-flex align-items-center justify-content-center text-center mt-3">
                <div class="fw-semibold" style="color: #212529;">비밀번호 확인</div>
            </div>
            <div class="col-md-2 mt-3">
                <input type="password" name="pwdCheck" class="form-control border-dark-subtle text-dark">
            </div>
            <div class="col-md-8 mt-3"></div>
            <div class="col-md-2 d-flex align-items-center justify-content-center text-center mt-3">
                <div class="fw-semibold" style="color: #212529;">이름</div>
            </div>
            <div class="col-md-2 mt-3">
                <input type="text" name="name" class="form-control border-dark-subtle text-dark">
            </div>
            <div class="col-md-8 mt-3"></div>
            <div class="col-md-2 d-flex align-items-center justify-content-center text-center mt-3">
                <div class="fw-semibold" style="color: #212529;">이메일</div>
            </div>
            <div class="col-md-3 mt-3">
                <input type="text" name="email" class="form-control border-dark-subtle text-dark">
            </div>

            <h4 class="fw-bold" style="color: #212529;">Optional</h4>

            <div class="col-md-2 d-flex align-items-center justify-content-center text-center mt-3">
                <div class="fw-semibold" style="color: #212529;">우편번호</div>
            </div>
            <div class="col-md-2 mt-3">
                <input type="text" name="zipNum" class="form-control border-dark-subtle text-dark">
            </div>
            <div class="col-md-2 mt-3">
                <input type="button" value="주소 찾기" class='btn btn-outline-dark mt-auto' onclick="post_zip()">
            </div>
            <div class="col-md-6 mt-3"></div>
            <div class="col-md-2 d-flex align-items-center justify-content-center text-center mt-3">
                <div class="fw-semibold" style="color: #212529;">주소</div>
            </div>
            <div class="col-md-5 mt-3">
                <input type="text" name="addr1" class="form-control border-dark-subtle text-dark">
            </div>
            <div class="col-md-5 mt-3">
                <input type="text" name="addr2" class="form-control border-dark-subtle text-dark">
            </div>
            <div class="col-md-2 d-flex align-items-center justify-content-center text-center mt-3">
                <div class="fw-semibold" style="color: #212529;">전화번호</div>
            </div>
            <div class="col-md-3 mt-3">
                <input type="text" name="phone" class="form-control border-dark-subtle text-dark">
            </div>

            <input type="hidden" name="useyn" value="Y">
        </div>
        <div id="buttons"  class="text-center mt-5">
            <input type="button" value="회원가입" class="btn btn-secondary" onclick="go_save()">
            <input type="reset" value="취소" class="btn btn-secondary">
        </div>
    </form>
</div>

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
    var url = "/member/idcheck?id=" + document.formm.id.value;
    window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=550, height=350");
}

function post_zip() {
    var url = "/member/findzipnum";
    window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=550, height=300");
}

</script>

<%@ include file="../includes/footer.jsp" %>
