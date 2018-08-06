package org.fkit.hrm.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.fkit.hrm.domain.Employee;
import static org.fkit.hrm.util.common.HrmConstants.EMPLOYEETABLE;


/**   
 * @Description: 员工动态SQL语句提供类
 */
public class EmployeeDynaSqlProvider {
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(EMPLOYEETABLE);
				if(params.get("employee") != null){
					Employee employee = (Employee)params.get("employee");
					if(employee.getProductnumber()!= null && !employee.getProductnumber().equals("")){
						WHERE("  productnumber LIKE CONCAT ('%',#{employee.productnumber},'%') ");
					}
					if(employee.getProductname()!= null && !employee.getProductname().equals("")){
						WHERE("  productname LIKE CONCAT ('%',#{employee.productname},'%') ");
					}
					if(employee.getTesttime()!= null && !employee.getTesttime().equals("")){
						WHERE("  testtime LIKE CONCAT ('%',#{employee.testtime},'%') ");
					}
					/*
					if(employee.getDept() != null && employee.getDept().getId() != null && employee.getDept().getId() != 0){
						WHERE(" DEPT_ID = #{employee.dept.id} ");
					}
					if(employee.getJob() != null && employee.getJob().getId() != null && employee.getJob().getId() != 0){
						WHERE(" JOB_ID = #{employee.job.id} ");
					}
					if(employee.getName() != null && !employee.getName().equals("")){
						WHERE("  NAME LIKE CONCAT ('%',#{employee.name},'%') ");
					}
					if(employee.getPhone() != null && !employee.getPhone().equals("")){
						WHERE(" phone LIKE CONCAT ('%',#{employee.phone},'%') ");
					}
					if(employee.getCardId() != null && !employee.getCardId().equals("") ){
						WHERE(" card_id LIKE CONCAT ('%',#{employee.cardId},'%') ");
					}
					if(employee.getSex()!= null && employee.getSex() != 0){
						WHERE("sex = #{employee.sex}");
					}*/
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
		System.out.println("=========count测试===============");
		return new SQL(){
			{
				SELECT("count(*)");
				FROM(EMPLOYEETABLE);
				if(params.get("employee") != null){
					Employee employee = (Employee)params.get("employee");
					if(employee.getProductnumber() != null){
						WHERE(" productnumber = #{employee.productnumber} ");
					}
					if(employee.getProductname()!= null){
						WHERE(" productname = #{employee.productname} ");
					}
					if(employee.getTesttime() != null){
						WHERE("  testtime LIKE CONCAT ('%',#{employee.testtime},'%') ");
					}
					/*
					if(employee.getDept() != null && employee.getDept().getId() != null && employee.getDept().getId() != 0){
						WHERE(" DEPT_ID = #{employee.dept.id} ");
					}
					if(employee.getJob() != null && employee.getJob().getId() != null && employee.getJob().getId() != 0){
						WHERE(" JOB_ID = #{employee.job.id} ");
					}
					if(employee.getName() != null && !employee.getName().equals("")){
						WHERE("  NAME LIKE CONCAT ('%',#{employee.name},'%') ");
					}
					if(employee.getPhone() != null && !employee.getPhone().equals("")){
						WHERE(" phone LIKE CONCAT ('%',#{employee.phone},'%') ");
					}
					if(employee.getCardId() != null && !employee.getCardId().equals("") ){
						WHERE(" card_id LIKE CONCAT ('%',#{employee.cardId},'%') ");
					}
					if(employee.getSex()!= null && employee.getSex() != 0){
						WHERE("sex = #{employee.sex}");
					}*/
				}
			}
		}.toString();
	}	
	
	// 动态插入
	public String insertEmployee(Employee employee){
		
		return new SQL(){
			{
				INSERT_INTO(EMPLOYEETABLE);
				if(employee.getProductnumber() != null){
					VALUES("productnumber", "#{productnumber}");
				}
				if(employee.getProductname() != null){
					VALUES("productname", "#{productname}");
				}
				if(employee.getData1()!= null){
					VALUES("data1", "#{data1}");
				}
				if(employee.getData1result()!= null){
					VALUES("data1result", "#{data1result}");
				}
				if(employee.getData2()!= null){
					VALUES("data2", "#{data2}");
				}
				if(employee.getData2result()!= null){
					VALUES("data2result", "#{data2result}");
				}
				
				if(employee.getResult()!= null){
					VALUES("result", "#{result}");
				}
				if(employee.getTesttime()!= null){
					VALUES("testtime", "#{testtime}");
				}
				
			}
		}.toString();
	}
	// 动态更新
	public String updateEmployee(Employee employee){
		
		return new SQL(){
			{
				UPDATE(EMPLOYEETABLE);/*
				if(employee.getName() != null){
					SET(" name = #{name} ");
				}
				if(employee.getCardId() != null){
					SET(" card_id = #{cardId} ");
				}
				if(employee.getAddress()!= null){
					SET(" address = #{address} ");
				}
				if(employee.getPostCode()!= null){
					SET(" post_code = #{postCode} ");
				}
				if(employee.getTel()!= null){
					SET(" tel = #{tel} ");
				}
				if(employee.getPhone()!= null){
					SET(" phone = #{phone} ");
				}
				if(employee.getQqNum()!= null){
					SET(" qq_num = #{qqNum} ");
				}
				if(employee.getEmail()!= null){
					SET(" email = #{email} ");
				}
				if(employee.getSex()!= null){
					SET(" sex = #{sex} ");
				}
				if(employee.getParty()!= null){
					SET(" party = #{party} ");
				}
				if(employee.getBirthday()!= null){
					SET(" birthday = #{birthday} ");
				}
				if(employee.getRace()!= null){
					SET(" race = #{race} ");
				}
				if(employee.getEducation()!= null){
					SET(" education = #{education} ");
				}
				if(employee.getSpeciality()!= null){
					SET(" speciality = #{speciality} ");
				}
				if(employee.getHobby()!= null){
					SET(" hobby = #{hobby} ");
				}
				if(employee.getRemark()!= null){
					SET(" remark = #{remark} ");
				}
				if(employee.getCreateDate()!= null){
					SET(" create_Date = #{createDate} ");
				}
				if(employee.getDept()!= null){
					SET(" dept_id = #{dept.id} ");
				}
				if(employee.getJob()!= null){
					SET(" job_id = #{job.id} ");
				}
				WHERE(" id = #{id} ");*/
			}
		}.toString();
	}


}
