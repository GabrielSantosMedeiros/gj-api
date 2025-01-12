package com.business.gj_api.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.business.gj_api.models.Budget;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
    
}
