package org.example.hiredrive.SceneControllers.profile;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import org.example.hiredrive.SceneControllers.SuperSceneController;
import org.example.hiredrive.users.Company;
import org.example.hiredrive.users.Driver;

public class profilePageDriverFromCompanyController extends SuperSceneController {

    @FXML
    private Button back_btn;

    @FXML
    private Button goMainPageScene;

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
    private Button rate_btn;

    @FXML
    private ImageView ratingPng;

    @FXML
    private Label userInfo;

    private Company company;
    private Driver driver;

    @FXML
    void btn_clicked(ActionEvent event) {
        if(event.getSource() == rate_btn){



        } else if (event.getSource() == logOutButton) {
            company = null;
            driver = null;
            createScene("/org/example/hiredrive/Scenes/entranceScene.fxml");
            Stage main = (Stage) logOutButton.getScene().getWindow();
            main.close();

        }
    }

    @FXML
    void mouse_clicked(MouseEvent event) {

    }

    @Override
    public void setData(Object data){
        driver = (Driver) data;
        company = driver.getWorkWith();
        userInfo.setText(driver.getUsername());
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
