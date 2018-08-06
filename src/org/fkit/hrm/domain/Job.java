package org.fkit.hrm.domain;


public class Job implements java.io.Serializable{

	private Integer id;			// id
	private String productID;		// Ö°Î»Ãû³Æ
	private String productName;		// ÏêÏ¸ÃèÊö
	private String number;
	private String qualifiednumber;
	private String unqualifiednumber;
	private String qualifiedrate;
	private String unqualifiedrate;
	private String reason;
	
	public Job() {
		super();
	}

	public String getUnqualifiednumber() {
		return unqualifiednumber;
	}

	public void setUnqualifiednumber(String unqualifiednumber) {
		this.unqualifiednumber = unqualifiednumber;
	}

	public String getUnqualifiedrate() {
		return unqualifiedrate;
	}

	public void setUnqualifiedrate(String unqualifiedrate) {
		this.unqualifiedrate = unqualifiedrate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getQualifiednumber() {
		return qualifiednumber;
	}

	public void setQualifiednumber(String qualifiednumber) {
		this.qualifiednumber = qualifiednumber;
	}

	public String getQualifiedrate() {
		return qualifiedrate;
	}

	public void setQualifiedrate(String qualifiedrate) {
		this.qualifiedrate = qualifiedrate;
	}
	@Override
	public String toString() {
		return "Job [id=" + id + ", productID=" + productID + ", productName=" + productName + ",number=" + number + ",qualifiednumber=" + qualifiednumber + ",unqualifiednumber=" + unqualifiednumber + ",qualifiedrate=" + qualifiedrate + ",unqualifiedrate=" + unqualifiedrate + ",reason=" + reason + "]";
	}

}