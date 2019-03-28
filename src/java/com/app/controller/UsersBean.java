package com.app.controller;

import com.app.model.Users;
import com.app.service.UsersService;
import com.app.session.MySession;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Named
@RequestScoped
public class UsersBean implements Serializable {
    
    private static final long serialVersionUID = 1094801825228386363L;
 
    @Autowired
    private UsersService us;
    
    private String name;
    private String username;
    private String password;
;
    public String save() {
      if (username.isEmpty() || password.isEmpty()) {
        return "error";
      }

      Users user = new Users(name, username, password);
      us.saveUser(user);

      return "Login";
    }
    
    public String login() {
        Users user = us.login(username, password);
        if (user != null) {
            HttpSession session = MySession.getSession();
            session.setAttribute("userId", user.getUserID());
            setUsersBean(user);
            return "CreateContact";
        } else {
            FacesContext.getCurrentInstance().addMessage(
          null,
          new FacesMessage(FacesMessage.SEVERITY_WARN, "Invalid login", "Please enter correct Username and Password"));

            return "Login";
        }
        
    }
    
    private void setUsersBean(Users user) {
        setName(user.getName());
        setUsername(user.getUsername());
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
  
}