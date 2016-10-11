package com.chat4chat.controller;

import com.chat4chat.model.Friend;
import com.chat4chat.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/friends/")
public class FriendRestController {

    private final FriendService friendService;

    @Autowired
    public FriendRestController(FriendService service) {
        this.friendService = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> addFriend(@RequestBody Friend friends) {
        friendService.addFriend(friends);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> approveFriendsRequest(@RequestBody Friend friends) {
        friendService.approveFriendRequest(friends);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@RequestBody Friend friend) {
        friendService.deleteFromFriendsList(friend);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
