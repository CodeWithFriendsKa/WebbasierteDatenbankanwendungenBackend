package de.dhbw.WebbasierteDatenbankanwendungenBackend.user.authentification;

import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.repository.SpielerRepo;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.repository.TrainerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

/**
 * Trainer haben Adminrechte
 * Für Spieler  werden für verschiedene Operationsbereiche verschiedene Methoden zur Authentifizierung erstellt.
 *
 */
@Service
public abstract class AuthentificationService {

    private final Logger logger = LoggerFactory.getLogger(AuthentificationService.class);
    @Autowired
    private SpielerRepo spielerRepo;
    @Autowired
    private TrainerRepo trainerRepo;

    protected boolean checkAuthTrainer(String base64){
        String[] mailPassword = getMailPasswort(base64);
        logger.debug("String 0 (Mail):  {}, String 1 (Passwort): {}", mailPassword[0], mailPassword[1]);
        if(trainerRepo.existsTrainerEntityByMailAndPasswort(mailPassword[0],mailPassword[1])){
            return true;
        }
        else return false;
    }

    protected boolean checkAuthGetSpielerByMail(String base64, String mail){
        if (checkAuthTrainer(base64)){
            return true;
        }
        String[] mailPasswort = getMailPasswort(base64);
        logger.debug("String 0 (Mail):  {}, String 1 (Passwort): {}", mailPasswort[0], mailPasswort[1]);
        if(spielerRepo.existsSpielerEntityByMailAndPasswort(mailPasswort[0],mailPasswort[1]) && mailPasswort[0].equals(mail)) {
            return true;
        }
        else return false;
    }

    protected boolean checkAutGetGruppeBySpielerMail(String base64, String mail){
        if (checkAuthTrainer(base64)){
            return true;
        }
        String[] mailPasswort = getMailPasswort(base64);
        logger.debug("String 0 (Mail):  {}, String 1 (Passwort): {}", mailPasswort[0], mailPasswort[1]);
        if(spielerRepo.existsSpielerEntityByMailAndPasswort(mailPasswort[0],mailPasswort[1]) && mailPasswort[0].equals(mail)) {
            return true;
        }
        else return false;
    }

    private String[] getMailPasswort(String base64) {
        String decodedString = new String(Base64.getDecoder().decode(base64.split(" ")[1].getBytes()));
        return decodedString.split(":");
    }
}
