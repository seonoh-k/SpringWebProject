package org.nonage.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.nonage.service.MemberService;

@Controller
@RequestMapping("/member/*")
@Log4j
@AllArgsConstructor
public class MemberController {
    // 생성자에 의한 묵시적 의존 주입
    private MemberService service;

    @GetMapping("/contract")
    public void contract() {}

    @GetMapping("/findzipnum")
    public void findZipNum() {}

    @GetMapping("/login")
    public void login() {}

    @GetMapping("/join")
    public void join() {}

    @GetMapping("/idcheck")
    public void idCheck() {}

}
