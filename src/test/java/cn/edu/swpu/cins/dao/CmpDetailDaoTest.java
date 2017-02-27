package cn.edu.swpu.cins.dao;

import cn.edu.swpu.cins.entry.CmpDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by melo on 16-5-28.
 * 测试 cmp_detail 能否被查询
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class CmpDetailDaoTest {

    @Resource
    private CmpDetailDao cmpDetailDao;

    @Test
    public void getBehaviour() throws Exception {
        List<CmpDetail> cmpDetails = cmpDetailDao.getBehaviour(10000);
        for (CmpDetail cmpDetail : cmpDetails) {
            assertEquals(cmpDetail.getCmpId(), 10000);
        }
    }

    @Test
    public void mapCount() throws Exception {
        List<CmpDetail> cmpDetails = cmpDetailDao.mapCount(2);
        for (CmpDetail cmpDetail :
                cmpDetails) {
            assertNotNull(cmpDetail.getHandinTime());
        }
    }

    @Test
    public void govChart() throws Exception {
        int id = 2;
        String startTime = "2016-01-01";
        String endTime = "2016-01-31";
        List<CmpDetail> details = cmpDetailDao.govChart(id, startTime, endTime);
        System.out.println(details);
    }

}