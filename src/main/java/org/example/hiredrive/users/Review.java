package org.example.hiredrive.users;

import org.example.hiredrive.Connection.UserConnection;

public class Review {

    private User reviewer;
    private String comment;
    private int rating;
    private User user;

    public Review(int reviewerID, int user_id,  String comment, int rating){

        this.user = UserConnection.getUser(user_id);
        this.reviewer = UserConnection.getUser(reviewerID);
        this.comment = comment;
        this.rating = rating;
    }
    public Review(int reviewer, int user){
        this.reviewer = UserConnection.getUser(reviewer);
        this.user = UserConnection.getUser(user);
    }

    //getter methods

    public User getReviewer(){
        return this.reviewer;
    }
    public User getUser(){
        return this.user;
    }

    public String getComment(){
        return this.comment;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

    public int getRating(){
        return this.rating;
    }

    //setter methods
    public void setRating(int rate){
        this.rating = rate;
    }

}
