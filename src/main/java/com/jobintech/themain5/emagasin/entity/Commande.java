package com.jobintech.themain5.emagasin.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "commandes")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal totalPaye;
    @CreationTimestamp
    private LocalDateTime dateCommande;
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
}
