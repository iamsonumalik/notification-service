package org.example.notifiers;

import org.example.entity.Notification;
import org.example.entity.NotificationHistory;
import org.example.enums.NotificationStatus;
import org.example.enums.NotificationType;
import org.example.repository.NotificationRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotifierFactory implements INotifier {

    static Map<NotificationType, NotifierFactory> notifiers = new HashMap<>();
    static {
        notifiers.put(NotificationType.EMAIL, new EmailNotifier());
        notifiers.put(NotificationType.SMS, new SMSNotifier());
        notifiers.put(NotificationType.PUSH, new PushNotifier());
    }
    public static void notify(Notification notification){
        List<NotificationHistory> notificationHistorys = NotificationRepo.getNotificationHistory(notification.id);
        for(NotificationHistory notificationHistory: notificationHistorys) {
            if(notifiers.get(notificationHistory.type).send(notification)){
                notificationHistory.status = NotificationStatus.SENT;
            }else{
                notificationHistory.status = NotificationStatus.FAILED;
            }
            NotificationRepo.updateNotificationHistory(notificationHistory);
        }
    }

    @Override
    public boolean send(Notification notification) {
        return false;
    }
}
