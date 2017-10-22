package eu.ptriantafyllopoulos.bankcraft.View.activities;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import eu.ptriantafyllopoulos.bankcraft.BankCraftApplication;
import eu.ptriantafyllopoulos.bankcraft.R;
import eu.ptriantafyllopoulos.bankcraft.View.fragments.TransactionListFragment;
import eu.ptriantafyllopoulos.bankcraft.model.responseDAOs.UserTransactionsDAO;
import eu.ptriantafyllopoulos.bankcraft.utils.AmountUtils;
import eu.ptriantafyllopoulos.bankcraft.utils.NotificationUtils;
import eu.ptriantafyllopoulos.bankcraft.utils.RuntimeStorage;
import eu.ptriantafyllopoulos.bankcraft.utils.RuntimeStorageKeys;

public class TransactionsActivity extends BaseActivity  implements TransactionListFragment.OnTransactionListFragmentInteractionListener{

    private NotificationUtils mNotificationUtils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);

        UserTransactionsDAO transactionsDAO = (UserTransactionsDAO) RuntimeStorage.getInstance().getObject(RuntimeStorageKeys.TRANSACTION_DAO);
        mNotificationUtils = new NotificationUtils(BankCraftApplication.getInstance().getApplicationContext());
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TransactionListFragment fragment = TransactionListFragment.newInstance();
        fragmentTransaction.add(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            raiseNotificationOreo("Investment Oportunity","Your round up money to invest is: "+ AmountUtils.formatAmount(transactionsDAO.getTotalInvestAmount()));
        }else{
            raiseNotificationPreOreo(this,"Investment Oportunity","Your round up money to invest is: "+ AmountUtils.formatAmount(transactionsDAO.getTotalInvestAmount()));
        }


    }

    private void raiseNotificationOreo(String title, String body){
        NotificationCompat.Builder nb = mNotificationUtils.
                getDefaultNotification(title, body);

        mNotificationUtils.getNotificationManager().notify(1, nb.build());
    }

    private static void raiseNotificationPreOreo(Context c, String title, String body) {
        int notificationID = 1;
        Intent notificationIntent = new Intent(c, InvestmentActivity.class);
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

    //TransactionListFragment Callbacks
    @Override
    public void onInvestClicked() {
        startActivity(new Intent(this,InvestmentActivity.class));
    }
}
