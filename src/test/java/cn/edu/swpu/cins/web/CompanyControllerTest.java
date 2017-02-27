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

import java.net.URI;
import java.util.Calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by melo on 16-6-5.
 * 测试ComBaseInfoController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml",
        "classpath:spring/spring-web.xml"})
@WebAppConfiguration
public class CompanyControllerTest {

    @Autowired
    private CompanyController companyController;

    private MockMvc mockMvc;


    @Before
    public void Setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(companyController).build();
    }

    @Test
    public void getList() throws Exception {
        final String URL = "/company/list";
        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get(URL)
                .param("page", "1").accept(MediaType.APPLICATION_JSON_UTF8));

//        actions.andDo(MockMvcResultHandlers.print());
        assertEquals(200, actions.andReturn().getResponse().getStatus());
    }

    @Test
    public void getStatus() throws Exception {
        final String URL = "/company/count";
        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get(URL)
                .accept(MediaType.APPLICATION_JSON_UTF8));
//        actions.andDo(MockMvcResultHandlers.print());
        assertEquals(200, actions.andReturn().getResponse().getStatus());

        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.DECEMBER, 31);
        actions = mockMvc.perform(MockMvcRequestBuilders.get(URL)
                .param("time", Long.toString(calendar.getTimeInMillis())).accept(MediaType.APPLICATION_JSON_UTF8));
//        actions.andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void searchCompany() throws Exception {
        final String URL = "/company/search";
        String page = "1";
        String query = "集团";
        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get(URL)
                .param("page", page).param("query", query).accept(MediaType.APPLICATION_JSON_UTF8));
//        actions.andDo(MockMvcResultHandlers.print());
        assertEquals(200, actions.andReturn().getResponse().getStatus());
    }

    @Test
    public void getCompanyInfoByName() throws Exception {
        final URI uri = new URI("/company/成都市全友家私有限公司/info");
        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_UTF8));
        assertThat(actions.andReturn().getResponse().getStatus(), is(200));
    }

    @Test
    public void getBehaviour() throws Exception {
        final String URL = "/company/behaviour";
        String id = "10000";
        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get(URL)
                .param("id", id).accept(MediaType.APPLICATION_JSON_UTF8));
//        actions.andDo(MockMvcResultHandlers.print());
        assertEquals(200, actions.andReturn().getResponse().getStatus());
    }

    @Test
    public void getBehaviourWithAim() throws Exception {
        final String URL = "/company/behaviour/aim";
        String id = "10000";
        String aim = "nianshen";
        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get(URL)
                .param("id", id).param("aim", aim).accept(MediaType.APPLICATION_JSON_UTF8));
//        actions.andDo(MockMvcResultHandlers.print());
        assertEquals(200, actions.andReturn().getResponse().getStatus());

        aim = "企业信息公示";
        ResultActions actions1 = mockMvc.perform(MockMvcRequestBuilders.get(URL)
                .param("id", id).param("aim", aim).accept(MediaType.APPLICATION_JSON_UTF8));
//        actions1.andDo(MockMvcResultHandlers.print());
        assertEquals(200, actions1.andReturn().getResponse().getStatus());

        assertEquals(actions.andReturn().getResponse().getContentAsString(),
                actions1.andReturn().getResponse().getContentAsString());

        aim = "shedao";
        actions = mockMvc.perform(MockMvcRequestBuilders.get(URL)
                .param("id", id).param("aim", aim).accept(MediaType.APPLICATION_JSON_UTF8));
//        actions.andDo(MockMvcResultHandlers.print());
        assertEquals(200, actions.andReturn().getResponse().getStatus());
    }

    @Test
    public void getBehaviourCount() throws Exception {
        final String URL = "/company/behaviour/count";
        String id = "10000";
        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get(URL)
                .param("id", id).accept(MediaType.APPLICATION_JSON_UTF8));
//        actions.andDo(MockMvcResultHandlers.print());
        assertEquals(200, actions.andReturn().getResponse().getStatus());
    }

}