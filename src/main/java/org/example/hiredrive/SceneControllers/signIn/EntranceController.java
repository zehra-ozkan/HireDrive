package org.example.hiredrive.SceneControllers.signIn;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.hiredrive.SceneControllers.SuperSceneController;

public class EntranceController extends SuperSceneController {

    @FXML
    private Button btn_signIn;

    @FXML
    private Button btn_signUp;

    @FXML
    private Button goBackScene;

    @FXML
    void buttonClicked(ActionEvent event) {
        if(event.getSource() == btn_signIn) {

            Stage main = (Stage) btn_signIn.getScene().getWindow();

            createScene("/org/example/hiredrive/Scenes/sign in scene.fxml");
            main.close();

        }
        else if(event.getSource() == btn_signUp) {

            Stage main = (Stage) btn_signUp.getScene().getWindow();
            
            main.close();
            createScene("/org/example/hiredrive/Scenes/sign up scene.fxml");
        
        }
        else if(event.getSource() == goBackScene) {

            Stage main = (Stage) btn_signUp.getScene().getWindow();

            main.close();
            createScene("/org/example/hiredrive/Scenes/sign up scene.fxml");

        }
    }

    @Override
    public void setData(Object Data) {

    }
}
