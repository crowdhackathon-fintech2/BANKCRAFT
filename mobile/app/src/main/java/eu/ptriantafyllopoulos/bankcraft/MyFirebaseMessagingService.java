package eu.ptriantafyllopoulos.bankcraft;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

import eu.ptriantafyllopoulos.bankcraft.View.activities.FinalActivity;
import eu.ptriantafyllopoulos.bankcraft.View.activities.InvestmentActivity;
import eu.ptriantafyllopoulos.bankcraft.utils.AmountUtils;

/**
 * Created by p.triantafyllopoulos on 22/10/2017.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Map<String,String> map = remoteMessage.getData();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            raiseNotificationOreo("Investment Oportunity","Your round up money to invest is: "+map.get("amount")+"EUR");
        }else{
            raiseNotificationPreOreo(this,"Investment Oportunity","Your round up money to invest is: "+map.get("amount")+"EUR");
        }
    }

    private void raiseNotificationOreo(String title, String body){
        NotificationCompat.Builder nb = BankCraftApplication.getInstance().getmNotificationUtils().
                getDefaultNotification(title, body);

        BankCraftApplication.getInstance().getmNotificationUtils().getNotificationManager().notify(1, nb.build());
    }

    /**
     * Function to Raise Android OS Notification to inform the user for a possible ongoing web transaction
     * and to request action to approve or deny the action.
     *
     * @param c     The basic context to set up the notification
     * @param title String : The title of the notification
     * @param body  String : The text content of the notification
     */
    private static void raiseNotificationPreOreo(Context c, String title, String body) {
        int notificationID = 1;
        Intent notificationIntent = new Intent(c, FinalActivity.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_SINGLE_TOP);


        PendingIntent pi = PendingIntent.getActivity(c, 0, notificationIntent, 0);
        Uri alertSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(c)
                        .setSmallIcon(R.drawable.ic_attach_money_black_24dp)
                        .setContentTitle(title)
                        .setContentText(body).
                        setSound(alertSound)
                        .setColor(ContextCompat.getColor(c, R.color.colorGreen))
                        .setVibrate(new long[]{1000, 1000})
                        .setLights(ContextCompat.getColor(c, R.color.colorGreen), 3000, 3000).
                        setContentIntent(pi).setAutoCancel(true);



        NotificationManager mNotificationManager = (NotificationManager) c.getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(notificationID, mBuilder.build());
    }
}
