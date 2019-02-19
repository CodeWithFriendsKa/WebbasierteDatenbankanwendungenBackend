package de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.controller;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.entity.GruppeEntity;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.service.CalculatorService;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.service.GruppeNotFoundException;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.authentification.AuthorizationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @RequestMapping(method = RequestMethod.GET, value = "/Gruppen")
    public List<GruppeEntity> findAllGruppen(@RequestHeader(value = "Authorization") String authorization){
        try {
            return calculatorService.findAllGruppen(authorization);
        }
        catch (GruppeNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        catch (AuthorizationException e){
            throw  new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/Gruppen/{mail}")
    public GruppeEntity findGruppeBySpielerMail(@PathVariable(value = "mail") String mail, @RequestHeader(value = "Authorization") String authorization){
        try {
            return calculatorService.findGruppeBySpielerMail(mail, authorization);
        }
        catch (GruppeNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        catch (AuthorizationException e){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
        }
    }
}
