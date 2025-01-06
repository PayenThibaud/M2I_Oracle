module EmailNotification {
    exports packageEmail;
    requires NotificationService;
    provides packageNotification.INotificationService with packageEmail.EmailNotification;
}