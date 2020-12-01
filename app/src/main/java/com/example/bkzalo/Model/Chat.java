package com.example.bkzalo.Model;

public class Chat {

    //fields
    private String sender;
    private String receiver;
    private String message;
    private boolean isSeen;

    //constructors
    public Chat(){

    }

    public Chat(String sender, String receiver, String message, boolean isSeen) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.isSeen = isSeen;
    }

    //getters and setters

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getIsSeen(){
        return isSeen;
    }

    public void setIsSeen(boolean isSeen){
        this.isSeen = isSeen;
    }
}
