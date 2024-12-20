package org.example.notifiers;

import org.example.entity.Notification;

public class SMSNotifier extends NotifierFactory {

    @Override
    public boolean send(Notification notification)  {
        return true;
    }
}
