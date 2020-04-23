package com.zeus.uaa.dao;

import com.zeus.uaa.dao.entity.User;

import java.util.List;

public interface UserDao {

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(Long userId);

    User findOne(Long userId);

    List<User> findAll();

    User findByUsername(String username);

}
