package com.functionalprogramming.expense_category.mapper;

import com.functionalprogramming.expense_category.dto.ExpenseCategoryDTO;
import com.functionalprogramming.expense_category.model.ExpenseCategory;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ExpenseCategoryDTOMapper implements Function<ExpenseCategory, ExpenseCategoryDTO> {
    @Override
    public ExpenseCategoryDTO apply(ExpenseCategory expenseCategory) {
        return new ExpenseCategoryDTO(

                expenseCategory.getCategoryId(),
                expenseCategory.getCategoryName()
        );
    }
}