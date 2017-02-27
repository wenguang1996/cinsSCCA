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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

/**
 * Created by melo on 16-6-5.
 * 测试LocationController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml",
        "classpath:spring/spring-web.xml"})
@WebAppConfiguration
public class LocationControllerTest {

    @Autowired
    private LocationController locationController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(locationController).build();
    }

    @Test
    public void getCount() throws Exception {
        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get("/location")
                .accept(MediaType.APPLICATION_JSON_UTF8));
//        actions.andDo(MockMvcResultHandlers.print());
        assertEquals(200, actions.andReturn().getResponse().getStatus());
    }

    @Test
    public void getDetail() throws Exception {
        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get("/location/detail")
                .param("location", "新都区").accept(MediaType.APPLICATION_JSON_UTF8));
        actions.andDo(MockMvcResultHandlers.print());
        assertEquals(200, actions.andReturn().getResponse().getStatus());

        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.DECEMBER, 31);
        actions = mockMvc.perform(MockMvcRequestBuilders.get("/location/detail")
                .param("location", "新都区").param("time", Long.toString(calendar.getTimeInMillis())).accept(MediaType.APPLICATION_JSON_UTF8));
        actions.andDo(MockMvcResultHandlers.print());
    }

}