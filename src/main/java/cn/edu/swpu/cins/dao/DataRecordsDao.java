package cn.edu.swpu.cins.dao;

import cn.edu.swpu.cins.entry.DataRecords;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by melo on 16-6-5.
 * data_records访问接口
 */
@Repository
public interface DataRecordsDao {

	/**
	 * 获取数据提交列表
	 * @param limit 起始
	 * @param offset 结束
	 * @return 返回列表
	 */
	List<DataRecords> getList(@Param("limit") int limit, @Param("offset") int offset);

	/**
	 * 获取统计图数据
	 * @param id 上传机构的id
	 * @return 数据列表
	 */
	List<DataRecords> getChart(@Param("uploadId") int id);

	/**
	 * 获取列表总数
	 * @return 总数
	 */
	int getAll();
}
