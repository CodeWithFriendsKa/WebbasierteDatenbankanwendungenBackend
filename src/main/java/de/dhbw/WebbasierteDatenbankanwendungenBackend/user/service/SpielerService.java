package de.dhbw.WebbasierteDatenbankanwendungenBackend.user.service;

import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.authentification.AuthentificationService;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.authentification.AuthorizationException;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.entity.SpielerEntity;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.repository.SpielerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;

@Service
public class SpielerService extends AuthentificationService {

    private final Logger logger = LoggerFactory.getLogger(SpielerService.class);
    @Autowired
    SpielerRepo spielerRepo;

    /**
     * Diese Methode wird vom SpielerController aufgerufen
     * Diese Methode gibt einen Spieler anhand seiner Mailadresse zurück
     * Sie hat 2 Parameter:
     * 1) Die Mailadresse
     * 2) Authorization (siehe Controller)
     * In dieser Methode werden 3 Schritte ausgeführt:
     * 1) Authorisierung prüfen -> Bei Fehlschlag wird eine "AuhorizationException" geworfen
     * 2) Wenn erfolgreich schauen ob der Spieler gefunden werden kann -> Bei Fehlschlag wird eine "SpielerNotFoundException" geworfen
     * 3) Wenn erfolgreich gefundenen Spieler zurückgeben
     */
    public SpielerEntity getSpielerByMail(String mail, String authorization) throws AuthorizationException, SpielerNotFoundException {
        if (this.checkAuthGetSpielerByMail(authorization, mail)) {
            SpielerEntity spielerEntity = spielerRepo.findSpielerEntityByMail(mail);
            if (spielerEntity != null) {
                return spielerEntity;
            } else {
                throw new SpielerNotFoundException("Der Spieler wurde nicht in der Datenbank gefunden");
            }
        } else {
            throw new AuthorizationException("Du hast nicht die Berechtigung Daten von Spieler: " + mail + " anhand seiner E-Mail zu holen!");
        }
    }

    /**
     * Diese Mehtode wird vom SpielerController aufgerufen
     * Diese Methode speichert einen neuen Spieler in der Datenbank (Registrierung)
     * Sie hat einen Parameter
     * 1) SpielerEntity ist der Spieler, der in die Datenbank gespeichert werden soll
     * In der Methode werden 2 Schritte ausgeführt:
     * 1) Prüfe, ob es den Spieler noch nicht gibt -> Bei Fehlschlag wird eine DbDuplikatException geworfen
     * 2) Wenn erfolgreich speichere den neuen Spieler in der Datenbank
     */
    public void postSpieler(SpielerEntity spielerEntity) throws DbDuplikatException {
        SpielerEntity spieler = spielerRepo.findSpielerEntityByMail(spielerEntity.getMail());
        if (spieler == null) {
            if (spielerRepo.save(spielerEntity) != null){
                logger.info("Neuer Spieler in die Datenbank eingefügt: {}", spielerEntity);
            }

        } else {
            throw new DbDuplikatException("Spieler mit Mail-Adresse bereits vorhanden.");
        }
    }
}
