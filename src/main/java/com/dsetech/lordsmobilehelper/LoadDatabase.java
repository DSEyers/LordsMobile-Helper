package com.dsetech.lordsmobilehelper;

import com.dsetech.lordsmobilehelper.persistance.model.Player;
import com.dsetech.lordsmobilehelper.persistance.repo.PlayerRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(PlayerRepo playerRepo) {
        return args -> {
            log.info("Preloading " + playerRepo.save(new Player().setName("Vqmpire")));
            log.info("Preloading " + playerRepo.save(new Player().setName("Lore")));
        };
    }
}