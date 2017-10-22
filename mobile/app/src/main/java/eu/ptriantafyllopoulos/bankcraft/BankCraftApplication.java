package eu.ptriantafyllopoulos.bankcraft;

import android.app.Application;

import com.google.firebase.iid.FirebaseInstanceId;
import com.squareup.otto.Bus;

import java.util.concurrent.TimeUnit;

import eu.ptriantafyllopoulos.bankcraft.utils.NotificationUtils;
import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by p.triantafyllopoulos on 20/10/2017.
 */

public class BankCraftApplication extends Application {

    /* Application Instance */
    private static BankCraftApplication instance;
    /* Http Client Instance */
    private OkHttpClient okHttpClient;
    /* Event Bus Instance */
    @Deprecated
    private Bus eventBus;

    /* Firebase Instance */
    String firebaseInstanceId;

    private NotificationUtils mNotificationUtils;



    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        okHttpClient = createOkHttpClient();
        eventBus = new Bus();
        firebaseInstanceId = FirebaseInstanceId.getInstance().getToken();
        mNotificationUtils = new NotificationUtils(BankCraftApplication.getInstance().getApplicationContext());
    }
    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static BankCraftApplication getInstance() {
        return instance;
    }


    /**
     * Constructs The Http Client for Retrofit
     * @return OkHttpClient
     * */
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

    public String getFirebaseInstanceId() {
        return firebaseInstanceId;
    }

    public void setFirebaseInstanceId(String firebaseInstanceId) {
        this.firebaseInstanceId = firebaseInstanceId;
    }

    public NotificationUtils getmNotificationUtils() {
        return mNotificationUtils;
    }

    public void setmNotificationUtils(NotificationUtils mNotificationUtils) {
        this.mNotificationUtils = mNotificationUtils;
    }
}
