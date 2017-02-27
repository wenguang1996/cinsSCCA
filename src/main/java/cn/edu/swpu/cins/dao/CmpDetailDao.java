package cn.edu.swpu.cins.dao;

import cn.edu.swpu.cins.entry.CmpDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by melo on 2016/05/20.
 * Project : scca
 * interface for cmp_detail access
 */
@Repository
public interface CmpDetailDao {

    /**
     * get company's detail behaviours by id
     * @param cmpId company's id
     * @return list of behaviours
     */
    List<CmpDetail> getBehaviour(
            @Param("cmpId") int cmpId
    );

    /**
     * get list data for the map
     * @param sysName system name
     * @return list of map
     */
    List<CmpDetail> mapCount(
            @Param("sysName") int sysName
    );

	/**
   * 获取政务系统统计图数据
   * @param firstId 一级系统id
   * @param startTime 开始时间
   * @param endTime 结束时间
   * @return 数据列表
   */
  List<CmpDetail> govChart(
            @Param("firstId") int firstId,
            @Param("startTime") String startTime,
            @Param("endTime") String endTime
    );
}
