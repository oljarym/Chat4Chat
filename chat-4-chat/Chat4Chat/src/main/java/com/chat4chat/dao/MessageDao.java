package com.chat4chat.dao;

import com.chat4chat.model.Message;
import com.chat4chat.model.User;

import java.util.List;


public interface MessageDao {

    List<Message> getDialogWithUser(int userId, int userId2);

    void sendMassage(Message message);

    List<Message> getAllUsersDialog(int userId);

}
