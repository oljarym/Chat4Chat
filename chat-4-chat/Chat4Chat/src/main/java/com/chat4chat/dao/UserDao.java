package com.chat4chat.dao;

import com.chat4chat.model.User;

import java.util.List;


public interface UserDao {

    void addUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    User findUserById(int id);
    User findUserByEmail(String email);
    List<User> findUsersFriends(User user);
    List<User> findAll();

    List<User> getAllRequestsToUser(int userId);
    List<User> getAllRequestsFromUser(int userId);
    List<User> getFriendsList(int userId);

}
