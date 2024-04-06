package com.functionalprogramming.expense_category.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ExpenseCategoryDTO(
        UUID expenseCategoryId,
        String name
) {
}