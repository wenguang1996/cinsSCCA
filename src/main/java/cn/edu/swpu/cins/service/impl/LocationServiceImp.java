package cn.edu.swpu.cins.service.impl;

import cn.edu.swpu.cins.dao.BaseInfoDao;
import cn.edu.swpu.cins.dto.ComStatus;
import cn.edu.swpu.cins.dto.LocationCounter;
import cn.edu.swpu.cins.entry.BaseInfo;
import cn.edu.swpu.cins.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by melo on 16-6-5.
 * 实现LocationService
 */
@Service
public class LocationServiceImp implements LocationService {

    @Autowired
    private BaseInfoDao baseInfoDao;

    public ComStatus countLocationStatus(String location, long time) {
        List<BaseInfo> baseInfos = baseInfoDao.countLocationStatus(location, new Timestamp(time));
        if (baseInfos.size() == 0)
            return null;
        ComStatus status = new ComStatus();
        for (BaseInfo baseInfo : baseInfos) {
            if (baseInfo.getCmpStatus().equals("经营正常"))
                status.setNormal(baseInfo.getNumber());
            else
                status.setError(baseInfo.getNumber());
        }
        return status;
    }

    public List<LocationCounter> countLocation() {
        List<BaseInfo> baseInfos = baseInfoDao.countLocation();
        List<LocationCounter> counters = new ArrayList<LocationCounter>(baseInfos.size());
        for (BaseInfo baseInfo : baseInfos) {
            counters.add(new LocationCounter(baseInfo.getCmpLocation(), baseInfo.getNumber()));
        }
        return counters;
    }
}
