package com.example.demo.DAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.models.Expense;

@Repository
public class ExpenseDao {
	List<Expense> expenses = new ArrayList<>();

	public List<Expense> getAllExpenses() {
		// expenses = Arrays.asList(new Expense(101, "Books", 500, "Books to read"), new
		// Expense(102, "Vegetables", 120, "Veggies for the party"), new Expense(103,
		// "Groceries", 1000, "Groceries for the party"));
		return expenses;
	}

	public boolean add(Expense expense) {
		return expenses.add(expense);
	}

	public Expense findById(int id) {
		/*
		 * int index = expenses.indexOf(new Expense(id)); return index ==
		 * -1?null:expenses.get(index);
		 */

		List<Expense> exps = getAllExpenses();
		for (Expense list : exps) {
			if (list.getId() == id)
				return list;
		}
		return null;
	}
}