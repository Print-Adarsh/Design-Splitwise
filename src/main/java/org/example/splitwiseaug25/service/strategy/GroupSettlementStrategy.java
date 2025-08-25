package org.example.splitwiseaug25.service.strategy;

import org.example.splitwiseaug25.model.Group;
import org.example.splitwiseaug25.model.Transaction;

import java.util.List;

public interface GroupSettlementStrategy {
    List<Transaction> settleUp(Group group);

}
