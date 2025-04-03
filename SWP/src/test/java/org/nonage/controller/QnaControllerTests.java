package org.nonage.controller;


import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
        "file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
@Log4j
public class QnaControllerTests {

    @Setter(onMethod_ = @Autowired)
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void testRedirectWhenNotLoggedIn_userList() throws Exception {
        log.info("비로그인 유저 QnA 목록 접근 시 로그인 리다이렉트 확인");
        mockMvc.perform(MockMvcRequestBuilders.get("/qnalist"))
                .andExpect(result -> {
                    String viewName = result.getResponse().getRedirectedUrl();
                    log.info("Redirect URL: " + viewName);
                });
    }

    @Test
    public void testRedirectWhenNotLoggedIn_adminList() throws Exception {
        log.info("비로그인 관리자 QnA 목록 접근 시 로그인 리다이렉트 확인");
        mockMvc.perform(MockMvcRequestBuilders.get("/adminqnalist"))
                .andExpect(result -> {
                    String viewName = result.getResponse().getRedirectedUrl();
                    log.info("Redirect URL: " + viewName);
                });
    }

    @Test
    public void testAdminQnaDetailWithoutSession() throws Exception {
        log.info("비로그인 상태에서 관리자 QnA 상세 접근 시 리다이렉트 확인");
        mockMvc.perform(MockMvcRequestBuilders.get("/adminqnadetail")
                        .param("qseq", "1"))
                .andExpect(result -> {
                    log.info("Redirect URL: " + result.getResponse().getRedirectedUrl());
                });
    }
}
