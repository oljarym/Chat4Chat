package com.chat4chat.dao;

import com.chat4chat.model.Chat;

import java.util.List;


public interface ChatDao {

    void createChat(Chat chat);

    List<Chat> findChatByName(String name);

    List<Chat> getAllChats();

    void deleteChat(String name);
}
