package org.example.hiredrive.message;

import java.util.ArrayList;

import org.example.hiredrive.Connection.MessageConnection;
import org.example.hiredrive.users.Company;
import org.example.hiredrive.users.Driver;

public class Chat {
    //private int chatID;
    private Driver driver;
    private Company company;
    private ArrayList<Message> messages;

    public Chat(Driver driver, Company company){

        this.driver = driver;
        this.company = company;
        this.messages = MessageConnection.retrieveMessagesBetweenUsers(driver.getUserId(), company.getUserId());
    }

    public ArrayList<Message> showChat(int senderId, int receiverId){
        return messages;
    }
    public void addMessage(Message message){
        messages.add(message);
    }
    public void sendMessage(Message message){
        messages.add(message);
        MessageConnection.sendMessage(message.getSender().getUserId(), message.getReceiver().getUserId(), message.getContent());
    }

    public Driver getDriver(){
        return driver;
    }
    public Company getCompany(){
        return company;
    }
    public ArrayList<Message> getMessages(){
        return messages;
    }



}
