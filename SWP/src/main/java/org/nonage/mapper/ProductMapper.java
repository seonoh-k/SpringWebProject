package org.nonage.mapper;

import org.apache.ibatis.annotations.Param;
import org.nonage.domain.PageVO;
import org.nonage.domain.ProductVO;

import java.util.ArrayList;

public interface ProductMapper {
    void insertProduct(@Param("productVO") ProductVO productVO);
    public ArrayList<ProductVO> getProductList(@Param("pageVO") PageVO pageVO);

    public ProductVO getProduct(@Param("pseq") int pseq);

    public int getListCount(@Param("name") String name);
    public ArrayList<ProductVO> adminProductSearchList(@Param("name") String name, @Param("pageVO") PageVO pageVO);
    public void updateProduct(@Param("productVO") ProductVO productVO);

}
