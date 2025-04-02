package org.nonage.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j
public class IndexController {

    @GetMapping("/main")
    public void getIndex() {
        log.info("index connected");
    }
}
