package org.example;

import org.example.dto.NotificationPref;
import org.example.entity.Notification;
import org.example.entity.NotificationHistory;
import org.example.entity.User;
import org.example.enums.NotificationStatus;
import org.example.enums.NotificationType;
import org.example.repository.NotificationRepo;
import org.example.services.NotificationService;
import org.example.services.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.id = "1";
        user.email = "iamsonumalik@gmail.com";
        user.phoneNumber = "9927015843";

        // 1. create user with some preferences
        UserService.createUser(user);
        NotificationPref emailPred = new NotificationPref(NotificationType.EMAIL);

        // Adding Email prefs only
        UserService.addPref(user.id, new NotificationPref[]{emailPred});

        // 2. Create a notification for this user and content "BTC price is $90K"
        Notification notification = new Notification();
        notification.id = "1";
        notification.userId = user.id;
        notification.message = "BTC price is $90K";
        NotificationService notificationService = new NotificationService(notification);

        // 3. List Outstanding notifications for this user
        List<NotificationHistory> listOutstanding =  NotificationRepo.listNoticationHistory(user, NotificationStatus.OUTSTANDING);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Total Outstanding: " + listOutstanding.size());
        for (NotificationHistory notificationHistory: listOutstanding){
            System.out.println("Type: " + notificationHistory.type + " Message: " + NotificationRepo.getNotificationById(notificationHistory.notificationId).message);
        }

        // 4. Send this notification.
        notificationService.sendNotification();

        // 5. List successful notifications for this user.
        List<NotificationHistory> successNotification =  NotificationRepo.listNoticationHistory(user, NotificationStatus.SENT);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Total Success: "+ successNotification.size());
        for (NotificationHistory notificationHistory: successNotification){
            System.out.println("Type: " + notificationHistory.type + " Message: " + NotificationRepo.getNotificationById(notificationHistory.notificationId).message);
        }

        // 6. Update user preferences.
        NotificationPref smsPref = new NotificationPref(NotificationType.SMS);
        // Updating to Email and SMS pref
        UserService.addPref(user.id, new NotificationPref[]{emailPred, smsPref});


        // 7. Create a notification for this user and content "BTC price is $100K"
        Notification notification2 = new Notification();
        notification2.id = "2";
        notification2.userId = user.id;
        notification2.message = "BTC price is $100K";
        notificationService = new NotificationService(notification2);

        // 8. List Outstanding notifications for this user
        listOutstanding =  NotificationRepo.listNoticationHistory(user, NotificationStatus.OUTSTANDING);


        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Total Outstanding: " + listOutstanding.size());
        for (NotificationHistory notificationHistory: listOutstanding){
            System.out.println("Type: " + notificationHistory.type + " Message: " + NotificationRepo.getNotificationById(notificationHistory.notificationId).message);
        }
        // 9. Send this notification.
        notificationService.sendNotification();

        // 10. List successful notifications for this user.
        successNotification =  NotificationRepo.listNoticationHistory(user, NotificationStatus.SENT);


        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Total Success: "+ successNotification.size());
        for (NotificationHistory notificationHistory: listOutstanding){
            System.out.println("Type: " + notificationHistory.type + " Message: " + NotificationRepo.getNotificationById(notificationHistory.notificationId).message);
        }
    }
}

// 1. create user with some preferences
// 2. Create a notification for this user and content "BTC price is $90K"
// 3. List Outstanding notifications for this user
// 4. Send this notification.
// 5. List successful notifications for this user.
// 6. Update user preferences.
// 7. Create a notification for this user and content "BTC price is $100K"
// 8. List Outstanding notifications for this user
// 9. Send this notification.
// 10. List successful notifications for this user.