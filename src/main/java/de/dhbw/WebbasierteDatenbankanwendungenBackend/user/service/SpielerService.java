package de.dhbw.WebbasierteDatenbankanwendungenBackend.user.service;

import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.authentification.AuthentificationService;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.authentification.AuthorizationException;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.entity.SpielerEntity;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.repository.SpielerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpielerService extends AuthentificationService {

    private final Logger logger = LoggerFactory.getLogger(SpielerService.class);
    @Autowired
    SpielerRepo spielerRepo;

    public SpielerEntity getSpielerByMail(String mail, String authorization) throws AuthorizationException, SpielerNotFoundException {
        if (this.checkAuthGetSpielerByMail(authorization, mail)) {
            SpielerEntity spielerEntity = spielerRepo.findSpielerEntityByMail(mail);
            if (spielerEntity != null) {
                return spielerEntity;
            } else {
                throw new SpielerNotFoundException("Der Spieler wurde nicht in der Datenbank gefunden");
            }
        } else {
            throw new AuthorizationException("Du hast nicht die Berechtigung Daten von Spieler: "+ mail+" anhand seiner E-Mail zu holen!");
        }
    }

    public void postSpieler(SpielerEntity spielerEntity) throws DbDuplikatException {
        SpielerEntity spieler = spielerRepo.findSpielerEntityByMail(spielerEntity.getMail());
        if (spieler == null) {
            spielerRepo.save(spielerEntity);
        } else {
            throw new DbDuplikatException("Spieler mit Mail-Adresse bereits vorhanden.");
        }
    }
}
