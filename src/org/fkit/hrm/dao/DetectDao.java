package org.fkit.hrm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.fkit.hrm.dao.provider.DetectDynaSqlProvider;
import org.fkit.hrm.domain.Detect;
import static org.fkit.hrm.util.common.HrmConstants.DETECTTABLE;;


/**   
 * @Description: DetectMapper接口
 */
public interface DetectDao {

	// 动态查询
	
	@SelectProvider(type=DetectDynaSqlProvider.class,method="selectWhitParam")
	@Results({
		@Result(id=true,column="batchNumber",property="batchNumber"),
		@Result(column="detectTime",property="detectTime",javaType=java.util.Date.class),
		@Result(id=true,column="productName",property="productName"),
		@Result(id=true,column="detectorName",property="detectorName"),
		/*
		@Result(column="USER_ID",property="user",
			one=@One(select="org.fkit.hrm.dao.UserDao.selectBybatchNumber",
		fetchType=FetchType.EAGER))
		*/
	})
	
	List<Detect> selectByPage(Map<String, Object> params);
	
	@SelectProvider(type=DetectDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
		
	@Select("select * from "+DETECTTABLE+" where id = #{id}")
	Detect selectBybatchNumber(int batchNumber);
	
	// 根据id删除公告
	@Delete(" delete from "+DETECTTABLE+" where id = #{id} ")
	void deleteBybatchNumber(Integer batchNumber);
		
	// 动态插入公告
	@SelectProvider(type=DetectDynaSqlProvider.class,method="insertDetect")
	void save(Detect detect);
		
	// 动态修改公告
	@SelectProvider(type=DetectDynaSqlProvider.class,method="updateDetect")
	void update(Detect detect);
	
}
