package com.dsetech.lordsmobilehelper.persistance.repo;

import com.dsetech.lordsmobilehelper.persistance.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepo extends JpaRepository<Player, Long> {

    Player findByName(final String name);
}
