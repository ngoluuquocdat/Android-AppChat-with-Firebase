package com.example.bkzalo.Model;

public class User {

    //fields
    private String id;
    private String username;
    private String imageURL;
    private String status;      // online or offline

    // constructors
    public User(){

    }

    public User(String id, String username, String imageURL, String status) {
        this.id = id;
        this.username = username;
        this.imageURL = imageURL;
        this.status = status;
    }
    // getters and setters
    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getStatus(){return status;}

    public void setId(String id) { this.id = id; }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setStatus(String status){ this.status = status;}
}
