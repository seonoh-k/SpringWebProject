package org.nonage.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.nonage.domain.AddressVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.nonage.service.AddressService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("/address/*")
@Log4j
@AllArgsConstructor
public class AddressController {
    // 생성자에 의한 묵시적 의존 주입
    private AddressService service;

    // 우편번호 검색 폼 표시 (GET): 주소 검색 폼을 보여줍니다.
    @GetMapping("/find")
    public String showAddressSearch() {
        return "address/find_zipNum"; // 예: /WEB-INF/views/address/find_zipNum.jsp
    }

    // 우편번호 검색 처리 (POST): 검색어(dong)를 받아서 주소 목록을 조회합니다.
    @PostMapping("/find")
    public String AddressSearch(@RequestParam ("dong") String dong, Model model) {
        ArrayList<AddressVO> addressList = service.findZipNum(dong);
        model.addAttribute("addressList", addressList);
        return "address/find_zipNum"; // 검색 결과를 동일한 JSP에 전달
    }
}
