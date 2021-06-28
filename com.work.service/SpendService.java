package com.work.service;

import java.sql.Date;
import java.util.ArrayList;

import com.work.dto.Spend;
import com.work.utility.Utility;

public class SpendService {
	
	private ArrayList<Spend> list = new ArrayList<Spend>();
	Utility util = new Utility(); 
	
	public void addSpend(Spend spend) {
		list.add(spend);
	}
	
	public void addSpend(String date, String category, int amount, String methodPayment) {
		Spend spend = new Spend(date, category, amount, methodPayment);
		addSpend(spend);		
	}
	
	public void getAllSpend() {
		System.out.println("[번호]\t날짜\t\t항목\t금액\t결제수단");
		for(int index = 0; index < list.size(); index++) {
			System.out.println("["+ index + "]\t" + list.get(index).toString());
		}
	}

	public void getPeriodSpend(String start, String end) {
		Date startDate = util.StringToDate(start);
		Date endDate = util.StringToDate(end);
		int total = 0;
		System.out.println("[번호]\t날짜\t\t항목\t금액\t결제수단");
		for(int index = 0; index < list.size(); index++) {
			Date date = list.get(index).getDate();
			if(date.after(startDate) && date.before(endDate)) {
				System.out.println("["+ index + "]\t" + list.get(index).toString());
				total += list.get(index).getAmount();
			}
		}
		System.out.println(startDate + " ~ " + endDate + "의 총 지출: " + total);
	}
	
	public void getCategorySpend(String category) {
		int total = 0;
		System.out.println("[번호]\t날짜\t\t항목\t금액\t결제수단");
		for(int index = 0; index < list.size(); index++) {
			if(list.get(index).getCategory().equals(category)) {
				System.out.println("["+ index + "]\t" + list.get(index).toString());
				total += list.get(index).getAmount();
			}
		}
		System.out.println(category + "의 총 지출: " + total);
	}
	
	public void getMethodPaymentSpend(String methodPayment) {
		int total = 0;
		System.out.println("[번호]\t날짜\t\t항목\t금액\t결제수단");
		for(int index = 0; index < list.size(); index++) {
			if(list.get(index).getMethodPayment().equals(methodPayment)) {
				System.out.println(list.get(index).toString());
				total += list.get(index).getAmount();
			}
		}
		System.out.println(methodPayment + "의 총 지출: " + total);
	}
	
	public int setSpendDate(int index, String modifyDate) {
		list.get(index).setDate(modifyDate);
		return index;
	}
	
	public int setSpendCategory(int index, String modifyCategory) {
		list.get(index).setCategory(modifyCategory);		
		return index;
	}
	
	public int setSpendAmount(int index, int modifyAmount) {
		list.get(index).setAmount(modifyAmount);
		return index;
	}
	
	public int setSpendMethod(int index, String modifyMethodPayment) {
		list.get(index).setMethodPayment(modifyMethodPayment);
		return index;
	}
	
	public void removeSpend(int index) {
		list.remove(index);
	}
	
	public int initSpend() {
		Spend spend1 = new Spend("2021-03-01", "식비", 7000, "카드");
		Spend spend2 = new Spend("2021-03-02", "의류", 16000, "카드");
		Spend spend3 = new Spend("2021-03-03", "주거", 50000, "계좌이체");
		Spend spend4 = new Spend("2021-03-03", "의류", 20000, "현금");
		
		addSpend(spend1);
		addSpend(spend2);
		addSpend(spend3);
		addSpend(spend4);
		
		return list.size();
	}

}
