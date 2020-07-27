package com.dsetech.lordsmobilehelper.controller;

import com.dsetech.lordsmobilehelper.model.Player;
import com.dsetech.lordsmobilehelper.repo.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerRepo playerRepo;

    @Autowired
    public PlayerController(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    // Aggregate root

    @GetMapping
    List<Player> all() {
        return playerRepo.findAll();
    }

    @PostMapping
    Player newPlayer(@RequestBody Player newPlayer) {
        return playerRepo.save(newPlayer);
    }

    // Single item

    @GetMapping("/{id}")
    Player one(@PathVariable Long id) {

        return playerRepo.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException(id));
    }

    @PutMapping("/{id}")
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

    @DeleteMapping("/{id}")
    void deletePlayer(@PathVariable Long id) {
        playerRepo.deleteById(id);
    }
}
