package com.jobintech.themain5.emagasin.ws;

import com.jobintech.themain5.emagasin.entity.Commande;
import com.jobintech.themain5.emagasin.service.facade.CommandeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/commandes")
@Tag(name = "CRUD REST APIs for Commande Resource")
public class CommandeController {

    private CommandeService commandeService;
    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping("/")
    public List<Commande> findAll() {
        return commandeService.findAll();
    }

    @GetMapping("/id/{id}")
    public Optional<Commande> findById(@PathVariable Long id) {
        return commandeService.findById(id);
    }

    @PostMapping("/")
    public Commande save(@RequestBody Commande commande) {
        return commandeService.save(commande);
    }

    @PutMapping("/id/{id}")
    public Commande update(@RequestBody Commande commande, @PathVariable Long id) {
        return commandeService.update(commande, id);
    }

    @DeleteMapping("/id/{id}")
    public int delete(@PathVariable Long id) {
        return commandeService.delete(id);
    }
}
