package com.work.service;

import java.sql.Date;
import java.util.ArrayList;

import com.work.dto.Budget;
import com.work.dto.Spend;
import com.work.utility.Utility;

public class BudgetService {
	
	private ArrayList<Budget> list = new ArrayList<Budget>();
	Utility util = new Utility(); 
	
	public void addBudget(Budget budget) {
		list.add(budget);
	}
	
	public void addBudget(String start, String end, String category, int amount) {
		Budget budget = new Budget(start, end, category, amount);
		addBudget(budget);
	}
	
	public void getAllBudget() {
		System.out.println("[번호]\t기간\t\t\t항목\t금액");
		for(int index = 0; index < list.size(); index++) {
			System.out.println("["+ index + "]\t" + list.get(index).toString());
		}
	}
	
	public void getPeriodBudget(String start, String end) {
		Date begin = util.StringToDate(start);
		Date fin = util.StringToDate(end);
		for(int index = 0; index < list.size(); index++) {
			if(list.get(index).getStartDate().after(begin) && list.get(index).getEndDate().before(fin)) {
				System.out.println(list.get(index).toString());
			}
		}
	}
	
	public void getCategoryBudget(String category) {
		System.out.println("[번호]\t날짜\t\t항목\t금액");
		for(int index = 0; index < list.size(); index++) {
			if(list.get(index).getCategory().equals(category)) {
				System.out.println("["+ index + "]\t" + list.get(index).toString());
			}
		}
	}
	
	public void setBudgetDate(int index, String modifyStart, String modifyEnd) {
		list.get(index).setStartDate(modifyStart);
		list.get(index).setEndDate(modifyEnd);
	}
	
	public void setBudgetCategory(int index, String modifyCategory) {
		list.get(index).setCategory(modifyCategory);
	}
	
	public void setBudgetAmount(int index, int modifyAmount) {
		list.get(index).setAmount(modifyAmount);
	}
	
	public void removeBudget(int index) {
		list.remove(index);
	}

	public int initBudget() {
		Budget budget1 = new Budget("2021-03-01", "2021-03-31", "식비", 300000);
		Budget budget2 = new Budget("2021-03-01","2021-04-30", "취미", 250000);
		Budget budget3 = new Budget("2021-03-01", "2021-03-15", "교통", 50000);
		
		addBudget(budget1);
		addBudget(budget2);
		addBudget(budget3);
		
		return list.size();
	}
}
