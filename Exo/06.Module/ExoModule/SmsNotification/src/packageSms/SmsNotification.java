package packageSms;

import packageNotification.INotificationService;

import java.io.Serializable;

public class SmsNotification implements INotificationService, Serializable {

    @Override
    public String  sendNotification(String notification) {
        return notification + " depuis les sms";
    }
}
