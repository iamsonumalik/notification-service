package org.example.services;

import org.example.dto.NotificationPref;
import org.example.entity.User;
import org.example.repository.UserRepo;

public class UserService {

    public static void createUser(User user) {
        UserRepo.createUser(user);
    }

    public static void addPref(String userId, NotificationPref[] notificationPref){
        UserRepo.addPref(userId, notificationPref);
    }
}