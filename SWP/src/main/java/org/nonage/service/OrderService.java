package org.nonage.service;

import org.nonage.domain.CartVO;
import org.nonage.domain.OrderVO;

import java.util.List;

public interface OrderService {
    public List<OrderVO> totalList(String id);

    public void orderInsert(List<CartVO> cartList, String id);

    public int getMaxOseq();

    public void insertOrderDetail(CartVO cart, int oseq);

    public List<OrderVO> getList(String id, String result, int oseq);
}
