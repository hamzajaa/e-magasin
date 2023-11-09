package com.jobintech.themain5.emagasin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paiementId;
    private long commandeId;
    private double montant;
    private  EtatPaiement etatPaiement;
    private String methodDePaiement;


    public paiement() {
    }

    public paiement(long paiementId, long commandeId, double montant, EtatPaiement etatPaiement, String methodDePaiement) {
        this.paiementId = paiementId;
        this.commandeId = commandeId;
        this.montant = montant;
        this.etatPaiement = etatPaiement;
        this.methodDePaiement = methodDePaiement;
    }

    public long getPaiementId() {
        return paiementId;
    }

    public void setPaiementId(long paiementId) {
        this.paiementId = paiementId;
    }

    public long getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(long commandeId) {
        this.commandeId = commandeId;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getMethodDePaiement() {
        return methodDePaiement;
    }

    public void setMethodDePaiement(String methodDePaiement) {
        this.methodDePaiement = methodDePaiement;
    }

    public EtatPaiement getEtatPaiement() {
        return etatPaiement;
    }

    public void setEtatPaiement(EtatPaiement etatPaiement) {
        this.etatPaiement = etatPaiement;
    }
}
