package cn.edu.swpu.cins.service;

import cn.edu.swpu.cins.dto.ComStatus;
import cn.edu.swpu.cins.dto.LocationCounter;

import java.util.List;

/**
 * Created by melo on 16-6-5.
 * 区域性分析服务
 */
public interface LocationService {

    /**
     * 获取某时间某区域的正异常企业数量
     * @param location 企业名称
     * @param time 选定时间
     * @return 企业数量
     */
    ComStatus countLocationStatus(String location, long time);

    /**
     * 获取各区域的企业数量
     * @return 各区域的企业数量
     */
    List<LocationCounter> countLocation();
}
