package com.dsetech.lordsmobilehelper.repo;

import com.dsetech.lordsmobilehelper.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepo extends JpaRepository<Player, Long> {

    Player findByName(final String name);
}
