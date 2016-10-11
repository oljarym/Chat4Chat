package com.chat4chat.dao.impl;

import com.chat4chat.dao.FriendDao;
import com.chat4chat.model.Friend;
import com.chat4chat.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FriendDaoImpl implements FriendDao {

    private  SessionFactory sessionFactory;

    @Autowired
    public FriendDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public FriendDaoImpl() {
        super();
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addFriend(Friend friend) {
        currentSession().save(friend);
    }

    @Override
    public void deleteFromFriendsList(Friend friend) {
        currentSession().delete(friend);
    }
}
