package com.chat4chat.service.impl;

import com.chat4chat.dao.ChatDao;
import com.chat4chat.model.Chat;
import com.chat4chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    private ChatDao chatDao;

    @Autowired
    public ChatServiceImpl(ChatDao chatDao) {
        this.chatDao = chatDao;
    }

    @Override
    public void createChat(Chat chat) {
        chatDao.createChat(chat);
    }

    @Override
    public List<Chat> findChatByName(String name) {
        return chatDao.findChatByName(name);
    }

    @Override
    public List<Chat> getAllChats() {
        return chatDao.getAllChats();
    }

    @Override
    public void deleteChat(String name) {
        chatDao.deleteChat(name);
    }
}
