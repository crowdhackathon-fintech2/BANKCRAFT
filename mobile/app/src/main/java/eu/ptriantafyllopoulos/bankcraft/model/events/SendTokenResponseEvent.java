package eu.ptriantafyllopoulos.bankcraft.model.events;

import eu.ptriantafyllopoulos.bankcraft.model.responseDAOs.InvestDAO;
import eu.ptriantafyllopoulos.bankcraft.model.responseDAOs.SendTokenDAO;

/**
 * Created by p.triantafyllopoulos on 22/10/2017.
 */

public class SendTokenResponseEvent {
    private SendTokenDAO sendTokenDao;
    private String networkError;

    public SendTokenResponseEvent(SendTokenDAO sendTokenDao) {
        this.sendTokenDao = sendTokenDao;
    }

    public SendTokenResponseEvent(String networkError) {
        this.networkError = networkError;
    }

    public SendTokenDAO getSendTokenDao() {
        return sendTokenDao;
    }

    public void setSendTokenDao(SendTokenDAO sendTokenDao) {
        this.sendTokenDao = sendTokenDao;
    }

    public String getNetworkError() {
        return networkError;
    }

    public void setNetworkError(String networkError) {
        this.networkError = networkError;
    }
}
