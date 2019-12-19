package com.example.hello.repository;

import com.example.hello.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends
        JpaRepository<User, Integer> {
    public String findUserByName(String name);
    public List<User> findAllByNameEquals(String name);
}
