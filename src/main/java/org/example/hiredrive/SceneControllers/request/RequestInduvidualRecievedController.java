package org.example.hiredrive.SceneControllers.request;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import org.example.hiredrive.SceneControllers.SuperSceneController;
import org.example.hiredrive.advertisement.Request;
import org.example.hiredrive.users.User;

public class RequestInduvidualRecievedController extends SuperSceneController {

    @FXML
    private Button accept_btn;

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

    @FXML
    private Button reject_btn;

    private User user;
    private Request r;
    private RequestListController prevScene;

    @FXML
    void btn_clicked(ActionEvent event) {
        if(event.getSource() == accept_btn) {
            prevScene.AcceptRequest(r);
        }else if(event.getSource() == reject_btn) {
            prevScene.RejectRequest(r);
        }
        System.out.println(r);
    }

    @FXML
    void mouse_entered(MouseEvent event) {
        if (event.getSource() == adverrtisement_label) {
            adverrtisement_label.setVisible(true);
        } else if (event.getSource() == job_box) {
            job_box.setStyle("-fx-background-color: #ADD8E6;");

        }
    }
    //todo the graphic need a bit work
    @FXML
    void mouse_exited(MouseEvent event) {
            job_box.setStyle("-fx-background-color: #FFFFFF;");
    }

    @Override
    public void setData(Object data){
        prevScene = (RequestListController) data;
        r = prevScene.getCurrentRecievedRequest();
        user = r.getSender();
        experience_text.setText(user.getExperience() + "");
        nameSurnameText.setText(user.getUsername());
        adverrtisement_label.setText(r.getAdd().toString());
    }
}
