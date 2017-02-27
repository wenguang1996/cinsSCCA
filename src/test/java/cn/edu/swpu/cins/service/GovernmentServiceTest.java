package cn.edu.swpu.cins.service;

import cn.edu.swpu.cins.dto.ChartCoord;
import cn.edu.swpu.cins.dto.OrgMapper;
import cn.edu.swpu.cins.dto.RecordList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by melo on 16-6-7.
 * 测试政务服务接口
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
				"classpath:spring/spring-service.xml"})
public class GovernmentServiceTest {
	
	@Autowired
	private GovernmentService governmentService;
	
	@Test
	public void getChart() throws Exception {
		Calendar date = Calendar.getInstance();
		date.set(2016, Calendar.FEBRUARY, 2);
		List<ChartCoord> coords = governmentService.getChart(2, date.getTimeInMillis());
		if (coords != null) {
			assertNotEquals(coords.size(), 0);
			System.out.println(coords.get(0));
		}
	}

	@Test
	public void getList() throws Exception {
		RecordList list = governmentService.getList(1);
		assertNotEquals(list.getPages(), 0);
	}

	@Test
	public void getMapper() throws Exception {
		List<OrgMapper> mappers = governmentService.getMapper();
		for (OrgMapper mapper :
						mappers) {
			if (mapper.getId() == 14)
				assertEquals(mapper.getName(), "大数据中心");
		}
	}

}