package com.example.restaurant_mobile_app;


public class Inquiry {
    private int id;
    private String name, email, subject, content;

    public Inquiry() {

    }

    public Inquiry(int id, String name, String email, String subject, String content) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.content = content;
    }

    public Inquiry(String name, String email, String subject, String content) {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

