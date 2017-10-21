package eu.ptriantafyllopoulos.bankcraft.model.events;

import eu.ptriantafyllopoulos.bankcraft.model.responseDAOs.UserTransactionsDAO;

/**
 * Created by p.triantafyllopoulos on 21/10/2017.
 */

public class GetUserTransactionsResponseEvent {

    private UserTransactionsDAO transactionsDAO;
    private String networkError;

    public GetUserTransactionsResponseEvent(UserTransactionsDAO transactionsDAO) {
        this.transactionsDAO = transactionsDAO;
    }

    public GetUserTransactionsResponseEvent(String networkError) {
        this.networkError = networkError;
    }

    public UserTransactionsDAO getTransactionsDAO() {
        return transactionsDAO;
    }

    public void setTransactionsDAO(UserTransactionsDAO transactionsDAO) {
        this.transactionsDAO = transactionsDAO;
    }

    public String getNetworkError() {
        return networkError;
    }

    public void setNetworkError(String networkError) {
        this.networkError = networkError;
    }
}
