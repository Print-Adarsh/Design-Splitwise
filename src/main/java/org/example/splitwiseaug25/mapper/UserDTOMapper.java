package org.example.splitwiseaug25.mapper;

import org.example.splitwiseaug25.dto.CreateUserReqDTO;
import org.example.splitwiseaug25.dto.CreateUserRespDTO;
import org.example.splitwiseaug25.model.User;

public class UserDTOMapper
{
    public static User convertDTOTOEntity(CreateUserReqDTO createUserReqDTO){
        User user = new User();
        user.setName(createUserReqDTO.getName());
        user.setEmail(createUserReqDTO.getEmail());
        user.setPassword(createUserReqDTO.getPassword());
        return user;
    }

    public static CreateUserRespDTO convertEntityTOToDTO(User user){
        CreateUserRespDTO createUserRespDTO = new CreateUserRespDTO();
        createUserRespDTO.setUserId(user.getId());
        createUserRespDTO.setName(user.getName());
        createUserRespDTO.setEmail(user.getEmail());
        return createUserRespDTO;

    }
}
