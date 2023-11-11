package com.jobintech.themain5.emagasin.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "commandes")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;
    private BigDecimal totalPaye;
    @CreationTimestamp
    private LocalDateTime dateCommande;
    private Long clientId;
    @OneToMany(mappedBy = "commande", fetch = FetchType.LAZY)
    private List<CommandeItem> commandItems;

    public Commande() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotalPaye() {
        return totalPaye;
    }

    public void setTotalPaye(BigDecimal totalPaye) {
        this.totalPaye = totalPaye;
    }

    public LocalDateTime getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDateTime dateCommande) {
        this.dateCommande = dateCommande;
    }

    public List<CommandeItem> getCommandeItems() {
        return commandItems;
    }

    public void setCommandeItems(List<CommandeItem> commandItems) {
        this.commandItems = commandItems;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commande commande = (Commande) o;
        return Objects.equals(id, commande.id) && Objects.equals(reference, commande.reference) && Objects.equals(totalPaye, commande.totalPaye) && Objects.equals(dateCommande, commande.dateCommande) && Objects.equals(commandItems, commande.commandItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reference, totalPaye, dateCommande, commandItems);
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
