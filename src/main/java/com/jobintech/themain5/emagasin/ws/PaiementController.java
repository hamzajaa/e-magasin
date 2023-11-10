package com.jobintech.themain5.emagasin.ws;

import com.jobintech.themain5.emagasin.entity.Paiement;
import com.jobintech.themain5.emagasin.service.facade.PaiementService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/paiements")
@Tag(name = "CRUD REST APIs for Paiement Resource")
public class PaiementController {
    private final PaiementService paiementService;

    public PaiementController(PaiementService paiementService) {
        this.paiementService = paiementService;
    }

    @PostMapping("/")
    public Paiement savePaiement(Paiement paiement) {
        return paiementService.savePaiement(paiement);
    }

    @GetMapping("/id/{id}")
    public Optional<Paiement> findPaiementById(@PathVariable Long id) {
        return paiementService.findPaiementById(id);
    }

    @GetMapping("/")
    public List<Paiement> findAllPaiements() {
        return paiementService.findAllPaiements();
    }

    @PutMapping("/id/{id}")
    public Paiement updatePaiement(@RequestBody Paiement paiement,@PathVariable Long id) {
        return paiementService.updatePaiement(paiement, id);
    }

    @DeleteMapping("/id/{id}")
    public int deletePaiementById(@PathVariable Long id) {
        return paiementService.deletePaiementById(id);
    }
}
