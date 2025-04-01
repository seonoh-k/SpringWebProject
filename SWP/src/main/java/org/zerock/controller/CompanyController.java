package org.zerock.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/*")
@Log4j
@AllArgsConstructor
public class CompanyController {
}
