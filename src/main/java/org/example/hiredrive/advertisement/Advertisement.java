package org.example.hiredrive.advertisement;
import org.example.hiredrive.Connection.RequestConnection;
import org.example.hiredrive.Connection.AdvertisementConnection;
import org.example.hiredrive.Connection.RequestConnection;
import org.example.hiredrive.Connection.UserConnection;
import org.example.hiredrive.users.Company;
import org.example.hiredrive.users.Driver;

import java.sql.Date;
import java.util.ArrayList;

@SuppressWarnings("exports")
public class Advertisement {
//test
    private int advertisementID;
    private Company owner;
    private String addTitle;
    private String content;
    private String requiredLicense;
    private int experience;
    private String cargoType;
    private Date dueDate;
    private ArrayList<Request> requests;
    private String from;
    private String to;


                                                                        //Advertisement(advertId, ownerId, addTitle, addContent, cargoType, dueDate, requests, requiredLicense, fromLocation, toLocation, experience);
    //database constructor
    public Advertisement(int AdvertisementID, int company_id, String addTitle, String content, String cargoType, Date dueDate, ArrayList<Request> requests, String requiredLicense, String from, String to, int experience){
        this.advertisementID = AdvertisementID;
        this.owner = (Company) UserConnection.getUser(company_id);
        this.addTitle = addTitle;
        this.cargoType = cargoType;
        this.dueDate = dueDate;
        this.requests = requests;
        this.requiredLicense = requiredLicense;
        this.content = content;
        this.experience = experience;
        this.from = from;
        this.to = to;

    }
    //user view
    public Advertisement(Company owner, String addTitle,String addContent,String requiredLicense, String cargoType, Date dueDate, String from, String to, int experience){
        this.advertisementID = AdvertisementConnection.addAdvertisement(owner.getUserId(), addTitle, cargoType, addContent, dueDate, requiredLicense, experience);
        this.owner = owner;
        this.addTitle = addTitle;
        this.cargoType = cargoType;
        this.dueDate = dueDate;
        this.content = addContent;
        this.requiredLicense = requiredLicense;
        this.requests = new ArrayList<>();
        this.experience = experience;
        this.from = from;
        this.to = to;

    }

    public void deleteAdvertisement(){
        AdvertisementConnection.deleteAdvertisement(advertisementID);
    }

     //TODO addRequest
    public void addRequest(Request request){
        RequestConnection.sendJobRequestToAdd(request.getSender().getUserId(), request.getAdd().getAdvertisementID());
    }

    public void getAllRequests(Driver driver){
        RequestConnection.getSentRequests(driver.getUserId(),null);
    }

    // Getter methods
    public int getAdvertisementID() {
        return advertisementID;
    }

    public Company getOwner() {
        return owner;
    }

    public String getAddTitle() {
        return addTitle;
    }

    public String getContent() {
        return content;
    }

    public String getCargoType() {
        return cargoType;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public ArrayList<Request> getRequests() {
        return requests;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Advertisement ID: " + advertisementID + "\n" +
                "Owner: " + owner.getUsername() + "\n" +
                "Title: " + addTitle + "\n" +
                "Content: " + content + "\n" +
                "Cargo Type: " + cargoType + "\n" +
                "Due Date: " + dueDate + "\n" +
                "From: " + from + "\n" +
                "To: " + to + "\n" +
                "Experience Required: " + experience + " years\n" +
                "Requests: " + requests;
    }



}
