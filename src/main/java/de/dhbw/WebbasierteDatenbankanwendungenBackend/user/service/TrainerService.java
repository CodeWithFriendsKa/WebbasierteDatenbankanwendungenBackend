package de.dhbw.WebbasierteDatenbankanwendungenBackend.user.service;

import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.authentification.AuthentificationService;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.authentification.AuthorizationException;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.entity.SpielerEntity;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.entity.TrainerEntity;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.repository.TrainerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TrainerService extends AuthentificationService {

    private final Logger logger = LoggerFactory.getLogger(SpielerService.class);
    //Zufälliger Code, der den Trainern zur Registrierung mitgeteilt wird
    final private String registerCode = "gruppeEinsIsTheBest";

    @Autowired
    TrainerRepo trainerRepo;

    /**
     * Diese Methode wird vom TrainerController aufgerufen
     * Diese Methode gibt einen Trainer anhand seiner Mailadresse zurück
     * Sie hat 2 Parameter:
     * 1) Die Mailadresse
     * 2) Authorization (siehe Controller)
     * In dieser Methode werden 3 Schritte ausgeführt:
     * 1) Authorisierung prüfen -> Bei Fehlschlag wird eine "AuhorizationException" geworfen
     * 2) Wenn erfolgreich schauen ob der Trainer gefunden werden kann -> Bei Fehlschlag wird eine "TrainerNotFoundException" geworfen
     * 3) Wenn erfolgreich gefundenen Trainer zurückgeben
     */

    public TrainerEntity getTrainerByMail(String mail, String authorization) throws AuthorizationException, TrainerNotFoundException {
        if(this.checkAuthTrainer(authorization)) {
            TrainerEntity trainerEntity = trainerRepo.findTrainerEntityByMail(mail);
            if(trainerEntity != null) {
                logger.debug("getTrainerByMail: gefundener Trainer: {}", trainerEntity);
                return trainerEntity;
            }
            else {
                throw new TrainerNotFoundException("Der Trainer wurde nicht gefunden.");
            }
        }
        else {
            throw new AuthorizationException("Du hast keine Rechte, die Trainer-Daten zu holen.");
        }

    }

    /**
     * Diese Mehtode wird vom TrainerController aufgerufen
     * Diese Methode speichert einen neuen Trainer in der Datenbank (Registrierung)
     * Sie hat einen Parameter
     * 1) TrainerEntity ist der Trainer, der in die Datenbank gespeichert werden soll
     * In der Methode werden 2 Schritte ausgeführt:
     * 1) Prüfe, ob es den Trainer noch nicht gibt -> Bei Fehlschlag wird eine DbDuplikatException geworfen
     * 2) Wenn erfolgreich speichere den neuen Trainer in der Datenbank
     */

    public void postTrainer(TrainerEntity trainerEntity, String registerCode) throws DbDuplikatException, WrongCodeException {
        if(this.registerCode.equals(registerCode)) {
            TrainerEntity trainer = trainerRepo.findTrainerEntityByMail(trainerEntity.getMail());
            if(trainer == null) {
                logger.debug("postTrainer: Neuer Trainer in Datenbank eingefügt: {}", trainerEntity);
                trainerRepo.save(trainerEntity);
            }
            else {
                throw new DbDuplikatException("Trainer mit der Mail-Adresse ist bereits vorhanden.");
            }
        }
        else {
            throw new WrongCodeException("Der korrekte Registrierungscode für Trainer muss in die URL-Leiste (.../trainer/<CODE> ) eingetragen werden.");
        }

    }

    public void putTrainer(TrainerEntity trainerEntity, String authorization) throws AuthorizationException, SpielerNotFoundException {
        if (this.checkAuthGetSpielerByMail(authorization, trainerEntity.getMail())){
            TrainerEntity trainer = trainerRepo.findTrainerEntityByMail(trainerEntity.getMail());
            if (trainer != null) {
                trainer.setTrainingCount(trainerEntity.getTrainingCount());
                trainer.setZeiten(trainerEntity.getZeiten());
                trainerRepo.save(trainer);
            } else {
                throw new SpielerNotFoundException("Der Spieler wurde nicht in der Datenbank gefunden");
            }
        } else {
            throw new AuthorizationException("Du hast nicht die Berechtigung!");
        }
    }
}
