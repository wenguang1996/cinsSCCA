package cn.edu.swpu.cins.dao;

import cn.edu.swpu.cins.entry.Action;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by melo on 2016/05/20.
 * Project : scca
 * interface for fapiao, jiaoshui, nianshen, shebao and toubiao tables access
 */
@Repository
public interface ActionDao {

    /**
     * get log list of the action aim
     * @param cmpId company id
     * @return list of the Action
     */
    List<Action> getLog(
            @Param("tableName") String tableName,
            @Param("cmpId") int cmpId
    );

    /**
     * get times of the aim that the company did
     * @param cmpId company id
     * @return count of the ActionAim times
     */
    Action getCount(
            @Param("tableName") String tableName,
            @Param("cmpId") int cmpId
    );
}
