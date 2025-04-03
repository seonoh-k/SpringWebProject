package org.nonage.service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.nonage.domain.CartVO;
import org.nonage.domain.OrderVO;
import org.nonage.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Log4j
public class OrderServiceImpl implements OrderService{

    @Setter(onMethod_ = @Autowired)
    private OrderMapper mapper;

    public List<OrderVO> totalList(String id) {
        return mapper.totalList(id);
    }

    @Override
    public void orderInsert(List<CartVO> cartList, String id) {
        mapper.orderInsert(cartList, id);
    }

    @Override
    public int getMaxOseq() {
        return mapper.getMaxOseq();
    }

    @Override
    public void insertOrderDetail(CartVO cart, int oseq) {
        mapper.insertOrderDetail(cart, oseq);
        mapper.updateCartResult(cart);
    }

    @Override
    public List<OrderVO> getList(String id, String result, int oseq) {
        return mapper.getList(id, result, oseq);
    }
}
