package de.dhbw.WebbasierteDatenbankanwendungenBackend.user.controller;

import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.entity.SpielerEntity;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.authentification.AuthorizationException;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.service.DbDuplikatException;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.service.SpielerNotFoundException;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.service.SpielerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class SpielerController {

    @Autowired
    SpielerService spielerService;

    @RequestMapping(method = RequestMethod.GET, value = "/spieler/{mail}")
    public SpielerEntity getSpielerByMail(@PathVariable(value = "mail") String mail, @RequestHeader(value = "Authorization") String authorization) {
        try {
            return spielerService.getSpielerByMail(mail, authorization);
        } catch (SpielerNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (AuthorizationException e) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/spieler")
    public void postSpielerEntity(@RequestBody SpielerEntity spielerEntity) {
        try {
            spielerService.postSpieler(spielerEntity);
        } catch (DbDuplikatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
