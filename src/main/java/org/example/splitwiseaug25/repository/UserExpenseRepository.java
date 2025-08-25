package org.example.splitwiseaug25.repository;

import org.example.splitwiseaug25.model.User;
import org.example.splitwiseaug25.model.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserExpenseRepository extends JpaRepository<UserExpense, Integer> {
}
