package org.nonage.service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.nonage.domain.CartVO;
import org.nonage.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Log4j
public class CartServiceImpl implements CartService{

    @Setter(onMethod_ = @Autowired)
    private CartMapper mapper;

    @Override
    public void insert(CartVO cart, String id) {
        log.info("service cart : " + cart);
        log.info(id);

        mapper.insert(cart, id);
    }

    @Override
    public void delete(int cseq) {
        log.info("service cseq : " + cseq);

        mapper.delete(cseq);
    }

    @Override
    public List<CartVO> getList(String userid) {
        log.info("service userid : " + userid);

        return mapper.getList(userid);
    }
}
