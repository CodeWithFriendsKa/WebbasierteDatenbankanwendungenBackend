package de.dhbw.WebbasierteDatenbankanwendungenBackend.trainer;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrainerRepo extends CrudRepository<TrainerEntity, Long> {

    @Override
    List<TrainerEntity> findAll();

    boolean existsTrainerEntityByMailAndPassword(String mail, String password);
}
