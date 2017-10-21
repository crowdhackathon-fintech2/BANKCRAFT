package eu.ptriantafyllopoulos.bankcraft.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import eu.ptriantafyllopoulos.bankcraft.BankCraftApplication;
import eu.ptriantafyllopoulos.bankcraft.Config;
import eu.ptriantafyllopoulos.bankcraft.model.events.GetUserTransactionsResponseEvent;
import eu.ptriantafyllopoulos.bankcraft.model.events.InvestResponseEvent;
import eu.ptriantafyllopoulos.bankcraft.model.requests.InvestRequest;
import eu.ptriantafyllopoulos.bankcraft.model.responseDAOs.InvestDAO;
import eu.ptriantafyllopoulos.bankcraft.model.responseDAOs.UserTransactionsDAO;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by p.triantafyllopoulos on 21/10/2017.
 */

public class ServiceCalls {

    private static Retrofit getRetrofitEngine() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        OkHttpClient httpClient = BankCraftApplication.getInstance().getOkHttpClient();

        return new Retrofit.Builder().baseUrl(Config.BASE_URL).client(httpClient)
                .addConverterFactory(GsonConverterFactory.create(gson)).build();


    }


    /**
     * Service Call to retrieve User Transactions
     * @param id String
     * **/
    public static void getUserTransactions(String id)
    {
        APICalls invocations = getRetrofitEngine().create(APICalls.class);
        Call<UserTransactionsDAO> call = invocations.getUserTransactions();
        call.enqueue(new retrofit2.Callback<UserTransactionsDAO>() {
            @Override
            public void onResponse(Call<UserTransactionsDAO> call, Response<UserTransactionsDAO> response) {
                BankCraftApplication.getInstance().getEventBus().post(new GetUserTransactionsResponseEvent(response.body()));
            }

            @Override
            public void onFailure(Call<UserTransactionsDAO> call, Throwable t) {
                BankCraftApplication.getInstance().getEventBus().post(new GetUserTransactionsResponseEvent(t.getMessage()));
            }
        });
    }

    /**
     * Service Call to Invest User Savings in the selected option
     * @param investRequest InvestRequest
     * **/
    public static void manageAlias(InvestRequest investRequest) {
        APICalls invocations = getRetrofitEngine().create(APICalls.class);

        Call<InvestDAO> call = invocations.invest( investRequest);
        call.enqueue(new retrofit2.Callback<InvestDAO>() {
            @Override
            public void onResponse(Call<InvestDAO> call, Response<InvestDAO> response) {
                BankCraftApplication.getInstance().getEventBus().post(new InvestResponseEvent(response.body()));
            }

            @Override
            public void onFailure(Call<InvestDAO> call, Throwable t) {
                BankCraftApplication.getInstance().getEventBus().post(new InvestResponseEvent(t.getMessage()));
            }
        });
    }

}
