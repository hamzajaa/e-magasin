package com.jobintech.themain5.emagasin.ws;

import com.jobintech.themain5.emagasin.converter.CommandeConverter;
import com.jobintech.themain5.emagasin.dto.CommandeDto;
import com.jobintech.themain5.emagasin.entity.Commande;
import com.jobintech.themain5.emagasin.service.facade.CommandeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/commandes")
@Tag(name = "CRUD REST APIs for Commande Resource")
public class CommandeController {

    private CommandeService commandeService;
    private CommandeConverter commandeConverter;

    public CommandeController(CommandeService commandeService, CommandeConverter commandeConverter) {
        this.commandeService = commandeService;
        this.commandeConverter = commandeConverter;
    }

    @GetMapping("/")
    public List<CommandeDto> findAll() {
        return commandeConverter.toDto(commandeService.findAll());
    }

    @GetMapping("/id/{id}")
    public CommandeDto findById(@PathVariable Long id) {
        return commandeConverter.toDto(commandeService.findById(id).get());
    }

    @PostMapping("/")
    public CommandeDto save(@RequestBody CommandeDto commandeDto) {
        Commande commande = commandeConverter.toEntity(commandeDto);
        commande = commandeService.save(commande);
        return commandeConverter.toDto(commande);
    }

    @PutMapping("/")
    public CommandeDto update(@RequestBody CommandeDto commandeDto) {
        Commande commande = commandeConverter.toEntity(commandeDto);
        commande = commandeService.update(commande);
        return commandeConverter.toDto(commande);
    }

    @DeleteMapping("/id/{id}")
    public int delete(@PathVariable Long id) {
        return commandeService.delete(id);
    }
}
