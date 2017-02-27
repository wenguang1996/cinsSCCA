package cn.edu.swpu.cins.dao;

import cn.edu.swpu.cins.entry.BaseInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by melo on 2016/05/20.
 * Project : scca
 * interface for base_info access
 */
@Repository
public interface BaseInfoDao {

    /**
     * get list of companies
     * @param offset start number
     * @param limit number of every page
     * @return the list of companies
     */
    List<BaseInfo> list(
            @Param("offset") int offset,
            @Param("limit") int limit
    );

    /**
     * search companies by company name
     * @param cmpName company name
     * @param offset start number
     * @param limit number of every page
     * @return the list of companies
     */
    List<BaseInfo> searchByName(
            @Param("keyword") String cmpName,
            @Param("offset") int offset,
            @Param("limit") int limit
    );

    /**
     * get company id by name and location
     * @param cmpName company's name
     * @param cmpLocation company's location
     * @return company's id
     */
    BaseInfo getIdByName(
            @Param("cmpName") String cmpName,
            @Param("cmpLocation") String cmpLocation
    );

    /**
     * 获取某时间区域的正异常企业数量
     * @param cmpLocation the limit location
     * @param time 选定时间
     * @return at most has tow elements, only have cmpStatus and number properties
     */
    List<BaseInfo> countLocationStatus(
            @Param("cmpLocation") String cmpLocation,
            @Param("time") Timestamp time
    );

    /**
     * 计算某时间的正异常企业数量
     * @param time 选定时间
     * @return at most has tow elements, only have cmpStatus and number properties
     */
    List<BaseInfo> countStatus(
            @Param("time") Timestamp time
    );

    /**
     * group by cmp_location and count the number
     * @return all elements only have cmpLocation and number properties
     */
    List<BaseInfo> countLocation();

    /**
     * 获取企业总数
     * @return 企业总数
     */
    int getSum();

	/**
   * 精确查找公司信息
   * @param comName 公司名称
   * @return 公司信息
   */
  List<BaseInfo> getInfoByName(@Param("comName") String comName);
}
