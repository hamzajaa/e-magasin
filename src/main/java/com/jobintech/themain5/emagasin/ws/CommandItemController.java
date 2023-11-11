package com.jobintech.themain5.emagasin.ws;

import com.jobintech.themain5.emagasin.converter.CommandeItemConverter;
import com.jobintech.themain5.emagasin.dto.CommandeItemDto;
import com.jobintech.themain5.emagasin.entity.CommandeItem;
import com.jobintech.themain5.emagasin.service.facade.CommandeItemService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/commande-items")
@Tag(name = "CRUD REST APIs for Commande Item Resource")
public class CommandItemController {

    private final CommandeItemService commandeItemService;
    private CommandeItemConverter commandeItemConverter;

    public CommandItemController(CommandeItemService commandeItemService, CommandeItemConverter commandeItemConverter) {
        this.commandeItemService = commandeItemService;
        this.commandeItemConverter = commandeItemConverter;
    }

    @PostMapping("/")
    public CommandeItem saveCommandeItem(@RequestBody CommandeItemDto commandeItemDto) {
        CommandeItem commandeItem = commandeItemConverter.toEntity(commandeItemDto);
        return commandeItemService.save(commandeItem);
    }


    @GetMapping("/")
    public List<CommandeItemDto> getAllCommandeItems() {
        return commandeItemConverter.toDto(commandeItemService.getCommandeItem());
    }

    @GetMapping("/id/{id}")
    public CommandeItemDto findById(@PathVariable Long id) {
        return commandeItemConverter.toDto(commandeItemService.findById(id).get());
    }

    @PutMapping("/id/{id}")
    public CommandeItemDto updateCommandeItem(@RequestBody CommandeItemDto updatedCommandeItemDto, @PathVariable Long id) {
        CommandeItem commandeItem = commandeItemConverter.toEntity(updatedCommandeItemDto);
        commandeItem = commandeItemService.update(commandeItem, id);
        return commandeItemConverter.toDto(commandeItem);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteCommandeItem(@PathVariable Long id) {
        int result = commandeItemService.delete(id);
        if (result == 1) {
            return new ResponseEntity<>("CommandeItem deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("CommandeItem not found", HttpStatus.NOT_FOUND);
        }
    }

}
