package org.nonage.mapper;

import org.nonage.domain.QnaVO;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@Log4j
public class QnaMapperTests {

    @Autowired
    private QnaMapper qnaMapper;

    @Test
    public void testListAllQna() {
        List<QnaVO> list = qnaMapper.listAllQna();
        assertNotNull(list);
        log.info("전체 QnA 수: " + list.size());
    }

    @Test
    public void testGetQnaById() {
        QnaVO qna = qnaMapper.getQnaById(1);
        if (qna != null) {
            log.info("QnA 가져오기 성공: " + qna.getSubject());
        } else {
            log.warn("해당 QnA 없음.");
        }
    }

    @Test
    public void testInsertQna() {
        QnaVO qna = new QnaVO();
        qna.setSubject("JUnit 테스트 제목");
        qna.setContent("JUnit 테스트 내용");

        qnaMapper.insertQna(qna, "testuser");
        log.info("QnA 등록 성공");
    }

    @Test
    public void testUpdateReply() {
        QnaVO qna = new QnaVO();
        qna.setQseq(1);
        qna.setReply("JUnit을 통한 댓글 등록");

        qnaMapper.updateQnaReply(qna);
        log.info("댓글 등록 완료");
    }
}
