package cn.edu.swpu.cins.service;

import cn.edu.swpu.cins.entry.FirstSysMap;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by melo on 16-5-30.
 * 获取一级系统映射
 */
public interface SystemService {

    /**
     * 返回映射表
     * @return id与名称映射
     */
    List<FirstSysMap> findMap();

}
