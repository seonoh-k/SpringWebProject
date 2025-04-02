package org.nonage.service;

import org.nonage.domain.ProductVO;

import java.util.ArrayList;

public interface ProductService {

    public ArrayList<ProductVO> getProductList (int page, int limit);

}
