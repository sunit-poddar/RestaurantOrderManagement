package com.example.restaurantnotificationlistener;

import android.app.Notification;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

public class RestaurantNotificationListenerService extends NotificationListenerService {
    private static final String TAG = "NotificationListener";

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        Log.i(TAG, "Notification Posted: " + sbn.getPackageName());

        // Get the notification object
        Notification notification = sbn.getNotification();

        // Get the notification extras
        Bundle extras = notification.extras;

        // Extract notification title and text
        String notificationTitle = extras.getString(Notification.EXTRA_TITLE);
        CharSequence notificationTextCharSequence = extras.getCharSequence(Notification.EXTRA_TEXT);
        String notificationText = notificationTextCharSequence != null ? notificationTextCharSequence.toString() : null;

        // Log the title and text
        Log.i(TAG, "Notification Title: " + notificationTitle);
        Log.i(TAG, "Notification Text: " + notificationText);

        // Extract other useful information
        CharSequence notificationSubTextCharSequence = extras.getCharSequence(Notification.EXTRA_SUB_TEXT);
        String notificationSubText = notificationSubTextCharSequence != null ? notificationSubTextCharSequence.toString() : null;
        CharSequence notificationBigTextCharSequence = extras.getCharSequence(Notification.EXTRA_BIG_TEXT);
        String notificationBigText = notificationBigTextCharSequence != null ? notificationBigTextCharSequence.toString() : null;

        // Log other details if available
        if (notificationSubText != null) {
            Log.i(TAG, "Notification SubText: " + notificationSubText);
        }

        if (notificationBigText != null) {
            Log.i(TAG, "Notification BigText: " + notificationBigText);
        }
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        Log.i(TAG, "Notification Removed: " + sbn.getPackageName());
        // You can add more logic here to process the notification removal
    }
}
