package com.business.gj_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.business.gj_api.models.Budget;

@Repository
public interface BudgetRepository extends JpaRepository<Long, Budget>{
    
}
