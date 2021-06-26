package com.work.dto;

import java.sql.Date;

import com.work.utility.Utility;

public class Income {
	Date date;
	String category;
	int amount;
	
	Utility util = new Utility();
	
	public Income() {
		
	}
	
	/**
	 * @param date
	 * @param category
	 * @param amount
	 */
	public Income(String date, String category, int amount) {
		this.date = util.StringToDate(date);
		this.category = category;
		this.amount = amount;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = util.StringToDate(date);
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
		builder.append(date).append("\t").append(category).append("\t").append(amount);
		return builder.toString();
	}
}
