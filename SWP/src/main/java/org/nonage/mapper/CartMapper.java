package org.nonage.mapper;

import org.apache.ibatis.annotations.Param;
import org.nonage.domain.CartVO;

import java.util.List;

public interface CartMapper {

    public void insert(@Param("cart") CartVO cart, @Param("id") String id);

    public void delete(int cseq);

    public List<CartVO> getList(String userid);
}
