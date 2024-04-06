package com.functionalprogramming.expense_category.model;

import com.functionalprogramming.expense_category.request.ExpenseCategoryRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ExpenseCategory")
@Table(name = "expense_categories")
public class ExpenseCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "category_id", updatable = false, nullable = false)
    private UUID categoryId;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    public ExpenseCategory(ExpenseCategoryRequest expenseCategoryRequest) {
        this.categoryName = expenseCategoryRequest.getName();
    }
}