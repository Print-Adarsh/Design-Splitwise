package org.example.splitwiseaug25.repository;

import org.example.splitwiseaug25.model.Transaction;
import org.example.splitwiseaug25.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
