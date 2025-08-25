package org.example.splitwiseaug25.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateGroupReqDTO {
   private String name;
   private Integer adminId; // admin=user id
   private List<Integer> memberIds; // member-user id
}
