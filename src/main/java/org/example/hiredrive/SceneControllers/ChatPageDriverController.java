package org.example.hiredrive.SceneControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import org.example.hiredrive.SceneControllers.SearchPage.driverAddIndividiualController;
import org.example.hiredrive.message.Chat;
import org.example.hiredrive.message.Message;
import org.example.hiredrive.users.Company;
import org.example.hiredrive.users.Driver;

import static org.example.hiredrive.SceneControllers.signIn.SignInController.user;

import java.io.IOException;
import java.util.ArrayList;

public class ChatPageDriverController extends SuperSceneController {

    @FXML
    private Button send_btn;

    @FXML
    private Button logOutButton;

    @FXML
    private Button main_btn;

    @FXML
    private TextArea messageBox;

    @FXML
    private Button myProfileButton;

    @FXML
    private Circle profilePicCircle;

    @FXML
    private Circle profilePicCircle1;

    @FXML
    private Circle profilePicCircle11;

    @FXML
    private Button searchByNameButton;

    @FXML
    private TextField searchByNameTextArea;

    @FXML
    private VBox messages;

    @FXML
    private Button view_profile_btn;


    private Label userInfo;
    private Driver driver;
    private Chat chat;


    //TODO vbox needed
    @FXML
    void btn_clicked(ActionEvent event) {
        if(event.getSource() == main_btn) {
            createScene("/org/example/hiredrive/Scenes/Search Page Driver.fxml", driver);
            Stage main = (Stage) main_btn.getScene().getWindow();
            main.close();
        }else if (event.getSource() == logOutButton) {
            createScene("/org/example/hiredrive/Scenes/entranceScene");
            Stage main = (Stage) logOutButton.getScene().getWindow();
            main.close();
        }else if (event.getSource() == myProfileButton) {
            Stage main = (Stage) myProfileButton.getScene().getWindow();
            createScene("/org/example/hiredrive/Scenes/ProfilePageDriver.fxml", driver);
            main.close();
        }
    }

    //todo need to make sure that the driver is employed
    @Override
    public void setData(Object data){
        driver = (Driver) data;
        chat = new Chat(driver, driver.getWorkWith());

        update();
    }

    public void update() {
        myProfileButton.setText(driver.getUsername());

        for (Message message : chat.getMessages()) {
            try{
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/org/example/hiredrive/Scenes/realChatUser.fxml"));
                HBox profilePage = loader.load();
                realChatUserController driverAddIndController = loader.getController();
                driverAddIndController.setData(message.getContent());
                messages.getChildren().add(profilePage);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }




    @FXML
    void sendButtonAction(ActionEvent event) {
        //sendMessage();
    }

    @FXML
    void sendMethod(KeyEvent event) {

    }

}