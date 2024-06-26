package org.example.hiredrive.message;

import org.example.hiredrive.Connection.MessageConnection;
import org.example.hiredrive.users.User;

import java.sql.Date;
import java.time.LocalDate;

public class Message {
    private boolean isRead;
    private User sender;
    private User receiver;
    private String content;
    private Date timeStamp;
    
    public Message(User sender, User receiver, String content) {

        this.isRead = false;
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.timeStamp = Date.valueOf(LocalDate.now());

    }
    //for database
    public Message(User sender, User receiver, String content, Date date, boolean isRead) {

        this.isRead = isRead;
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.timeStamp = date;

    }

    public User getSender(){
        return sender;
    }
    public User getReceiver(){
        return receiver;
    }
    public String getContent(){
        return content;
    }
    public boolean getIsRead(){
        return isRead;
    }
    public Date getDate(){
        return timeStamp;
    }
    public void readMessage(){
        this.isRead = true;
        MessageConnection.markMessageAsRead(timeStamp, sender.getUserId(), receiver.getUserId());
    }
    public String toString(){
        return "sent from : " + this.sender.getUsername() + " to "  + receiver.getUsername()
                + "\n"+  this.content ;
    }

}
