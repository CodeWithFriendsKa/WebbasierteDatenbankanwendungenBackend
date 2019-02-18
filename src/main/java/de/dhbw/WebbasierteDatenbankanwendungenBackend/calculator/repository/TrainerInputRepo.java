package de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.repository;

import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.entity.TrainerEntity;
import org.springframework.data.repository.CrudRepository;

public interface TrainerInputRepo extends CrudRepository<TrainerEntity, Long> {
}
