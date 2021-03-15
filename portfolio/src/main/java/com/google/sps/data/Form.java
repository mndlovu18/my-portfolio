package com.google.sps.data;

/** An item on the form list. */
public final class Form {

  private final long id;
  private final String name;
  private final String email;
  private final String subject;
  private final String message;

  

  public Form(long id, String name, String email, String 
  subject, String message) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.subject = subject;
    this.message = message;
  }
}