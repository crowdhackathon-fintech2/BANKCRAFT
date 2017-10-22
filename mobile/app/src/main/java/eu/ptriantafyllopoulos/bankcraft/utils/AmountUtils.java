package eu.ptriantafyllopoulos.bankcraft.utils;

import java.text.DecimalFormat;

/**
 * Created by p.triantafyllopoulos on 21/10/2017.
 */

public class AmountUtils {

    /**
     * Function to format amount (double) from server and transform to String object
     *
     * @param amount double
     * @return String
     */
    public static String formatAmount(double amount) {
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format(amount);
    }
}
