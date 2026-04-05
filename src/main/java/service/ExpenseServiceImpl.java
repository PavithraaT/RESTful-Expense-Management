package com.example.demo.service;

import com.example.demo.dto.ExpenseDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Expense;
import com.example.demo.repository.ExpenseRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository repo;

    public ExpenseServiceImpl(ExpenseRepository repo) { this.repo = repo; }

    private ExpenseDTO mapToDTO(Expense expense) {
        return new ExpenseDTO(expense.getId(), expense.getTitle(), expense.getAmount(), expense.getCategory());
    }

    private Expense mapToEntity(ExpenseDTO dto) {
        Expense e = new Expense();
        e.setId(dto.getId());
        e.setTitle(dto.getTitle());
        e.setAmount(dto.getAmount());
        e.setCategory(dto.getCategory());
        return e;
    }

    @Override
    public List<ExpenseDTO> getAllExpenses() {
        return repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public ExpenseDTO getExpenseById(Long id) {
        Expense e = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Expense not found with id: " + id));
        return mapToDTO(e);
    }

    @Override
    public ExpenseDTO createExpense(ExpenseDTO expenseDTO) {
        Expense e = repo.save(mapToEntity(expenseDTO));
        return mapToDTO(e);
    }

    @Override
    public ExpenseDTO updateExpense(Long id, ExpenseDTO expenseDTO) {
        Expense e = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Expense not found with id: " + id));
        e.setTitle(expenseDTO.getTitle());
        e.setAmount(expenseDTO.getAmount());
        e.setCategory(expenseDTO.getCategory());
        return mapToDTO(repo.save(e));
    }

    @Override
    public void deleteExpense(Long id) {
        if(!repo.existsById(id)) throw new ResourceNotFoundException("Expense not found with id: " + id);
        repo.deleteById(id);
    }
}