package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
      // Sanitize user input to remove HTML tags and JavaScript.
    String name = Jsoup.clean(request.getParameter("name"), Whitelist.none());
    String email = Jsoup.clean(request.getParameter("email"), Whitelist.none());
    String subject = Jsoup.clean(request.getParameter("subject"), Whitelist.none());
    String message = Jsoup.clean(request.getParameter("message"), Whitelist.none());

    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Form");
    FullEntity formEntity = 
          Entity.newBuilder(keyFactory.newKey())
               .set("name", name)
               .set("email", email)
               .set("subject", subject)
               .set("message", message)
               .build();
        datastore.put(formEntity);
        response.sendRedirect("/index.html");
    // Get the value entered in the form.
    String textValue = request.getParameter("message");
    String nameValue = request.getParameter("name");
    String emailValue = request.getParameter("email");
    String subjectValue = request.getParameter("subject");

    // Print the value so you can see it in the server logs.
    System.out.println("Name: " + nameValue + "\n" + "Email: " + emailValue 
    + "\n" + "Subject: " + subjectValue + "\n" + "Message: " + textValue);
    

    // Write a message to let the user know their submission has been received.
    response.getWriter().println("Your submission has been received!");
  }
}