package com.functionalprogramming.expense_type.model;

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
@Entity(name = "ExpenseType")
@Table(name = "expense_types")
public class ExpenseType {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "expense_type_id", updatable = false, nullable = false)
    private UUID expenseTypeId;

    @Column(name = "type_name", nullable = false)
    private String typeName;
}