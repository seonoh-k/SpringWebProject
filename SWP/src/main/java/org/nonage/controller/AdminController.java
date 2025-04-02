package org.nonage.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.nonage.domain.AdminVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.nonage.service.AdminService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/*")
@Log4j
@AllArgsConstructor
public class AdminController {
    // 생성자에 의한 묵시적 의존 주입
    private AdminService service;

    @GetMapping("/adminlogin")
    public String adminLogin(){
        return "/admin/adminlogin";
    }
    @PostMapping("/adminlogin")
    public String adminLogin(@RequestParam("id") String id, @RequestParam("pwd") String pwd, HttpSession session, RedirectAttributes rttr, Model model){
        AdminVO admin = service.login(id, pwd);

        if (admin != null) {
            session.setAttribute("admin", admin);
            return "redirect:/product/adminproductlist";
        } else {
            model.addAttribute("loginFail", true);
            return "/admin/adminlogin"; // forward로 JSP 다시 띄우기
        }
    }
    @GetMapping("/adminlogout")
    public String adminLogout(HttpSession session){
        session.invalidate(); // 세션 완전 제거
        return "redirect:/admin/adminlogin"; // 나중에 index.jsp 보내는 Controller 파악되면 넣어줄 것.
    }



}
