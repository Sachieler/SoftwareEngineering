package org.fkit.hrm.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.fkit.hrm.domain.Advice;
import static org.fkit.hrm.util.common.HrmConstants.ADVICETABLE;;


/**   
 * @Description: 反馈动态SQL语句提供类
 */
public class AdviceDynaSqlProvider {
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(ADVICETABLE);
				if(params.get("advice") != null){
					Advice advice = (Advice)params.get("advice");
					
					if(advice.getBatchNumber() != null && !advice.getBatchNumber().equals("")){
						WHERE("  batchNumber  = #{advice.batchNumber} ");
					}
					if(advice.getCreateDate() != null && !advice.getCreateDate().equals("")){
						WHERE("  createDate = #{advice.createDate} ");
					}
					
				}
			}
		}.toString();
		
		if(params.get("pageModel") != null){
			sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
		}
		
		return sql;
	}	
	// 动态查询总数量
	public String count(Map<String, Object> params){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM(ADVICETABLE);
				if(params.get("advice") != null){
					Advice advice = (Advice)params.get("advice");
					if(params.get("advice") != null){
						
						if(advice.getBatchNumber() != null && advice.getBatchNumber().equals("")){
							WHERE("  batchNumber = #{advice.batchNumber} ");
						}
						if(advice.getCreateDate() != null && !advice.getCreateDate().equals("")){
							WHERE("  createDate = #{advice.createDate} ");
						}
						
					}
				}
			}
		}.toString();
	}	
	// 动态插入
	public String insertAdvice(Advice advice){
		
		return new SQL(){
			{
				INSERT_INTO(ADVICETABLE);
				
				if(advice.getBatchNumber() != null && !advice.getBatchNumber().equals("")){
					VALUES("batchNumber", "#{batchNumber}");
				}
				if(advice.getCreateDate() != null && !advice.getCreateDate().equals("")){
					VALUES("createDate", "#{createDate}");
				}
				if(advice.getFeedback() != null && !advice.getFeedback().equals("")){
					VALUES("feedback", "#{feedback}");
				}

			}
		}.toString();
	}
	// 动态更新
	public String updateAdvice(Advice advice){
		
		return new SQL(){
			{
				UPDATE(ADVICETABLE);

				if(advice.getBatchNumber() != null && !advice.getBatchNumber().equals("")){
					SET("batchNumber = #{batchNumber}");
				}
				if(advice.getCreateDate() != null && !advice.getCreateDate().equals("")){
					SET("createDate = #{createDate}");
				}
				if(advice.getFeedback() != null && !advice.getFeedback().equals("")){
					SET("feedback = #{feedback}");
				}
				
				WHERE(" id = #{id} ");
			}
		}.toString();
	}
	
}
