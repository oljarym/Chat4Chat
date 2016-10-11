package com.chat4chat.controller;

import com.chat4chat.model.Message;
import com.chat4chat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/message/{userId}/")
@RestController
public class MessageRestController {

    private MessageService messageService;

    @Autowired
    public MessageRestController(MessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping(value = "{userId2}/", method = RequestMethod.POST)
    public ResponseEntity<Void> sendMessage(@PathVariable int userId, @PathVariable int userId2,
                                            @RequestBody Message message) {

        if (message == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        messageService.sendMessage(message);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "{userId2}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Message>> getDialogWithUser(@PathVariable int userId, @PathVariable int userId2) {

        List<Message> messageList = messageService.getDialogWithUser(userId, userId2);
        if (messageList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(messageList, HttpStatus.OK);
    }

    @RequestMapping(value = "{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Message>> getAllUsersDialog(@PathVariable int userId) {

        List<Message> messageList = messageService.getAllUsersDialog(userId);
        if (messageList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(messageList, HttpStatus.OK);
    }


}
