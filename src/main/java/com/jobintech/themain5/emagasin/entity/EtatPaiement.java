package com.jobintech.themain5.emagasin.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "etat-paiements")
public class EtatPaiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;
    public EtatPaiement() {
    }

    public EtatPaiement(Long id, String label) {
        this.id = id;
        this.label = label;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
