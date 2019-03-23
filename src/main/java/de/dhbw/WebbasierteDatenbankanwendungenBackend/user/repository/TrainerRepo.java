package de.dhbw.WebbasierteDatenbankanwendungenBackend.user.repository;

import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.entity.TrainerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrainerRepo extends CrudRepository<TrainerEntity,Long> {

    TrainerEntity findTrainerEntityByMail(String mail);

    @Override
    List<TrainerEntity> findAll();

    boolean existsTrainerEntityByMailAndPasswort(String mail, String passwort);
}
