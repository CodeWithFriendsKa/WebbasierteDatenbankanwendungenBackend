package de.dhbw.WebbasierteDatenbankanwendungenBackend.user.service;

import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.entity.SpielerEntity;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.repository.SpielerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpielerService {

    @Autowired
    SpielerRepo spielerRepo;

    public SpielerEntity getSpielerByMail(String mail) {
        return spielerRepo.findSpielerEntityByMail(mail);
    }

    public void postSpieler(SpielerEntity spielerEntity) throws DbDuplikatException {
        SpielerEntity spieler = spielerRepo.findSpielerEntityByMail(spielerEntity.getMail());
        if(spieler == null) {
            spielerRepo.save(spielerEntity);
        }
        else {
            throw new DbDuplikatException("Spieler mit Mail-Adresse bereits vorhanden.");
        }

    }
}
