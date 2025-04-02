package org.nonage.service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nonage.domain.AdminVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class AdminServiceTests {

    @Setter(onMethod = @__({@Autowired}))
    private AdminService adminService;

    @Test
    public void testLoginSuccess() {
        AdminVO admin = adminService.login("admin", "admin");
        assertNotNull("로그인 실패: admin 계정이 존재하지 않거나 비밀번호 틀림", admin);
        System.out.println("로그인 성공: " + admin.getName());
    }

    @Test
    public void testLoginFail() {
        AdminVO admin = adminService.login("admin", "wrongpassword");

        assertNull("실패해야 하는데 로그인됨 - 문제 있음", admin);// Null 이어야 함
        System.out.println("비정상 로그인 테스트 통과 (정상 실패)");
    }
}
