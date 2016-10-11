package com.chat4chat.service.impl;

import com.chat4chat.dao.MessageDao;
import com.chat4chat.model.Message;
import com.chat4chat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageDao messageDao;

    @Autowired
    public MessageServiceImpl(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    public List<Message> getDialogWithUser(int userId, int userId2) {
        return messageDao.getDialogWithUser(userId, userId2);
    }

    @Override
    public void sendMessage(Message message) {
        messageDao.sendMassage(message);
    }

    @Override
    public List<Message> getAllUsersDialog(int userId) {
        return messageDao.getAllUsersDialog(userId);
    }
}
