package eu.ptriantafyllopoulos.bankcraft.model.events;

import eu.ptriantafyllopoulos.bankcraft.model.responseDAOs.InvestDAO;

/**
 * Created by p.triantafyllopoulos on 21/10/2017.
 */

public class InvestResponseEvent {
    private InvestDAO investDAO;
    private String networkError;

    public InvestResponseEvent(InvestDAO investDAO) {
        this.investDAO = investDAO;
    }

    public InvestResponseEvent(String networkError) {
        this.networkError = networkError;
    }

    public InvestDAO getInvestDAO() {
        return investDAO;
    }

    public void setInvestDAO(InvestDAO investDAO) {
        this.investDAO = investDAO;
    }

    public String getNetworkError() {
        return networkError;
    }

    public void setNetworkError(String networkError) {
        this.networkError = networkError;
    }
}
