package com.work.dto;

import java.sql.Date;

import com.work.utility.Utility;

public class Budget {
	Date startDate;
	Date endDate;
	String category;
	int amount;
	
	Utility util = new Utility();
	
	public Budget() {
		
	}
	
	/**
	 * @param startDate
	 * @param endDate
	 * @param category
	 * @param amount
	 */
	public Budget(String startDate, String endDate, String category, int amount) {
		super();
		this.startDate = util.StringToDate(startDate);
		this.endDate = util.StringToDate(endDate);
		this.category = category;
		this.amount = amount;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = util.StringToDate(startDate);
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = util.StringToDate(endDate);
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(startDate).append("~").append(endDate).append("\t").append(category).append("\t")
				.append(amount);
		return builder.toString();
	}
	
}
