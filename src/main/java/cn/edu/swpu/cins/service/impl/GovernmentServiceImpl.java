package cn.edu.swpu.cins.service.impl;

import cn.edu.swpu.cins.dao.CmpDetailDao;
import cn.edu.swpu.cins.dao.DataRecordsDao;
import cn.edu.swpu.cins.dao.OrgMapDao;
import cn.edu.swpu.cins.dto.ChartCoord;
import cn.edu.swpu.cins.dto.OrgMapper;
import cn.edu.swpu.cins.dto.OrgRecord;
import cn.edu.swpu.cins.dto.RecordList;
import cn.edu.swpu.cins.entry.CmpDetail;
import cn.edu.swpu.cins.entry.DataRecords;
import cn.edu.swpu.cins.entry.OrgMap;
import cn.edu.swpu.cins.service.GovernmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by melo on 16-6-7.
 * 实现政务服务
 */
@Service
public class GovernmentServiceImpl implements GovernmentService {

	@Autowired
	private OrgMapDao orgMapDao;

	@Autowired
	private DataRecordsDao dataRecordsDao;

	@Autowired
	private CmpDetailDao cmpDetailDao;

	public List<ChartCoord> getChart(int id, long time) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		String temp = calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-";
		String startTime = temp + "01";
		calendar.set(Calendar.DATE, 1);
		calendar.roll(Calendar.DATE, -1);
		String endTime = temp + calendar.get(Calendar.DATE);
		List<CmpDetail> details = cmpDetailDao.govChart(id, startTime, endTime);
		if (details.size() == 0) return null;
		List<ChartCoord> coords = new ArrayList<ChartCoord>(details.size());
		for (CmpDetail detail :
						details) {
			coords.add(new ChartCoord(detail.getNumber(), detail.getHandinTime().getTime()));
		}
		return coords;
	}

	public RecordList getList(int page) {
		RecordList result = new RecordList();
		final int pageNum = 10;
		page = (page < 1) ? 1 : page;
		int offset = page * pageNum;
		page = offset - pageNum;
		List<DataRecords> recordses = dataRecordsDao.getList(page, offset);
		int all = dataRecordsDao.getAll();
		List<OrgMap> maps = orgMapDao.getMap();
		page = all % pageNum == 0 ? all/pageNum : all/pageNum + 1;
		result.setNumber(all);
		result.setPages(page);
		List<OrgRecord> records = new ArrayList<OrgRecord>(recordses.size());
		for (DataRecords record :	recordses) {
			OrgRecord orgRecord = new OrgRecord(record.getUploadTime().getTime(), record.getUploadNum());
			for (OrgMap map : maps) {
				if (map.getOrgId() == record.getUploadId())
					orgRecord.setUploadOrg(map.getOrgName());
				if (map.getOrgId() == record.getAcceptId())
					orgRecord.setAcceptOrg(map.getOrgName());
			}
			records.add(orgRecord);
		}
		result.setRecords(records);
		return result;
	}

	public List<OrgMapper> getMapper() {
		List<OrgMap> maps = orgMapDao.getMap();
		List<OrgMapper> result = new ArrayList<OrgMapper>(maps.size());
		for (OrgMap map :
						maps) {
			result.add(new OrgMapper(map.getOrgId(), map.getOrgName()));
		}
		return result;
	}
}
