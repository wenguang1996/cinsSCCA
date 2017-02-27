package cn.edu.swpu.cins.service;

import cn.edu.swpu.cins.dto.ChartCoord;
import cn.edu.swpu.cins.dto.OrgMapper;
import cn.edu.swpu.cins.dto.OrgRecord;
import cn.edu.swpu.cins.dto.RecordList;

import java.util.List;

/**
 * Created by melo on 16-6-5.
 * 政务分析服务
 */
public interface GovernmentService {

    /**
     * 获取统计图的坐标列表
     * @param id 一级系统的id
     * @return 坐标列表
     */
    List<ChartCoord> getChart(int id, long time);

    /**
     * 获取政务机构行为记录表
     * @param page 页数
     * @return 表格的单页信息
     */
    RecordList getList(int page);

    /**
     * 获取政务机构id与名称的映射
     * @return 映射列表
     */
    List<OrgMapper> getMapper();
}
