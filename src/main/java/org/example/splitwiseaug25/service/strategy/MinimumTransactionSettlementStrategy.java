package org.example.splitwiseaug25.service.strategy;

import org.example.splitwiseaug25.dto.UserExpenseHeapEntry;
import org.example.splitwiseaug25.model.*;

import java.util.*;

public class MinimumTransactionSettlementStrategy implements GroupSettlementStrategy{

    private PriorityQueue<UserExpenseHeapEntry>borrowersMinHeap;
    private PriorityQueue<UserExpenseHeapEntry>lendorsMaxHeap;
    private HashMap<User,Double>userAmountMap;

    public MinimumTransactionSettlementStrategy() {
        borrowersMinHeap = new PriorityQueue<>(Comparator.comparingDouble(UserExpenseHeapEntry::getAmount));
        lendorsMaxHeap = new PriorityQueue<>(Comparator.comparingDouble(UserExpenseHeapEntry::getAmount).reversed());
        userAmountMap = new HashMap<>();
    }
    @Override
    public List<Transaction> settleUp(Group group) {
        List<Expense>expenses = group.getExpenses();
        for(Expense expense : expenses){
            for(UserExpense userExpense : expense.getExpenseEntries()){
                User user = userExpense.getUser();
                double amount = userExpense.getAmount();
                if(userExpense.getExpenseType().equals(UserExpenseType.HAD_TO_PAY)){
                    amount= -1 * amount;
                }
                double mapAmount = userAmountMap.getOrDefault(user,0.0);
                mapAmount += amount;
                userAmountMap.put(user,mapAmount);
            }
        }
       // inserting in heaps
        for(Map.Entry<User,Double> entry : userAmountMap.entrySet()){
            if(entry.getValue() > 0){
                UserExpenseHeapEntry heapEntry = new UserExpenseHeapEntry(entry.getKey(),entry.getValue());
                lendorsMaxHeap.add(heapEntry);
            } else if (entry.getValue() < 0){
                UserExpenseHeapEntry heapEntry = new UserExpenseHeapEntry(entry.getKey(),entry.getValue());
                borrowersMinHeap.add(heapEntry);
            }
            else
            {
                // condition - amount=0;
            }
        }
        return settleHeaps(borrowersMinHeap,lendorsMaxHeap);

    }
    private List<Transaction> settleHeaps(PriorityQueue<UserExpenseHeapEntry>borrowersMinHeap,PriorityQueue<UserExpenseHeapEntry>lendorsMaxHeap){
        List<Transaction>transactions = new ArrayList<Transaction>();
        while(!borrowersMinHeap.isEmpty()){
            UserExpenseHeapEntry borrower = borrowersMinHeap.poll();
            UserExpenseHeapEntry lendor = lendorsMaxHeap.poll();
            if(Math.abs(borrower.getAmount())>lendor.getAmount()){
                Transaction t= new Transaction(borrower.getUser(), lendor.getUser(), lendor.getAmount());
                transactions.add(t);
                borrower.setAmount(borrower.getAmount()+lendor.getAmount());
                borrowersMinHeap.add(borrower);
            }
            else if(Math.abs(borrower.getAmount())<lendor.getAmount()){
                Transaction t= new Transaction(lendor.getUser(), borrower.getUser(), Math.abs(borrower.getAmount()));
                transactions.add(t);
                lendor.setAmount(lendor.getAmount()+borrower.getAmount());
                lendorsMaxHeap.add(lendor);

            }
            else{
                Transaction t= new Transaction(borrower.getUser(), lendor.getUser(), lendor.getAmount());
                transactions.add(t);
            }
        }
        return transactions;
    }

}
