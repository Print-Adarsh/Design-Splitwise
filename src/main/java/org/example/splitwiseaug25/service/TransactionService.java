package org.example.splitwiseaug25.service;

import org.example.splitwiseaug25.model.Transaction;
import org.example.splitwiseaug25.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction save(Transaction transaction) {

        return transactionRepository.save(transaction);
    }
}
