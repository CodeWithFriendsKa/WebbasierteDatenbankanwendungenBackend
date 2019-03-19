package de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.service;

import de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.entity.GruppeEntity;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.repository.GruppeRepo;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.authentification.AuthentificationService;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.authentification.AuthorizationException;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.entity.SpielerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorService extends AuthentificationService {

    @Autowired
    GruppeRepo gruppeRepo;
    private final Logger logger = LoggerFactory.getLogger(CalculatorService.class);

    public List<GruppeEntity> findAllGruppen(String authorization) throws GruppeNotFoundException, AuthorizationException {
        if (this.checkAuthTrainer(authorization)) {
            var gruppen = gruppeRepo.findAll();
            if (gruppen != null) {
                logger.debug("findAllGruppen: Gruppe/n wurde/n gefunden");
                return gruppen;
            } else {
                throw new GruppeNotFoundException("Die Gruppen wurden nicht gefunden");
            }
        } else {
            throw new AuthorizationException("Du hast nicht die Berechtigung alle Gruppen zu holen");
        }
    }
    public GruppeEntity findGruppeBySpielerMail(String mail, String authorization) throws GruppeNotFoundException, AuthorizationException {
        if (this.checkAutGetGruppeBySpielerMail(authorization, mail)) {
            var gruppen = gruppeRepo.findAll();
            for (GruppeEntity gruppeEntity : gruppen) {
                for (SpielerEntity spielerEntity : gruppeEntity.getSpielerListe()) {
                    if (spielerEntity.getMail().equals(mail)) {
                        logger.debug("findGruppeBySpielerMail gefundene Gruppe: {}", gruppeEntity);
                        return gruppeEntity;
                    }
                }
            }
            throw new GruppeNotFoundException("Gruppe des Spielers wurde nicht gefunden!");
        } else {
            throw new AuthorizationException("Du hast nicht die Berechtigung diese Gruppe zu holen");
        }
    }
    public void optimize(String authorization) throws AuthorizationException {
        if (this.checkAuthTrainer(authorization)){

        }
        else {
            throw new AuthorizationException("Du hast nicht die Berechtigung den Algorithmus zu starten!");
        }
    }
    public int[] getPossibleTrainingTimes(String authorization) throws AuthorizationException {
        if (this.checkAuthSpieler(authorization)){
            int[] a = {0,0,1,0,1,0,1,0};
            return a;
        }
        else {
            throw new AuthorizationException("Du hast nicht die Berechtigung den Algorithmus zu starten!");
        }
    }
}
