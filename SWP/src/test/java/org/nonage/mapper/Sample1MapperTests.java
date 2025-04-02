package org.nonage.mapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class Sample1MapperTests {

    @Setter(onMethod_ = @__({@Autowired}))
    private Sample1Mapper mapper;

    @Test
    public void get() {
        mapper.get().forEach(log::info);
    }
}
