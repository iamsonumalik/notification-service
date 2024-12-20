package org.example.services;

import org.example.entity.Notification;
import org.example.notifiers.NotifierFactory;
import org.example.repository.NotificationRepo;

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
        NotifierFactory.notify(notification);
    }

}
