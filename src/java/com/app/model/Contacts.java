package com.app.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Contacts")
public class Contacts implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private int contactID;
    
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "first_name", nullable = false)
    private String firstName;
    
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @Column(name = "gender", nullable = false)
    private String gender;
    
    @Column(name = "phone_no", nullable = false)
    private String phone;
    
    @Column(name = "address", nullable = false)
    private String address;
    
    @Column(name = "email_address", nullable = false)
    private String addy;

    @Column(name = "birth_date", nullable = false)
    private String birthDate;
    
    @Column(name = "relationship", nullable = false)
    private String rship;
    
    @ManyToOne
    @JoinColumn(name="userID")
    private Users user;

    public Contacts() {
    }

    public Contacts(String title, String firstName, String lastName, String gender, String phone, String address, String addy, String birthDate, String rship) {
//        this.user=user;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.addy = addy;
        this.birthDate = birthDate;
        this.rship = rship;
     
    }
    
  
    public int getContactID() {
      return contactID;
    }
    public void setContactID(int contactID) {
      this.contactID = contactID;
    }

    public String getTitle() {
      return title;
    }
    public void setTitle(String title) {
      this.title = title;
    }

    public String getFirstName() {
      return firstName;
    }
    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }
    
    public String getLastName() {
      return lastName;
    }
    public void setLastName(String lastName) {
      this.lastName = lastName;
    }
    
    public String getGender() {
      return gender;
    }
    public void setGender(String gender) {
      this.gender = gender;
    }
    
    public String getPhone() {
      return phone;
    }
    public void setPhone(String phone) {
      this.phone = phone;
    }
    
    public String getAddress() {
      return address;
    }
    public void setAddress(String address) {
      this.address = address;
    }
    
    public String getAddy() {
      return addy;
    }
    public void setAddy(String addy) {
      this.addy = addy;
    }
    
    public String getBirthDate() {
      return birthDate;
    }
    
    public void setBirthDate(String birthDate) {
      this.birthDate = birthDate;
    }
    
    public String getRship() {
      return rship;
    }
    
    public void setRship(String rship) {
      this.rship = rship;
    }
    
    public Users getUser() {
      return user;
    }
    
    public void setUser(Users user) {
      this.user = user;
    }

}
