package org.example.hiredrive.SceneControllers.chat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import org.example.hiredrive.SceneControllers.SuperSceneController;
import org.example.hiredrive.message.Chat;
import org.example.hiredrive.message.Message;
import org.example.hiredrive.users.Driver;

import java.io.IOException;

public class ChatPageDriverController extends SuperSceneController {


    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Button logOutButton;

    @FXML
    private Button main_btn;

    @FXML
    private TextArea messageBox;

    @FXML
    private VBox messages;

    @FXML
    private Button myProfileButton;

    @FXML
    private Circle profilePicCircle;

    @FXML
    private Circle profilePicCircle1;

    @FXML
    private Circle profilePicCircle11;

    @FXML
    private Label reciever_text;

    @FXML
    private Button searchByNameButton;

    @FXML
    private TextField searchByNameTextArea;

    @FXML
    private Button send_btn;

    @FXML
    private Button view_profile_btn;


    private Label userInfo;
    private Driver driver;
    private Chat chat;


    @FXML
    void btn_clicked(ActionEvent event) {
        if(event.getSource() == main_btn) {
            createScene("/org/example/hiredrive/Scenes/Search Page Driver.fxml", driver);
            Stage main = (Stage) main_btn.getScene().getWindow();
            main.close();
        }else if (event.getSource() == logOutButton) {
            createScene("/org/example/hiredrive/Scenes/entranceScene.fxml");
            Stage main = (Stage) logOutButton.getScene().getWindow();
            main.close();
        }else if (event.getSource() == myProfileButton) {
            Stage main = (Stage) myProfileButton.getScene().getWindow();
            createScene("/org/example/hiredrive/Scenes/ProfilePageDriver.fxml", driver);
            main.close();
        }else if (event.getSource() == searchByNameTextArea) {

        } else if (event.getSource() == send_btn) {
            createMessage();
            update();

        }
    }
    public void createMessage() {
        if(messageBox.getText() == null) return;
        Message message = new Message(driver, driver.getWorkWith(), messageBox.getText());
        chat.sendMessage(message);
        messageBox.clear();

    }

    //todo need to make sure that the driver is employed
    @Override
    public void setData(Object data){
        driver = (Driver) data;
        chat = new Chat(driver, driver.getWorkWith());
        myProfileButton.setText(driver.getUsername());

        update();
    }

    public void update() {

        for (Message message : chat.getMessages()) {
            try{
                FXMLLoader loader = new FXMLLoader();
                if(message.getSender().getUserId() == driver.getUserId()){
                    loader.setLocation(getClass().getResource("/org/example/hiredrive/Scenes/realChatUser.fxml"));
                    HBox profilePage = loader.load();
                    realChatUserController driverAddIndController = loader.getController();
                    driverAddIndController.setData(message.getContent());
                    messages.getChildren().add(profilePage);
                }
                else {
                    loader.setLocation(getClass().getResource("/org/example/hiredrive/Scenes/otherChatUser.fxml"));
                    HBox profilePage = loader.load();
                    otherChatUserController driverAddIndController = loader.getController();
                    driverAddIndController.setData(message.getContent());
                    messages.getChildren().add(profilePage);
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    @FXML
    public void initialize() {
        // Ensure the scrollPane is scrolled to the bottom when the content is fully loaded
        scrollPane.vvalueProperty().bind(messages.heightProperty());
    }
    @FXML
    void sendMethod(KeyEvent event) {

    }
}