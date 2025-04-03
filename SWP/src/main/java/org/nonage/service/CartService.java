package org.nonage.service;

import org.apache.ibatis.annotations.Param;
import org.nonage.domain.CartVO;

import java.util.List;

public interface CartService {

    public void insert(@Param("cart") CartVO cart, @Param("id") String id);

    public void delete(int cseq);

    public List<CartVO> getList(String userid);
}
