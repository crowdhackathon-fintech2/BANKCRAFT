package eu.ptriantafyllopoulos.bankcraft;

import android.app.Application;

import com.squareup.otto.Bus;

import java.util.concurrent.TimeUnit;

import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by p.triantafyllopoulos on 20/10/2017.
 */

public class BankCraftApplication extends Application {

    private static BankCraftApplication instance;
    private OkHttpClient okHttpClient;
    private Bus eventBus;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        okHttpClient = createOkHttpClient();
        eventBus = new Bus();
    }
    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static BankCraftApplication getInstance() {
        return instance;
    }


    private OkHttpClient createOkHttpClient(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);



        return new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addNetworkInterceptor(logging).build();
    }

    public OkHttpClient getOkHttpClient(){
        return okHttpClient;
    }

    public Bus getEventBus() {
        return eventBus;
    }
}
