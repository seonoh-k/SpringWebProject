package org.nonage.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.nonage.service.AddressService;

@Controller
@RequestMapping("/product/*")
@Log4j
@AllArgsConstructor
public class AddressController {
    // 생성자에 의한 묵시적 의존 주입
    private AddressService service;
}
