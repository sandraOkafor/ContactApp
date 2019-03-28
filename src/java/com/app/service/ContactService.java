package com.app.service;

import com.app.model.Contacts;
import com.app.model.Users;
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
    private Contacts c;
    private Users user;
        

    public void addContact(Object us) {
      final Session session = sessionFactory.getCurrentSession();
      us = session.get(Contacts.class, user);
      session.save(us);
    }

    public List<Contacts> viewContacts() {
        final Session session = sessionFactory.getCurrentSession();
    
        final List<Contacts> cList = session.createQuery("FROM Contacts").list();
        return cList;
            
    }
    
    public void save(Integer id, String title, String firstName, String lastName, String gender, String phone, String address, String addy, String birthDate, String rship) {
        final Session session = sessionFactory.getCurrentSession();
        Contacts con = (Contacts) session.get(Contacts.class, id);
        con.setTitle(title);
        con.setFirstName(firstName);
        con.setLastName(lastName);
        con.setGender(gender);
        con.setPhone(phone);
        con.setAddress(address);
        con.setAddy(addy);
        con.setBirthDate(birthDate);
        con.setRship(rship);
        session.update(con);
    }
    

   public void delete(){
       c= new Contacts();
       viewContacts().remove(c);
   }
   
    
  }

