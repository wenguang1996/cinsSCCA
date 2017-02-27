package cn.edu.swpu.cins.service;

import cn.edu.swpu.cins.dto.*;
import cn.edu.swpu.cins.entry.BaseInfo;
import cn.edu.swpu.cins.enums.Tables;

import java.util.List;

/**
 * Created by melo on 16-5-30.
 * 获取公司列表，查询公司等功能
 */
public interface CompanyService {

    /**
     * 获取企业列表
     * @param page 页数
     * @return 列表
     */
    CompanyList getList(int page);

    /**
     * 查找公司，可模糊查找
     * @param key 公司名称
     * @param page 页数
     * @return 公司列表
     */
    CompanyList searchCompany(String key, int page);

    /**
     * 获取公司状态比例
     * @return 正常公司与异常公司的数目
     */
    ComStatus countStatus(long time);

    /***
     * 获取公司行为详情
     * @param cmpId 公司id
     * @return 公司详细信息 List 用于画折线图图
     */
    List<ComBehaviour> getBehaviour(int cmpId);

    /**
     * 获取公司某一目的的行为记录
     * @param cmpId 公司id
     * @return 详情列表，用于画第二个折线图
     */
    List<AimLogger> getBehaviourAim(int cmpId, Tables tables);

    /**
     * 获取公司发票等行为的数据，用于画饼图和雷达图
     * @param cmpId 公司id
     * @return 发票等五个目的的行为次数
     */
    List<AimCounter> getBehaviourCount(int cmpId);

	/**
   * 通过名称获取公司信息，精确查找
   * @param comName 公司名称
   * @return 公司信息
   */
  List<BaseInfo> getComInfoByName(String comName);

}
