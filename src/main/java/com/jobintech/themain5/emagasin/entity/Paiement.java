package com.jobintech.themain5.emagasin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paiementId;

    @OneToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;
    private double montant;
    @ManyToOne
    @JoinColumn(name = "etatPaiement_id")
    private  EtatPaiement etatPaiement;
    private String methodDePaiement;



    public Paiement() {
    }

    public Paiement(long paiementId, Commande commande, double montant, EtatPaiement etatPaiement, String methodDePaiement) {
        this.paiementId = paiementId;
        this.commande = commande;
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

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public EtatPaiement getEtatPaiement() {
        return etatPaiement;
    }

    public void setEtatPaiement(EtatPaiement etatPaiement) {
        this.etatPaiement = etatPaiement;
    }

    public String getMethodDePaiement() {
        return methodDePaiement;
    }

    public void setMethodDePaiement(String methodDePaiement) {
        this.methodDePaiement = methodDePaiement;
    }
}
