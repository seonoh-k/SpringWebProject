<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../includes/adminheader.jsp" %>

<div class="container p-5">
  <h4 class="mb-4">Q&A 상세보기</h4>

  <table class="table table-bordered">
    <tr>
      <th width="20%">제목</th>
      <td>${qna.subject}</td>
    </tr>
    <tr>
      <th>작성자</th>
      <td>${qna.id}</td>
    </tr>
    <tr>
      <th>작성일</th>
      <td><fmt:formatDate value="${qna.indate}" pattern="yyyy-MM-dd" /></td>
    </tr>
    <tr>
      <th>문의내용</th>
      <td style="white-space: pre-line;">${qna.content}</td>
    </tr>
    <tr>
      <th>답변</th>
      <td id="replyContentArea">
        <c:choose>
          <c:when test="${empty qna.reply}">
            <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#replyModal">답변 작성</button>
          </c:when>
          <c:otherwise>
            <div style="white-space: pre-line;" id="existingReply">${qna.reply}</div>
          </c:otherwise>
        </c:choose>
      </td>
    </tr>
  </table>

  <a href="/qna/adminqnalist" class="btn btn-secondary">목록으로</a>
</div>

<!-- Modal -->
<div class="modal fade" id="replyModal" tabindex="-1" aria-labelledby="replyModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">답변 작성</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="닫기"></button>
      </div>
      <div class="modal-body">
        <textarea id="modalReplyContent" class="form-control" rows="5" placeholder="답변을 입력하세요"></textarea>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
        <button type="button" class="btn btn-primary" id="saveReplyBtn" data-qseq="${qna.qseq}">저장</button>
      </div>
    </div>
  </div>
</div>

<script>
  document.querySelector('#saveReplyBtn')?.addEventListener('click', function () {
    const reply = document.querySelector('#modalReplyContent').value.trim();
    const qseq = this.dataset.qseq;

    if (!reply) {
      alert('답변을 입력해주세요.');
      return;
    }

    fetch('/qna/reply', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({ qseq: qseq, reply: reply })
    })
    .then(res => {
      if (res.ok) {
        return res.text();
      } else {
        throw new Error('서버 오류');
      }
    })
    .then(result => {

      const modal = bootstrap.Modal.getInstance(document.getElementById('replyModal'));
      modal.hide();


      const replyArea = document.getElementById('replyContentArea');
      replyArea.innerHTML = `
        <div style="white-space: pre-line;" id="existingReply"></div>
      `;
      document.getElementById('existingReply').textContent = reply;
    })
    .catch(err => {
      alert('답변 저장오류 : ' + err);
    });
  });
</script>


<%@ include file="../includes/footer.jsp" %>
