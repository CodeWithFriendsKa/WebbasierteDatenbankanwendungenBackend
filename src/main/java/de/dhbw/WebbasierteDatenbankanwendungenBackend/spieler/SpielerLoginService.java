package de.dhbw.WebbasierteDatenbankanwendungenBackend.spieler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;


@Service
public class SpielerLoginService {

    @Autowired
    SpielerRepo spielerRepo;

    private final Logger logger = LoggerFactory.getLogger(SpielerLoginService.class);

    protected boolean checkAuthAdmin(String base64){
        String[] usernamePassword = getUsernamePasswort(base64);
        logger.debug("String 0:  {}, String 1: {}", usernamePassword[0], usernamePassword[1]);
        if (usernamePassword[0].equals("admin") && usernamePassword[1].equals("p")){
            return true;
        } else return false;
    }

    protected boolean checkAuth(String base64){
        if (checkAuthAdmin(base64)){
            return true;
        }
        String[] usernamePassword = getUsernamePasswort(base64);
        logger.debug("String 0:  {}, String 1: {}", usernamePassword[0], usernamePassword[1]);
        if(spielerRepo.existsSpielerEntitiesByMailAndPasswort(usernamePassword[0],usernamePassword[1])){
            return true;
        }
        else return false;
    }

    private String[] getUsernamePasswort(String base64) {
        String decodedString = new String(Base64.getDecoder().decode(base64.split(" ")[1].getBytes()));
        return decodedString.split(":");
    }
}
