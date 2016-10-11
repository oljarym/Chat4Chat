package com.chat4chat.dao;


import com.chat4chat.model.Friend;
import com.chat4chat.model.User;

import java.util.List;

public interface FriendDao {

    void addFriend(Friend friend);

    void deleteFromFriendsList(Friend friend);
}
