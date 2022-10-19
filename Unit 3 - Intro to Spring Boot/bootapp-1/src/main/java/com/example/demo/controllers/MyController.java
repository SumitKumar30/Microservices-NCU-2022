package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DAO.ExpenseDao;
import com.example.demo.exceptions.ExpenseNotFoundException;
import com.example.demo.models.Expense;

@RestController
@RequestMapping(path = "/home")
public class MyController {
	@Autowired
	ExpenseDao expenseDao;

	@RequestMapping(method = RequestMethod.GET, path = "/hello")
	public String getHello() {
		return "Hello from Spring boot";
	}

	@GetMapping(path = "/expense")
	public Expense getExpense() {
		Expense expense = new Expense(101, "Gifts", 1800, "Buy gifts");
		return expense;
	}

	@GetMapping(path = "/expenses")
	public Map<String, List<Expense>> getAllExpenses() {
		// return expenseDao.getAllExpenses();
		Map<String, List<Expense>> map = new HashMap<>();
		map.put("Expenses", expenseDao.getAllExpenses());
		return map;
	}

	@PostMapping("/addexpense")
	public String addExpense(@RequestBody Expense expense) {
		return expenseDao.add(expense) ? "Record Added Successfully!" : "Not Added!!";
	}

	@GetMapping(path = "/expenses/{expenseId}")
	public Expense findExpenseById(@PathVariable int expenseId) {
		/*
		 * List<Expense> exp = expenseDao.getAllExpenses(); return exp.get(expenseId);
		 */
		Expense expense = expenseDao.findById(expenseId);
		if (expense != null)
			return expense;
		else
			throw new ExpenseNotFoundException(expenseId + " Not Found!");
	}
	
	@DeleteMapping("/deleteexpense/{expenseId}")
	public String deleteExpense(@PathVariable int expenseId) {
		return expenseDao.deleteById(expenseId)?"Record Deleted Successfully!":"Record does not exist!";
	}
	
	@PutMapping("/updateexpense/{expenseId}")
	public String updateExpense(@PathVariable int expenseId, @RequestBody Expense expense) {
		Expense exp =  expenseDao.updateExpense(expenseId, expense);
		//return expenseDao.add(exp) ? "Record Updated Successfully!" : "Not Updated!!";
		
		  if(exp != null) return "Expense updated successfully!"; else return
		  "Error updating Expense!";
		 
	}
}
