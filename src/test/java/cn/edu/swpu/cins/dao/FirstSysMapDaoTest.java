package cn.edu.swpu.cins.dao;

import cn.edu.swpu.cins.entry.FirstSysMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by melo on 16-5-28.
 * 测试能否获取一级系统名称和id映射
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class FirstSysMapDaoTest {

    @Resource
    private FirstSysMapDao firstSysMapDao;

    @Test
    public void getFirstSysMap() throws Exception {
        List<FirstSysMap> firstSysMap = firstSysMapDao.getFirstSysMap();
        for (FirstSysMap map :
                firstSysMap) {
            assertNotNull(map.getFirstName());
            assertNotEquals(map.getFirstId(), 0);
        }
    }

}