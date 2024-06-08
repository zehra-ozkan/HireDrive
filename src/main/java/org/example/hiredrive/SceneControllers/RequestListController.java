package org.example.hiredrive.SceneControllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.example.hiredrive.Connection.RequestConnection;
import org.example.hiredrive.SceneControllers.jobs.jobsInduvidiualController;
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

import java.io.IOException;
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
    private VBox request_box;

    @FXML
    private TextField searchByNameTextArea;

    @FXML
    private RadioButton sentRequests;

    private User user;
    private ArrayList<Request> sendR;
    private ArrayList<Request> receivedR;
    private int currentReq;

    @FXML
    void btn_clicked(ActionEvent event) {
        if(event.getSource() == goMainPageScene) {
            Stage main = (Stage) goMainPageScene.getScene().getWindow();
            main.close();
            createScene("/org/example/hiredrive/Scenes/Search Page Company.fxml", user);
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
            if(user.getUserType().equals("company")){
                createScene("/org/example/hiredrive/Scenes/ProfilePageCompany.fxml", user);
            }
            else{
                createScene("/org/example/hiredrive/Scenes/ProfilePageDriver.fxml", user);
            }
        }
    }
    @FXML
    void search_name(ActionEvent event) {

    }
    @FXML
    void rd_clicked(ActionEvent event) {
        update();
    }


    @Override
    public void setData(Object data){
        user = (User) data;
        sendR = user.getSentRequests();
        receivedR = user.getRecievedRequests();
        myProfileButton.setText(user.getUsername());
        update();
    }

    private void update() {
        ArrayList<Request> m = new ArrayList<>();
        String path = "";
        if(receivedRequests.isSelected()) {
            m = receivedR;
            path = "/org/example/hiredrive/Scenes/RequestInduvidual.fxml";
        }
        else if(sentRequests.isSelected()){
            m = sendR;
            path = "/org/example/hiredrive/Scenes/RequestInduvidualSent.fxml";
        }
        request_box.getChildren().clear();
        for (Request req : m) {
            public int getCurrentRequest() {
                return 0;
            }
            }
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(path));
                StackPane profilePage = loader.load();

                if (m.equals(sendR)) {
                    RequestInduvidualSentController  k = loader.getController();
                    k.setData(req);
                }

                else{
                    RequestInduvidualController cController = loader.getController();
                    cController.setData(req);
                }
                request_box.getChildren().add(profilePage);


            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
