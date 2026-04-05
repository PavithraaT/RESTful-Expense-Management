package com.example.demo.service;

import com.example.demo.dto.ExpenseDTO;
import java.util.List;

public interface ExpenseService {
    List<ExpenseDTO> getAllExpenses();
    ExpenseDTO getExpenseById(Long id);
    ExpenseDTO createExpense(ExpenseDTO expenseDTO);
    ExpenseDTO updateExpense(Long id, ExpenseDTO expenseDTO);
    void deleteExpense(Long id);
}