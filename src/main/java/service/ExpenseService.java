package com.example.expense.service;

import com.example.expense.model.Expense;
import com.example.expense.repository.ExpenseRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository repo;

    public ExpenseService(ExpenseRepository repo) {
        this.repo = repo;
    }

    public List<Expense> getAll() { return repo.findAll(); }

    public Expense getById(Long id) { return repo.findById(id).orElse(null); }

    public Expense save(Expense expense) { return repo.save(expense); }

    public void delete(Long id) { repo.deleteById(id); }
}

