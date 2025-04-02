package org.zerock.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.service.ProductService;
import org.zerock.service.QnaService;

@Controller
@RequestMapping("/product/*")
@Log4j
@AllArgsConstructor
public class QnaController {

    // 생성자에 의한 묵시적 의존 주입
    private QnaService service;
}
