package cn.edu.swpu.cins.dao;

import cn.edu.swpu.cins.entry.FirstSysMap;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by melo on 16-5-28.
 * 获取一级系统名称和id映射的接口
 */
@Repository
public interface FirstSysMapDao {

    /**
     * 获取映射表
     * @return 映射表
     */
    List<FirstSysMap> getFirstSysMap();

}
