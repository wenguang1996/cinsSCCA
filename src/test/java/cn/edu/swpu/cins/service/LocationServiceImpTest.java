package cn.edu.swpu.cins.service;

import cn.edu.swpu.cins.dto.ComStatus;
import cn.edu.swpu.cins.dto.LocationCounter;
import cn.edu.swpu.cins.service.LocationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;

/**
 * Created by melo on 16-6-5.
 * 测试LocationService
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class LocationServiceImpTest {

    @Autowired
    private LocationService locationService;

    @Test
    public void countLocationStatus() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.DECEMBER, 31);
        ComStatus status = locationService.countLocationStatus("新都", calendar.getTimeInMillis());
        System.out.println(status);
    }

    @Test
    public void testCountLocationStatus() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.DECEMBER, 31);
        ComStatus status = locationService.countLocationStatus("自贡", calendar.getTimeInMillis());
        System.out.println(status);
    }

    @Test
    public void countLocation() throws Exception {
        List<LocationCounter> counters = locationService.countLocation();
        System.out.println(counters);
    }

}