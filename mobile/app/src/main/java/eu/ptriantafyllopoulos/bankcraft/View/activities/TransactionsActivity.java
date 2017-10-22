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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TransactionListFragment fragment = TransactionListFragment.newInstance();
        fragmentTransaction.add(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

    }



    //TransactionListFragment Callbacks
    @Override
    public void onInvestClicked() {
        startActivity(new Intent(this,InvestmentActivity.class));
    }
}
