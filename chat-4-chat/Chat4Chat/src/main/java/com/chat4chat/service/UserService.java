package com.chat4chat.service;

import com.chat4chat.model.User;

import java.util.List;


public interface UserService {

    void addUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    User findUserById(int id);
    User findUserByEmail(String email);

    List<User> findAll();



}
