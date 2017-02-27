package cn.edu.swpu.cins.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;

/**
 * Created by melo on 16-6-3.
 * 测试一级系统映射Controller
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml",
        "classpath:spring/spring-web.xml"})
@WebAppConfiguration
public class SystemControllerTest {

    @Autowired
    private SystemController mapController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(mapController).build();
    }

    @Test
    public void getMap() throws Exception {

        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get("/system/first/map")
                .accept(MediaType.APPLICATION_JSON_UTF8)
        );

//        actions.andDo(MockMvcResultHandlers.print());
        assertEquals(200, actions.andReturn().getResponse().getStatus());
    }

}