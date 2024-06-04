package org.example.hiredrive.SceneControllers.chat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import org.example.hiredrive.SceneControllers.SuperSceneController;
import org.example.hiredrive.message.Chat;
import org.example.hiredrive.message.Message;
import org.example.hiredrive.users.Company;
import org.example.hiredrive.users.Driver;

import java.io.IOException;
import java.util.ArrayList;

public class ChatPageCompanyController extends SuperSceneController {

    //todo yeni mesaj bildirimi

    @FXML
    private Label add_info;

    @FXML
    private Label add_title;

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
    private Label otherUsername;

    @FXML
    private VBox profileBox;

    @FXML
    private Circle profilePicCircle;

    @FXML
    private Circle profilePicCircle1;

    @FXML
    private Circle profilePicCircle11;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Button searchByNameButton;

    @FXML
    private TextField searchByNameTextArea;

    @FXML
    private Button send_btn;

    @FXML
    private Button view_profile_btn;

    private Label userInfo;



    private Company company;
    private ArrayList<Chat> chats;
    private int currentChat = 0;


    @FXML
    void btn_clicked(ActionEvent event) {
        if(event.getSource() == main_btn) {
            createScene("/org/example/hiredrive/Scenes/Search Page Driver.fxml", company);
            Stage main = (Stage) main_btn.getScene().getWindow();
            main.close();
        }else if (event.getSource() == logOutButton) {
            createScene("/org/example/hiredrive/Scenes/entranceScene.fxml");
            Stage main = (Stage) logOutButton.getScene().getWindow();
            main.close();
        }else if (event.getSource() == myProfileButton) {
            Stage main = (Stage) myProfileButton.getScene().getWindow();
            createScene("/org/example/hiredrive/Scenes/ProfilePageCompany.fxml", company);
            main.close();}
        else if (event.getSource() == view_profile_btn) {
        Stage main = (Stage) view_profile_btn.getScene().getWindow();
        createScene("/org/example/hiredrive/Scenes/ProfilePageDriverFromCompany.fxml", company);
        main.close();

        }else if (event.getSource() == searchByNameTextArea) {

        } else if (event.getSource() == send_btn) {
            createMessage(chats.get(currentChat).getDriver());
            setDrivers();
            update();

        }
    }
    public void createMessage(Driver driver) {
        if(messageBox.getText() == null) return;
        Message message = new Message(this.company, driver, messageBox.getText());
        chats.get(currentChat).sendMessage(message);
        messageBox.clear();

    }

    @Override
    public void setData(Object data){
        chats = new ArrayList<Chat>();
        company = (Company) data;
        myProfileButton.setText(company.getUsername());
        setChats();
        setDrivers();
        update();
    }
    //todo can be more efficient
    private void setChats() {
        for(Driver driver : company.getWorksWith()){
            chats.add(new Chat(driver, company));
        }
    }
    private void setDrivers() {
        profileBox.getChildren().clear();
        for (int i =0; i < chats.size(); i++) {
            Chat chat =  chats.get(i);
            try{
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/org/example/hiredrive/Scenes/driverChatInduvidual.fxml"));
                Pane profilePage = loader.load();
                DriverChatInduvidualController driverAddIndController = loader.getController();
                driverAddIndController.setData(this, chat, i);
                profileBox.getChildren().add(profilePage);

            }catch (IOException e){
                System.out.println(e);;
            }
        }
    }

    public void update() {

        messages.getChildren().clear();
        for (Message message : chats.get(currentChat).getMessages()) {
            try{
                FXMLLoader loader = new FXMLLoader();
                if(message.getSender().getUserId() == company.getUserId()){
                    loader.setLocation(getClass().getResource("/org/example/hiredrive/Scenes/realChatUser.fxml"));
                    HBox profilePage = loader.load();
                    realChatUserController driverAddIndController = loader.getController();
                    driverAddIndController.setData(message.getContent());
                    messages.getChildren().add(profilePage);
                }
                else {
                    loader.setLocation(getClass().getResource("/org/example/hiredrive/Scenes/otherChatUser.fxml"));
                    HBox profilePage = loader.load();
                    message.readMessage();
                    otherChatUserController driverAddIndController = loader.getController();
                    driverAddIndController.setData(message.getContent());
                    messages.getChildren().add(profilePage);
                }

            }catch (IOException e){
                e.printStackTrace();
            }

            otherUsername.setText(chats.get(currentChat).getDriver().getUsername());
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
    public void setCurrentChat(int currentChat) {
        this.currentChat = currentChat;
        updateAdvertisement();
    }
    private void updateAdvertisement() {
        Driver  currentDriver = chats.get(currentChat).getDriver();
        add_title.setText(currentDriver.getAdvertisement().getAddTitle());
        add_info.setText(currentDriver.getAdvertisement().toString());
    }

}