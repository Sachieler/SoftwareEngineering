package org.fkit.hrm.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.fkit.hrm.domain.Dept;
import static org.fkit.hrm.util.common.HrmConstants.DEPTTABLE;;

/**   
 * @Description: 部门动态SQL语句提供类
 */
public class DeptDynaSqlProvider {
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(DEPTTABLE);
				if(params.get("dept") != null){
					Dept dept = (Dept) params.get("dept");
					if(dept.getP_id() != null && !dept.getP_id().equals("")){
						WHERE("  p_id LIKE CONCAT ('%',#{dept.p_id},'%') ");
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
				FROM(DEPTTABLE);
				
				if(params.get("dept") != null){
					Dept dept = (Dept) params.get("dept");
					if(dept.getP_id()!= null && !dept.getP_id().equals("")){
						WHERE("  p_id LIKE CONCAT ('%',#{dept.p_id},'%') ");
					}
				}
			}
		}.toString();
	}	
	// 动态插入
	public String insertDept(Dept dept){
		
		return new SQL(){
			{
				INSERT_INTO(DEPTTABLE);
				if(dept.getP_id() != null && !dept.getP_id().equals("")){
					VALUES("p_id", "#{p_id}");
				}
				if(dept.getP_name() != null && !dept.getP_name().equals("")){
					VALUES("p_name", "#{p_name}");
				}
				if(dept.getP_number() != null && !dept.getP_number().equals("")){
					VALUES("p_number", "#{p_number}");
				}
				if(dept.getP_date() != null && !dept.getP_date().equals("")){
					VALUES("p_date", "#{p_date}");
				}
				if(dept.getName() != null && !dept.getName().equals("")){
					VALUES("name", "#{name}");
				}
			}
		}.toString();
	}
	
	// 动态更新
	public String updateDept(Dept dept){
		System.out.println("=======测试修改==============");
		System.out.println(dept);
		String test  = new SQL(){
			{
				UPDATE(DEPTTABLE);
				
				if(dept.getP_id() !=null){
					SET(" p_id = #{p_id} ");
				}
				if(dept.getP_name() != null){
					SET(" p_name = #{p_name} ");
				}
				if(dept.getP_number() != null){
					SET(" p_number = #{p_number} ");
				}
				if(dept.getP_date() != null){
					SET(" p_date = #{p_date} ");
				}
				if(dept.getName() != null){
					SET(" name = #{name} ");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
		
		System.out.println(test);
		return test;
	}


}
