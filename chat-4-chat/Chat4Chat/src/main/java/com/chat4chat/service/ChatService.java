package com.chat4chat.service;

import com.chat4chat.model.Chat;

import java.util.List;


public interface ChatService {

    void createChat(Chat chat);

    List<Chat> findChatByName(String name);

    List<Chat> getAllChats();

    void deleteChat(String name);

}
