package eu.ptriantafyllopoulos.bankcraft.model.requests;

import com.google.gson.annotations.SerializedName;

/**
 * Created by p.triantafyllopoulos on 21/10/2017.
 */

public class InvestRequest {

    @SerializedName("investOpt")
    private int investOpt;

    public int getInvestOpt() {
        return investOpt;
    }

    public void setInvestOpt(int investOpt) {
        this.investOpt = investOpt;
    }
}
