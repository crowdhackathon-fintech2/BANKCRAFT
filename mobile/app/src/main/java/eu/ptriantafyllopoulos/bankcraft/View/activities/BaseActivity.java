package eu.ptriantafyllopoulos.bankcraft.View.activities;

import android.support.v7.app.AppCompatActivity;

import eu.ptriantafyllopoulos.bankcraft.View.AppLoader;
import eu.ptriantafyllopoulos.bankcraft.model.responseDAOs.UserTransactionsDAO;

public abstract class BaseActivity extends AppCompatActivity {

    AppLoader appLoader = new AppLoader();

    public AppLoader getAppLoader() {
        return appLoader;
    }


    public void setAppLoader(AppLoader appLoader) {
        this.appLoader = appLoader;
    }
}

