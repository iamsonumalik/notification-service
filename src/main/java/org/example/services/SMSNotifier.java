package org.example.services;

import org.example.entity.Notification;

public class SMSNotifier extends NotifierService{

    @Override
    public boolean send(Notification notification)  {
        return true;
    }
}
