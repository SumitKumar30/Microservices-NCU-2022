package com.example.demo.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Expense;

@Repository
public class ExpenseDao {

	@Autowired
	public JdbcTemplate jdbcTemplate;

	public boolean add(Expense expense) {
		String query = "insert into expense (id, name, cost, description) values(?, ?, ?, ?)";
		Object records[] = { expense.getId(), expense.getName(), expense.getCost(), expense.getDescription() };
		int result = jdbcTemplate.update(query, records);
		System.out.println("Description is: " + expense.getDescription());
		return result > 0;
	}

	public List<Expense> getAllExpenses() {
		String query = "select * from expense";
		List<Expense> expenses = jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Expense.class));
		return expenses;
	}

	public Expense findById(int id) {
		String query = "select * from expense where id = ?";
		Expense exp = jdbcTemplate.queryForObject(query, BeanPropertyRowMapper.newInstance(Expense.class), id);
		return exp;
	}

	public boolean deleteById(int id) {
		String query = "delete from expense where id = ?";
		int result = jdbcTemplate.update(query, id);
		return result > 0;
	}

	public boolean updateExpense(int id, Expense exp) {

		String sql = "update expense set name = ?, cost = ?, description = ? where id = ?";
		Object[] args = { exp.getName(), exp.getCost(), exp.getDescription(), id };
		int recordsUpdated = jdbcTemplate.update(sql, args);
		return recordsUpdated > 0;
	}
}
