package com.jobintech.themain5.emagasin.entity;

import java.util.List;


public class Client {


    private Long clientId;


    private String clientName;

    // One-to-Many relationship with Commande

    private List<Commande> commandes;



    public Client() {
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
}
