package org.example.hiredrive.SceneControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.hiredrive.users.Review;
import org.example.hiredrive.users.User;

public class ReviewPageController extends SuperSceneController{

    @FXML
    private TextArea comment_txt;

    @FXML
    private TextField rate_txt;

    @FXML
    private Button submit_btn;

    private SuperSceneController prev;
    private Review review;
    private User user;
    private User otherUser;

    @FXML
    void btn_clicked(ActionEvent event) {

        if(event.getSource() == submit_btn) {
            if(checkPass()){
                review.setComment(comment_txt.getText());
                review.setRating(Integer.parseInt(rate_txt.getText().trim()));
                user.reviewUser(otherUser, review);

                Stage main = (Stage) submit_btn.getScene().getWindow();
                main.close();
            }
        }
    }

    @Override
    public void setData(Object data){
        prev = (SuperSceneController) data;
        user = ((Reviewable) prev).getSender();
        otherUser = ((Reviewable) prev).getReceiver();
        review = new Review(user.getUserId(), otherUser.getUserId());
    }
    private boolean checkPass(){

        if(comment_txt.getText().trim().isEmpty() || rate_txt.getText().trim().isEmpty()){
            return false;
        }
        if(Integer.parseInt(rate_txt.getText()) < 0 && Integer.parseInt(rate_txt.getText())> 5 )return false;
        return true;
    }

}
