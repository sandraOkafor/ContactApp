package com.app.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;
        
@Entity
@Table(name = "Users")
public class Users implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private int userID;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "username", nullable = false)
    private String username;
    
    @Column(name = "password", nullable = false)
    private String password;
//    
//    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
//    private Set<Contacts> myContacts = new HashSet<Contacts>();
    
    public Users() {
    
    }

    public Users(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Set<Contacts> getMyContacts() {
//        return myContacts;
//    }
//
//    public void setMyContacts(Set<Contacts> myContacts) {
//        this.myContacts = myContacts;
//    }
}
