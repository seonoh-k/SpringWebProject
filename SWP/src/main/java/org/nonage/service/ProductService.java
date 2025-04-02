package org.nonage.service;

import org.nonage.domain.PageVO;
import org.nonage.domain.ProductVO;

import java.util.ArrayList;

public interface ProductService {

    void insertProduct(ProductVO productVO);

    ArrayList<ProductVO> getProductList(PageVO pageVO);

    ProductVO getProduct(int pseq);

    int getListCount(String name);

    ArrayList<ProductVO> adminProductSearchList(String name, PageVO pageVO);

    void updateProduct(ProductVO productVO);

}
