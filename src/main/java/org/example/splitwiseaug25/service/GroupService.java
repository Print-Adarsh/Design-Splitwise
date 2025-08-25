package org.example.splitwiseaug25.service;

import org.example.splitwiseaug25.dto.CreateExpenseReqDTO;
import org.example.splitwiseaug25.dto.CreateGroupReqDTO;
import org.example.splitwiseaug25.dto.UserExpenseReqDTO;
import org.example.splitwiseaug25.exception.GroupDoesNotExistException;
import org.example.splitwiseaug25.model.*;
import org.example.splitwiseaug25.repository.GroupRepository;
import org.example.splitwiseaug25.service.strategy.GroupSettlementStrategy;
import org.example.splitwiseaug25.service.strategy.MinimumTransactionSettlementStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserExpenseService userExpenseService;
    @Autowired
    private ExpenseService expenseService;
    @Autowired
    private TransactionService transactionService;

    public Group findGroupById(int id) {
        return groupRepository.findById(id).orElseThrow(
                ()-> new GroupDoesNotExistException("Group " + id + " does not exist")
        );
    }

    public Group createGroup(CreateGroupReqDTO groupReqDTO){
        Group group = new Group();
        group.setName(groupReqDTO.getName());
        User admin=userService.findUserById(groupReqDTO.getAdminId());
        group.setAdmin(admin);
        List<User>members= new ArrayList<>();
        for (Integer id: groupReqDTO.getMemberIds()){
            members.add(userService.findUserById(id));

        }
        members.add(admin);
        group.setMembers(members);
        return groupRepository.save(group);
    }

    public Expense addExpenseToGroup(CreateExpenseReqDTO reqDTO, int groupId){
        Group group = findGroupById(groupId);
        Expense expense = new Expense();

        expense.setAmount(reqDTO.getAmount());
        expense.setDescription(reqDTO.getDescription());
        expense.setEntryTime(LocalDateTime.now());
        User createdByUser=userService.findUserById(reqDTO.getCreatedByUserId());
        expense.setCreatedBy(createdByUser);

        List<UserExpense> userExpenses= new ArrayList<>();

        for(UserExpenseReqDTO userExpenseReqDTO:reqDTO.getUserExpenseDTOs()){
            UserExpense userExpense = new UserExpense();
            userExpense.setAmount(userExpenseReqDTO.getAmount());
            userExpense.setUser(userService.findUserById(userExpenseReqDTO.getUserId()));
            if(userExpenseReqDTO.getExpenseType()==1){
                userExpense.setExpenseType(UserExpenseType.PAID);
            }
            else {
                userExpense.setExpenseType(UserExpenseType.HAD_TO_PAY);
            }
            userExpense=userExpenseService.save(userExpense);
            userExpenses.add(userExpense);
        }
        // set all user expense entries in expense
        expense.setExpenseEntries(userExpenses);
        expense=expenseService.saveExpense(expense);

        group.getExpenses().add(expense);
         groupRepository.save(group);
        return expense;

    }
    public List<Transaction>settleUp(int groupId){
        Group group = findGroupById(groupId);
        GroupSettlementStrategy settlementStrategy=new MinimumTransactionSettlementStrategy();
        List<Transaction> transactions= settlementStrategy.settleUp(group);
        for(Transaction transaction:transactions){
            transaction.setGroup(group);
            transactionService.save(transaction);
        }
        return transactions;

    }


}
