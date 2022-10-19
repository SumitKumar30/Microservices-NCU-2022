package com.example.demo.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Expense;

@Repository
public class ExpenseDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	List<Expense> expenses = new ArrayList<>();

	public List<Expense> getAllExpenses() {
		/*
		 * expenses = Arrays.asList(new Expense(101, "Books", 500, "Books to read"), new
		 * Expense(102, "Vegetables", 120, "Veggies for the party"), new Expense(103,
		 * "Groceries", 1000, "Groceries for the party"));
		 */
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

	public boolean deleteById(int id) {
		List<Expense> exps = getAllExpenses();
		System.out.println(exps);
		for (Expense list : exps) {
			if (list.getId() == id) {
				exps.remove(exps.indexOf(list));
				return true;
			}
		}
		return false;
	}

	public Expense updateExpense(int id, Expense exp) {

		/*
		 * Expense expense = findById(id);
		 * 
		 * expense.setCost(exp.getCost()); expense.setDesc(exp.getDesc());
		 * expense.setName(exp.getName()); expenses.set(id, expense); return expense;
		 */

		int index = 0;
		List<Expense> exps = getAllExpenses();
		for (Expense list : exps) {
			if (list.getId() == id) {
				index = exps.indexOf(list);
				list.setCost(exp.getCost());
				list.setDesc(exp.getDesc()); // list.setId(list.getId());
				list.setName(exp.getName());
				expenses.set(index, list);
				return list;
			}
		}
		return null;
	}
}
