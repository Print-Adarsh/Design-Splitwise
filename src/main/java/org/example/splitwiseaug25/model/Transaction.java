package org.example.splitwiseaug25.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="SW_TRANSACTION")

public class Transaction extends  BaseModel{
    @ManyToOne
    private User sender;
    @ManyToOne
    private User recipient;
    private double amount;
    @ManyToOne
    private Group group;

    public Transaction() {

    }
    public Transaction(User sender, User recipient, double amount) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
    }
}
