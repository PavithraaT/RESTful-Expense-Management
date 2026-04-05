package com.example.demo.controller;

import com.example.demo.dto.ExpenseDTO;
import com.example.demo.service.ExpenseService;
import org.springframework.web.bind.annotation.*;
        import java.util.List;

@RestController
@RequestMapping("/api/v1/expenses")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) { this.service = service; }

    @GetMapping
    public List<ExpenseDTO> getAll() { return service.getAllExpenses(); }

    @GetMapping("/{id}")
    public ExpenseDTO getById(@PathVariable Long id) { return service.getExpenseById(id); }

    @PostMapping
    public ExpenseDTO create(@RequestBody ExpenseDTO dto) { return service.createExpense(dto); }

    @PutMapping("/{id}")
    public ExpenseDTO update(@PathVariable Long id, @RequestBody ExpenseDTO dto) {
        return service.updateExpense(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.deleteExpense(id); }
}