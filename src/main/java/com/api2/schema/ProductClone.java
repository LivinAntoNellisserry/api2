package com.api2.schema;

import java.sql.Date;

/**
 * 
 * ProductClone Class. Contains cloneId, cloneProductId, cloneProductName,
 * cloneProductExpiryDate.
 *
 */
public class ProductClone {

	Integer cloneId;
	String cloneProductId;
	String cloneProductName;
	Date cloneProductExpiryDate;

	public Integer getCloneId() {
		return cloneId;
	}

	public void setCloneId(Integer cloneId) {
		this.cloneId = cloneId;
	}

	public String getCloneProductId() {
		return cloneProductId;
	}

	public void setCloneProductId(String cloneProductId) {
		this.cloneProductId = cloneProductId;
	}

	public String getCloneProductName() {
		return cloneProductName;
	}

	public void setCloneProductName(String cloneProductName) {
		this.cloneProductName = cloneProductName;
	}

	public Date getCloneProductExpiryDate() {
		return cloneProductExpiryDate;
	}

	public void setCloneProductExpiryDate(Date cloneProductExpiryDate) {
		this.cloneProductExpiryDate = cloneProductExpiryDate;
	}

	@Override
	public String toString() {
		return "ProductClone [cloneId=" + cloneId + ", cloneProductId=" + cloneProductId + ", cloneProductName="
				+ cloneProductName + ", cloneProductExpiryDate=" + cloneProductExpiryDate + "]";
	}
}
