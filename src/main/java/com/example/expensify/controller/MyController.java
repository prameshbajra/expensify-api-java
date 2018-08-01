package com.example.expensify.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.expensify.model.Expense;
import com.example.expensify.service.ExpenseDataService;

@RestController
@RequestMapping("/")
public class MyController {

	@Autowired
	public ExpenseDataService expenseDataService;

	@RequestMapping(value = "create-expense", method = RequestMethod.POST)
	public int createExpense(@RequestBody Expense newExpense) {
		return expenseDataService.createExpense(newExpense);
	}

	@RequestMapping(value = "get-all-expenses", method = RequestMethod.GET)
	public List<Expense> getAllExpenses() {
		return expenseDataService.getAllExpenses();
	}

	@RequestMapping(value = "update-expense/{updateId}", method = RequestMethod.PUT)
	public int updateExpense(@RequestBody Expense newExpense, @PathVariable long updateId) {
		return expenseDataService.updateExpense(updateId, newExpense);
	}

	@RequestMapping(value = "delete-expense/{updateId}", method = RequestMethod.DELETE)
	public int deleteExpense(@PathVariable long updateId) {
		return expenseDataService.deleteExpense(updateId);
	}
}
