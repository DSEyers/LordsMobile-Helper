package com.dsetech.lordsmobilehelper.controller;

import com.dsetech.lordsmobilehelper.model.Player;
import com.dsetech.lordsmobilehelper.repo.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    private final PlayerRepo playerRepo;

    @Autowired
    public PlayerController(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    // Aggregate root

    @GetMapping("/players")
    List<Player> all() {
        return playerRepo.findAll();
    }

    @PostMapping("/players")
    Player newPlayer(@RequestBody Player newPlayer) {
        return playerRepo.save(newPlayer);
    }

    // Single item

    @GetMapping("/players/{id}")
    Player one(@PathVariable Long id) {

        return playerRepo.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException(id));
    }

    @PutMapping("/players/{id}")
    Player replacePlayer(@RequestBody Player newPlayer, @PathVariable Long id) {

        return playerRepo.findById(id)
                .map(Player -> {
                    Player.setName(newPlayer.getName());
                    return playerRepo.save(Player);
                })
                .orElseGet(() -> {
                    newPlayer.setId(id);
                    return playerRepo.save(newPlayer);
                });
    }

    @DeleteMapping("/players/{id}")
    void deletePlayer(@PathVariable Long id) {
        playerRepo.deleteById(id);
    }
}
