package org.example.splitwiseaug25.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Expense extends  BaseModel{
    private String description;
    private double amount;
    private LocalDateTime entryTime;
    @ManyToOne
    private User createdBy;
    @OneToMany
    @JoinColumn(name="expense_id")
    private List<UserExpense> expenseEntries;
}
