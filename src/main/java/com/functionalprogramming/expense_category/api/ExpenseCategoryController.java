package com.functionalprogramming.expense_category.api;

import com.functionalprogramming.expense_category.dto.ExpenseCategoryDTO;
import com.functionalprogramming.expense_category.service.ExpenseCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("financial/api/v1/expense-categories/")
public class ExpenseCategoryController {

    private final ExpenseCategoryService expenseCategoryService;

    @GetMapping(path = "{page-number}/{page-size}")
    public Page<ExpenseCategoryDTO> getAllExpenseCategories(

            @PathVariable("page-number") Integer pageNumber,
            @PathVariable("page-size") Integer pageSize
    ) {
        return expenseCategoryService.getAllExpenseCategories(pageNumber, pageSize);
    }
}