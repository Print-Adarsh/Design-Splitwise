package org.example.splitwiseaug25.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.splitwiseaug25.model.User;

@Getter
@Setter
public class UserExpenseHeapEntry {
    private User user;
    private Double amount;

    public UserExpenseHeapEntry(User user, Double amount) {
        this.user = user;
        this.amount = amount;
    }
    public UserExpenseHeapEntry() {

    }
}
