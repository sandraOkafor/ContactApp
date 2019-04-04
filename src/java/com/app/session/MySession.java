package com.app.session;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MySession {
    public static HttpSession getSession() {
    return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  }

  public static HttpServletRequest getRequest() {
    return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
  }

  public static String getUserName() {
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    
    return session.getAttribute("username").toString();
  }

  public static String getContactID() {
    HttpSession session = getSession();
    if (session != null) {
      return String.valueOf(session.getAttribute("contactId"));
    } 
      
    return null;
    
  }

}
