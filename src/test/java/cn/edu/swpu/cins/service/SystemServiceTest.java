package cn.edu.swpu.cins.service;

import cn.edu.swpu.cins.entry.FirstSysMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by melo on 16-5-30.
 * 测试一级系统映射
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SystemServiceTest {

    @Autowired
    private SystemService systemService;

    @Test
    public void findMap() throws Exception {
        List<FirstSysMap> maps = systemService.findMap();
        assertNotNull(maps);
    }

}