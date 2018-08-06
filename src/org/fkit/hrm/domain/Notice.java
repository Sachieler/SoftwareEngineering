package org.fkit.hrm.domain;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
public class Notice implements java.io.Serializable{

	private Integer id;
	private String batchNumber;		// 批次编号
	private String productName;   //产品名称
	private String detectContent; // 检测内容
	private String detectionMethod;  //检测方法
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date plannedCompletionTime;  //计划完成时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date deadline; //截止时间


	// 无参数构造器
	public Notice() {
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



	public String getDetectContent() {
		return detectContent;
	}



	public void setDetectContent(String detectContent) {
		this.detectContent = detectContent;
	}



	public String getDetectionMethod() {
		return detectionMethod;
	}



	public void setDetectionMethod(String detectionMethod) {
		this.detectionMethod = detectionMethod;
	}



	public Date getPlannedCompletionTime() {
		return plannedCompletionTime;
	}



	public void setPlannedCompletionTime(Date plannedCompletionTime) {
		this.plannedCompletionTime = plannedCompletionTime;
	}



	public Date getDeadline() {
		return deadline;
	}



	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}



	@Override
	public String toString() {
		return "添加计划 [batchNumber=" + batchNumber + ", productName=" + productName + ", detectContent=" + detectContent
				+ ", detectionMethod=" + detectionMethod + ", plannedCompletionTime=" + plannedCompletionTime+", deadline=" + deadline + "]";
	}
	
	

}