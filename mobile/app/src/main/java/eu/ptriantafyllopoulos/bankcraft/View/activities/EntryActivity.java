package eu.ptriantafyllopoulos.bankcraft.View.activities;

import android.os.Handler;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

import eu.ptriantafyllopoulos.bankcraft.BankCraftApplication;
import eu.ptriantafyllopoulos.bankcraft.R;
import eu.ptriantafyllopoulos.bankcraft.View.loadingWidget.WaveDrawable;
import eu.ptriantafyllopoulos.bankcraft.api.ServiceCalls;
import eu.ptriantafyllopoulos.bankcraft.model.events.GetUserTransactionsResponseEvent;

public class EntryActivity extends BaseActivity {


    CardView nbgCard;
    CardView alphaCard;
    CardView efgCard;
    CardView winbankCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BankCraftApplication.getInstance().getEventBus().register(this);

        final Handler handler = new Handler();
        setContentView(R.layout.activity_entry);
        nbgCard= findViewById(R.id.card1);
        alphaCard= findViewById(R.id.card2);
        efgCard= findViewById(R.id.card3);
        winbankCard= findViewById(R.id.card4);


        ServiceCalls.getUserTransactions("User1");

        nbgCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAppLoader().showLoader(EntryActivity.this,R.drawable.nbg_icon);
                if(handler != null) {
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

        alphaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAppLoader().showLoader(EntryActivity.this,R.drawable.alpha_logo);
                if(handler != null) {
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
                getAppLoader().showLoader(EntryActivity.this,R.drawable.eurobank_logo);
                if(handler != null) {
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
                getAppLoader().showLoader(EntryActivity.this,R.drawable.piraeus_logo);
                if(handler != null) {
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


    }

    @Subscribe
    public void onGetUserTransactionsResponse(GetUserTransactionsResponseEvent responseEvent) {


    }
}
