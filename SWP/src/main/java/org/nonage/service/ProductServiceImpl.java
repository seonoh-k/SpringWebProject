package org.nonage.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.nonage.domain.PageVO;
import org.springframework.stereotype.Service;
import org.nonage.domain.ProductVO;
import org.nonage.service.ProductService;
import org.nonage.mapper.ProductMapper;
import java.util.ArrayList;

@Service
@AllArgsConstructor
@Log4j
public class ProductServiceImpl implements ProductService{

    private ProductMapper mapper;

    @Override
    public void insertProduct(ProductVO productVO) {
        mapper.insertProduct(productVO);
    }

    @Override
    public ArrayList<ProductVO> getProductList(PageVO pageVO) {
        return mapper.getProductList(pageVO);
    }

    @Override
    public ProductVO getProduct(int pseq) {
        return mapper.getProduct(pseq);
    }

    @Override
    public int getListCount(String name) {
        return mapper.getListCount(name);
    }

    @Override
    public ArrayList<ProductVO> adminProductSearchList(String name, PageVO pageVO) {
        return mapper.adminProductSearchList(name, pageVO);
    }

    @Override
    public void updateProduct(ProductVO productVO) {
        mapper.updateProduct(productVO);
    }

}
