package com.example.usermanagementservice.repository.jpa;

import com.example.usermanagementservice.entity.User;
import com.example.usermanagementservice.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserRepositoryJPAImp implements UserRepository {

    private final UserRepositoryJPA userRepositoryJPASpring;

    public UserRepositoryJPAImp(UserRepositoryJPA userRepositoryJPASpring) {
        this.userRepositoryJPASpring = userRepositoryJPASpring;
    }

    @Override
    public long save(User user) {
        User saved = userRepositoryJPASpring.save(user);
        return saved.getId();
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepositoryJPASpring.findById(id);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(userRepositoryJPASpring.findAll());
    }

    @Override
    public Page<User> loadUsers(Pageable pageable) {
        return userRepositoryJPASpring.findAll(pageable);
    }

    @Override
    public Page<User> searchUserByName(String name, Pageable pageable) {

        return userRepositoryJPASpring
                .findByName(name, pageable);
    }

    @Override
    public void removeUser(Long id) {
        userRepositoryJPASpring.deleteById(id);
    }
}