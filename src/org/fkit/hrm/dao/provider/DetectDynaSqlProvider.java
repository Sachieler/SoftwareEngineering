package org.fkit.hrm.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.fkit.hrm.domain.Detect;
import static org.fkit.hrm.util.common.HrmConstants.DETECTTABLE;;


/**   
 * @Description: 鍏憡鍔ㄦ�丼QL璇彞鎻愪緵绫�
 */
public class DetectDynaSqlProvider {
	// 鍒嗛〉鍔ㄦ�佹煡璇�
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(DETECTTABLE);
				if(params.get("detect") != null){
					Detect detect = (Detect)params.get("detect");
					
					if(detect.getBatchNumber() != null && !detect.getBatchNumber().equals("")){
						WHERE("  batchNumber LIKE CONCAT ('%',#{detect.batchNumber},'%') ");
					}
					if(detect.getProductName() != null && !detect.getProductName().equals("")){
						WHERE("  productName LIKE CONCAT ('%',#{detect.productName},'%') ");
					}
					if(detect.getDetectTime() != null && !detect.getDetectTime().equals("")){
						WHERE("  detectTime LIKE CONCAT ('%',#{detect.detectTime},'%') ");
					}
					if(detect.getDetectorName() != null && !detect.getDetectorName().equals("")){
						WHERE("  detectorName LIKE CONCAT ('%',#{detect.detectorName},'%') ");
					}					
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
				FROM(DETECTTABLE);
				if(params.get("detect") != null){
					Detect detect = (Detect)params.get("detect");
						
					if(detect.getBatchNumber() != null && !detect.getBatchNumber().equals("")){
						WHERE("  batchNumber LIKE CONCAT ('%',#{detect.batchNumber},'%') ");
					}
					if(detect.getProductName() != null && !detect.getProductName().equals("")){
						WHERE("  productName LIKE CONCAT ('%',#{detect.productName},'%') ");
					}
					if(detect.getDetectTime() != null && !detect.getDetectTime().equals("")){
						WHERE("  detectTime LIKE CONCAT ('%',#{detect.detectTime},'%') ");
					}
					if(detect.getDetectorName() != null && !detect.getDetectorName().equals("")){
						WHERE("  detectorName LIKE CONCAT ('%',#{detect.detectorName},'%') ");
					}	
					
				}
			}
		}.toString();
	}	
	// 鍔ㄦ�佹彃鍏�
	public String insertDetect(Detect detect){
		
		return new SQL(){
			{
				INSERT_INTO(DETECTTABLE);
				
				if(detect.getBatchNumber() != null && !detect.getBatchNumber().equals("")){
					VALUES("batchNumber", "#{batchNumber}");
				}
				if(detect.getProductName() != null && !detect.getProductName().equals("")){
					VALUES("productName", "#{productName}");
				}
				if(detect.getDetectTime() != null && !detect.getDetectTime().equals("")){
					VALUES("detectTime", "#{detectTime}");
				}
				if(detect.getDetectorName()!= null && !detect.getDetectorName().equals("")){
					VALUES("detectorName", "#{detectorName}");
				}
				if(detect.getDetectedNum() != null && !detect.getDetectedNum().equals("")){
					VALUES("detectedNum","#{detectedNum}");
				}

			}
		}.toString();
	}
	// 鍔ㄦ�佹洿鏂�
	public String updateDetect(Detect detect){
		
		return new SQL(){
			{
				UPDATE(DETECTTABLE);
				
				if(detect.getBatchNumber() != null && !detect.getBatchNumber().equals("")){
					SET("batchNumber = #{batchNumber}");
				}
				if(detect.getProductName() != null && !detect.getProductName().equals("")){
					SET("productName = #{productName}");
				}
				if(detect.getDetectTime() != null && !detect.getDetectTime().equals("")){
					SET("detectTime = #{detectTime}");
				}
				if(detect.getDetectorName() != null && !detect.getDetectorName().equals("")){
					SET("detectorName = #{detectorName}");
				}
				if(detect.getDetectedNum() != null && !detect.getDetectedNum().equals("")){
					SET("detectedNum = #{detectedNum}");
				}
				
				WHERE(" id = #{id} ");
			}
		}.toString();
	}
	
}
