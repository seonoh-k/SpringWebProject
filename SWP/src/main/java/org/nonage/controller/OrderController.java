package org.nonage.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.nonage.domain.OrderVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.nonage.service.OrderService;

import java.util.List;

@Controller
@RequestMapping("/order/*")
@Log4j
@AllArgsConstructor
public class OrderController {
    // 생성자에 의한 묵시적 의존 주입
    private OrderService service;

    @GetMapping("/totallist")
    public String totalList(Model model) {

        List<OrderVO> totalList = service.totalList();

        int totalPrice = 0;
        for(OrderVO order : totalList) {
            totalPrice += order.getPrice2() * order.getQuantity();
        }

        model.addAttribute("totalList", totalList);
        model.addAttribute("totalPrice", totalPrice);

        return "/mypage/totallist";
    }
}
