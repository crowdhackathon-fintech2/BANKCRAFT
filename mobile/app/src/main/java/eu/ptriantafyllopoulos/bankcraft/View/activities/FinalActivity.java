package eu.ptriantafyllopoulos.bankcraft.View.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import eu.ptriantafyllopoulos.bankcraft.R;
import eu.ptriantafyllopoulos.bankcraft.api.ServiceCalls;
import eu.ptriantafyllopoulos.bankcraft.model.requests.InvestRequest;
import eu.ptriantafyllopoulos.bankcraft.utils.ServiceCallsKeys;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        InvestRequest req = new InvestRequest();
        req.setInvestOpt(ServiceCallsKeys.InvestOptionAliases.BITCOIN);
        ServiceCalls.manageInvestOption(req);
    }
}
