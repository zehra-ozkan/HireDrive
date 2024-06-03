package org.example.hiredrive.SceneControllers.chat;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import org.example.hiredrive.SceneControllers.SuperSceneController;
import org.example.hiredrive.advertisement.Advertisement;
import org.example.hiredrive.users.Driver;


public class DriverChatInduvidualController extends SuperSceneController{

    @FXML
    private Label addTitle;

    @FXML
    private HBox driverBox;

    @FXML
    private Label dueDate;

    @FXML
    private Label nameSurnameText;

    @FXML
    private Label no;

    @FXML
    private Circle profilePicCircle;

    private Driver driver;

    @FXML
    void mouse_clicked(MouseEvent event) {
        System.out.println("hey");
    }

    @FXML
    void mouse_entered(MouseEvent event) {

        System.out.println("hey");
    }

    @Override
    public void setData(Object data){
        driver = (Driver) data;
        nameSurnameText.setText(driver.getUsername());
        Advertisement add = driver.getAdvertisement();
        addTitle.setText(add.getAddTitle());
    }

}
