package org.nonage.service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nonage.domain.QnaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class QnaServiceTests {

    @Setter(onMethod_ = @Autowired)
    private QnaService qnaService;

    @Test
    public void testExist() {
        log.info("QnaService 객체 확인: " + qnaService);
        assertNotNull(qnaService);
    }

    @Test
    public void testGetList() {
        List<QnaVO> list = qnaService.getList("testuser");
        log.info("유저 QnA 리스트 수: " + list.size());
        list.forEach(qna -> log.info("QnA: " + qna));
    }

    @Test
    public void testAdminGetList() {
        List<QnaVO> list = qnaService.adminGetList();
        log.info("관리자 QnA 리스트 수: " + list.size());
        list.forEach(qna -> log.info("QnA: " + qna));
    }

    @Test
    public void testGetDetail() {
        QnaVO qna = qnaService.getDetail(1);
        log.info("상세 QnA: " + qna);
    }

    @Test
    public void testQnaInsert() {
        QnaVO qna = new QnaVO();
        qna.setSubject("서비스 테스트 제목");
        qna.setContent("서비스 테스트 내용");

        qnaService.qnaInsert(qna, "testuser");
        log.info("QnA 등록 완료");
    }

    @Test
    public void testQnaInsertReply() {
        QnaVO qna = new QnaVO();
        qna.setQseq(1);
        qna.setReply("서비스 댓글 등록 테스트");

        qnaService.qnaInsertReply(qna);
        log.info("댓글 등록 완료");
    }
}
