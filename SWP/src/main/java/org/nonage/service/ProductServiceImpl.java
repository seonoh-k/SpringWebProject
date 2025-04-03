package org.nonage.service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.nonage.domain.PageVO;
import org.nonage.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ProductVO getDetail(int pseq) {

        log.info("pseq : " + pseq);

        return mapper.getDetail(pseq);
    }

    @Override
    public ArrayList<ProductVO> getNewList() {

        log.info("get new list");

        return mapper.getNewList();
    }

    @Override
    public ArrayList<ProductVO> getBestList() {

        log.info("get best list");

        return mapper.getBestList();
    }

    @Override
    public ArrayList<ProductVO> getKindList(String kind) {

        log.info("service kind : " + kind);

        return mapper.getKindList(kind);
    }

    @Override
    public void insertProduct(ProductVO productVO) {
        mapper.insertProduct(productVO);
    }

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
