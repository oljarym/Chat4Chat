package com.chat4chat.service.impl;

import com.chat4chat.dao.FriendDao;
import com.chat4chat.model.Friend;
import com.chat4chat.model.User;
import com.chat4chat.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendServiceImpl implements FriendService {

    private FriendDao friendDao;

    @Autowired
    public FriendServiceImpl(FriendDao friendDao) {
        this.friendDao = friendDao;
    }

    @Override
    public void addFriend(Friend friend) {
        friendDao.addFriend(friend);
    }

    @Override
    public void approveFriendRequest(Friend friend) {
        friendDao.addFriend(friend);
    }

    @Override
    public void deleteFromFriendsList(Friend friend) {
        friendDao.deleteFromFriendsList(friend);
    }
}
