package cn.edu.swpu.cins.dao;

import cn.edu.swpu.cins.entry.Action;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by melo on 16-5-28.
 * 测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class ActionDaoTest {

    @Resource
    private ActionDao actionDao;

    @Test
    public void getLog() throws Exception {
        List<Action> actions = actionDao.getLog("shebao", 10000);
        for (Action action :
                actions) {
            assertEquals(action.getCmpId(), 10000);
        }
        if (actions.size() > 0)
            System.out.println(actions.get(0));
    }

    @Test
    public void getCount() throws Exception {
        Action action = actionDao.getCount("shebao", 10000);
        assertEquals(action.getCmpId(), 10000);
        System.out.println(action);
    }

}