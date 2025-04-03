package org.nonage.mapper;


import java.util.ArrayList;
import org.apache.ibatis.annotations.Param;
import org.nonage.domain.PageVO;
import org.nonage.domain.ProductVO;


public interface ProductMapper {
    public ProductVO getDetail (int pseq);

    public ArrayList<ProductVO> getNewList();

    public ArrayList<ProductVO> getBestList();

    public ArrayList<ProductVO> getKindList(String kind);

    public ArrayList<ProductVO> getProductList(@Param("pageVO") PageVO pageVO);

    public void insertProduct(@Param("productVO") ProductVO productVO);

    public void updateProduct(@Param("productVO") ProductVO productVO);

    public int getListCount(@Param("name") String name);

    public ProductVO getProduct(@Param("pseq") int pseq);

    public ArrayList<ProductVO> adminProductSearchList(@Param("name") String name, @Param("pageVO") PageVO pageVO);

}
