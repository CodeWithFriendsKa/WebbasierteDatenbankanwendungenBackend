package de.dhbw.WebbasierteDatenbankanwendungenBackend.user.controller;

import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.entity.SpielerEntity;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.authentification.AuthorizationException;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.service.DbDuplikatException;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.service.SpielerNotFoundException;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.service.SpielerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin
@RestController
public class SpielerController {

    private final Logger logger = LoggerFactory.getLogger(SpielerService.class);

    @Autowired
    SpielerService spielerService;

    /**
     * "getSpielerByMail" gibt einen Spieler anhand seiner Mailadresse zurück
     * Diese Methode stellt eine "Öffnung" unseres Servers für eine Http-Anfrage zur Verfügung
     * Wenn die URL localhost:8080/spieler/{mail} mit GET aufgerufen wird tritt diese Mehtode in Aktion
     * Dem Request sind 2 Variablen zu entnehmen:
     * 1) {mail} ist die Mailadresse des Spilers, der geholt werden soll
     * 2) @RequestHeader("authorization") ist die Mail + Passwort des Aufrufenden in Base64 codiert
     * Um den Spieler anhand seiner Mail zu bekommen wird vom Serviceobjekt die Methode getSpielerByMail aufgerufen
     * Wird in der Serviceklasse eine "AuthorizationException" geworfen, so wird diese hier abgefangen und dem Aufrufenden mitgeteilt, dass die Authorisierung fehlgeschlagen ist
     * Wird in der Serviceklasse eine "NotFoundException" geworfen, so wird diese hier abgefangen und dem Aufrufenden mitgeteilt, dass der Spieler nicht zu finden ist
     */
    @RequestMapping(method = RequestMethod.GET, value = "/spieler/{mail}")
    public SpielerEntity getSpielerByMail(@PathVariable(value = "mail") String mail, @RequestHeader(value = "Authorization") String authorization) {
        logger.debug("GET-Request für getSpielerByMail empfangen, Authorization: {}", authorization);
        try {
            return spielerService.getSpielerByMail(mail, authorization);
        } catch (SpielerNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (AuthorizationException e) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
        }
    }

    /**
     * "postSpielerEntity" gibt einen Spieler anhand seiner Mailadresse zurück
     * Diese Methode stellt eine "Öffnung" unseres Servers für eine Http-Anfrage zur Verfügung
     * Wenn die URL localhost:8080/spieler mit POST aufgerufen wird tritt diese Mehtode in Aktion
     * Dem Request ist 1 Variablen zu entnehmen:
     * 1) @RequestBody ist der einzufügende (zu "POSTende") Spieler
     * Eine Authorisierung ist hier nicht nötig, man sich ja hiermit erstmalig anmeldet
     * Um den Spieler in die Datenbank einzufügen wird vom Serviceobjekt die Mehtode postSpieler aufgerufen
     * Wird in der Serviceklasse eine "DuplikatException" geworfen, so wird diese hier abgefangen und dem Aufrufenden mitgeteilt, dass der Spieler bereits einen Account hat
     */
    @RequestMapping(method = RequestMethod.POST, value = "/spieler")
    public void postSpielerEntity(@Validated @RequestBody SpielerEntity spielerEntity) {
        logger.debug("POST-Request für postSpielerEntity empfangen, Spieler: {}", spielerEntity);
        try {
            spielerService.postSpieler(spielerEntity);
        } catch (DbDuplikatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/spieler")
    public void putSpieler(@RequestBody SpielerEntity spielerEntity, @RequestHeader(value = "Authorization") String authorization){
        logger.debug("PUT-Request für Spieler empfangen, Authorization: {}, RequestBody: {}", authorization, spielerEntity);
        try {
            spielerService.putSpieler(spielerEntity, authorization);
        } catch (SpielerNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (AuthorizationException e) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
        }
    }
}
