package com.chat4chat.dao.impl;

import com.chat4chat.dao.ChatDao;
import com.chat4chat.model.Chat;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ChatDaoImpl implements ChatDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public ChatDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public void createChat(Chat chat) {
        currentSession().save(chat);
    }



    @SuppressWarnings("unchecked")
    @Override
    public List<Chat> findChatByName(String name) {
        Criteria criteria = currentSession().createCriteria(Chat.class);
        criteria.add(Restrictions.eq("name", name));
        return criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Chat> getAllChats() {
        Criteria criteria = currentSession().createCriteria(Chat.class);
        criteria.setProjection(Projections.property("name"));
        criteria.addOrder(Order.desc("date"));
        return criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deleteChat(String name) {
        Session session = currentSession();
        Criteria criteria = session.createCriteria(Chat.class);
        criteria.add(Restrictions.eq("name", name));
        List<Chat> list = criteria.list();
        for(Chat chat : list) {
            session.delete(chat);
        }
    }
}
