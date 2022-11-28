package com.example.usermanagementservice.repository.jpa;

import com.example.usermanagementservice.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepositoryJPA extends JpaRepository<User,Long> {
    Page<User> findByName(String name, Pageable pageable);
}
