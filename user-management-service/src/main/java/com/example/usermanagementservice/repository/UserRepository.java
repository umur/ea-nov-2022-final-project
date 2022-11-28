package com.example.usermanagementservice.repository;


import com.example.usermanagementservice.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface UserRepository {

    long save(User user);

    Optional<User> findById(long id);

    List<User> findAll();

    Page<User> loadUsers(Pageable pageable);

    Page<User> searchUserByName(String name, Pageable pageable);

    void removeUser(Long id);

}
