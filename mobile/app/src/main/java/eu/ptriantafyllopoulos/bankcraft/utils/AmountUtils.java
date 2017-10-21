package eu.ptriantafyllopoulos.bankcraft.utils;

import java.text.DecimalFormat;

/**
 * Created by p.triantafyllopoulos on 21/10/2017.
 */

public class AmountUtils {

    public static String formatAmount(double amount){
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format(amount);
    }
}
