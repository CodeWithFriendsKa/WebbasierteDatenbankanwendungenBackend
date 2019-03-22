package de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.algorithm;

import de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.algorithm.algo.*;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.entity.SpielerEntity;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.repository.SpielerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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

    public void startAlgo(){
        ArrayList<SpielerModel> spieler = TestList.testListSpieler();
        ArrayList<TrainerModel> trainer = TestList.testListTrainer();
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
    }
}
