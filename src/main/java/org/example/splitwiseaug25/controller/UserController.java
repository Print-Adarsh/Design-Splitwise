package org.example.splitwiseaug25.controller;

import org.example.splitwiseaug25.dto.CreateUserReqDTO;
import org.example.splitwiseaug25.dto.CreateUserRespDTO;
import org.example.splitwiseaug25.mapper.UserDTOMapper;
import org.example.splitwiseaug25.model.User;
import org.example.splitwiseaug25.repository.UserRepository;
import org.example.splitwiseaug25.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public ResponseEntity<CreateUserRespDTO> createUser(@RequestBody CreateUserReqDTO createUserReqDTO) {
        User newUser = UserDTOMapper.convertDTOTOEntity(createUserReqDTO);
        newUser=userRepository.save(newUser);
        CreateUserRespDTO createdUserResp=UserDTOMapper.convertEntityTOToDTO(newUser);
        return ResponseEntity.ok(createdUserResp);

    }


}
