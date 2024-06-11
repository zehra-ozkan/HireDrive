package org.example.hiredrive.SceneControllers.request;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.example.hiredrive.SceneControllers.SuperSceneController;
import org.example.hiredrive.advertisement.Request;

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

public class RequestListController extends SuperSceneController {

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
    private int currentSent;
    private int currentReceived;

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
        for (int i = 0; i < m.size(); i++) {
            Request req = m.get(i);

            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(path));
                StackPane profilePage = loader.load();

                if (m.equals(sendR)) {
                    RequestInduvidualSentController k = loader.getController();
                    updateSent(i);
                    k.setData(req);
                }
                else{
                    RequestInduvidualRecievedController cController = loader.getController();
                    updateReceived(i);
                    cController.setData(this);

                }
                request_box.getChildren().add(profilePage);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    private void updateSent(int k) {
        currentSent = k;
    }
    private void updateReceived(int k) {
        currentReceived = k;
    }
    public Request getCurrentRecievedRequest(){
        return receivedR.get(currentReceived);
    }
    public Request getCurrentSentRequest(){
        return sendR.get(currentSent);
    }
    public void AcceptRequest(Request request){
        request.setStatus("ACCEPTED");
        user = request.getRecipient();
        receivedR.remove(request);
        update();
    }
    public void RejectRequest(Request request){
        request.setStatus("REJECTED");
        receivedR.remove(request);
        update();
    }
}
