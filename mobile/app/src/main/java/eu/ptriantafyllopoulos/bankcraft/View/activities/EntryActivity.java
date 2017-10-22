package eu.ptriantafyllopoulos.bankcraft.View.activities;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

import eu.ptriantafyllopoulos.bankcraft.BankCraftApplication;
import eu.ptriantafyllopoulos.bankcraft.R;
import eu.ptriantafyllopoulos.bankcraft.api.ServiceCalls;
import eu.ptriantafyllopoulos.bankcraft.model.events.GetUserTransactionsResponseEvent;
import eu.ptriantafyllopoulos.bankcraft.utils.RuntimeStorage;
import eu.ptriantafyllopoulos.bankcraft.utils.RuntimeStorageKeys;

public class EntryActivity extends BaseActivity {

    /* View Variables */
    CardView nbgCard;
    CardView alphaCard;
    CardView efgCard;
    CardView winbankCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        final Handler handler = new Handler();
        setContentView(R.layout.activity_entry);
        nbgCard = findViewById(R.id.card1);
        alphaCard = findViewById(R.id.card2);
        efgCard = findViewById(R.id.card3);
        winbankCard = findViewById(R.id.card4);


        nbgCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ServiceCalls.getUserTransactions("User1");
                getAppLoader().showLoader(EntryActivity.this, R.drawable.nbg_icon);

            }
        });

        alphaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAppLoader().showLoader(EntryActivity.this, R.drawable.alpha_logo);
                if (handler != null) {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            getAppLoader().dismissLoader(EntryActivity.this);
                            handler.removeCallbacks(this);
                        }
                    }, 4000L);
                }
            }
        });

        efgCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAppLoader().showLoader(EntryActivity.this, R.drawable.eurobank_logo);
                if (handler != null) {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            getAppLoader().dismissLoader(EntryActivity.this);
                            handler.removeCallbacks(this);
                        }
                    }, 4000L);
                }
            }
        });

        winbankCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAppLoader().showLoader(EntryActivity.this, R.drawable.piraeus_logo);
                if (handler != null) {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            getAppLoader().dismissLoader(EntryActivity.this);
                            startActivity(new Intent(EntryActivity.this, TransactionsActivity.class));
                            handler.removeCallbacks(this);
                        }
                    }, 4000L);
                }
            }
        });


    }

    @Override
    protected void onPause() {
        super.onPause();
        BankCraftApplication.getInstance().getEventBus().unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        BankCraftApplication.getInstance().getEventBus().register(this);
    }

    @SuppressWarnings("unused")
    @Subscribe
    public void onGetUserTransactionsResponse(GetUserTransactionsResponseEvent responseEvent) {
        getAppLoader().dismissLoader(this);
        if (responseEvent.getTransactionsDAO() != null) {
            RuntimeStorage.getInstance().put(RuntimeStorageKeys.TRANSACTION_DAO, responseEvent.getTransactionsDAO());
            startActivity(new Intent(this, TransactionsActivity.class));

        } else {
            Toast.makeText(this, "CALL FAILED", Toast.LENGTH_LONG).show();
        }

    }
}
