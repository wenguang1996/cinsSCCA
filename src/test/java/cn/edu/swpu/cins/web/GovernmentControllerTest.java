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

import static org.junit.Assert.*;

/**
 * Created by melo on 16-6-7.
 * 测试政务服务的Controller
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
				"classpath:spring/spring-service.xml",
				"classpath:spring/spring-web.xml"})
@WebAppConfiguration
public class GovernmentControllerTest {

	@Autowired
	private GovernmentController govController;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(govController).build();
	}

	@Test
	public void getMap() throws Exception {
		ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get("/government/map")
						.accept(MediaType.APPLICATION_JSON_UTF8));
		assertEquals(actions.andReturn().getResponse().getStatus(), 200);
	}

	@Test
	public void getList() throws Exception {
		ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get("/government/list").param("page", "1")
						.accept(MediaType.APPLICATION_JSON_UTF8));
		assertEquals(actions.andReturn().getResponse().getStatus(), 200);
//		actions.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void getChart() throws Exception {
		Calendar date = Calendar.getInstance();
		date.set(2016, Calendar.JANUARY, 30);
		ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get("/government/chart")
						.param("id", "2").param("time", Long.toString(date.getTimeInMillis()))
						.accept(MediaType.APPLICATION_JSON_UTF8));
		assertEquals(actions.andReturn().getResponse().getStatus(), 200);
		actions.andDo(MockMvcResultHandlers.print());
	}

}