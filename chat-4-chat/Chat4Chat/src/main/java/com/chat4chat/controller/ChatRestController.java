package com.chat4chat.controller;

import com.chat4chat.model.Chat;
import com.chat4chat.service.ChatService;
import org.apache.tiles.request.collection.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/chats/")
@RestController
public class ChatRestController {

    private ChatService chatService;

    @Autowired
    public ChatRestController(ChatService chatService) {
        this.chatService = chatService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createChat(Chat chat) {

        if(chat == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        chatService.createChat(chat);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{name}/", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteChat(@PathVariable String name) {

        List<Chat> chatList = chatService.findChatByName(name);

        if(chatList != null) {
            chatService.deleteChat(name);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{name}/")
    public ResponseEntity<Void> writeIntoTheChat(@PathVariable String name, @RequestBody Chat chat) {
        if (chat == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        chatService.createChat(chat);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Chat>> getAllChats() {
        List<Chat> chats = chatService.getAllChats();
        return new ResponseEntity<>(chats, HttpStatus.OK);
    }

}
