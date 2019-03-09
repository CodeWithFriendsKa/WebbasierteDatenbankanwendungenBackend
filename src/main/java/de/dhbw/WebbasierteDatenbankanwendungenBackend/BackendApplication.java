package de.dhbw.WebbasierteDatenbankanwendungenBackend;

import de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.entity.GruppeEntity;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.repository.GruppeRepo;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.entity.SpielerEntity;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.entity.TrainerEntity;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.repository.SpielerRepo;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.repository.TrainerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class BackendApplication {

	private static final Logger logger = LoggerFactory.getLogger(BackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	/**
	 * Einfügen von Demodaten für Spieler in die Datenbank
	 * Demo Spieler 1: "max1.mustermann@dhbw.de", "123"
	 * Demo Spieler 2: "max2.mustermann@dhbw.de", "123"
	 * Demo Spieler 3: "max3.mustermann@dhbw.de", "123"
	 * Demo Spieler 4: "max4.mustermann@dhbw.de", "123"
	 * Demo Spieler 5: "max5.mustermann@dhbw.de", "123"
	 */
	@Bean
	protected CommandLineRunner demoSpielerEinfügen(SpielerRepo spielerRepo) {
		return args -> {
			SpielerEntity s1 = new SpielerEntity("max1.mustermann@dhbw.de", "12345678");
			spielerRepo.save(s1);
			logger.debug("Demospieler eingefügt: {}",spielerRepo.findSpielerEntityByMail("max1.mustermann@dhbw.de"));

			SpielerEntity s2 = new SpielerEntity("max2.mustermann@dhbw.de", "12345678");
			spielerRepo.save(s2);
			logger.debug("Demospieler eingefügt: {}",spielerRepo.findSpielerEntityByMail("max2.mustermann@dhbw.de"));

			SpielerEntity s3 = new SpielerEntity("max3.mustermann@dhbw.de", "12345678");
			spielerRepo.save(s3);
			logger.debug("Demospieler eingefügt: {}",spielerRepo.findSpielerEntityByMail("max3.mustermann@dhbw.de"));

			SpielerEntity s4 = new SpielerEntity("max4.mustermann@dhbw.de", "12345678");
			spielerRepo.save(s4);
			logger.debug("Demospieler eingefügt: {}",spielerRepo.findSpielerEntityByMail("max4.mustermann@dhbw.de"));

			SpielerEntity s5 = new SpielerEntity("max5.mustermann@dhbw.de", "12345678");
			spielerRepo.save(s5);
			logger.debug("Demospieler eingefügt: {}",spielerRepo.findSpielerEntityByMail("max5.mustermann@dhbw.de"));
		};
	}

	/**
	 * Einfügen von Demodaten für Trainer in die Datenbank
	 * Demo Trainer 1: "tim1.trainer@dhbw.de", "123"
	 * Demo Trainer 2: "tim2.trainer@dhbw.de", "123"
	 * Demo Trainer 3: "tim3.trainer@dhbw.de", "123"
	 */
	@Bean
	protected CommandLineRunner demoTrainerEinfügen(TrainerRepo trainerRepo) {
		return args -> {
			TrainerEntity s1 = new TrainerEntity("tim1.trainer@dhbw.de", "12345678");
			trainerRepo.save(s1);
			logger.debug("Demotrainer eingefügt: {}",trainerRepo.findTrainerEntityByMail("tim1.trainer@dhbw.de"));

			TrainerEntity s2 = new TrainerEntity("tim2.trainer@dhbw.de", "12345678");
			trainerRepo.save(s2);
			logger.debug("Demotrainer eingefügt: {}",trainerRepo.findTrainerEntityByMail("tim2.trainer@dhbw.de"));

			TrainerEntity s3 = new TrainerEntity("tim3.trainer@dhbw.de", "12345678");
			trainerRepo.save(s3);
			logger.debug("Demotrainer eingefügt: {}",trainerRepo.findTrainerEntityByMail("tim3.trainer@dhbw.de"));
		};
	}

	/***
	 * Einfügen von Demodaten für Gruppen in die Datenbank
	 * Demo Gruppe 1:
	 * Demo Gruppe 2:
	 */
	@Bean
	protected CommandLineRunner demoGruppenEinfügen(GruppeRepo gruppeRepo, SpielerRepo spielerRepo, TrainerRepo trainerRepo){
		return args -> {
			List<SpielerEntity> spielerListe1 = new ArrayList<>();
			spielerListe1.add(spielerRepo.findSpielerEntityByMail("max1.mustermann@dhbw.de"));
			spielerListe1.add(spielerRepo.findSpielerEntityByMail("max2.mustermann@dhbw.de"));
			spielerListe1.add(spielerRepo.findSpielerEntityByMail("max3.mustermann@dhbw.de"));
			GruppeEntity g1 = new GruppeEntity(
					"Platz 1",
					"Montag 16:00 - 18:00 Uhr",
					spielerListe1,
					trainerRepo.findTrainerEntityByMail("tim1.trainer@dhbw.de")
			);
			gruppeRepo.save(g1);
			logger.debug("Demogruppe eingefügt: {}", gruppeRepo.findAll());

			List<SpielerEntity> spielerListe2 = new ArrayList<>();
			spielerListe2.add(spielerRepo.findSpielerEntityByMail("max4.mustermann@dhbw.de"));
			spielerListe2.add(spielerRepo.findSpielerEntityByMail("max5.mustermann@dhbw.de"));
			GruppeEntity g2 = new GruppeEntity(
					"Platz 1",
					"Montag 16:00 - 18:00 Uhr",
					spielerListe2,
					trainerRepo.findTrainerEntityByMail("tim2.trainer@dhbw.de")
			);
			gruppeRepo.save(g2);
			logger.debug("Demogruppe eingefügt: {}", gruppeRepo.findAll());
		};
	}
}

