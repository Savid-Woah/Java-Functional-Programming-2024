package com.functionalprogramming.expense_category.repository;

import com.functionalprogramming.expense_category.model.ExpenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ExpenseCategoryRepository extends JpaRepository<ExpenseCategory, UUID> {
    Optional<ExpenseCategory> findByNameIgnoreCase(String name);
}