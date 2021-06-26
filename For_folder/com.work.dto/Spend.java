package com.work.dto;

import java.sql.Date;
import com.work.utility.Utility;

public class Spend {
	Date date;
	String category;
	int amount;
	String methodPayment;
	
	Utility util = new Utility();
	
	public Spend() {
		
	}
	
	/**
	 * 
	 * @param date
	 * @param amount
	 * @param category
	 * @param methodPayment
	 */
	public Spend(String date, String category, int amount, String methodPayment) {
		this.date = util.StringToDate(date);
		this.amount = amount;
		this.category = category;
		this.methodPayment = methodPayment;
	}

	/**
	 * 
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
	 * @return the methodPayment
	 */
	public String getMethodPayment() {
		return methodPayment;
	}

	/**
	 * @param methodPayment the methodPayment to set
	 */
	public void setMethodPayment(String methodPayment) {
		this.methodPayment = methodPayment;
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
		builder.append(date).append("\t").append(category).append("\t").append(amount).append("\t")
				.append(methodPayment);
		return builder.toString();
	}

}
