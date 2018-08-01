package com.example.expensify.service;

import java.util.List;

import com.example.expensify.model.Expense;

public interface ExpenseDataService {

	public int createExpense(Expense newExpense);

	public List<Expense> getAllExpenses();

	public int updateExpense(long updateId, Expense newExpense);

	public int deleteExpense(long updateId);
	
}
