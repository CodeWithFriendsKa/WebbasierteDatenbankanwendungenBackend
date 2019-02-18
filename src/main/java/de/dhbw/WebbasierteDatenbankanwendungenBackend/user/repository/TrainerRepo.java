package de.dhbw.WebbasierteDatenbankanwendungenBackend.user.repository;

import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.entity.TrainerEntity;
import org.springframework.data.repository.CrudRepository;

public interface TrainerRepo extends CrudRepository<TrainerEntity,Long> {

    public TrainerEntity findTrainerEntityByMail(String mail);
}
