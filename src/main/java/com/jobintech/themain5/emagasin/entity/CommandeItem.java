package com.jobintech.themain5.emagasin.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class CommandeItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;
    private BigDecimal prix;
    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;
    private Long productId;


    public CommandeItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Long getProduct_id() {
        return productId;
    }

    public void setProduct_id(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }
}
