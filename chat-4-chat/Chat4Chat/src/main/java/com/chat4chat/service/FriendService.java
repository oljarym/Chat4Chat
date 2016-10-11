package com.chat4chat.service;


import com.chat4chat.model.Friend;
import com.chat4chat.model.User;

import java.util.List;

public interface FriendService {

    void addFriend(Friend friend);

    void approveFriendRequest(Friend friend);

    void deleteFromFriendsList(Friend friend);
}
