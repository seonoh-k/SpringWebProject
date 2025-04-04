package org.nonage.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.nonage.domain.CompanyVO;
import org.nonage.domain.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.nonage.service.CompanyService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/company/*")
@Log4j
@AllArgsConstructor
public class CompanyController {
    // 생성자에 의한 묵시적 의존 주입
    private CompanyService service;

    @GetMapping("/getnonage")
    public String getNonage(Model model) {

        CompanyVO nonage = service.getNonage();
        log.info("getNonage : " + nonage);
        model.addAttribute("nonage", nonage);

        return "/mypage/invoice";
    }

    @GetMapping("/adminnonage")
    public String adminNonage(@RequestParam("id") String id, HttpSession session,  Model model) {

        CompanyVO nonage = service.getNonage();
        log.info("getNonage : " + nonage);
        model.addAttribute("nonage", nonage);

        session.setAttribute("id", id);

        return "/admin/invoice";
    }

    @GetMapping(value = "/getcompany", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<CompanyVO> getCompany(HttpSession session) {

        String id = (String) session.getAttribute("id");
        log.info(id);

        if(id != null) {
            log.info(id);
            return new ResponseEntity<>(service.getCompany(id), HttpStatus.OK);
        }else {
            MemberVO member = (MemberVO) session.getAttribute("loginUser");
            log.info("controller get id : " + member.getId());
            return new ResponseEntity<>(service.getCompany(member.getId()), HttpStatus.OK);
        }
    }

    @GetMapping("/ccheck")
    @ResponseBody
    public int cCheck(HttpSession session) {

        MemberVO member = (MemberVO) session.getAttribute("loginUser");
        log.info(member.getId());

        return service.cCheck(member.getId());
    }

    @GetMapping("/invoicelist")
    public String invoiceList(Model model) {

        log.info("invoiceList work");

        List<CompanyVO> companyList = service.invoiceList();
        model.addAttribute("companyList", companyList);
        log.info(companyList);

        return "/admin/invoicelist";
    }

}
