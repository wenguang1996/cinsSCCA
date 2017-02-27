package cn.edu.swpu.cins.service;

import cn.edu.swpu.cins.dto.*;
import cn.edu.swpu.cins.entry.BaseInfo;
import cn.edu.swpu.cins.enums.Tables;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by melo on 16-6-1.
 * test CompanyService
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class CompanyServiceTest {

    @Autowired
    private CompanyService companyService;

    @Test
    public void getList() throws Exception {
        CompanyList companyList = companyService.getList(1);
        assertNotNull(companyList.getComList());
    }

    @Test
    public void searchCompany() throws Exception {
        CompanyList companyList = companyService.searchCompany("集团", 1);
        assertNotNull(companyList.getComList());
        System.out.println(companyList);
    }

    @Test
    public void countStatus() throws Exception {
        ComStatus status = companyService.countStatus(System.currentTimeMillis());
        assertNotEquals(status.getNormal(), 0);
    }

    @Test
    public void getBehaviour() throws Exception {
        List<ComBehaviour> behaviours = companyService.getBehaviour(10000);
        assertNotNull(behaviours);
    }

    @Test
    public void getBehaviourAim() {
        List<AimLogger> actions = companyService.getBehaviourAim(10000, Tables.FAPIAO);
        assertNotNull(actions);
        assertNotEquals(actions.size(), 0);
    }

    @Test
    public void getBehaviourCount() throws Exception {
        List<AimCounter> aims = companyService.getBehaviourCount(10000);
        assertNotNull(aims);
        int tablesLen = 0;
        for (Tables table :
                Tables.values()) {
            tablesLen++;
        }
        assertEquals(aims.size(), tablesLen);
    }

    @Test
    public void getComInfoByName() throws Exception {
        String comName = "成都市全友家私有限公司";
        List<BaseInfo> baseInfos = companyService.getComInfoByName(comName);
        assertThat(baseInfos.get(0).getCmpName(), is(comName));
        comName = "公司";
        baseInfos = companyService.getComInfoByName(comName);
        assertNull(baseInfos);
    }
}