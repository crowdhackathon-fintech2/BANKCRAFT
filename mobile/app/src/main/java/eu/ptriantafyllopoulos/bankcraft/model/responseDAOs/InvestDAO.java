package eu.ptriantafyllopoulos.bankcraft.model.responseDAOs;

import com.google.gson.annotations.SerializedName;

/**
 * Created by p.triantafyllopoulos on 21/10/2017.
 */

public class InvestDAO {


    @SerializedName("status")
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
