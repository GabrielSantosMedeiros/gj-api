package com.business.gj_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.business.gj_api.models.Budget;
import com.business.gj_api.repositories.BudgetRepository;

@RestController
@RequestMapping("/budget")
public class BudgetController {
    
    @Autowired
    private BudgetRepository budgetRepository;

    @GetMapping
    @ResponseBody
    private List<Budget> getAll() {
        return budgetRepository.findAll();
    }

    @PostMapping
    private Budget newBudget(@RequestBody Budget budget) {
        return budgetRepository.save(budget);
    }
}
