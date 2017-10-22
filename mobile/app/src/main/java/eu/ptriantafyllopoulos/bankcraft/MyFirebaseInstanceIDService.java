package eu.ptriantafyllopoulos.bankcraft;

import android.app.Service;

import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by p.triantafyllopoulos on 22/10/2017.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
    }
}
