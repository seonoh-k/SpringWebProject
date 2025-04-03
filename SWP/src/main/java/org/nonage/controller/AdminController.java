package org.nonage.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.nonage.domain.AdminVO;
import org.nonage.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Log4j
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    // 로그인 폼 이동
    @GetMapping("/login")
    public String loginForm() {
        return "admin/admin_login";
    }

    // 로그인 처리
    @PostMapping("/login")
    public String login(@RequestParam("id") String id,
                        @RequestParam("pwd") String pwd,
                        HttpSession session,
                        Model model) {

        AdminVO admin = adminService.confirmAuth(id, pwd);

        if (admin == null || admin.getId() == null) {
            return "admin/admin_login_fail";
        }

        session.setAttribute("adminLoginUser", admin);
        return "redirect:/admin/admin_product_list";
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:admin/admin_login";
    }



}