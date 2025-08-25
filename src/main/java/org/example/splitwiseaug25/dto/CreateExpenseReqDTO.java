package org.example.splitwiseaug25.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateExpenseReqDTO {
    private String description;
    private Double amount;
    private Integer createdByUserId;
   private List<UserExpenseReqDTO> userExpenseDTOs;

}
