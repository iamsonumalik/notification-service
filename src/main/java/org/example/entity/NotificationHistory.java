package org.example.entity;

import org.example.enums.NotificationStatus;
import org.example.enums.NotificationType;

import java.util.Date;

public class NotificationHistory {
    public String id;
    public String notificationId;
    public String userId;
    public NotificationType type;
    public NotificationStatus status;
    public Date createdAt;
    public Date updatedAt;
}
