package eu.ptriantafyllopoulos.bankcraft.model.requests;

import com.google.gson.annotations.SerializedName;

/**
 * Created by p.triantafyllopoulos on 22/10/2017.
 */

public class SendTokenRequest {

    @SerializedName("token")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
