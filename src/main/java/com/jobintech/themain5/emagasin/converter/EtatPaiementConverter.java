package com.jobintech.themain5.emagasin.converter;

import com.jobintech.themain5.emagasin.dto.EtatPaiementDto;
import com.jobintech.themain5.emagasin.entity.EtatPaiement;
import org.springframework.stereotype.Component;

@Component
public class EtatPaiementConverter extends AbstractConverter<EtatPaiement, EtatPaiementDto> {

    @Override
    EtatPaiement toEntity(EtatPaiementDto dto) {
        if (dto == null) {
            return null;
        }
        EtatPaiement etatPaiement = new EtatPaiement();
        etatPaiement.setId(dto.id());
        etatPaiement.setLabel(dto.label());
        // Set other properties as needed
        return etatPaiement;
    }

    @Override
    EtatPaiementDto toDto(EtatPaiement entity) {
        if (entity == null) {
            return null;
        }
        return new EtatPaiementDto(
                entity.getId(),
                entity.getLabel()
                // Map other properties as needed
        );
    }
}
