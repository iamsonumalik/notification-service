package org.example.notifiers;

import org.example.entity.Notification;

public class EmailNotifier extends NotifierFactory {

    @Override
    public boolean send(Notification notification)  {
        return true;
    }
}
