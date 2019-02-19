package de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.service;

import de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.entity.GruppeEntity;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.repository.GruppeRepo;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.authentification.AuthentificationService;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.authentification.AuthorizationException;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.entity.SpielerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorService extends AuthentificationService {

    @Autowired
    GruppeRepo gruppeRepo;

    public List<GruppeEntity> findAllGruppen(String authorization) throws GruppeNotFoundException, AuthorizationException {
        if (this.checkAuthTrainer(authorization)) {
            var gruppen = gruppeRepo.findAll();
            if (gruppen != null) {
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
                    if (spielerEntity.getMail().equals(mail)) return gruppeEntity;
                }
            }
            throw new GruppeNotFoundException("Gruppe des Spielers wurde nicht gefunden!");
        } else {
            throw new AuthorizationException("Du hast nicht die Berechtigung diese Gruppe zu holen");
        }
    }
}
