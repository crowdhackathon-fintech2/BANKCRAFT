package eu.ptriantafyllopoulos.bankcraft.View.activities;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

import eu.ptriantafyllopoulos.bankcraft.BankCraftApplication;
import eu.ptriantafyllopoulos.bankcraft.R;
import eu.ptriantafyllopoulos.bankcraft.View.fragments.InvestmentFragment;
import eu.ptriantafyllopoulos.bankcraft.api.ServiceCalls;
import eu.ptriantafyllopoulos.bankcraft.model.events.InvestResponseEvent;
import eu.ptriantafyllopoulos.bankcraft.model.requests.InvestRequest;


public class InvestmentActivity extends BaseActivity implements InvestmentFragment.OnInvestmentFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investment);

        BankCraftApplication.getInstance().getEventBus().register(this);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        InvestmentFragment fragment = InvestmentFragment.newInstance();
        fragmentTransaction.add(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        BankCraftApplication.getInstance().getEventBus().unregister(this);
    }

    /* Callbacks from Fragment */
    @Override
    public void onOptionClicked(int optKey) {
        getAppLoader().showLoader(this,R.drawable.app_loader);
        InvestRequest request = new InvestRequest();
        request.setInvestOpt(optKey);
        ServiceCalls.manageInvestOption(request);
    }

    /**
     * Otto Subscriber to listen the event of an incoming call
     * Move to Presenter in the future to enforcee MVP Patern
     */
    @SuppressWarnings("unused")
    @Subscribe
    public void onManageInvestOptionResponse(InvestResponseEvent responseEvent) {
        getAppLoader().dismissLoader(this);
        if (responseEvent.getInvestDAO() != null && responseEvent.getInvestDAO().isStatus()) {
            Toast.makeText(this, "CALL success", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "CALL FAILED", Toast.LENGTH_LONG).show();
        }

    }
}
