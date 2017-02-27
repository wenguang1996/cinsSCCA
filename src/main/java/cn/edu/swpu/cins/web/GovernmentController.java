package cn.edu.swpu.cins.web;

import cn.edu.swpu.cins.dto.ChartCoord;
import cn.edu.swpu.cins.dto.OrgMapper;
import cn.edu.swpu.cins.dto.RecordList;
import cn.edu.swpu.cins.dto.ResultData;
import cn.edu.swpu.cins.service.GovernmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by melo on 16-6-7.
 * 政务系统Controller
 */
@Controller
@RequestMapping("/government")
public class GovernmentController {

	@Autowired
	private GovernmentService govService;

	@RequestMapping(value = "/map",
					method = RequestMethod.GET,
					produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public ResultData getMap() {
		return new ResultData<List<OrgMapper>>(true, govService.getMapper());
	}

	@RequestMapping(value = "/list",
					method = RequestMethod.GET,
					produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public ResultData getList(@RequestParam(name = "page") int page){
		return new ResultData<RecordList>(true, govService.getList(page));

	}

	@RequestMapping(value = "/chart",
					method = RequestMethod.GET,
					produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResultData getChart(@RequestParam(name = "id") int id,
	                           @RequestParam(name = "time") long time) {
		List<ChartCoord> coords = govService.getChart(id, time);
		if (coords == null)
			return new ResultData(false, "没有数据");
		return new ResultData<List<ChartCoord>>(true, coords);
	}
}
