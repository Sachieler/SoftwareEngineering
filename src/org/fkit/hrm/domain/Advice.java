package org.fkit.hrm.domain;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
public class Advice implements java.io.Serializable{

	private Integer id;
	private String batchNumber;		// 批次编号	

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createDate;   //创建时间
	
	private String feedback;  //检测方法

	// 无参数构造器
	public Advice() {
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



	public Date getCreateDate() {
		return createDate;
	}



	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}



	public String getFeedback() {
		return feedback;
	}



	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}





	@Override
	public String toString() {
		return "建议反馈 [batchNumber=" + batchNumber + ", createDate=" + createDate + ", feedback=" + feedback + "+ ]";
	}


	
	

}