module SmsNotification {
    exports packageSms;
    requires NotificationService;
    provides packageNotification.INotificationService with packageSms.SmsNotification;
}