package org.example.hiredrive.SceneControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import org.example.hiredrive.users.Driver;
import org.example.hiredrive.users.User;

public class RequestInduvidualController extends SuperSceneController{

    @FXML
    private Button accept_btn;

    @FXML
    private Label adverrtisement_label;

    @FXML
    private Label experience_text;

    @FXML
    private HBox job_box;

    @FXML
    private MenuItem menu;

    @FXML
    private Label nameSurnameText;

    @FXML
    private ImageView ratingPng;

    @FXML
    private Button reject_btn;

    private Driver driver;

    @FXML
    void btn_clicked(ActionEvent event) {

    }

    @FXML
    void mouse_entered(MouseEvent event) {

    }

    @FXML
    void mouse_exited(MouseEvent event) {

    }

    @Override
    public void setData(Object data){
        driver = (Driver) data;
        experience_text.setText(driver.getExperience() + "");
        nameSurnameText.setText(driver.getUsername());
    }
}
