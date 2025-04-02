package org.zerock.service;

import org.zerock.domain.ProductVO;

import java.util.ArrayList;

public interface ProductService {

    public ArrayList<ProductVO> getProductList (int page, int limit);

}
