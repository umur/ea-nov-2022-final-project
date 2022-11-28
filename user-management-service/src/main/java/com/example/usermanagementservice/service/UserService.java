package com.example.usermanagementservice.service;


import com.example.usermanagementservice.entity.User;
import com.example.usermanagementservice.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long registerUser(User user){
        //do first check

        //do second check

        // persist data
        return userRepository.save(user);
    }

    public Optional<User> loadById(Long id){
        return userRepository.findById(id);
    }


    public Page<User> loadAll(Pageable pageable){
        return userRepository.loadUsers(pageable);
    }

    public Page<User> loadAllByName(String name,Pageable pageable){
        return userRepository.searchUserByName(name,pageable);
    }

    public void unregisterUser(Long id){
        userRepository.removeUser(id);
    }
}
