package packageEmail;

import packageNotification.INotificationService;

public class EmailNotification implements INotificationService {

    @Override
    public String sendNotification(String notification) {
        return notification + " depuis les Emails";
    }
}
