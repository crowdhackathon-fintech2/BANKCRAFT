package eu.ptriantafyllopoulos.bankcraft.model.responseDAOs;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by p.triantafyllopoulos on 21/10/2017.
 */

public class UserTransactionsDAO {


    @SerializedName("Transactions")
    private List<Transactions> Transactions;

    public List<Transactions> getTransactions() {
        return Transactions;
    }

    public void setTransactions(List<Transactions> Transactions) {
        this.Transactions = Transactions;
    }

    public static class Transactions {
        @SerializedName("datetime")
        private int datetime;
        @SerializedName("description")
        private String description;
        @SerializedName("Amount")
        private double Amount;
        @SerializedName("investedAmount")
        private double investedAmount;

        public int getDatetime() {
            return datetime;
        }

        public void setDatetime(int datetime) {
            this.datetime = datetime;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getAmount() {
            return Amount;
        }

        public void setAmount(double Amount) {
            this.Amount = Amount;
        }

        public double getInvestedAmount() {
            return investedAmount;
        }

        public void setInvestedAmount(double investedAmount) {
            this.investedAmount = investedAmount;
        }
    }
}
