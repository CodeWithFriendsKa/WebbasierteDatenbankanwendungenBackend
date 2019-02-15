package de.dhbw.WebbasierteDatenbankanwendungenBackend.spieler;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpielerRepo extends CrudRepository<SpielerEntity, Long> {

    @Override
    List<SpielerEntity> findAll();

    boolean existsSpielerEntitiesByMailAndPasswort(String mail, String passwort);
}
