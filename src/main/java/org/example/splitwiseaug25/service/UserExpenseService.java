package org.example.splitwiseaug25.service;

import org.example.splitwiseaug25.model.UserExpense;
import org.example.splitwiseaug25.repository.UserExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserExpenseService {
    @Autowired
    private UserExpenseRepository userExpenseRepository;
    public UserExpense save(UserExpense userExpense) {
        return userExpenseRepository.save(userExpense);
    }
}
