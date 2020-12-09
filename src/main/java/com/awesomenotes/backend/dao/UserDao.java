package com.awesomenotes.backend.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.awesomenotes.backend.model.User;

public interface UserDao extends CrudRepository<User, Integer>{
    @Query(value = "SELECT * FROM User u WHERE u.username = ?1 and u.password = ?2", nativeQuery = true)
     User findUserbyCredentials(String username, String password);

     @Query(value = "SELECT * FROM User u WHERE u.username = ?1", nativeQuery = true)
     User findUserByUsername(String username);

}