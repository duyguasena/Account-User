package com.example.Account.User.repository;

import com.example.Account.User.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByNameandSurname(String name,String surname);
}
