package org.example.hiredrive.SceneControllers.signIn;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.hiredrive.Connection.UserConnection;
import org.example.hiredrive.SceneControllers.SuperSceneController;
import org.example.hiredrive.users.User;

public class SignInController extends SuperSceneController {

    @FXML
    private TextField mailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signIn;

    @FXML
    private Hyperlink signUpLink;

    @FXML
    private Label wrongPrompt;

    public static User user;

    @FXML
    void LinkClicked(ActionEvent event) {

        Stage main = (Stage) signUpLink.getScene().getWindow();
        createScene("/org/example/hiredrive/Scenes/sign up scene.fxml");
        main.close();
    }

    @FXML
    void signInBtnClicked(ActionEvent event) {

        //todo here fix
        if(UserConnection.checkPassword(mailField.getText() , passwordField.getText())) {

            System.out.println("completed");
            Stage main = (Stage) signIn.getScene().getWindow();
           // user = UserConnection.getUser("user2@example.com");
            user = UserConnection.getUser(mailField.getText());

            if(user.getUserType().equals("driver")){
                createScene("/org/example/hiredrive/Scenes/Search Page Driver.fxml", user);

            }
            else{
                createScene("/org/example/hiredrive/Scenes/Search Page Company.fxml", user);
            }
            main.close();
            wrongPrompt.setVisible(false);
        }
        else {
            wrongPrompt.setVisible(true);
        }
    }

    @Override
    public void setData(Object Data) {

    }
}
