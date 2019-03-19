package de.dhbw.WebbasierteDatenbankanwendungenBackend.user.repository;

import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.entity.SpielerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpielerRepo extends CrudRepository<SpielerEntity,Long> {

    SpielerEntity findSpielerEntityByMail(String mail);

    SpielerEntity findSpielerEntityByName(String name);

    boolean existsSpielerEntityByMailAndPasswort(String mail, String passwort);

    @Override
    List<SpielerEntity> findAll();
}
