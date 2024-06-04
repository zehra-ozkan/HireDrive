package org.example.hiredrive.SceneControllers.chat;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import org.example.hiredrive.SceneControllers.SuperSceneController;
import org.example.hiredrive.advertisement.Advertisement;
import org.example.hiredrive.message.Chat;
import org.example.hiredrive.message.Message;
import org.example.hiredrive.users.Driver;


public class DriverChatInduvidualController extends SuperSceneController{


    @FXML
    private HBox driverBox;

    @FXML
    private Label dueDate;

    @FXML
    private Label lastMessage;

    @FXML
    private Label nameSurnameText;

    @FXML
    private Label no;

    @FXML
    private Circle profilePicCircle;

    private Driver driver;
    private Chat chat;
    private int index;
    private final int MAX_TEXT_LENGTH = 40;
    private ChatPageCompanyController s;

    @FXML
    void mouse_clicked(MouseEvent event) {

        s.setCurrentChat(index);
        s.update();
    }

    @FXML
    void mouse_entered(MouseEvent event) {
        driverBox.setStyle("-fx-background-color: #ADD8E6;");
    }
    @FXML
    void mouse_exited(MouseEvent event) {

        driverBox.setStyle("-fx-background-color: #FFFFFF;");
    }


    public void setData(ChatPageCompanyController m, Object data, int i){
        s =m;
        chat = (Chat) data;
        driver = chat.getDriver();
        index = i;
        no.setText(String.valueOf(index + 1));
        nameSurnameText.setText(driver.getUsername());
        if(chat.getMessages().isEmpty()) return;
        Message last = chat.getMessages().getLast();

        if(last == null) return;

        String lastM = last.getContent();
        if(!lastM.isEmpty() && lastM.length() < MAX_TEXT_LENGTH){
            lastMessage.setText(lastM);
        } else if (!lastM.isEmpty()) {
            lastMessage.setText(lastM.substring(0 , MAX_TEXT_LENGTH - 2) + "...");
        }
        dueDate.setText(last.getDate() + "");
    }

}
