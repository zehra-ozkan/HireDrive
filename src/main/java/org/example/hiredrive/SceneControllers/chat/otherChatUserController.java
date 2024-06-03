package org.example.hiredrive.SceneControllers.chat;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import org.example.hiredrive.SceneControllers.SuperSceneController;

public class otherChatUserController extends SuperSceneController {

    @FXML
    private HBox hboxOtherMesagess;

    @FXML
    private Label otherMessages;

    @Override
    public void setData(Object data) {
        otherMessages.setText((String)data);
    }


}
