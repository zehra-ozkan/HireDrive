package org.example.hiredrive.SceneControllers.profile;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

import org.example.hiredrive.Connection.UserConnection;
import org.example.hiredrive.SceneControllers.SuperSceneController;
import org.example.hiredrive.users.Company;
import org.example.hiredrive.users.User;

//this is for company
public class ProfileControllerCompany extends SuperSceneController {

    @FXML
    private Hyperlink chat_btn;

    @FXML
    private Button goMainPageScene;

    @FXML
    private Hyperlink job_btn;

    @FXML
    private Button logOutButton;

    @FXML
    private Button myProfileButton;

    @FXML
    private Circle profilePicCircle;

    @FXML
    private Circle profilePicCircleBig;

    @FXML
    private Label rateInfo;

    @FXML
    private ImageView ratingPng;

    @FXML
    private Hyperlink requestBtn;

    @FXML
    private Label userInfo;
    private User user;
    private SuperSceneController prevScene;

    @FXML
    void btn_clicked(ActionEvent event) {
        if(event.getSource() == rateInfo) {

        }else if(event.getSource() == goMainPageScene) {
            createScene("/org/example/hiredrive/Scenes/Search Page Company.fxml", user);
            Stage main = (Stage) goMainPageScene.getScene().getWindow();
            main.close();

        }else if(event.getSource() == job_btn) {
            createScene("/org/example/hiredrive/Scenes/Jobs.fxml", this);
            Stage main = (Stage) job_btn.getScene().getWindow();
            main.close();

        } else if (event.getSource() == logOutButton) {
            user = null;
            prevScene = null;
            createScene("/org/example/hiredrive/Scenes/entranceScene.fxml");
            Stage main = (Stage) logOutButton.getScene().getWindow();
            main.close();
        }else if (event.getSource() == chat_btn) {
            createScene("/org/example/hiredrive/Scenes/Chat Page Company.fxml", user);
            Stage main = (Stage) logOutButton.getScene().getWindow();
            main.close();
        }
    }
    @FXML
    void mouse_clicked(MouseEvent event) {
        if (event.getSource() == profilePicCircleBig) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choose Profile Picture");
            File file = fileChooser.showOpenDialog(new Stage());
            if (file != null) {
                Image image = new Image(file.toURI().toString());
                profilePicCircleBig.setFill(new ImagePattern(image));
                Image im = new Image("/org/example/hiredrive/pngs/user.png",false);
                profilePicCircleBig.setFill(new ImagePattern(image));
            }
        }
    }
    @FXML
    void link_clicked(ActionEvent event) {
        if(event.getSource() == requestBtn) {
            createScene("/org/example/hiredrive/Scenes/Request List Page.fxml", user);
            Stage main = (Stage) job_btn.getScene().getWindow();
            main.close();

        }else if(event.getSource() == goMainPageScene) {

        }else if(event.getSource() == job_btn) {
            createScene("/org/example/hiredrive/Scenes/Jobs.fxml", this);
            Stage main = (Stage) job_btn.getScene().getWindow();
            main.close();
        }else if(event.getSource() == chat_btn) {
            createScene("/org/example/hiredrive/Scenes/Chat Page Company.fxml", user);
            Stage main = (Stage) job_btn.getScene().getWindow();
            main.close();
        }
    }

    @Override
    public void setData(Object data){
        if(data instanceof SuperSceneController){
            prevScene = (SuperSceneController) data;
            user = prevScene.getUserData();
        }
        else user = (User) data;
        update();
    }
    public User getUserData(){
        return user;
    }
    public void update(){
        myProfileButton.setDisable(true);
        myProfileButton.setText(user.getUsername());
        userInfo.setText(user.getUsername() + " (" + user.getUserType() + ") ");
        setNewRatingImage(user.getRating());
        try {
            rateInfo.setText(user.getRating() + " rated " + UserConnection.getTotalRated(user.getUserId()));
        }catch(Exception e){
            System.out.println(e);
        }
    }
    private void setNewRatingImage(double rating) {
        if(rating <= 1){
            Image im = new Image(getClass().getResourceAsStream("/org/example/hiredrive/pngs/1.png"));
            ratingPng.setImage(im);
        }
        else if(rating <= 1.5){
            Image im = new Image(getClass().getResourceAsStream("/org/example/hiredrive/pngs/1.5.png"));
            ratingPng.setImage(im);
        }
        else if(rating <= 2){
            Image im = new Image(getClass().getResourceAsStream("/org/example/hiredrive/pngs/2.png"));
            ratingPng.setImage(im);
        }
        else if(rating <= 2.5){
            Image im = new Image(getClass().getResourceAsStream("/org/example/hiredrive/pngs/2.5.png"));
            ratingPng.setImage(im);
        }
        else if(rating <= 3){
            Image im = new Image(getClass().getResourceAsStream("/org/example/hiredrive/pngs/3.png"));
            ratingPng.setImage(im);
        }
        else if(rating <= 3.5){
            Image im = new Image(getClass().getResourceAsStream("/org/example/hiredrive/pngs/3.5.png"));
            ratingPng.setImage(im);
        }
        else if(rating <= 4){
            Image im = new Image(getClass().getResourceAsStream("/org/example/hiredrive/pngs/4.png"));
            ratingPng.setImage(im);
        }
        else if(rating <= 4.5){
            Image im = new Image(getClass().getResourceAsStream("/org/example/hiredrive/pngs/4.5.png"));
            ratingPng.setImage(im);
        }
        else if(rating <= 5){
            Image im = new Image(getClass().getResourceAsStream("/org/example/hiredrive/pngs/5.png"));
            ratingPng.setImage(im);
        }
    }

}