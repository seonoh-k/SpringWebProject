package org.nonage.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.nonage.domain.CartVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.nonage.service.CartService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cart/*")
@Log4j
@AllArgsConstructor
public class CartController {
    // 생성자에 의한 묵시적 의존 주입
    private CartService service;

    @PostMapping("/cartinsert")
    public String insert(CartVO cart) {
        log.info(cart);

        service.insert(cart);

        return "/mypage/cartlist";
    }

    @PostMapping("/cartdelete")
    public String delete(@RequestParam("cseq") int cseq) {
        log.info("controller cseq : " + cseq);

        service.delete(cseq);

        return "/mypage/cartlist";
    }

    @GetMapping("/cartlist")
    public String getList(Model model) {
        String userid = "ks123";
        log.info("controller userid : " + userid);

        List<CartVO> cartList = service.getList(userid);

        int totalPrice = 0;

        for(CartVO cart : cartList) {
            totalPrice += cart.getPrice2() * cart.getQuantity();
        }

        model.addAttribute("list", cartList);
        model.addAttribute("totalPrice", totalPrice);

        return "/mypage/cartlist";
    }
}
