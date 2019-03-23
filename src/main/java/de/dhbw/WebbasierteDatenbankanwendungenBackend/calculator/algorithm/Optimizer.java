package de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.algorithm;

import de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.algorithm.algo.*;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.entity.SpielerEntity;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.entity.TrainerEntity;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.repository.SpielerRepo;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.repository.TrainerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Optimizer {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SpielerRepo spielerRepo;
    @Autowired
    private TrainerRepo trainerRepo;
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
    public TrainerEntity trainerModelToEntity(TrainerModel trainerModel){
        var entity = trainerRepo.findTrainerEntityByMail(trainerModel.getName());
        entity.setMinTrainingTimes(trainerModel.getMinAnzTraining());
        entity.setTrainingCount(trainerModel.getAktAnzTraining());
        return entity;
    }
    public TrainerModel trainerEntityToModel(TrainerEntity trainerEntity){
        logger.debug("trainerEntityToModel aufgerufen");
        TrainerModel tr =  new TrainerModel(
                trainerEntity.getName(),
                trainerEntity.getZeiten(),
                trainerEntity.getPrio(),
                trainerEntity.getMinTrainingTimes()
        );
        logger.debug("Trainer.toString: " + tr.toString());
        return tr;
    }
    public void startAlgo(){
        AlgoBibliothek.spielerHatKeinTrainer.clear();
        AlgoBibliothek.spielerKeineGruppeZuo.clear();
        AlgoBibliothek.zweierSpielerKeineGruppeZuo.clear();
        AlgoBibliothek.zweierGruppe.clear();
        AlgoBibliothek.vorLaeufigeMoeglichkeiten.clear();
        AlgoBibliothek.zeiten.clear();
        AlgoBibliothek.zeitenKopie.clear();
        this.getSpielerModels();
        ArrayList<SpielerModel> spieler = SpielerModel.getAlleSpieler();
        logger.debug("Aufruf getTrainerModels");
        this.getTrainerModels();
        logger.debug("Ende Aufruf getTrainerModels");
        ArrayList<TrainerModel> trainer = TrainerModel.getAlleTrainer();
        logger.debug("Trainer aus alleTrainerList: " + trainer);
        ArrayList<Platz> plaetze = TestList.testListPlaetze();
        AlgoBibliothek.ErstellePlan(spieler, trainer, plaetze);
        ArrayList<ZeitEndModel> vorMoeg = AlgoBibliothek.Algorythmus(spieler, trainer, plaetze);
        System.out.println("anz moeglichkeiten: " + AlgoBibliothek.gruppenZuordnen(spieler, trainer, plaetze).size());
        for (int i = 0; i < vorMoeg.size(); i++) {
            System.out.println("Stunde: " + ZeitenModel.intToString(vorMoeg.get(i).getZeit()) + "\n");

            System.out.println("Name des Trainers: " + vorMoeg.get(i).getTrainer().getName());
            System.out.println("Name des Platzes: " + vorMoeg.get(i).getPlatz().getName() + "\n");

            System.out.println("Name der Gruppe: " + vorMoeg.get(i).getGruppe().getName());
            for (int k = 0; k < vorMoeg.get(i).getGruppe().getSpieler().size(); k++) {
                System.out.println("Name von Spieler " + (k + 1) + " :" + vorMoeg.get(i).getGruppe().getSpieler().get(k).getName());
            }

            System.out.println("-- -- -- -- --");

        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        /*
        for (int i = 0; i <  AlgoBibliothek.alleMoeglichenTrainingsZeiten(plaetze,trainer).length; i++) {
            System.out.println("" + AlgoBibliothek.alleMoeglichenTrainingsZeiten(plaetze,trainer)[i]);
        }
        */
        SpielerModel.removeAlleSpieler();
        SpielerModel.resetZaehler();
        TrainerModel.deleteAlleTrainer();
        TrainerModel.resetZaehler();
    }
    private List<SpielerModel> getSpielerModels() {
        var a = spielerRepo.findAll();
        logger.debug("DEMODATA_SPIELER_FROM_DATABASE_BEGIN");
        a.forEach(s -> {
            logger.debug(s.toString());
        });
        logger.debug("DEMODATA_FROM_DATABASE_BEGIN");
        var b = spielerRepo.findAll().stream().map(model -> spielerEntityToModel(model)).collect(Collectors.toList());
        return b;
    }
    private List<TrainerModel> getTrainerModels() {
        var a = trainerRepo.findAll();
        logger.debug("DEMODATA_TRAINER_FROM_DATABASE_BEGIN");
        a.forEach(s -> {
            logger.debug(s.toString());
        });
        logger.debug("DEMODATA_FROM_DATABASE_SAVE");
        var b  = trainerRepo.findAll().stream().map(model -> trainerEntityToModel(model)).collect(Collectors.toList());
        return b;
    }
}
