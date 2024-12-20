package org.example.entity;

import org.example.enums.NotificationType;

public class UserPrefrences {
    public String id;
    public String userId;
    public NotificationType type;

    public UserPrefrences(String userId, NotificationType type){
        this.id = "";// random
        this.userId = userId;
        this.type = type;
    }
    // unique - userid, type
}
