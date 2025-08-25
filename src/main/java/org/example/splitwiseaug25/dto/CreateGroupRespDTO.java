package org.example.splitwiseaug25.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateGroupRespDTO {
    private Integer groupId;
    private String groupName;
    private String adminName;
    private List<String> members;
}
