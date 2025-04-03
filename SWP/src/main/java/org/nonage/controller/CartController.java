package org.nonage.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.nonage.domain.CartVO;
import org.nonage.domain.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.nonage.service.CartService;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cart/*")
@Log4j
@AllArgsConstructor
public class CartController {
    // 생성자에 의한 묵시적 의존 주입
    private CartService service;

    @PostMapping("/cartinsert")
    public String insert(HttpSession session, CartVO cart) {
        log.info(cart);

        MemberVO member = (MemberVO) session.getAttribute("loginUser");

        service.insert(cart, member.getId());

        return "redirect:/cart/cartlist";
    }

    @PostMapping("/cartdelete")
    public String delete(@RequestParam("cseq") int cseq) {
        log.info("controller cseq : " + cseq);

        service.delete(cseq);

        return "redirect:/cart/cartlist";
    }

    @GetMapping("/cartlist")
    public String getList(HttpSession session, Model model) {
        MemberVO member = (MemberVO) session.getAttribute("loginUser");

        log.info("controller userid : " + member.getId());

        List<CartVO> cartList = service.getList(member.getId());

        int totalPrice = 0;

        for(CartVO cart : cartList) {
            totalPrice += cart.getPrice2() * cart.getQuantity();
        }

        model.addAttribute("list", cartList);
        model.addAttribute("totalPrice", totalPrice);

        return "/mypage/cartlist";
    }
}
