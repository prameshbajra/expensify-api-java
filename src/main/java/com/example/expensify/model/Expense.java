package com.example.expensify.model;

public class Expense {

	private long id;
	private String expenseTitle;
	private String expenseDescription;
	private String date;
	private long amount;

	public Expense() {
	}

	public Expense(long id, String expenseTitle, String expenseDescription, String date, long amount) {
		super();
		this.id = id;
		this.expenseTitle = expenseTitle;
		this.expenseDescription = expenseDescription;
		this.date = date;
		this.amount = amount;
	}

	public String getExpenseTitle() {
		return expenseTitle;
	}

	public void setExpenseTitle(String expenseTitle) {
		this.expenseTitle = expenseTitle;
	}

	public String getExpenseDescription() {
		return expenseDescription;
	}

	public void setExpenseDescription(String expenseDescription) {
		this.expenseDescription = expenseDescription;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
