package com.business.gj_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.business.gj_api.handlers.EmailHandler;
import com.business.gj_api.models.Budget;
import com.business.gj_api.repositories.BudgetRepository;

@RestController
@RequestMapping("/budget")
public class BudgetController {
    
    @Autowired
    private BudgetRepository budgetRepository;

    private EmailHandler emailHandler = new EmailHandler();

    @GetMapping
    @ResponseBody
    private List<Budget> getAll() {
        return budgetRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    private Budget getById(@PathVariable(value="id") String id) {
        return budgetRepository.findById(id).get();
    }

    @PostMapping
    private Budget newBudget(@RequestBody Budget budget) {
        Budget savedBudget = budgetRepository.save(budget);
        emailHandler.sendEmailToNewBudget(savedBudget);
        return savedBudget;
    }

    @PutMapping("/{id}")
    private Budget editBudget(@PathVariable(value="id") String id, @RequestBody Budget budget) throws Exception {
        Budget oldBudget = budgetRepository.findById(id).get();
        if (budget.getName()!=null || !budget.getName().equals("")) oldBudget.setName(budget.getName());
        if (budget.getCompany()!=null || !budget.getCompany().equals("")) oldBudget.setCompany(budget.getCompany());
        if (budget.getEmail()!=null || !budget.getEmail().equals("")) oldBudget.setEmail(budget.getEmail());
        if (budget.getNumberPhone()!=null || !budget.getNumberPhone().equals("")) oldBudget.setNumberPhone(budget.getNumberPhone());
        return budgetRepository.save(oldBudget);
    }
}
