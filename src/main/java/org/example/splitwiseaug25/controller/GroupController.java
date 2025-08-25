package org.example.splitwiseaug25.controller;

import org.example.splitwiseaug25.dto.CreateExpenseReqDTO;
import org.example.splitwiseaug25.dto.CreateGroupReqDTO;
import org.example.splitwiseaug25.dto.CreateGroupRespDTO;
import org.example.splitwiseaug25.dto.CreateUserReqDTO;
import org.example.splitwiseaug25.mapper.GroupDTOMapper;
import org.example.splitwiseaug25.model.Expense;
import org.example.splitwiseaug25.model.Group;
import org.example.splitwiseaug25.model.Transaction;
import org.example.splitwiseaug25.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupController {
    @Autowired
    private GroupService groupService;

    @PostMapping("/group")
    public ResponseEntity<CreateGroupRespDTO> createGroup(@RequestBody CreateGroupReqDTO groupReqDTO) {
        Group createdGroup = groupService.createGroup(groupReqDTO);
        CreateGroupRespDTO responseDTO = GroupDTOMapper.convertEntityToDTO(createdGroup);
        return ResponseEntity.ok(responseDTO);

    }

    @PostMapping("/expense/{id}")
    public ResponseEntity addExpenseToGroup(@RequestBody CreateExpenseReqDTO reqDTO, @PathVariable("id") int groupId){

        Expense savedExpense = groupService.addExpenseToGroup(reqDTO, groupId);
        if(savedExpense != null){
            return ResponseEntity.ok("Expense added successfully");
        }
        else{
            return ResponseEntity.ok("Expense not added successfully");
        }

    }
    @GetMapping("/group/settle/{id}")
    public ResponseEntity settleUp(@PathVariable("id") int groupId){
        List<Transaction> transactions=groupService.settleUp(groupId);
        return ResponseEntity.ok(transactions);
    }
}
