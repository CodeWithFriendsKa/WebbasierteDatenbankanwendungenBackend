package de.dhbw.WebbasierteDatenbankanwendungenBackend.user.repository;

import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.entity.SpielerEntity;
import org.springframework.data.repository.CrudRepository;

public interface SpielerRepo extends CrudRepository<SpielerEntity,Long> {

    public SpielerEntity findSpielerEntityByMail(String mail);

}
