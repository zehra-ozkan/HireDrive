package org.example.hiredrive.users;

import org.example.hiredrive.Connection.MessageConnection;
import org.example.hiredrive.Connection.RequestConnection;
import org.example.hiredrive.Connection.ReviewConnection;
import org.example.hiredrive.Connection.UserConnection;
import org.example.hiredrive.advertisement.Advertisement;
import org.example.hiredrive.advertisement.Request;
import org.example.hiredrive.message.Message;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class User {

    protected int userId;
    protected ArrayList<Review> reviews;
    protected String username;
    protected String password;
    protected String email;
    protected double rating;
    protected String phoneNumber;
    protected String userType;


    public User(String username,String password, String email, String phoneNumber){
        this.username = username;
        this.password = password;
        this.email = email;
        this.rating = 0;
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Request> getSentRequests(){
        return RequestConnection.getSentRequests(userId, null);
    }
    public ArrayList<Request> getRecievedRequests(){
        return RequestConnection.getIncomingRequest(userId);
    }


    public void reviewUser(User user, String comment, int rating){
        if(UserConnection.worksWith(userId, user.userId)){
            this.userId = user.userId;
            this.username = user.username;
            ReviewConnection.addReview(this.userId, user.userId, comment, rating);
           // user.updateRating();
        }
        else throw new IllegalArgumentException("You cannot rate a user you are not associated with");
    }
    public String getUserType(){
        return userType;
    }

    public void sendMessage(Message message) {
        MessageConnection.sendMessage(this.userId, message.getReceiver().userId, message.getContent());
    }
    public String getMail() {
        return this.email;
    }
    public int getUserId() {
        return this.userId;
    }
    public String getUsername() {
        return this.username;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public double getRating() {
        this.rating = ReviewConnection.getRating(userId);
        return this.rating;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public ArrayList<Review> getReviews() {
        if(this.reviews == null)reviews = ReviewConnection.getReviewsForUser(userId);
        return reviews;
    }
    public void updateReviews(){
        reviews = ReviewConnection.getReviewsForUser(userId);
    }
    public void reviewUser(User user, Review review){
        ReviewConnection.addReview(userId, user.userId, review.getComment(), review.getRating());
    }

    public String toString(){
        return this.userId + this.username + " "  + " " + this.email;
    }


    public int getExperience() {
        return -1;
    }
    public boolean isDriver(){
        return this.userType.equals("driver");
    }
    public void addWorksWith(User user, Advertisement add) {
        int driver_id = -5; //to shut the compiler
        int company_id = -5; //to shut the cı-ompiler
        if(user.isDriver() && !this.isDriver()){
            driver_id = user.userId;
            company_id = userId;

        }
        else if(!user.isDriver() && this.isDriver()){
            driver_id = userId;
            company_id = user.userId;
        }
        else{
            System.out.println("PROBLENM \n PROBLEM \n PROBLEMMMMMMMM");
        }
        UserConnection.addWorksWith(driver_id , company_id, add.getAdvertisementID(), Date.valueOf(LocalDate.now()));
    }
    public boolean worksWith(User user, User otherUser){
        return UserConnection.worksWith(user.userId, otherUser.userId);
    }
    public abstract void updateWorksWith();
}
