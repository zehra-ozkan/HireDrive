package org.example.hiredrive.SceneControllers;

import org.example.hiredrive.users.User;

public interface Reviewable {

    User getSender();
    User getReceiver();
    void updateRating();

}
