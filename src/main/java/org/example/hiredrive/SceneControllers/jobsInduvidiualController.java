package org.example.hiredrive.SceneControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import org.example.hiredrive.users.Driver;

public class jobsInduvidiualController extends  SuperSceneController{

    @FXML
    private Label IDText;

    @FXML
    private Button chatButton;

    @FXML
    private HBox job_box;

    @FXML
    private Label nameSurnameText;

    @FXML
    private ImageView ratingPng;
    private Driver driver;

    @FXML
    void btn_clicked(ActionEvent event) {
        if(event.getSource() == chatButton) {
            createScene("/org/example/hiredrive/Scenes/Chat Page Company.fxml", driver);
        }
    }

    @FXML
    void mouse_entered(MouseEvent event) {
        job_box.setStyle("-fx-background-color: #ADD8E6;");
    }
    @FXML
    void mouse_exited(MouseEvent event) {
        job_box.setStyle("-fx-background-color: #FFFFFF;");
    }

    @Override
    public void setData(Object data) {

        this.driver =(Driver) data;
        this.IDText.setText(driver.getUserId() + "");
        this.nameSurnameText.setText(driver.getUsername());
        setNewRatingImage(driver.getRating());
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
