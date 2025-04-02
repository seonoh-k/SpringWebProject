package org.nonage.mapper;

import org.nonage.domain.PageVO;
import org.nonage.domain.ProductVO;

import java.util.ArrayList;

public interface ProductMapper {
    void insertProduct(ProductVO productVO);
    public ArrayList<ProductVO> getProductList(PageVO pageVO);

    public ProductVO getProduct(int pseq);

    public int getListCount();

}
