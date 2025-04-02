package org.nonage.controller;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.nonage.domain.ProductVO;
import org.nonage.service.ProductService;


@Controller
@RequestMapping("/product/*")
@Log4j
@AllArgsConstructor
public class ProductController {
    /**
     * Rest 방식으로 처리할 때는 브라우저나 외부에서 서버를 호출할때는 데이터의 포맷과 서버에서
     * 보내주는 데이터의 타입을 명확히 해주어야한다.
     * 등록 /replies/new -> POST
     * 조회 /replies/:rno -> GET
     * 삭제 /replies/:rno -> DELETE
     * 수정 /replies/:rno -> PUT OR PATCH
     * 페이지 /replies/pages/:bno/:page -> GET
     * @PostMapping(value="url", produces = "내가 이런 타입의 이터로 보내줄게 text/plain; charset=UTF-8", consumes="나는 데이터 이렇게 받을게 application/json"
     * // REST Controller는 반환하는 데이터를 produces속성에 정의하면 알아서 변환해준다.
     */
    // 생성자에 의한 묵시적 의존 주입
    private ProductService service;


    @GetMapping(value = "/list")
    public ResponseEntity<ProductVO> get(){
        log.info("get : zzzzzzzzzzzzzzzzzzzzzzz");
        ProductVO productVO = new ProductVO();
        productVO.setName("Test");
        return new ResponseEntity<>(productVO,HttpStatus.OK);
    }

}
