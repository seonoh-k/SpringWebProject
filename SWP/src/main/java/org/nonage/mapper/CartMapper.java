package org.nonage.mapper;

import org.nonage.domain.CartVO;

import java.util.List;

public interface CartMapper {

    public void insert(CartVO cart);

    public void delete(int cseq);

    public List<CartVO> getList(String userid);
}
