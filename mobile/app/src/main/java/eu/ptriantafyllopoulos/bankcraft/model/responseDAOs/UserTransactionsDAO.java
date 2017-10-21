package eu.ptriantafyllopoulos.bankcraft.model.responseDAOs;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by p.triantafyllopoulos on 21/10/2017.
 */

public class UserTransactionsDAO {


    @SerializedName("transactions")
    private List<Transactions> transactions;
    @SerializedName("total")
    private double totalInvestAmount;

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    public double getTotalInvestAmount() {
        return totalInvestAmount;
    }

    public void setTotalInvestAmount(double totalInvestAmount) {
        this.totalInvestAmount = totalInvestAmount;
    }

    public static class Transactions {
        @SerializedName("datetime")
        private String datetime;
        @SerializedName("description")
        private String description;
        @SerializedName("amount")
        private double amount;
        @SerializedName("investedAmount")
        private double investedAmount;

        public String getDatetime() {
            return datetime;
        }

        public void setDatetime(String datetime) {
            this.datetime = datetime;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public double getInvestedAmount() {
            return investedAmount;
        }

        public void setInvestedAmount(double investedAmount) {
            this.investedAmount = investedAmount;
        }
    }

}
