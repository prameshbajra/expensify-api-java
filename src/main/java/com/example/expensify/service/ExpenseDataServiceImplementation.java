package com.example.expensify.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expensify.dao.ExpenseDataDao;
import com.example.expensify.model.Expense;

@Service("expenseDataService")
public class ExpenseDataServiceImplementation implements ExpenseDataService {

	@Autowired
	public ExpenseDataDao expenseDataDao;

	@Override
	public int createExpense(Expense newExpense) {
		return expenseDataDao.createExpense(newExpense.getId(), newExpense.getExpenseTitle(),
				newExpense.getExpenseDescription(), newExpense.getDate(), newExpense.getAmount());
	}

	@Override
	public List<Expense> getAllExpenses() {
		return expenseDataDao.getAllExpenses();
	}

	@Override
	public int updateExpense(long updateId, Expense newExpense) {
		return expenseDataDao.updateExpense(updateId, newExpense.getId(), newExpense.getExpenseTitle(),
				newExpense.getExpenseDescription(), newExpense.getDate(), newExpense.getAmount());
	}

	@Override
	public int deleteExpense(long updateId) {
		return expenseDataDao.deleteExpense(updateId);
	}

}
