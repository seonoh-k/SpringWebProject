package org.nonage.mapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.exceptions.PersistenceException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nonage.domain.PageVO;
import org.nonage.domain.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
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
        String keyword = "";
        int total = mapper.getListCount(keyword);
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
        String keyword = "테스트";
        int totalCount = mapper.getListCount(keyword);

        log.info(totalCount);
    }
    @Test
    public void testAdminProductSearchList() {
        String keyword = "스니커즈"; // 이름에 포함될 검색어
        int page = 1;

        int totalCount = mapper.getListCount(keyword);
        PageVO pageVO = new PageVO(page, totalCount);

        List<ProductVO> list = mapper.adminProductSearchList(keyword, pageVO);

        assertNotNull("검색 결과가 null 입니다.", list);
        assertTrue("검색 결과가 없습니다.", list.size() > 0);

        for (ProductVO vo : list) {
            log.info("상품명: " + vo.getName() + " / 가격: " + vo.getPrice2());
            assertTrue("검색어가 상품명에 포함되지 않음", vo.getName().contains(keyword));
        }
    }

    @Test
    public void testUpdateProduct() {
        ProductVO vo = new ProductVO();

        vo.setPseq(281); // 수정할 제품 번호
        vo.setName("수정된 상품명");
        vo.setKind("3");
        vo.setPrice1(3000);
        vo.setPrice2(5000);
        vo.setPrice3(2000); // 계산값
        vo.setContent("수정된 내용");
        vo.setImage("updated.jpg");
        vo.setUseyn("y");
        vo.setBestyn("n");

        mapper.updateProduct(vo);
        log.info("업데이트 완료");
    }

    @Test
    public void testUpdateProductWrong() {
        ProductVO vo = new ProductVO();

        vo.setPseq(281); // 수정할 제품 번호
        vo.setName("수정된 상품명");
        vo.setKind("9");
        vo.setPrice1(3000);
        vo.setPrice2(5000);
        vo.setPrice3(2000); // 계산값
        vo.setContent("수정된 내용");
        vo.setImage("updated.jpg");
        vo.setUseyn("y");
        vo.setBestyn("y");

        mapper.updateProduct(vo);
        log.info("업데이트 완료");
    }

}
