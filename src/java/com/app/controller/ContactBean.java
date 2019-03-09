package com.app.controller;

import com.app.model.Contacts;
import com.app.service.ContactService;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Named
@RequestScoped
public class ContactBean {
    
    @Autowired
    private ContactService cs;

    private String title;
    private String firstName;
    private String lastName;
    private String gender;
    private String phone;
    private String address;
    private String addy;
    private String birthDate;
    private String rship;

    public String addContact() {
      if (firstName.isEmpty() || phone.isEmpty()) {
        return "error";
      }

      Contacts c = new Contacts(title, firstName, lastName, gender, phone, address, addy, birthDate, rship);
      cs.addContact(c);
      return "Success";
    }
    
    public String viewContact() {
        Contacts c = new Contacts(title, firstName, lastName, gender, phone, address, addy, birthDate, rship);
        cs.viewContacts();
        return "ViewContacts";
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
}