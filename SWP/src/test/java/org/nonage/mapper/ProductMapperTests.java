package org.nonage.mapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nonage.domain.PageVO;
import org.nonage.domain.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Random;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ProductMapperTests {

    @Setter(onMethod = @__({@Autowired}))
    private ProductMapper mapper;

    @Test
    public void testGetList(){
        int total = mapper.getListCount();
        // assertTrue(total <= 0);
        log.info("Total : " + total);
        PageVO pageVO = new PageVO(1,total);
        ArrayList<ProductVO> productArrayList = mapper.getProductList(pageVO);
        assertNotNull(productArrayList);
        assertTrue(!productArrayList.isEmpty());
        productArrayList.forEach(log::info);
        return;
    }

    @Test
    public void testInertProduct(){
        // then
        Random random = new Random();
        int num = 260;
        String name = "test" + (num);
        String kind = String.valueOf(random.nextInt(9) + 1); // "1"~"9"
        int price1 = 1000 + random.nextInt(5000); // 원가 1000~5999
        int price2 = price1 + (500 + random.nextInt(5000)); // 판매가 원가보다 높게
        int price3 = price2 - price1;
        String content =  "테스트 제품입니다." + (num);
        String image = "test.jpg";
        ProductVO productVO = new ProductVO();
        productVO.setName(name);
        productVO.setKind(kind);
        productVO.setPrice1(price1);
        productVO.setPrice2(price2);
        productVO.setPrice3(price3);
        productVO.setContent(content);
        productVO.setImage(image);

        mapper.insertProduct(productVO);

        log.info(productVO);
    }

    @Test
    public void testGetProduct(){
        int pseq = 230;

        ProductVO productVO = mapper.getProduct(pseq);
        log.info(productVO.getName());
        assertNotNull("DB에서 상품을 못 불러왔습니다", productVO);

    }
    @Test
    public void testGetListCount(){
        int total = mapper.getListCount();
        log.info(total);
    }
}
