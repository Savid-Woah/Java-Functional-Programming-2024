package com.functionalprogramming.expense_category.service;

import com.functionalprogramming.expense_category.dto.ExpenseCategoryDTO;
import com.functionalprogramming.expense_category.mapper.ExpenseCategoryDTOMapper;
import com.functionalprogramming.expense_category.model.ExpenseCategory;
import com.functionalprogramming.expense_category.repository.ExpenseCategoryRepository;
import com.functionalprogramming.expense_category.request.ExpenseCategoryRequest;
import com.functionalprogramming.exception.BackendException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

import static com.functionalprogramming.exception.MsgCode.CUSTOMER_ALREADY_EXISTS;
import static com.functionalprogramming.response.Response.generateResponse;

@Service
@Transactional
@RequiredArgsConstructor
public class ExpenseCategoryService {

    private final ExpenseCategoryDTOMapper expenseCategoryDTOMapper;
    private final ExpenseCategoryRepository expenseCategoryRepository;

    public Page<ExpenseCategoryDTO> getAllExpenseCategories(Integer pageNumber, Integer pageSize) {

        return expenseCategoryRepository.findAll(PageRequest.of(pageNumber, pageSize))
                .map(expenseCategoryDTOMapper);
    }


    public Map<String, Object> addExpenseCategory(ExpenseCategoryRequest expenseCategoryRequest) {

        String name = expenseCategoryRequest.getName();
        Optional<ExpenseCategory> expenseCategory = expenseCategoryRepository.findByNameIgnoreCase(name);

        if(expenseCategory.isEmpty()) {

            ExpenseCategory newExpenseCategory = new ExpenseCategory(expenseCategoryRequest);
            ExpenseCategory savedExpenseCategory = expenseCategoryRepository.save(newExpenseCategory);
            return generateResponse(savedExpenseCategory, "Expense category created successfully!");
        }
        else {
            throw new BackendException(CUSTOMER_ALREADY_EXISTS);
        }
    }
}