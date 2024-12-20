package org.example.repository;

import org.example.entity.Notification;
import org.example.entity.NotificationHistory;
import org.example.entity.User;
import org.example.entity.UserPrefrences;
import org.example.enums.NotificationStatus;
import org.example.enums.NotificationType;

import java.util.*;

public class NotificationRepo {
    static Map<String, Notification> notificationMap = new HashMap<>();
    static Map<String, NotificationHistory> notificationHistoryMap = new HashMap<>();


    public static String createNotification(Notification notification){
        // validate if same key exists

        // else
        notificationMap.put(notification.id, notification);
        List<UserPrefrences> userPrefrences = UserRepo.getUserPrefs(notification.userId);
        for(UserPrefrences up: userPrefrences) {
            NotificationRepo.createNotificationHistory(notification, up.type);
        }
        return  notification.id;
    }

    public static Notification getNotificationById(String id){
        return notificationMap.get(id);
    }

    public  static  List<NotificationHistory> getNotificationHistory(String notificationId){
        return notificationHistoryMap.values().stream().filter(k -> notificationId.equals(k.notificationId)).toList();
    }

    public static void createNotificationHistory(Notification notification, NotificationType type){
        NotificationHistory notificationHistory = new NotificationHistory();
        notificationHistory.notificationId = notification.id;
        notificationHistory.userId = notification.userId;
        notificationHistory.status = NotificationStatus.OUTSTANDING;
        notificationHistory.createdAt = new Date();
        notificationHistory.type = type;
        notificationHistory.updatedAt = new Date();
        notificationHistory.id = UUID.randomUUID().toString();

        notificationHistoryMap.put(notificationHistory.id, notificationHistory);
    }

    public static void updateNotificationHistory(NotificationHistory notificationHistory) {
        notificationHistoryMap.put(notificationHistory.id, notificationHistory);
    }

    public static  List<NotificationHistory> listNoticationHistory(User user, NotificationStatus status) {
        return notificationHistoryMap.values().stream().filter(k -> user.id.equals(k.userId) && k.status == status).toList();
    }
}
