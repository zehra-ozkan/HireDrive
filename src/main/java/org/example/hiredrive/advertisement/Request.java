package org.example.hiredrive.advertisement;

import org.example.hiredrive.Connection.AdvertisementConnection;
import org.example.hiredrive.Connection.RequestConnection;
import org.example.hiredrive.Connection.UserConnection;
import org.example.hiredrive.users.User;

public class Request {

    private String status;
    private User sender;
    private User recipient;
    private int addID;
    private Advertisement add;

    //for users
    public Request(User sender,User recipient, Advertisement add) {
        this.status = "PENDING";
        this.recipient = recipient;
        this.sender = sender;
        this.add = add;
    }

    //for database
    public Request(String status, int sender_id,int recipent_id, int add_id) {
        this.status = status;
        this.sender = UserConnection.getUser(sender_id);
        this.recipient = UserConnection.getUser(recipent_id);
        this.addID = add_id;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        RequestConnection.replyRequest(sender.getUserId(), addID, status);
        sender.addWorksWith(recipient, add);
        if(status.equals("ACCEPTED")) {
            sender.updateWorksWith();
            recipient.updateWorksWith();
        }
    }
    public User getSender() {
        return sender;
    }public User getRecipient() {
        return recipient;
    }
    public Advertisement getAdd(){
        if(add == null) add = AdvertisementConnection.getAdvertisementById(addID);
        return add;
    }
    public String toString(){
        return "sent from " + sender + " to " + recipient + " on addvertisement " + add;
    }
}
