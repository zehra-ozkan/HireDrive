package org.example.hiredrive.SceneControllers.request;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import org.example.hiredrive.SceneControllers.SuperSceneController;
import org.example.hiredrive.advertisement.Request;
import org.example.hiredrive.users.User;

public class RequestInduvidualSentController extends SuperSceneController {


    @FXML
    private Label adverrtisement_label;

    @FXML
    private Label experience_text;

    @FXML
    private HBox job_box;

    @FXML
    private MenuItem menu;

    @FXML
    private Label nameSurnameText;

    @FXML
    private ImageView ratingPng;


    private User user;
    private Request r;

    @FXML
    void btn_clicked(ActionEvent event) {

    }

    @FXML
    void mouse_entered(MouseEvent event) {
        if (event.getSource() == adverrtisement_label) {
            adverrtisement_label.setVisible(true);
        }

    }

    @FXML
    void mouse_exited(MouseEvent event) {

    }

    @Override
    public void setData(Object data){
        r = (Request)data;
        user = r.getSender();
        experience_text.setText(r.getStatus());
        nameSurnameText.setText(r.getRecipient().getUsername());
        adverrtisement_label.setText(r.getAdd().toString());
    }
}
