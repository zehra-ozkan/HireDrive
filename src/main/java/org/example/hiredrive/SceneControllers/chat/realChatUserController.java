package org.example.hiredrive.SceneControllers;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class realChatUserController extends  SuperSceneController{

    @FXML
    private HBox userHbox;

    @FXML
    private Label userMesseges;

    @Override
    public void setData(Object data) {
        userMesseges.setText((String)data);
    }


}
