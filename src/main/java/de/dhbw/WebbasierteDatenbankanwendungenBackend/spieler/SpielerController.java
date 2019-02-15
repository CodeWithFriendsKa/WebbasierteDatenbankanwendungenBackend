package de.dhbw.WebbasierteDatenbankanwendungenBackend.spieler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
public class SpielerController {

    private final Logger logger = LoggerFactory.getLogger(SpielerController.class);

    @Autowired
    private SpielerService spielerService;

    @Autowired
    private SpielerLoginService spielerLoginService;

    @RequestMapping(method = RequestMethod.POST, value = "/spieler")
    public void postSpieler(@RequestBody SpielerEntity spielerEntity){spielerService.insertSpieler(spielerEntity);}

    @RequestMapping(method = RequestMethod.DELETE, value = "/spieler/{id}")
    public void deleteSpieler(@PathVariable Long id, @RequestHeader(value = "Authorization") String authorization){
        if (spielerLoginService.checkAuth(authorization)){
            spielerService.deleteSpielerById(id);
            logger.info("detele Spieler with id {}", id);
        }
        else throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Melde dich richtig an du Idiot!");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/spieler/{id}")
    public SpielerEntity getSpieler(@PathVariable Long id, @RequestHeader(value = "Authorization") String authorization){
        if (spielerLoginService.checkAuth(authorization)){
            var result = spielerService.selectSpielerById(id);
            logger.info("get Spieler with id {}", result);
            return result;
        }
        else throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Melde dich richtig an du Idiot!");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/spieler")
    public List<SpielerEntity> getAllSpieler(@RequestHeader(value = "Authorization") String authorization){
        if(spielerLoginService.checkAuthAdmin(authorization)){
            var result = spielerService.selectAllSpieler();
            logger.info("getAllSpieler, result: {}", result);
            return result;
        }
        else throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Melde dich richtig an du Idiot!");
    }
}
