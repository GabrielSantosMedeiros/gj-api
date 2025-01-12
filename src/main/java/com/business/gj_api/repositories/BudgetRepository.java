package com.business.gj_api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.business.gj_api.models.Budget;

public interface BudgetRepository extends MongoRepository<Budget, String> {
    
}
