package org.example.hiredrive.users;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import org.example.hiredrive.Connection.AdvertisementConnection;
import org.example.hiredrive.Connection.LicencesConnection;
import org.example.hiredrive.Connection.ReviewConnection;
import org.example.hiredrive.Connection.UserConnection;
import org.example.hiredrive.advertisement.Advertisement;

public class Driver extends User {
    private boolean available;
    private Company worksWith;
    private ArrayList<String> lisenses;
    private String surname;
    private int experience;


    //for the user
    public Driver(String username, String usersurname, String password, String email, String phoneNo, int experience){
        super(username + usersurname, password, email, phoneNo);
        this.surname = usersurname;
        this.experience = experience;
        this.available = true;

        UserConnection.addUser(username, surname, email, password, phoneNo,"driver", Date.valueOf(LocalDate.now()), experience);
        userId = UserConnection.getUserID(email);
        userType = "driver";
        worksWith = UserConnection.getCompanyOfDriver(userId);
        setRating(ReviewConnection.getRating(userId));

    }

    public Driver(String username, String userSurname, String password, String email, int userId, String phoneNo, int experience) {
        super(username,  password, email, phoneNo);
        this.surname = userSurname;
        userType = "driver";
        this.experience = userId;
        super.userId = userId;
    }
    public void addLicense(String license){
        try{
            LicencesConnection.addLicense(userId, license);

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public int getExperience(){
        return experience;
    }
    public Advertisement getAdvertisement(){
        return AdvertisementConnection.getAdvertisementOfDriver(userId);
    }

    public ArrayList<String> getLicenses(){
        return LicencesConnection.getLicensesForDriver(userId);
    }
    @Override
    public void updateWorksWith(){
        worksWith = UserConnection.getCompanyOfDriver(userId);

    }

    public Company getWorkWith(){
        if(worksWith == null) worksWith = UserConnection.getCompanyOfDriver(userId);
        return worksWith;
    }
    public String toString(){
        return super.toString() + "driver " + available + "\nLisenses: " + lisenses;
    }


}
