package com.jobintech.themain5.emagasin.ws;

import com.jobintech.themain5.emagasin.entity.EtatPaiement;
import com.jobintech.themain5.emagasin.service.facade.EtatPaiementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/etatpaiements")
@Tag(name = "CRUD REST APIs for EtatPaiement Resource")
public class EtatPaiementController {

    private final EtatPaiementService etatPaiementService;

    @Autowired
    public EtatPaiementController(EtatPaiementService etatPaiementService) {
        this.etatPaiementService = etatPaiementService;
    }

    @GetMapping("/")
    public List<EtatPaiement> findAll() {
        return etatPaiementService.findAll();
    }

    @GetMapping("/id/{id}")
    public Optional <EtatPaiement> findById(@PathVariable Long id) {
        return etatPaiementService.findById(id);
    }

    @PostMapping("/")
    public EtatPaiement save(@RequestBody EtatPaiement etatPaiement) {
        return etatPaiementService.save(etatPaiement);
    }

    @PutMapping("/id/{id}")
    public EtatPaiement update(@RequestBody EtatPaiement etatPaiement, @PathVariable Long id) {
        return etatPaiementService.update(etatPaiement, id);
    }

    @DeleteMapping("/id/{id}")
    public int delete(@PathVariable Long id) {
        return etatPaiementService.delete(id);
    }
}
