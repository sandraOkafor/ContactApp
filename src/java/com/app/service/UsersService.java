package com.app.service;

import com.app.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsersService {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    public void saveUser(Users user) {
        final Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }
    
    public Users login(String username, String password) {
        final Session session = sessionFactory.getCurrentSession();
        final Users user = (Users) session.createQuery("SELECT u FROM Users u "
            + "WHERE u.username = :username "
            + "AND u.password = :password")
            .setParameter("username", username)
            .setParameter("password", password)
                .uniqueResult();

        return user;
    }
    
}
