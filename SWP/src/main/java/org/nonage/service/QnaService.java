package org.nonage.service;

import org.nonage.domain.QnaVO;

import java.util.List;

public interface QnaService {
    List<QnaVO> getList(String userid);          // 사용자 QnA 목록
    List<QnaVO> adminGetList();                  // 관리자 QnA 목록
    QnaVO getDetail(int qseq);                   // 사용자 QnA 상세
    QnaVO adminGetDetail(int qseq);              // 관리자 QnA 상세
    void qnaInsert(QnaVO qna, String userid);    // 사용자 QnA 등록
    void qnaInsertReply(QnaVO qna);              // 관리자 댓글 등록
}
