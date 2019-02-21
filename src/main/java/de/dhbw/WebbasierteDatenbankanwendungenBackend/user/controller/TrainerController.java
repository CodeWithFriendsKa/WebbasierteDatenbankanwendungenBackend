package de.dhbw.WebbasierteDatenbankanwendungenBackend.user.controller;

import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.authentification.AuthorizationException;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.entity.TrainerEntity;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.service.DbDuplikatException;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.service.TrainerNotFoundException;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class TrainerController {

    @Autowired
    TrainerService trainerService;

    /**
     * "getTrainerByMail" gibt einen Trainer anhand seiner Mailadresse zurück
     * Diese Methode stellt eine "Öffnung" unseres Servers für eine Http-Anfrage zur Verfügung
     * Wenn die URL localhost:8080/trainer/{mail} mit GET aufgerufen wird tritt diese Mehtode in Aktion
     * Dem Request sind 2 Variablen zu entnehmen:
     * 1) {mail} ist die Mailadresse des Spilers, der geholt werden soll
     * 2) @RequestHeader("authorization") ist die Mail + Passwort des Aufrufenden in Base64 codiert
     * Um den Trainer anhand seiner Mail zu bekommen wird vom Serviceobjekt die Methode getTrainerByMail aufgerufen
     * Wird in der Serviceklasse eine "AuthorizationException" geworfen, so wird diese hier abgefangen und dem Aufrufenden mitgeteilt, dass die Authorisierung fehlgeschlagen ist
     * Wird in der Serviceklasse eine "NotFoundException" geworfen, so wird diese hier abgefangen und dem Aufrufenden mitgeteilt, dass der Trainer nicht zu finden ist
     */

    @RequestMapping(method = RequestMethod.GET, value = "/trainer/{mail}")
    public TrainerEntity getTrainerByMail(@PathVariable(value = "mail") String mail , @RequestHeader(value = "Authorization") String authorization) {

        try {
            return trainerService.getTrainerByMail(mail, authorization);
        } catch (TrainerNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (AuthorizationException e) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
        }
    }


    /**
     * "postTrainerEntity" gibt einen Trainer anhand seiner Mailadresse zurück
     * Diese Methode stellt eine "Öffnung" unseres Servers für eine Http-Anfrage zur Verfügung
     * Wenn die URL localhost:8080/trainer mit POST aufgerufen wird tritt diese Mehtode in Aktion
     * Dem Request ist 1 Variablen zu entnehmen:
     * 1) @RequestBody ist der einzufügende (zu "POSTende") Trainer
     * Eine Authorisierung ist hier nicht nötig, man sich ja hiermit erstmalig anmeldet
     * Um den Trainer in die Datenbank einzufügen wird vom Serviceobjekt die Mehtode postTrainer aufgerufen
     * Wird in der Serviceklasse eine "DuplikatException" geworfen, so wird diese hier abgefangen und dem Aufrufenden mitgeteilt, dass der Trainer bereits einen Account hat
     */
    @RequestMapping(method = RequestMethod.POST, value = "/trainer")
    public void postTrainerEntity(@RequestBody TrainerEntity trainerEntity) {
        try {
            trainerService.postTrainer(trainerEntity);
        } catch (DbDuplikatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}

