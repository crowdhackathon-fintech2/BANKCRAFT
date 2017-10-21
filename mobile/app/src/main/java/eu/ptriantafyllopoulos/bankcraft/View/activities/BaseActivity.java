package eu.ptriantafyllopoulos.bankcraft.View.activities;

import android.support.v7.app.AppCompatActivity;

import eu.ptriantafyllopoulos.bankcraft.View.AppLoader;

public abstract class BaseActivity extends AppCompatActivity {
    AppLoader appLoader = new AppLoader();

    public AppLoader getAppLoader() {
        return appLoader;
    }

}

