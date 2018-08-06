package org.fkit.hrm.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.fkit.hrm.domain.Notice;
import static org.fkit.hrm.util.common.HrmConstants.NOTICETABLE;;


/**   
 * @Description: 公告动态SQL语句提供类
 */
public class NoticeDynaSqlProvider {
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(NOTICETABLE);
				if(params.get("notice") != null){
					Notice notice = (Notice)params.get("notice");
					
					if(notice.getBatchNumber() != null && !notice.getBatchNumber().equals("")){
						WHERE("  batchNumber  = #{notice.batchNumber} ");
					}
					if(notice.getDeadline() != null && !notice.getDeadline().equals("")){
						WHERE("  deadline = #{notice.deadline} ");
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
				FROM(NOTICETABLE);
				if(params.get("notice") != null){
					Notice notice = (Notice)params.get("notice");
					if(params.get("notice") != null){
						
						if(notice.getBatchNumber() != null && !notice.getBatchNumber().equals("")){
							WHERE("  batchNumber LIKE CONCAT ('%',#{notice.batchNumber},'%') ");
						}
						if(notice.getDeadline() != null && !notice.getDeadline().equals("")){
							WHERE("  deadline LIKE CONCAT ('%',#{notice.deadline},'%') ");
						}
						
					}
				}
			}
		}.toString();
	}	
	// 动态插入
	public String insertNotice(Notice notice){
		
		return new SQL(){
			{
				INSERT_INTO(NOTICETABLE);
				
				if(notice.getBatchNumber() != null && !notice.getBatchNumber().equals("")){
					VALUES("batchNumber", "#{batchNumber}");
				}
				if(notice.getProductName() != null && !notice.getProductName().equals("")){
					VALUES("productName", "#{productName}");
				}
				if(notice.getDetectionMethod() != null && !notice.getDetectionMethod().equals("")){
					VALUES("detectionMethod", "#{detectionMethod}");
				}
				if(notice.getDetectContent() != null && !notice.getDetectContent().equals("")){
					VALUES("detectContent", "#{detectContent}");
				}
				if(notice.getPlannedCompletionTime() != null && !notice.getPlannedCompletionTime().equals("")){
					VALUES("plannedCompletionTime","#{plannedCompletionTime}");
				}
				if(notice.getDeadline() != null && !notice.getDeadline().equals("")){
					VALUES("deadline","#{deadline}");
				}				
			}
		}.toString();
	}
	// 动态更新
	public String updateNotice(Notice notice){
		
		return new SQL(){
			{
				UPDATE(NOTICETABLE);
				
				if(notice.getBatchNumber() != null && !notice.getBatchNumber().equals("")){
					SET("batchNumber = #{batchNumber}");
				}
				if(notice.getProductName() != null && !notice.getProductName().equals("")){
					SET("productName = #{productName}");
				}
				if(notice.getDetectionMethod() != null && !notice.getDetectionMethod().equals("")){
					SET("detectionMethod = #{detectionMethod}");
				}
				if(notice.getDetectContent() != null && !notice.getDetectContent().equals("")){
					SET("detectContent = #{detectContent}");
				}
				if(notice.getPlannedCompletionTime() != null && !notice.getPlannedCompletionTime().equals("")){
					SET("plannedCompletionTime = #{plannedCompletionTime}");
				}
				if(notice.getDeadline() != null && !notice.getDeadline().equals("")){
					SET("deadline = #{deadline}");
				}
				
				WHERE(" id = #{id} ");
			}
		}.toString();
	}
	
}
