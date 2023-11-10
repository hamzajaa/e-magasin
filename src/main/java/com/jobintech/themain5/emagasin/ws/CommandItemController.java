package com.jobintech.themain5.emagasin.ws;

import com.jobintech.themain5.emagasin.entity.CommandeItem;
import com.jobintech.themain5.emagasin.service.facade.CommandeItemService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/commande-items")
@Tag(name = "CRUD REST APIs for Commande Item Resource")
public class CommandItemController {

    private final CommandeItemService commandeItemService;

    public CommandItemController(CommandeItemService commandeItemService) {
        this.commandeItemService = commandeItemService;
    }

    @GetMapping("/")
    public List<CommandeItem> getAllCommandeItems(){
        return commandeItemService.getCommandeItem();
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<CommandeItem> getCommandeItemById(@PathVariable Long id) {
        Optional<CommandeItem> commandeItem = commandeItemService.findById(id);
        return commandeItem.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/id/{id}")
    public ResponseEntity<CommandeItem> updateCommandeItem(@RequestBody CommandeItem updatedCommandeItem, @PathVariable Long id) {
        CommandeItem updatedItem = commandeItemService.update(updatedCommandeItem, id);
        if (updatedItem != null) {
            return new ResponseEntity<>(updatedItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
