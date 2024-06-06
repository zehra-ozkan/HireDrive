package org.example.hiredrive.SceneControllers;

import org.example.hiredrive.Connection.RequestConnection;
import org.example.hiredrive.advertisement.Request;
import org.example.hiredrive.users.Company;
import org.example.hiredrive.users.Driver;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import org.example.hiredrive.users.User;

import java.util.ArrayList;

public class RequestListController extends SuperSceneController{

    @FXML
    private Button goMainPageScene;

    @FXML
    private Button logOutButton;

    @FXML
    private Button myProfileButton;

    @FXML
    private Circle profilePicCircle;

    @FXML
    private RadioButton receivedRequests;

    @FXML
    private ToggleGroup request;

    @FXML
    private Button searchByNameButton;

    @FXML
    private TextField searchByNameTextArea;

    @FXML
    private RadioButton sentRequests;

    private User user;
    private ArrayList<Request> sendR;
    private ArrayList<Request> receivedR;

    @FXML
    void btn_clicked(ActionEvent event) {
        if(event.getSource() == goMainPageScene) {
            Stage main = (Stage) goMainPageScene.getScene().getWindow();
            main.close();
            createScene("/org/example/hiredrive/Scenes/Search Page Driver.fxml");
        }
        else if(event.getSource() == logOutButton) {
            Stage main = (Stage) logOutButton.getScene().getWindow();
            main.close();
            createScene("/org/example/hiredrive/Scenes/entranceScene.fxml");
        }
        else if(event.getSource() == myProfileButton) {
            Stage main = (Stage) myProfileButton.getScene().getWindow();
            main.close();

            //todo
            createScene("/org/example/hiredrive/Scenes/ProfilePageCompany.fxml", (Company)user);
        }
        else if(event.getSource() == sentRequests) {

        }
        else if(event.getSource() == receivedRequests) {
        }
    }
    @FXML
    void search_name(ActionEvent event) {

    }

    @Override
    public void setData(Object data){
        user = (User) data;
        sendR = user.getSentRequests();
        receivedR = user.getRecievedRequests();


    }
}
