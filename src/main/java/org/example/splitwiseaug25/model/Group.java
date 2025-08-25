package org.example.splitwiseaug25.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="SW_GROUP")
public class Group extends BaseModel{
    private String name;
    @ManyToOne
    private User admin;
    private String description;
    @ManyToMany
    private List<User> members ;
    @OneToMany
    @JoinColumn(name="group_id")
    private List<Expense>expenses;
}
