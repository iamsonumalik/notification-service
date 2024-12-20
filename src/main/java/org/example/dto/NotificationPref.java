package org.example.dto;

import org.example.enums.NotificationType;

public class NotificationPref {
    public NotificationType notificationType;

    public NotificationPref(NotificationType notificationType) {
        this.notificationType = notificationType;
    }
}
