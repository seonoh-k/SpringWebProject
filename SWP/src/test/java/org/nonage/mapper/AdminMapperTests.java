package org.nonage.mapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nonage.domain.AdminVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class AdminMapperTests {

    @Setter(onMethod = @__({@Autowired}))
    private AdminMapper mapper;

    @Test
    public void testLogin(){
        String id = "admin";
        String pwd = "admin";

        AdminVO admin = mapper.loginAdmin(id, pwd);
        log.info(admin);
        Assert.assertNotNull(admin);
    }
}