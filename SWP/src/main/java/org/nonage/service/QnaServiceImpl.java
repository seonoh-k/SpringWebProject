package org.nonage.service;

import org.nonage.domain.QnaVO;
import org.nonage.mapper.QnaMapper;
import org.nonage.service.QnaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QnaServiceImpl implements QnaService {

    private QnaMapper qnaMapper;

    public QnaServiceImpl(QnaMapper qnaMapper) {
        this.qnaMapper = qnaMapper;
    }

    @Override
    public List<QnaVO> getList(String userid) {
        return qnaMapper.listQnaByUserId(userid);
    }

    @Override
    public List<QnaVO> adminGetList() {
        return qnaMapper.listAllQna();
    }

    @Override
    public QnaVO getDetail(int qseq) {
        return qnaMapper.getQnaById(qseq);
    }

    @Override
    public QnaVO adminGetDetail(int qseq) {
        return qnaMapper.getQnaById(qseq);
    }

    @Override
    public void qnaInsert(QnaVO qna, String userid) {
        qnaMapper.insertQna(qna, userid);
    }

    @Override
    public void qnaInsertReply(QnaVO qna) {
        qnaMapper.updateQnaReply(qna);
    }
}