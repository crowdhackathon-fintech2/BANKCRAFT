package eu.ptriantafyllopoulos.bankcraft.View.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import eu.ptriantafyllopoulos.bankcraft.R;
import eu.ptriantafyllopoulos.bankcraft.View.fragments.TransactionListFragment;

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
}
