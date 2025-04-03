package org.nonage.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.nonage.domain.CartVO;
import org.nonage.domain.MemberVO;
import org.nonage.domain.OrderVO;
import org.nonage.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.nonage.service.OrderService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/order/*")
@Log4j
@AllArgsConstructor
public class OrderController {
    // 생성자에 의한 묵시적 의존 주입
    private OrderService service;
    private CartService cartService;

    @GetMapping("/totallist")
    public String totalList(HttpSession session, Model model) {
        MemberVO member = (MemberVO) session.getAttribute("loginUser");

        List<OrderVO> totalList = service.totalList(member.getId());

        int totalPrice = 0;
        for(OrderVO order : totalList) {
            totalPrice += order.getPrice2() * order.getQuantity();
        }

        model.addAttribute("totalList", totalList);
        model.addAttribute("totalPrice", totalPrice);

        return "/mypage/totallist";
    }

    @PostMapping("/orderinsert")
    public String orderInsert(HttpSession session, Model model) {

        MemberVO member = (MemberVO) session.getAttribute("loginUser");
        log.info("id : " + member.getId());

        List<CartVO> cartList = cartService.getList(member.getId());
        log.info(cartList);

        service.orderInsert(cartList, member.getId());

        int maxOseq = service.getMaxOseq();
        log.info(maxOseq);

        for(CartVO cart : cartList) {
            service.insertOrderDetail(cart, maxOseq);
        }

        model.addAttribute("maxOseq", maxOseq);

        return "redirect:/order/orderlist";
    }

    @GetMapping("/orderlist")
    public String orderList(@RequestParam("maxOseq") int oseq, HttpSession session, Model model) {

        String result = "1";
        MemberVO member = (MemberVO) session.getAttribute("loginUser");
        log.info("id : " + member.getId());

        if(oseq <= 0) {
            return "/main";
        }else {
            List<OrderVO> orderList = service.getList(member.getId(), result, oseq);
            model.addAttribute("orderList", orderList);
            orderList.forEach(log::info);

            int totalPrice = 0;
            for(OrderVO order : orderList) {
                totalPrice += order.getPrice2() * order.getQuantity();
            }

            model.addAttribute("totalPrice", totalPrice);
        }

        return "/mypage/orderlist";
    }
}
