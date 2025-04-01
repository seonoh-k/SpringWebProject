package org.zerock.mapper;

import org.apache.ibatis.annotations.Insert;
import org.zerock.domain.ProductVO;

import java.util.List;

public interface Sample1Mapper {

    public List<ProductVO> get();
}
