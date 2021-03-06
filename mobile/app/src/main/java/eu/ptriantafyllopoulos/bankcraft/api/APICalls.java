package eu.ptriantafyllopoulos.bankcraft.api;

import eu.ptriantafyllopoulos.bankcraft.model.requests.InvestRequest;
import eu.ptriantafyllopoulos.bankcraft.model.requests.SendTokenRequest;
import eu.ptriantafyllopoulos.bankcraft.model.responseDAOs.InvestDAO;
import eu.ptriantafyllopoulos.bankcraft.model.responseDAOs.SendTokenDAO;
import eu.ptriantafyllopoulos.bankcraft.model.responseDAOs.UserTransactionsDAO;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by p.triantafyllopoulos on 20/10/2017.
 */

public interface APICalls {


    @GET("transactions/a")
    Call<UserTransactionsDAO> getUserTransactions();

    @POST("invest")
    Call<InvestDAO> invest(@Body InvestRequest request);

    @POST("token")
    Call<SendTokenDAO> sendFCMToken(@Body SendTokenRequest request);

}
