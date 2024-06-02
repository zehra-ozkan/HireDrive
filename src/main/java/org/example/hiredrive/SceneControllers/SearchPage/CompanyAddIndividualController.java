package org.example.hiredrive.SceneControllers.SearchPage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import org.example.hiredrive.SceneControllers.SuperSceneController;
import org.example.hiredrive.advertisement.Advertisement;


public class CompanyAddIndividualController extends SuperSceneController {

    @FXML
    private Label CompanyNameText;

    @FXML
    private Label adTitleText;

    @FXML
    private Label cargoTypeText;

    @FXML
    private Label dueDateText;

    @FXML
    private Label experienceOfDriverText;

    @FXML
    private Label nameSurnameText;

    @FXML
    private Circle profilePicCircle;

    @FXML
    private ImageView ratingPng;

    @FXML
    private Button rating_btn;

    @FXML
    void btn_clicked(ActionEvent event) {

       
    }
    @FXML
    void mouse_clicked(MouseEvent event) {

    }

    private double rating;

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
    @Override
    public void setData(Object data){
        Advertisement advertisement = (Advertisement) data;
        this.cargoTypeText.setText(advertisement.getCargoType());
        this.CompanyNameText.setText(advertisement.getOwner().getUsername());
        this.adTitleText.setText(advertisement.getAddTitle());
        this.dueDateText.setText(advertisement.getDueDate().toString());

        this.rating = advertisement.getOwner().getRating();
        setNewRatingImage(rating);

    }
}
