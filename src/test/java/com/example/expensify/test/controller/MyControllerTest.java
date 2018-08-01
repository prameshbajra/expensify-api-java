package com.example.expensify.test.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.expensify.controller.MyController;
import com.example.expensify.model.Expense;
import com.example.expensify.service.ExpenseDataService;
import com.example.expensify.test.utility.JavaToJson;

public class MyControllerTest {

	private MockMvc mockMvc;

	@Mock
	private ExpenseDataService expenseDataService;

	@InjectMocks
	private MyController myController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(myController).build();
	}

	List<Expense> expenses = Arrays.asList(new Expense(1, "MOMO", "HOT POT CHINA MOMOS", "2016 - 18 -19", 1000),
			new Expense(3, "BUrger", "Mc Donalds", "2016 - 18 -19", 200),
			new Expense(4, "Wraps", "Sandwich", "2016 - 18 -19", 200),
			new Expense(5, "Heineken", "Gress Code", "2019", 120));

	@Test
	public void getAllExpenses() throws Exception {
		when(expenseDataService.getAllExpenses()).thenReturn(expenses);
		mockMvc.perform(get("/get-all-expenses")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
	}

	@Test
	public void createExpense() throws Exception {
		Expense newExpense = new Expense(6, "Breer", "Kiliman Code", "1990", 1120);
		mockMvc.perform(
				post("/create-expense")
					.contentType(MediaType.APPLICATION_JSON)
					.content(JavaToJson.asJsonString(newExpense)))
		.andExpect(status().isOk());
	}

}
