package org.nonage.service;

import org.nonage.domain.CartVO;

import java.util.List;

public interface CartService {

    public void insert(CartVO cart);

    public void delete(int cseq);

    public List<CartVO> getList(String userid);
}
