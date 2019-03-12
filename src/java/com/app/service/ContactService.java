package com.app.service;

import com.app.model.Contacts;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContactService {

    @Autowired
    private SessionFactory sessionFactory;
    
    

    public void addContact(Contacts c) {
      final Session session = sessionFactory.getCurrentSession();
      session.save(c);
    }

    public List<Contacts> viewContacts() {
        final Session session = sessionFactory.getCurrentSession();
    
        final List<Contacts> cList = session.createQuery("FROM Contacts").list();
        return cList;
            
      }
     
  }

