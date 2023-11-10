package com.jobintech.themain5.emagasin.converter;

import com.jobintech.themain5.emagasin.dto.PaiementDto;
import com.jobintech.themain5.emagasin.entity.Paiement;
import org.springframework.stereotype.Component;

@Component
public class PaiementConverter extends AbstractConverter<Paiement, PaiementDto>{

    private final EtatPaiementConverter etatPaiementConverter;
    private final CommandeConverter commandeConverter;

    public PaiementConverter(EtatPaiementConverter etatPaiementConverter, CommandeConverter commandeConverter) {
        this.etatPaiementConverter = etatPaiementConverter;
        this.commandeConverter = commandeConverter;
    }

    @Override
    Paiement toEntity(PaiementDto dto) {
        if (dto == null)
        return null;
        else{
            Paiement paiement = new Paiement();
            paiement.setPaiementId(dto.paiementId());
            paiement.setMontant(dto.montant());
            paiement.setMethodDePaiement(dto.methodDePaiement());
            paiement.setCommande(commandeConverter.toEntity(dto.commandeDto()));
            paiement.setEtatPaiement(etatPaiementConverter.toEntity(dto.etatPaiementDto()));
            return paiement;
        }

    }

    @Override
    PaiementDto toDto(Paiement entity) {
        if (entity == null) {
            return null;
        }
        {
            return new PaiementDto(
                entity.getPaiementId(),
                commandeConverter.toDto(entity.getCommande()),
                entity.getMontant(),
                etatPaiementConverter.toDto(entity.getEtatPaiement()),
                entity.getMethodDePaiement()
        );
        }
    }
}
