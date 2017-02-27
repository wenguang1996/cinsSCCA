package cn.edu.swpu.cins.web;

import cn.edu.swpu.cins.dto.ResultData;
import cn.edu.swpu.cins.entry.FirstSysMap;
import cn.edu.swpu.cins.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by melo on 16-6-3.
 * 一级系统映射控制器
 */
@Controller
@RequestMapping("/system")
public class SystemController {

    @Autowired
    private SystemService systemService;

    @RequestMapping(value = "/first/map",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ResultData<List<FirstSysMap>> getMap() {
        List<FirstSysMap> map = systemService.findMap();
        return new ResultData<List<FirstSysMap>>(true, map);
    }
}
