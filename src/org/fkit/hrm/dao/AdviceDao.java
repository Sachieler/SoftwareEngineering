package org.fkit.hrm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.fkit.hrm.dao.provider.AdviceDynaSqlProvider;
import org.fkit.hrm.domain.Advice;
import static org.fkit.hrm.util.common.HrmConstants.ADVICETABLE;;


/**   
 * @Description: NoticeMapper接口
 */
public interface AdviceDao {

	// 动态查询
	
	@SelectProvider(type=AdviceDynaSqlProvider.class,method="selectWhitParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
		@Result(column="USER_ID",property="user",
			one=@One(select="org.fkit.hrm.dao.UserDao.selectById",
		fetchType=FetchType.EAGER))
	})
	
	List<Advice> selectByPage(Map<String, Object> params);
	
	@SelectProvider(type=AdviceDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
		
	@Select("select * from "+ADVICETABLE+" where id = #{id}")
	Advice selectById(int id);
	
	// 根据id删除公告
	@Delete(" delete from "+ADVICETABLE+" where id = #{id} ")
	void deleteById(Integer id);
		
	// 动态插入公告
	@SelectProvider(type=AdviceDynaSqlProvider.class,method="insertAdvice")
	void save(Advice advice);
		
	// 动态修改公告
	@SelectProvider(type=AdviceDynaSqlProvider.class,method="updateAdvice")
	void update(Advice advice);
	
}
