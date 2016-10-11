package com.chat4chat.dao.impl;


import com.chat4chat.dao.UserDao;
import com.chat4chat.model.User;
import com.sun.xml.internal.bind.v2.TODO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

    private final SessionFactory sessionFactory;

    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserDaoImpl(PasswordEncoder passwordEncoder, SessionFactory sessionFactory) {
        this.passwordEncoder = passwordEncoder;
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        currentSession().saveOrUpdate(user);
    }

    @Override
    public void updateUser(User user) {
        currentSession().saveOrUpdate(user);
    }

    @Override
    public void deleteUser(User user) {
        currentSession().delete(user);
    }

    @Override
    public User findUserById(int id) {
        Criteria criteria = currentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("id_user", id));
        return (User) criteria.uniqueResult();
    }

    @Override
    public User findUserByEmail(String email) {
        Criteria criteria = currentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("email", email));
        return (User) criteria.uniqueResult();
    }

    @Override
    public List<User> findUsersFriends(User user) {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        return currentSession().createQuery("from User").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllRequestsToUser(int userId) {
        return null; // TODO
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllRequestsFromUser(int userId) {
        return null; // TODO
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getFriendsList(int userId) {
        return null;// TODO
    }
}
