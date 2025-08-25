package org.example.splitwiseaug25.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "SW_USER")

public class User extends  BaseModel{
    private String name;
    private String email;
    private String password;


}
