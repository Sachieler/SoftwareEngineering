package org.fkit.hrm.domain;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
public class Detect implements java.io.Serializable{

	private Integer id;
	private String batchNumber;		
	private String productName;   
	private String detectorName; 
	private String detectedNum;  

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date detectTime;


	public Detect() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getBatchNumber() {
		return batchNumber;
	}



	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getDetectorName() {
		return detectorName;
	}



	public void setDetectorName(String detectorName) {
		this.detectorName = detectorName;
	}



	public String getDetectedNum() {
		return detectedNum;
	}



	public void setDetectedNum(String detectedNum) {
		this.detectedNum = detectedNum;
	}



	public Date getDetectTime() {
		return detectTime;
	}



	public void setDetectTime(Date detectTime) {
		this.detectTime = detectTime;
	}



	@Override
	public String toString() {
		return "添加进度 [batchNumber=" + batchNumber + ", productName=" + productName + ", detectorName=" + detectorName
				+ ", detectedNum=" + detectedNum + ", detectTime=" + detectTime+"]";
	}
	
	

}