package org.nonage.service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.nonage.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.nonage.domain.ProductVO;

import java.util.ArrayList;

@Service
@AllArgsConstructor
@Log4j
public class ProductServiceImpl implements ProductService{

    @Setter(onMethod_ = @Autowired)
    private ProductMapper mapper;

    @Override
    public ArrayList<ProductVO> getProductList(int page, int limit) {
        return null;
    }

    @Override
    public void insert(ProductVO product) {

    }

    @Override
    public void modify(ProductVO product) {

    }

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
}
