package org.example.hiredrive.SceneControllers;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class errorFrameController {

    @FXML
    private Label errorText;

    public void setErrorText(String text){
        errorText.setText(text);
    }

}
