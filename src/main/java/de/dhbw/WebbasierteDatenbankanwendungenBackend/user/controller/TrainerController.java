package de.dhbw.WebbasierteDatenbankanwendungenBackend.user.controller;

import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.entity.TrainerEntity;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class TrainerController {

    @Autowired
    TrainerService trainerService;

    @RequestMapping(method = RequestMethod.GET, value = "/trainer/{mail}")
    public TrainerEntity getTrainerByMail(@PathVariable(value = "mail") String mail) {
        TrainerEntity trainerEntity = trainerService.getTrainerByMail(mail);

        if(trainerEntity != null) {
            return trainerService.getTrainerByMail(mail);
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trainer nicht gefunden.");
    }

}

