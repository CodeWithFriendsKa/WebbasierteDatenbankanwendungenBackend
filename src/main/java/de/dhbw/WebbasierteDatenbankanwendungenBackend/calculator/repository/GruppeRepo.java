package de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.repository;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.entity.GruppeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GruppeRepo extends CrudRepository<GruppeEntity, Long> {

    @Override
    List<GruppeEntity> findAll();

}
