package org.fkit.hrm.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Dept implements java.io.Serializable{

	
	private Integer id;		// id
	
	private String p_id;	// 产品编号
	private String p_name;	// 产品名称
	private Integer p_number;	// 产品数量
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date p_date;	// 日期
	private String name;	// 接收人
	// 无参数构造器
	public Dept() {
		super();
	}
	// setter和getter方法
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public Integer getP_number() {
		return p_number;
	}

	public void setP_number(Integer p_number) {
		this.p_number = p_number;
	}

	public Date getP_date() {
		return p_date;
	}

	public void setP_date(Date p_date) {
		this.p_date = p_date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Dept [ id=" + id + " , p_id=" + p_id + ", p_name=" + p_name + " , p_number=" +
				p_number + ", p_date=" + p_date + ", name=" + name + "]";
	}


}