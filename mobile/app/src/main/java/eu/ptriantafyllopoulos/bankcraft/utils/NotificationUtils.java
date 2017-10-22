package eu.ptriantafyllopoulos.bankcraft.utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;


import eu.ptriantafyllopoulos.bankcraft.R;
import eu.ptriantafyllopoulos.bankcraft.View.activities.EntryActivity;
import eu.ptriantafyllopoulos.bankcraft.View.activities.FinalActivity;
import eu.ptriantafyllopoulos.bankcraft.View.activities.InvestmentActivity;

/**
 * Created by p.triantafyllopoulos on 22/10/2017.
 */

public class NotificationUtils extends ContextWrapper {
    private NotificationManager mManager;
    public static final String ANDROID_CHANNEL_ID = "eu.panostriantafyllopoulos.bancraft.invest";
    public static final String ANDROID_CHANNEL_NAME = "Investment Notification";

    public NotificationUtils(Context base) {
        super(base);
        createChannels();
    }

    public void createChannels() {

        // create android channel
        NotificationChannel androidChannel = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            androidChannel = new NotificationChannel(ANDROID_CHANNEL_ID,
                    ANDROID_CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            // Sets whether notifications posted to this channel should display notification lights
            androidChannel.enableLights(true);
            // Sets whether notification posted to this channel should vibrate.
            androidChannel.enableVibration(true);
            // Sets the notification light color for notifications posted to this channel
            androidChannel.setLightColor(Color.GREEN);
            // Sets whether notifications posted to this channel appear on the lockscreen or not
            androidChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

            getNotificationManager().createNotificationChannel(androidChannel);
        }

    }

    public NotificationManager getNotificationManager() {
        if (mManager == null) {
            mManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager;
    }

    public NotificationCompat.Builder getDefaultNotification(String title, String body) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Intent acceptIntent = new Intent(getApplicationContext(), FinalActivity.class);
            acceptIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                    | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            Intent declineIntent = new Intent(getApplicationContext(), EntryActivity.class);
            acceptIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                    | Intent.FLAG_ACTIVITY_SINGLE_TOP);


            PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, acceptIntent, 0);
            PendingIntent pi2 = PendingIntent.getActivity(getApplicationContext(), 0, declineIntent, 0);
            return new NotificationCompat.Builder(getApplicationContext(), ANDROID_CHANNEL_ID)
                    .setContentTitle(title)
                    .setContentText(body)
                    .addAction(R.drawable.ic_check_black_24dp,"APPROVE",pi)
                    .addAction(R.drawable.ic_close_black_24dp,"DECLINE",pi2)
                    .setVisibility(Notification.VISIBILITY_PUBLIC)
                    .setColor(getColor(R.color.colorGreen))
                    .setSmallIcon(R.drawable.ic_attach_money_black_24dp)
                    //.setContentIntent(pi)
                    .setAutoCancel(true);
        }
        return null;
    }


}
