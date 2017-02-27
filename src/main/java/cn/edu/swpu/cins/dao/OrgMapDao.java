package cn.edu.swpu.cins.dao;

import cn.edu.swpu.cins.entry.OrgMap;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by melo on 16-6-5.
 * org_map访问接口
 */
@Repository
public interface OrgMapDao {

    /**
     * 获取机构映射
     * @return 机构映射列表
     */
    List<OrgMap> getMap();
}
