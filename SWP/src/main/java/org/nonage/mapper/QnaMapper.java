package org.nonage.mapper;

import org.nonage.domain.QnaVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QnaMapper {
    List<QnaVO> listQnaByUserId(String userid);
    List<QnaVO> listAllQna();
    QnaVO getQnaById(int qseq);
    void insertQna(@Param("qna") QnaVO qna, @Param("userid") String userid);
    void updateQnaReply(QnaVO qna);
}
