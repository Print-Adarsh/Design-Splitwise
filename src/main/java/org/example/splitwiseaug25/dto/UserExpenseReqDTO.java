package org.example.splitwiseaug25.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserExpenseReqDTO {
    private Integer userId;
    private double amount;
    // 1 paid 2 had_to_pay
    private Integer expenseType;



}
