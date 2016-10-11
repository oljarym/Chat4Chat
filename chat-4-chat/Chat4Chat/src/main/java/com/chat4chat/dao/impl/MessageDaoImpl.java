package com.chat4chat.dao.impl;

import com.chat4chat.dao.MessageDao;
import com.chat4chat.model.Message;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageDaoImpl implements MessageDao {


    private SessionFactory sessionFactory;

    @Autowired
    public MessageDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @SuppressWarnings("unchecked") //
    public List<Message> getDialogWithUser(int userId, int userId2) {
        Criteria criteria = currentSession().createCriteria(Message.class);
        Criterion criterion1 = Restrictions.and(Restrictions.eq("user_1", userId), Restrictions.eq("user_2", userId2));
        Criterion criterion2 = Restrictions.and(Restrictions.eq("user_1", userId2), Restrictions.eq("user_2", userId));
        criteria.add(Restrictions.or(criterion1, criterion2));
        return criteria.list();
    }

    @Override
    public void sendMassage(Message message) {
        currentSession().saveOrUpdate(message);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Message> getAllUsersDialog(int userId) {
//// TODO: 27.09.2016
        Criteria criteria = currentSession().createCriteria(Message.class);
        Criterion criterion1 = Restrictions.eq("user_1", userId);
        Criterion criterion2 = Restrictions.eq("user_2", userId);
        criteria.add(Restrictions.or(criterion1, criterion2));
        return criteria.list();
    }
}
