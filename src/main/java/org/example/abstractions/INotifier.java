package org.example.abstractions;

import org.example.entity.Notification;

public interface INotifier {
    public boolean send(Notification notification);
}
