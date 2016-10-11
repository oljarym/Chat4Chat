package com.chat4chat.service;


import com.chat4chat.model.Message;

import java.util.List;

public interface MessageService {

    List<Message> getDialogWithUser(int userId, int userId2);

    void sendMessage(Message message);

    List<Message> getAllUsersDialog(int userId);


}
