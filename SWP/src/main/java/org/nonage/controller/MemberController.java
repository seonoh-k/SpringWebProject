package org.nonage.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.nonage.domain.AddressVO;
import org.nonage.domain.MemberVO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.nonage.service.MemberService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping("/member/*")
@Log4j
@AllArgsConstructor
public class MemberController {
    // 생성자에 의한 묵시적 의존 주입
    private MemberService service;

    @GetMapping("/contract")
    public String contract() {
        log.info("회원 약관동의 페이지 입니다.");
        return "member/contract";
    }

    @PostMapping("/contract")
    public String contract(@RequestParam("okon1") String okon1) {
        if ("agree".equals(okon1)) {
            // 약관 동의한 경우 회원가입 페이지로 이동
            return "redirect:/member/join";
        } else {
            // 동의하지 않으면 다시 약관 페이지로 돌아감
            return "member/contract";
        }
    }

    @GetMapping("/findzipnum")
    public String findzipnum() {
        return "member/findzipnum";
    }

    @PostMapping("/findzipnum")
    public String findzipnum(@RequestParam("dong") String dong, Model model) {
        ArrayList<AddressVO> addressList = service.findZipNum(dong);
        model.addAttribute("addressList", addressList);
        return "member/findzipnum";
    }

    @GetMapping("/login")
    public String login() {
        log.info("로그인 페이지에 진입했습니다.");
        return "member/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("id") String id,
                        @RequestParam("pwd") String pwd,
                        HttpSession session,
                        Model model) {
        MemberVO member = service.login(id, pwd);
        if (member != null) {
            session.setAttribute("loginUser", member);
            log.info("로그인 성공: 사용자 " + id + " 로그인 성공했습니다.");
            return "redirect:/main";
        } else {
            log.info("로그인 실패: 사용자 " + id + " 의 로그인 정보가 올바르지 않습니다.");
            model.addAttribute("msg", "아이디 또는 비밀번호가 틀렸습니다.");
            return "member/login";
        }
    }

    @GetMapping("/join")
    public String join() {
        log.info("회원가입 페이지에 진입했습니다.");
        return "member/join"; //
    }

    @PostMapping("/join")
    public String join(@ModelAttribute MemberVO newMember, @RequestParam("addr1") String addr1, @RequestParam("addr2") String addr2) {
        log.info("회원가입 성공하였습니다..");
        newMember.setAddress(addr1 + " " + addr2);
        service.join(newMember);
        return "redirect:/member/login";
    }

    @GetMapping("/idcheck")
    public String idCheck(@RequestParam("id") String id, Model model) {
        log.info("아이디 중복 창이 열렸습니다.");
        int result = service.idCheck(id); // 중복이면 1, 아니면 0
        model.addAttribute("message", result);
        model.addAttribute("id", id);
        return "member/idcheck";
    }

    @PostMapping("/idcheck")
    public ResponseEntity<Integer> idcheck(@RequestParam("id") String id) {
        int result = service.idCheck(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 세션 무효화: 로그인 정보를 삭제
        session.invalidate();
        log.info("로그아웃 완료. 세션이 무효화되었습니다.");
        return "redirect:/main";
    }
}
