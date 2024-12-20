package org.example.services;

import org.example.entity.Notification;

public class PushNotifier extends NotifierService{

    @Override
    public boolean send(Notification notification)  {
        return true;
    }
}
