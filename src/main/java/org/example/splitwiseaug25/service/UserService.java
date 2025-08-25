package org.example.splitwiseaug25.service;

import org.example.splitwiseaug25.exception.UserDoesNotExistException;
import org.example.splitwiseaug25.model.User;
import org.example.splitwiseaug25.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(
                () -> new UserDoesNotExistException("User with id " + id + " not found")
        );

    }

}
