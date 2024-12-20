package org.example.notifiers;

import org.example.entity.Notification;

public class PushNotifier extends NotifierFactory {

    @Override
    public boolean send(Notification notification)  {
        return true;
    }
}
