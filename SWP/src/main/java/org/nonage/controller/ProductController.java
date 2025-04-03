package org.nonage.controller;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.nonage.domain.PageVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.nonage.domain.ProductVO;
import org.nonage.service.ProductService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import java.util.List;


@Controller
@RequestMapping("/product/*")
@Log4j
@AllArgsConstructor
public class ProductController {

    // 생성자에 의한 묵시적 의존 주입
    private ProductService service;

    // URL PPT와 일치
    @GetMapping("/productinsert")
    public String insert(@RequestParam(value = "page", defaultValue = "1") int page,
                                 Model model) {

        model.addAttribute("page", page);
        return "/product/productinsert"; // → productinsert.jsp
    }

    // URL PPT와 일치
    // 상품 등록 처리
    // 객체의 필드에 자동으로 데이터 매핑
    // @ModelAttribute("productVO")ProductVO productVO
    @PostMapping("/productinsert")
    public String insert(@ModelAttribute("productVO") ProductVO productVO,
                                RedirectAttributes rttr) {

        // 가격 검증
        if (productVO.getPrice2() < productVO.getPrice1()) {
            rttr.addFlashAttribute("error", "판매가는 원가보다 같거나 높아야 합니다.");
            return "redirect:/product/productinsert";
        }

        // 판매 수익 계산
        productVO.setPrice3(productVO.getPrice2() - productVO.getPrice1());

        // DB 저장
        service.insertProduct(productVO);

        return "redirect:/product/adminproductlist";
    }

    // 상품 수정 화면
    // URL PPT와 일치
    @GetMapping("/productmodify")
    public String modify(@RequestParam("pseq") int pseq,
                         @RequestParam(value = "page", defaultValue = "1") int page,
                         Model model) {

        ProductVO product = service.getProduct(pseq);
        model.addAttribute("product", product);
        model.addAttribute("page", page);

        return "/product/productmodify"; // → productmodify.jsp
    }
    // URL PPT와 일치
    // 상품 수정 처리
    @PostMapping("/productmodify")
    public String modify(@ModelAttribute ProductVO productVO,
                                @RequestParam(value = "page", defaultValue = "1") int page,
                                RedirectAttributes rttr) {
        int price1 = productVO.getPrice1();
        int price2 = productVO.getPrice2();
        int price3 = price2 - price1;

        if (price3 < 0) {
            rttr.addFlashAttribute("error", "판매가는 원가보다 작을 수 없습니다.");
            return "redirect:/product/productmodify?pseq=" + productVO.getPseq() + "&page=" + page;
        }

        productVO.setPrice3(price3);
        service.updateProduct(productVO);

        rttr.addAttribute("page", page);
        return "redirect:/product/adminproductlist";
    }

    // 상품 상세 보기
    // URL PPT와 일치
    @GetMapping("/adminproductdetail")
    public String getAdminProductDetail(@RequestParam("pseq") int pseq,
                                        @RequestParam(value = "page", defaultValue = "1") int page,
                                         Model model) {

        ProductVO product = service.getProduct(pseq);
        model.addAttribute("product", product);
        model.addAttribute("page", page);

        return "/product/adminproductdetail"; // → adminproductdetail.jsp
    }

    // 관리자 상품 검색
    // URL PPT와 일치
    @GetMapping("/productsearch")
    public String searchList(@RequestParam(defaultValue = "1") int page,
                                @RequestParam(defaultValue = "") String name,
                                Model model) {

        int totalCount = service.getListCount(name);
        PageVO pageVO = new PageVO(page, totalCount);

        List<ProductVO> list = service.adminProductSearchList(name, pageVO);

        model.addAttribute("list", list);
        model.addAttribute("pageVO", pageVO);
        model.addAttribute("name", name);

        return "/product/adminproductlist";
    }

    // 관리자 상품 전체 목록
    // URL PPT와 일치
    @GetMapping("/adminproductlist")
    public String productList(@RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "") String name,
                              Model model) {

        int totalCount = service.getListCount(name);
        PageVO pageVO = new PageVO(page, totalCount);

        List<ProductVO> list;
        if (name == null || name.trim().isEmpty()) {
            list = service.getProductList(pageVO);
        } else {
            list = service.adminProductSearchList(name, pageVO);
        }

        model.addAttribute("list", list);
        model.addAttribute("pageVO", pageVO);
        model.addAttribute("name", name);

        return "/product/adminproductlist";
    }

    @GetMapping(value = "/getnewlist", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<List<ProductVO>> getNewList() {

        return new ResponseEntity<>(service.getNewList(), HttpStatus.OK);
    }

    @GetMapping(value = "/getbestlist", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<List<ProductVO>> getBestList() {

        return new ResponseEntity<>(service.getBestList(), HttpStatus.OK);
    }

    @GetMapping("/kindlist")
    public String getKindList(@RequestParam("kind") String kind, Model model) {
        log.info("controller kind : " + kind);

        model.addAttribute("kind", kind);

        List<ProductVO> kindList = service.getKindList(kind);
        model.addAttribute("kindList", kindList);
        kindList.forEach(log::info);

        return "/product/kindlist";
    }

    @GetMapping("/productdetail")
    public String getDetail(@RequestParam("pseq") int pseq, Model model) {
        log.info("controller pseq : " + pseq);

        ProductVO product = service.getDetail(pseq);
        model.addAttribute("product", product);
        log.info(product);

        return "/product/productdetail";
    }
}
