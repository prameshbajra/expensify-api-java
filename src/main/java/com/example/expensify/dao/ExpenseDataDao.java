package com.example.expensify.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.example.expensify.model.Expense;

@Component
public interface ExpenseDataDao {

	public String createExpense = "INSERT INTO expenses(id, \"expenseTitle\", \"expenseDescription\", date, amount) VALUES (#{id}, #{expenseTitle}, #{expenseDescription}, #{date}, #{amount});";

	@Insert(createExpense)
	public int createExpense(@Param("id") long id, @Param("expenseTitle") String expenseTitle,
			@Param("expenseDescription") String expenseDescription, @Param("date") String date,
			@Param("amount") long amount);

	public String getAllExpenses = "SELECT * FROM expenses ORDER BY id;";

	@Select(getAllExpenses)
	public List<Expense> getAllExpenses();

	public String updateExpense = "UPDATE expenses SET \"expenseTitle\" = #{expenseTitle}, \"expenseDescription\" = #{expenseDescription}, date = #{date}, amount = #{amount} WHERE id = #{updateId};";

	@Update(updateExpense)
	public int updateExpense(@Param("updateId") long updateId, @Param("id") long id,
			@Param("expenseTitle") String expenseTitle, @Param("expenseDescription") String expenseDescription,
			@Param("date") String date, @Param("amount") long amount);

	public String deleteExpense = "DELETE FROM expenses WHERE id = #{updateId}";
	@Delete(deleteExpense)
	public int deleteExpense(@Param("updateId") long updateId);

}
