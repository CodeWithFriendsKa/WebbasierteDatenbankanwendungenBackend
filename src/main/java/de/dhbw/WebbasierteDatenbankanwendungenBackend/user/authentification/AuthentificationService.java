package de.dhbw.WebbasierteDatenbankanwendungenBackend.user.authentification;

import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.repository.SpielerRepo;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.repository.TrainerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

/***
 * Die sogenannte "AuthetificationService" Klasse stellt Logik zuf Verfügung den Authentifizierungsvorgang durchzuführen
 * Diese Klasse ist vom Typ abstract und stellt die Oberklasse von allen Serviceklassen dar,
 * d.h. dass zum Beispiel "SpielerService" von dieser Klasse erbt und somit "SpielerService" die methoden die hier aufgeführt sind verwenden kann
 *
 */
@Service
public abstract class AuthentificationService {

    private final Logger logger = LoggerFactory.getLogger(AuthentificationService.class);
    @Autowired
    private SpielerRepo spielerRepo;
    @Autowired
    private TrainerRepo trainerRepo;

    /***
     * Diese Methode checkt, ob der base64 String, welche ja eine Mischung aus Mail und Passwort ist,
     * auch wirklich ein Trainer ist, der in der Datenbank gespeichert ist
     * In dieser Methode werden 2 Schritte ausgeführt:
     * 1) Decoodiere base64 und Mail und Passwort
     * 2) Schaue in der Datenbank ob es diese Mail mit diesem Passwort gibt -> bei Fehlschlag gib false zurück, ansonsten true
     */
    protected boolean checkAuthTrainer(String base64){
        String[] mailPassword = getMailPasswort(base64);
        logger.debug("checkAuthTrainer: Mail: {}, Passwort: {}", mailPassword[0], mailPassword[1]);
        if(trainerRepo.existsTrainerEntityByMailAndPasswort(mailPassword[0],mailPassword[1])){
            return true;
        }
        else return false;
    }

    /***
     * Diese Methode checkt, ob der base64 String, welche ja eine Mischung aus Mail und Passwort ist,
     * auch wirklich ein Trainer (Admin) oder ein Spieler ist, der in der Datenbank gespeichert ist
     * In dieser Methode werden 2 Schritte ausgeführt:
     * 1) Decoodiere base64 und Mail und Passwort
     * 2) Schaue in der Datenbank ob es diese Mail mit diesem Passwort gibt -> bei Fehlschlag gib false zurück, ansonsten true
     */
    protected boolean checkAuthGetSpielerByMail(String base64, String mail){
        if (checkAuthTrainer(base64)){
            return true;
        }
        String[] mailPasswort = getMailPasswort(base64);
        logger.debug("checkAuthGetSpielerByMail. Mail: {}, Passwort): {}", mailPasswort[0], mailPasswort[1]);
        if(spielerRepo.existsSpielerEntityByMailAndPasswort(mailPasswort[0],mailPasswort[1]) && mailPasswort[0].equals(mail)) {
            return true;
        }
        else return false;
    }

    /***
     * Diese Methode checkt, ob der base64 String, welche ja eine Mischung aus Mail und Passwort ist,
     * auch wirklich ein Trainer (Admin) oder ein Spieler ist, der in der Datenbank gespeichert ist
     * In dieser Methode werden 2 Schritte ausgeführt:
     * 1) Decoodiere base64 und Mail und Passwort
     * 2) Schaue in der Datenbank ob es diese Mail mit diesem Passwort gibt -> bei Fehlschlag gib false zurück, ansonsten true
     */
    protected boolean checkAutGetGruppeBySpielerMail(String base64, String mail){
        if (checkAuthTrainer(base64)){
            return true;
        }
        String[] mailPasswort = getMailPasswort(base64);
        logger.debug("checkAutGetGruppeBySpielerMail. Mail: {}, Passwort): {}", mailPasswort[0], mailPasswort[1]);
        if(spielerRepo.existsSpielerEntityByMailAndPasswort(mailPasswort[0],mailPasswort[1]) && mailPasswort[0].equals(mail)) {
            return true;
        }
        else return false;
    }

    /***
     * Diese Methode wird nur hier aufgerufen und ist dh. private
     * Sie dient dazu Base64 welches z.B. so aussehen könnte: =?fab235bed in das hier zu decodieren: max1.mustermann 123
     */
    private String[] getMailPasswort(String base64) {
        String decodedString = new String(Base64.getDecoder().decode(base64.split(" ")[1].getBytes()));
        return decodedString.split(":");
    }
}
