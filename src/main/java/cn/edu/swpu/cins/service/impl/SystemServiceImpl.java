package cn.edu.swpu.cins.service.impl;

import cn.edu.swpu.cins.dao.FirstSysMapDao;
import cn.edu.swpu.cins.entry.FirstSysMap;
import cn.edu.swpu.cins.service.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by melo on 16-5-30.
 * 实现 SystemService 接口
 */
@Service
public class SystemServiceImpl implements SystemService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FirstSysMapDao firstSysMapDao;

    public List<FirstSysMap> findMap() {
        return firstSysMapDao.getFirstSysMap();
    }

}
