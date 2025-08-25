package org.example.splitwiseaug25.repository;

import org.example.splitwiseaug25.model.Expense;
import org.example.splitwiseaug25.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
}
