package org.example.repository;

import org.example.dto.NotificationPref;
import org.example.entity.User;
import org.example.entity.UserPrefrences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepo {
    static final Map<String, User> users = new HashMap<>();
    static final Map<String, List<UserPrefrences>> userPrefrencesHashMap = new HashMap<>();
    static String addUser(User user){
        if(users.containsKey(user.id)){
            return null;
        }

        users.put(user.id, user);
        return  user.id;
    }


    public static void addPref(String userId, NotificationPref[] notificationPref) {
        // validate user if exits

        //else
        List<UserPrefrences> userPreferences = new ArrayList<>();
        for(NotificationPref np : notificationPref){
            UserPrefrences uP = new UserPrefrences(userId, np.notificationType);
            userPreferences.add(uP);
        }
        userPrefrencesHashMap.put(userId, userPreferences);
    }

    public static User getUserById(String id) {
        return users.get(id);
    }

    public static List<UserPrefrences> getUserPrefs(String id) {
        return userPrefrencesHashMap.get(id);
    }

    public static void createUser(User user) {
        // validate user if exits

        //else
        users.put(user.id, user);
    }
}
