package cn.edu.swpu.cins.web;

import cn.edu.swpu.cins.dto.ComStatus;
import cn.edu.swpu.cins.dto.LocationCounter;
import cn.edu.swpu.cins.dto.ResultData;
import cn.edu.swpu.cins.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by melo on 16-6-5.
 * 区域性分析Controller
 */
@Controller
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @RequestMapping(method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ResultData getCount() {
        List<LocationCounter> counters = locationService.countLocation();
        return new ResultData<List<LocationCounter>>(true, counters);
    }

    @RequestMapping(value = "/detail",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ResultData getDetail(@RequestParam(name = "location") String location,
                                @RequestParam(name = "time", required = false) Long time) {
        if (time == null)
            time = System.currentTimeMillis();
        ComStatus status = locationService.countLocationStatus(location, time);
        return new ResultData<ComStatus>(true, status);
    }

}
