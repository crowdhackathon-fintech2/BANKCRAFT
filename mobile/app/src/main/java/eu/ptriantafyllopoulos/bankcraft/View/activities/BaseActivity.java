package eu.ptriantafyllopoulos.bankcraft.View.activities;

import android.support.v7.app.AppCompatActivity;

import eu.ptriantafyllopoulos.bankcraft.View.AppLoader;
import eu.ptriantafyllopoulos.bankcraft.model.responseDAOs.UserTransactionsDAO;

public abstract class BaseActivity extends AppCompatActivity {
    UserTransactionsDAO userTransactionsDAO;
    AppLoader appLoader = new AppLoader();

    public AppLoader getAppLoader() {
        return appLoader;
    }

    public UserTransactionsDAO getUserTransactionsDAO() {
        return userTransactionsDAO;
    }

    public void setUserTransactionsDAO(UserTransactionsDAO userTransactionsDAO) {
        this.userTransactionsDAO = userTransactionsDAO;
    }

    public void setAppLoader(AppLoader appLoader) {
        this.appLoader = appLoader;
    }
}

