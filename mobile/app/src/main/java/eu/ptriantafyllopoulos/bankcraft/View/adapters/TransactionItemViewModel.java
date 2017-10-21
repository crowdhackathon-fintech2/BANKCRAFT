package eu.ptriantafyllopoulos.bankcraft.View.adapters;

/**
 * Created by p.triantafyllopoulos on 21/10/2017.
 */

public class TransactionItemViewModel {

    String descreption;
    String date;
    double amount;
    double investAmount;

    public TransactionItemViewModel(String descreption, String date, double amount, double investAmount) {
        this.descreption = descreption;
        this.date = date;
        this.amount = amount;
        this.investAmount = investAmount;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getInvestAmount() {
        return investAmount;
    }

    public void setInvestAmount(double investAmount) {
        this.investAmount = investAmount;
    }
}
