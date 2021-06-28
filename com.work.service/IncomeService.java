package com.work.service;

import java.sql.Date;
import java.util.ArrayList;

import com.work.dto.Income;
import com.work.dto.Income;
import com.work.utility.Utility;

public class IncomeService {
	
	private ArrayList<Income> list = new ArrayList<Income>();
	Utility util = new Utility(); 
	
	public void addIncome(Income income) {
		list.add(income);
	}
	
	public void addIncome(String date, String category, int amount) {
		Income income = new Income(date, category, amount);
		addIncome(income);
	}
	
	public void getAllIncome() {
		System.out.println("[번호]\t날짜\t\t항목\t금액");
		for(int index = 0; index < list.size(); index++) {
			System.out.println("["+ index + "]\t" + list.get(index).toString());
		}
	}
	
	public void getPeriodIncome(String start, String end) {
		int total = 0;
		Date startDate = util.StringToDate(start);
		Date endDate = util.StringToDate(end);
		System.out.println("[번호]\t날짜\t\t항목\t금액");
		for(int index = 0; index < list.size(); index++) {
			Date date = list.get(index).getDate();
			if(date.after(startDate) && date.before(endDate)) {
				System.out.println("["+ index + "]\t" + list.get(index).toString());
				total += list.get(index).getAmount();
			}
		}
		System.out.println(startDate + "~" + endDate + " 의 총 수입: " + total);
	}
	
	public void getCategoryIncome(String category) {
		int total = 0;
		System.out.println("[번호]\t날짜\t\t항목\t금액");
		for(int index = 0; index < list.size(); index++) {
			if(list.get(index).getCategory().equals(category)) {
				System.out.println("["+ index + "]\t" + list.get(index).toString());
				total += list.get(index).getAmount();
			}
		}
		System.out.println(category + "의 총 수입: " + total);
	}
	
	public int setIncomeDate(int index, String modifyDate) {
		list.get(index).setDate(modifyDate);
		return index;
	}
	
	public void setIncomeCategory(int index, String modifyCategory) {
		list.get(index).setCategory(modifyCategory);
	}
	
	public void setIncomeAmount(int index, int modifyAmount) {
		list.get(index).setAmount(modifyAmount);
	}
	
	public void removeIncome(int index) {
		list.remove(index);
	}
	
	public int initIncome() {
		Income income1 = new Income("2021-03-01", "용돈", 100000);
		Income income2 = new Income("2021-03-02", "월급", 300000);
		Income income3 = new Income("2021-03-03", "기타", 50000);
		Income income4 = new Income("2021-03-03", "배당금", 12340);
		
		addIncome(income1);
		addIncome(income2);
		addIncome(income3);
		addIncome(income4);
		
		return list.size();
	}
	
}
