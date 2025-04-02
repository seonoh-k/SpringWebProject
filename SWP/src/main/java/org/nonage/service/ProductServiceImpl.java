package org.nonage.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.nonage.domain.ProductVO;

import java.util.ArrayList;

@Service
@AllArgsConstructor
@Log4j
public class ProductServiceImpl implements ProductService{
    @Override
    public ArrayList<ProductVO> getProductList(int page, int limit) {
        return null;
    }
}
