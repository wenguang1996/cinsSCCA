package cn.edu.swpu.cins.service.impl;

import cn.edu.swpu.cins.dao.ActionDao;
import cn.edu.swpu.cins.dao.BaseInfoDao;
import cn.edu.swpu.cins.dao.CmpDetailDao;
import cn.edu.swpu.cins.dto.*;
import cn.edu.swpu.cins.entry.Action;
import cn.edu.swpu.cins.entry.BaseInfo;
import cn.edu.swpu.cins.entry.CmpDetail;
import cn.edu.swpu.cins.entry.FirstSysMap;
import cn.edu.swpu.cins.enums.Tables;
import cn.edu.swpu.cins.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by melo on 16-6-1.
 * 实现ComBaseInfoService
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final int pageNumber = 10;

    @Autowired
    private BaseInfoDao baseInfoDao;

    @Autowired
    private CmpDetailDao cmpDetailDao;

    @Autowired
    private ActionDao actionDao;

    @Autowired
    private SystemServiceImpl firstSysMapService;
    
    public CompanyList getList(int page) {
        int[] limit = getLimit(page);
        List<BaseInfo> baseInfoList = baseInfoDao.list(limit[0], limit[1]);
        int[] sp = getSumAndPages();
        return new CompanyList(baseInfoList, sp[1], sp[0]);
    }

    public CompanyList searchCompany(String key, int page) {
        int[] limit = getLimit(page);
        key = "%" + key + "%";
        List<BaseInfo> baseInfoList = baseInfoDao.searchByName(key, limit[0], limit[1]);
        int[] sp = getSumAndPages();
        return new CompanyList(baseInfoList, sp[1], sp[0]);
    }

    /**
     * 获取企业总数和页数信息
     * @return 返回数组:
     *          0 企业总数
     *          1 页数
     */
    private int[] getSumAndPages() {
        int sum = baseInfoDao.getSum();
        int pages = sum / pageNumber;
        if (sum % pageNumber != 0)
            pages ++;
        return new int[]{sum, pages};
    }

    /**
     * 计算请求的页数，获得 SQL 需要的 limit 和 offset
     * @param page 请求的页数
     * @return 返回 limit 和 offset 的数组
     *          0 limit
     *          1 offset
     */
    private int[] getLimit(int page) {
        if (page < 1)
            page = 1;
        int start = (--page) * pageNumber;
        return new int[]{start, pageNumber};
    }

    public ComStatus countStatus(long time) {
        Timestamp ts = new Timestamp(time);
        List<BaseInfo> info = baseInfoDao.countStatus(ts);
        ComStatus status = new ComStatus();
        for (BaseInfo item : info) {
            if (item.getCmpStatus().equals("经营正常"))
                status.setNormal(item.getNumber());
            else
                status.setError(item.getNumber());
        }
        return status;
    }

    public List<ComBehaviour> getBehaviour(int cmpId) {
        List<CmpDetail> details = cmpDetailDao.getBehaviour(cmpId);
        if (details == null)
            return null;
        List<FirstSysMap> map = firstSysMapService.findMap();
        List<ComBehaviour> behaviourList = new ArrayList<ComBehaviour>(details.size());
        for (CmpDetail detail : details) {
            int sysId = detail.getFirstSys();
            for (FirstSysMap item : map) {
                if (item.getFirstId() == sysId)
                    behaviourList.add(new ComBehaviour(cmpId,
                            detail.getHandinTime().getTime(),
                            item.getFirstId()));
            }
        }
        return behaviourList;
    }

    public List<AimLogger> getBehaviourAim(int cmpId, Tables tables) {
        List<Action> actions = actionDao.getLog(tables.getTableName(), cmpId);
        List<AimLogger> loggers = new ArrayList<AimLogger>(actions.size());
        for (Action action :
                actions) {
            loggers.add(new AimLogger(action.getInstitution(), action.getHandinTime().getTime()));
        }
        return loggers;
    }

    public List<AimCounter> getBehaviourCount(int cmpId) {
        List<AimCounter> counters = new ArrayList<AimCounter>(Tables.values().length);
        for (Tables table:Tables.values()) {
            Action action = actionDao.getCount(table.getTableName(), cmpId);
            counters.add(new AimCounter(table, action.getNumber()));
        }
        return counters;
    }

    public List<BaseInfo> getComInfoByName(String comName) {
        List<BaseInfo> baseInfos = baseInfoDao.getInfoByName(comName);
        if (baseInfos.size() == 0)
            return null;
        return baseInfos;
    }
}
