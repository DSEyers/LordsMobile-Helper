package com.dsetech.lordsmobilehelper.persistance.repo;

import com.dsetech.lordsmobilehelper.persistance.model.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PlayerTest {

    @Autowired
    private PlayerRepo playerRepo;

    @Test
    @Sql(scripts = {"classpath:createPlayerTest.sql"})
        // Very annoyingly needs classpath
    void checkRecordReturnedAndNotNull() {
        final Player player = playerRepo.findByName("Vqmpire");
        assertThat(player).isNotNull();
    }

    @Test
    @Sql(scripts = {"classpath:createPlayerTest.sql"})
        // Very annoyingly needs classpath
    void checkNameReturnedIsCorrect() {
        final String name = "Vqmpire";
        final Player player = playerRepo.findByName(name);
        assertThat(player.getName().equals(name));
    }
}
