package de.dhbw.WebbasierteDatenbankanwendungenBackend.spieler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SpielerService {

    @Autowired
    private SpielerRepo spielerRepo;

    protected void insertSpieler(SpielerEntity spieler){spielerRepo.save(spieler);}

    protected List<SpielerEntity> selectAllSpieler() {return spielerRepo.findAll();}

    protected void deleteSpielerById(Long id){spielerRepo.deleteById(id);}

    protected SpielerEntity selectSpielerById(Long id){return spielerRepo.findById(id).get();}

}
