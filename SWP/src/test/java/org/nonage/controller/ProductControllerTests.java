package org.nonage.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.nonage.domain.ProductVO;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@Log4j
@WebAppConfiguration
public class ProductControllerTests {

    @Setter(onMethod = @__({@Autowired}))
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setMockMvc(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testList() throws Exception{

        // Auto Test
        mockMvc.perform(MockMvcRequestBuilders.get("/product/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test"));
        // direct Checking Test
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/product/list"))
                .andExpect(status().isOk()).andReturn();

        String json = mvcResult.getResponse().getContentAsString();
        System.out.println(" JSON 응답 문자열: " + json);

        // Jackson ObjectMapper로 JSON → 객체 변환
        ObjectMapper mapper = new ObjectMapper();
        ProductVO vo = mapper.readValue(json, ProductVO.class);

        System.out.println("name: " + vo.getName());
    }
}

