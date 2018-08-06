package org.fkit.hrm.domain;

import org.springframework.format.annotation.DateTimeFormat;

public class Employee implements java.io.Serializable{

	/*private Integer id;		
	private Dept dept;	*/		
	
	private String productnumber;
	private String productname;		
	private String data1;	
	private Integer data1result;	
	private String data2;			
	private Integer data2result;	
	private Integer result;	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private java.util.Date testtime;
	// 无参数构造器
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getProductnumber() {
		return productnumber;
	}

	public void setProductnumber(String productnumber) {
		this.productnumber = productnumber;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getData1() {
		return data1;
	}

	public void setData1(String data1) {
		this.data1 = data1;
	}

	public Integer getData1result() {
		return data1result;
	}

	public void setData1result(Integer data1result) {
		this.data1result = data1result;
	}

	public String getData2() {
		return data2;
	}

	public void setData2(String data2) {
		this.data2 = data2;
	}

	public Integer getData2result() {
		return data2result;
	}

	public void setData2result(Integer data2result) {
		this.data2result = data2result;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public java.util.Date getTesttime() {
		return testtime;
	}

	public void setTesttime(java.util.Date testtime) {
		this.testtime = testtime;
	}

	@Override
	public String toString() {
		return "Employee [productnumber=" + productnumber + ", productname=" + productname + ", data1=" + data1
				+ ", data1result=" + data1result + ", data2=" + data2 + ", data2result="
				+ data2result + ", result=" + result + ", testtime=" + testtime
				+ "]";
	}

}