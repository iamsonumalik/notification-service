package org.example.services;

import org.example.entity.Notification;
import org.example.entity.NotificationHistory;
import org.example.entity.User;
import org.example.repository.NotificationRepo;

import java.util.List;

public class NotificationService {
    private final Notification notification;

    public NotificationService(String id){
        notification = NotificationRepo.getNotificationById(id);
    }

    public NotificationService(Notification notification){
        NotificationRepo.createNotification(notification);
        this.notification = notification;
    }

    public void sendNotification(){
        NotifierService.notify(notification);
    }

}
