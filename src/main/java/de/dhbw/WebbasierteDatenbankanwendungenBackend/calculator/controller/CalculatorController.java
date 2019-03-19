package de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.controller;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.entity.GruppeEntity;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.service.CalculatorService;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.service.GruppeNotFoundException;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.authentification.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;
    private final Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    @RequestMapping(method = RequestMethod.GET, value = "/gruppen")
    public List<GruppeEntity> findAllGruppen(@RequestHeader(value = "Authorization") String authorization){
        try {
            logger.debug("findAllGruppen: eingehender Request. {}", authorization);
            return calculatorService.findAllGruppen(authorization);
        }
        catch (GruppeNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        catch (AuthorizationException e){
            throw  new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/gruppen/{mail}")
    public GruppeEntity findGruppeBySpielerMail(@PathVariable(value = "mail") String mail, @RequestHeader(value = "Authorization") String authorization){
        try {
            logger.debug("findGruppeBySpielerMail: eingehender Request. Mail: {} Base64: {}", mail, authorization);
            return calculatorService.findGruppeBySpielerMail(mail, authorization);
        }
        catch (GruppeNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        catch (AuthorizationException e){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
        }
    }
    @RequestMapping(method = RequestMethod.POST, value = "/startalgo")
    public void startAlgo(@RequestHeader(value = "Authorozation") String authorization){
        try {
            logger.debug("startALgo: eingehender Request. {}", authorization);
            calculatorService.optimize(authorization);
        }
        catch (AuthorizationException e){
            throw  new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
        }
    }
    @RequestMapping(method = RequestMethod.GET, value = "/possibletimes")
    public int[] getPossibleTrainingTimes(@RequestHeader(value = "Authorization") String authorization){
        try {
            logger.debug("startALgo: eingehender Request. {}", authorization);
            return calculatorService.getPossibleTrainingTimes(authorization);
        }
        catch (AuthorizationException e){
            throw  new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
        }
    }
}
