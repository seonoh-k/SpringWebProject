package org.nonage.service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nonage.domain.PageVO;
import org.nonage.domain.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ProductServiceTests {

    @Setter(onMethod = @__({@Autowired}))
    private ProductService service;

    @Test
    public void testGetListCount() {
        int count = service.getListCount("");
        System.out.println("전체 상품 개수: " + count);
        assertTrue(count >= 0);
    }

    @Test
    public void testGetProductList() {
        PageVO pageVO = new PageVO(1, service.getListCount(""));
        ArrayList<ProductVO> list = service.getProductList(pageVO);
        assertNotNull(list);
        System.out.println("첫 페이지 상품 수: " + list.size());
        list.forEach(vo -> System.out.println(vo.getPseq() + " | " + vo.getName()));
    }

    @Test
    public void testGetProduct() {
        ProductVO product = service.getProduct(1); // 존재하는 pseq로 변경 가능
        if (product != null) {
            System.out.println("상품명: " + product.getName());
        } else {
            System.out.println("상품 없음");
        }
    }

    @Test
    public void testAdminProductSearchList() {
        String keyword = "test"; // 실제 데이터에 맞는 키워드
        int total = service.getListCount(keyword);
        PageVO pageVO = new PageVO(1, total);

        ArrayList<ProductVO> searchList = service.adminProductSearchList(keyword, pageVO);
        assertNotNull(searchList);
        System.out.println("검색된 상품 수: " + searchList.size());
        searchList.forEach(vo -> System.out.println(vo.getName()));
    }

    @Test
    public void testUpdateProduct() {

        ProductVO vo = new ProductVO();
        vo.setPseq(280);
        vo.setName("서비스 테스트 수정");
        vo.setKind("2");
        vo.setPrice1(2000);
        vo.setPrice2(3000);
        vo.setPrice3(1000);
        vo.setContent("수정된 내용");
        vo.setImage("updated_by_service.jpg");
        vo.setUseyn("n");
        vo.setBestyn("n");

        service.updateProduct(vo);
        log.info("서비스단 수정 완료");
    }

}