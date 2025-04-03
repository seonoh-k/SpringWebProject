package org.nonage.mapper;

import org.apache.ibatis.annotations.Param;
import org.nonage.domain.CartVO;
import org.nonage.domain.OrderVO;

import java.util.List;

public interface OrderMapper {

    public List<OrderVO> totalList(String id);

    public void orderInsert(@Param("cartList") List<CartVO> cartList, @Param("id") String id);

    public int getMaxOseq();

    public void insertOrderDetail(@Param("cart") CartVO cart, @Param("oseq") int oseq);

    public List<OrderVO> getList(@Param("id") String id, @Param("result") String result, @Param("oseq") int oseq);

    public void updateCartResult(@Param("cart") CartVO cart);
}
