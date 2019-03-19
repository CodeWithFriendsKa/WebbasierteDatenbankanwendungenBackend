package de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.algorithm;

import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.entity.SpielerEntity;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.repository.SpielerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Optimizer {

    @Autowired
    private SpielerRepo spielerRepo;

    //todo name durch mail tauschen, da die mail eindeutig ist -> wenn Emil Änderungen vorgenommen hat
    public SpielerEntity spielerModelToEntity(SpielerModel spielerModel){
        var entity = spielerRepo.findSpielerEntityByMail(spielerModel.getName());
        entity.setTrainingTimes(spielerModel.getZeiten());
        entity.setTrainingCount(spielerModel.getTrainingsAnzahl());
        return entity;
    }

    public SpielerModel spielerEntityToModel(SpielerEntity spielerEntity){
        return new SpielerModel(
                spielerEntity.getName(),
                spielerEntity.getTrainingTimes(),
                spielerEntity.getAge(),
                spielerEntity.getSex(),
                spielerEntity.getTrainingCount()
        );
    }
}
