package cn.edu.swpu.cins.web;

import cn.edu.swpu.cins.dto.*;
import cn.edu.swpu.cins.entry.BaseInfo;
import cn.edu.swpu.cins.enums.ExcepMsg;
import cn.edu.swpu.cins.enums.Tables;
import cn.edu.swpu.cins.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by melo on 16-6-4.
 * 公司基本信息Controller
 */
@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    /**
     * 获取企业列表信息
     * @param page 页数
     * @return 公司列表和总页数及总公司数
     */
    @RequestMapping(value = "/list",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ResultData getList(@RequestParam(name = "page") int page) {
        return new ResultData<CompanyList>(true, companyService.getList(page));
    }

    /**
     * 获取正异常企业数目
     * @return 正常和异常企业的数目
     */
    @RequestMapping(value = "/count",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ResultData getStatus(@RequestParam(name = "time", required = false) Long time) {
        if (time == null)
            time = System.currentTimeMillis();
        return new ResultData<ComStatus>(true, companyService.countStatus(time));
    }

    /**
     * 搜索企业
     * @param page 页数
     * @param query 搜索关键字
     * @return 搜索结果，与'/list'返回结果相同
     */
    @RequestMapping(value = "/search",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ResultData searchCompany(@RequestParam(name = "page") int page,
                              @RequestParam(name = "query") String query) {
        if (query == null || query.equals(""))
            return getList(page);
        return new ResultData<CompanyList>(true, companyService.searchCompany(query, page));
    }

    @RequestMapping(value = "{comName}/info")
    public ResultData getComInfoByName(@PathVariable String comName) {
        if (comName == null || comName.trim().equals(""))
            return new ResultData(false, ExcepMsg.NO_COM_NAME);
        List<BaseInfo> baseInfos = companyService.getComInfoByName(comName);
        if (baseInfos == null)
            return new ResultData(false, ExcepMsg.NO_COMPANY);
        return new ResultData<List<BaseInfo>>(true, baseInfos);
    }

    /**
     * 获取企业行为记录中折线图的数据
     * @param id 企业id
     * @return 企业信息
     */
    @RequestMapping(value = "/behaviour",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ResultData getBehaviour(@RequestParam(name = "id") int id) {
        List<ComBehaviour> behaviours = companyService.getBehaviour(id);
        if (behaviours == null)
            return new ResultData<List<ComBehaviour>>(false, "id不存在");
        return new ResultData<List<ComBehaviour>>(true, behaviours);
    }

    /**
     * 获取第二个折线图所需内容
     * @param id 企业id
     * @return 企业信息
     */
    @RequestMapping(value = "/behaviour/aim",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ResultData getBehaviourAim(@RequestParam(name = "id") int id,
                                            @RequestParam(name = "aim") String aim) {
        for (Tables table : Tables.values()) {
            if (table.getTableName().equalsIgnoreCase(aim) || table.getChineseName().equals(aim))
                return new ResultData<List<AimLogger>>(true, companyService.getBehaviourAim(id, table));
        }
        // TODO: 16-6-5 用异常或枚举来处理
        return new ResultData(false, "目标名称错误");
    }

    @RequestMapping(value = "/behaviour/count",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ResultData getBehaviourCount(@RequestParam(name = "id") int id) {
        return new ResultData<List<AimCounter>>(true, companyService.getBehaviourCount(id));
    }

}
