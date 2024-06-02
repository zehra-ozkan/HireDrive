package org.example.hiredrive.advertisement;

import org.example.hiredrive.Connection.AdvertisementConnection;
import org.example.hiredrive.Connection.UserConnection;
import org.example.hiredrive.users.User;

public class Request {

    private String status;
    private User sender;
    private int addID;
    private Advertisement add;

    //for users
    public Request(User sender, Advertisement add) {
        this.status = "PENDING"; //the default
        this.sender = sender;
        this.add = add;
    }

    //for database
    public Request(String status, int sender_id, int add_id) {
        this.status = status;
        this.sender = UserConnection.getUser(sender_id);
        this.addID = add_id;
    }


    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public User getSender() {
        return sender;
    }
    public Advertisement getAdd(){
        if(add == null) add = AdvertisementConnection.getAdvertisementById(addID);
        return add;
    }
}
