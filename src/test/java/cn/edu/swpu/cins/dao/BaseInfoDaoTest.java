package cn.edu.swpu.cins.dao;

import cn.edu.swpu.cins.entry.BaseInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by melo on 16-5-28.
 * 测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class BaseInfoDaoTest {

    @Resource
    private BaseInfoDao baseInfoDao;

    @Test
    public void list() throws Exception {
        List<BaseInfo> baseInfoList = baseInfoDao.list(0, 10);
        for (BaseInfo baseInfo : baseInfoList) {
            assertNotNull(baseInfo);
        }
        if (baseInfoList.size() > 0)
            System.out.println(baseInfoList.get(0));
    }

    @Test
    public void searchByName() throws Exception {
        List<BaseInfo> baseInfoList = baseInfoDao.searchByName("%集团%", 0, 10);
        for (BaseInfo baseInfo : baseInfoList) {
            assert baseInfo.getCmpName().contains("集团");
        }
        if (baseInfoList.size() > 0)
            System.out.println(baseInfoList.get(0));
    }

    @Test
    public void getIdByName() throws Exception {
        BaseInfo baseInfo = baseInfoDao.getIdByName("成都东泰商城有限公司", "成都市");
        assertNotNull(baseInfo.getCmpId());
        System.out.println(baseInfo);
    }

    @Test
    public void countLocationStatus() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.DECEMBER, 31);
        List<BaseInfo> baseInfos = baseInfoDao.countLocationStatus("高新区", new Timestamp(calendar.getTimeInMillis()));
        for (BaseInfo baseinfo :
                baseInfos) {
            assertNotNull(baseinfo.getCmpStatus());
            assertNotEquals(baseinfo.getNumber(), 0);
        }
    }

    @Test
    public void countStatus() throws Exception {
        List<BaseInfo> baseInfoList = baseInfoDao.countStatus(new Timestamp(System.currentTimeMillis()));
        for (BaseInfo baseinfo :
                baseInfoList) {
            assertNotNull(baseinfo.getCmpStatus());
            assertNotEquals(baseinfo.getNumber(), 0);
        }
    }

    @Test
    public void countLocation() throws Exception {
        List<BaseInfo> baseInfos = baseInfoDao.countLocation();
        for (BaseInfo baseInfo :
                baseInfos) {
            assertNotNull(baseInfo.getCmpLocation());
        }
    }

    @Test
    public void getSum() throws Exception {
        int num = baseInfoDao.getSum();
        System.out.println("the sum of companies : " + num);
    }

    @Test
    public void getComInfoByName() throws Exception {
        String comName = "成都市全友家私有限公司";
        List<BaseInfo> infoByName = baseInfoDao.getInfoByName(comName);
        System.out.println(infoByName);
    }
}