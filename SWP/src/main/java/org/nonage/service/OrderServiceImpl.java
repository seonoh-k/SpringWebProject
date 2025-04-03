package org.nonage.service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
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

    public List<OrderVO> totalList() {
        return mapper.totalList();
    }
}
