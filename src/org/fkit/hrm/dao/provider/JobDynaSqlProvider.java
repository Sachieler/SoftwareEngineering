package org.fkit.hrm.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.fkit.hrm.domain.Job;
import static org.fkit.hrm.util.common.HrmConstants.JOBTABLE;


/**   
 * @Description: 鑱屼綅鍔ㄦ�丼QL璇彞鎻愪緵绫�
 */
public class JobDynaSqlProvider {
	// 鍒嗛〉鍔ㄦ�佹煡璇�
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(JOBTABLE);
				if(params.get("job") != null){
					Job job = (Job) params.get("job");
					if(job.getProductID() != null && !job.getProductID().equals("")){
						WHERE("  productID LIKE CONCAT ('%',#{job.productID},'%') ");
					}
					/*
					if(job.getName() != null && !job.getName().equals("")){
						WHERE("  name LIKE CONCAT ('%',#{job.name},'%') ");
					}
					*/
				}
			}
		}.toString();
		
		if(params.get("pageModel") != null){
			sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
		}
		
		return sql;
	}	
	// 鍔ㄦ�佹煡璇㈡�绘暟閲�
	public String count(Map<String, Object> params){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM(JOBTABLE);
				if(params.get("job") != null){
					Job job = (Job) params.get("job");
					if(job.getProductID() != null && !job.getProductID().equals("")){
						WHERE("  productID LIKE CONCAT ('%',#{job.productID},'%') ");
					}
					/*
					if(job.getName() != null && !job.getName().equals("")){
						WHERE("  name LIKE CONCAT ('%',#{job.name},'%') ");
					}
					*/
				}
			}
		}.toString();
	}	
	// 鍔ㄦ�佹彃鍏�
	public String insertJob(Job job){
		System.out.println("测试插入数据");
		System.out.println(job);
		return new SQL(){
			{
				INSERT_INTO(JOBTABLE);
				if(job.getProductID() != null && !job.getProductID().equals("")){
					VALUES("productID", "#{productID}");
				}
				if(job.getProductName() != null && !job.getProductName().equals("")){
					VALUES("productName", "#{productName}");
				}
				if(job.getNumber() != null && !job.getNumber().equals("")){
					VALUES("number", "#{number}");
				}
				if(job.getQualifiednumber() != null && !job.getQualifiednumber().equals("")){
					VALUES("qualifiednumber", "#{qualifiednumber}");
				}
				if(job.getQualifiedrate() != null && !job.getQualifiedrate().equals("")){
					VALUES("qualifiedrate", "#{qualifiedrate}");
				}
				if(job.getUnqualifiednumber() != null && !job.getUnqualifiednumber().equals("")){
					VALUES("unqualifiednumber", "#{unqualifiednumber}");
				}
				if(job.getUnqualifiedrate() != null && !job.getUnqualifiedrate().equals("")){
					VALUES("unqualifiedrate", "#{unqualifiedrate}");
				}
				if(job.getReason() != null && !job.getReason().equals("")){
					VALUES("reason", "#{reason}");
				}
				/*
				if(job.getName() != null && !job.getName().equals("")){
					VALUES("name", "#{name}");
				}
				if(job.getRemark() != null && !job.getRemark().equals("")){
					VALUES("remark", "#{remark}");
				}
				*/
			}
		}.toString();
	}
	// 鍔ㄦ�佹洿鏂�
	public String updateJob(Job job){
	
		return new SQL(){
			{
				UPDATE(JOBTABLE);
				if(job.getProductID() != null){
					SET(" productID = #{productID} ");
				}
				if(job.getProductName() != null){
					SET(" productName = #{productName} ");
				}if(job.getNumber() != null){
					SET(" number = #{number} ");
				}if(job.getQualifiednumber() != null){
					SET(" qualifiednumber = #{qualifiednumber} ");
				}if(job.getQualifiedrate() != null){
					SET(" qualifiedrate = #{qualifiedrate} ");
				}if(job.getUnqualifiednumber() != null){
					SET(" unqualifiednumber = #{unqualifiednumber} ");
				}if(job.getUnqualifiedrate() != null){
					SET(" unqualifiedrate = #{unqualifiedrate} ");
				}if(job.getReason() != null){
					SET(" reason = #{reason} ");
				}
				/*
				if(job.getName() != null){
					SET(" name = #{name} ");
				}
				if(job.getRemark() != null){
					SET(" remark = #{remark} ");
				}
				*/
				WHERE(" id = #{id} ");
			}
		}.toString();
	}
	
	
}
