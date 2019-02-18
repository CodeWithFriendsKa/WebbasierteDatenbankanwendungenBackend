package de.dhbw.WebbasierteDatenbankanwendungenBackend;

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


@SpringBootApplication
public class BackendApplication {

	private static final Logger logger = LoggerFactory.getLogger(BackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	/**
	 * Einfügen von Demodaten für Spieler in die Datenbank
	 * Demo Spieler 1: "max.mustermann@dhbw.de", "123"
	 */

	@Bean
	protected CommandLineRunner demoSpieler(SpielerRepo spielerRepo) {
		return(args) -> {
			SpielerEntity s1 = new SpielerEntity("max.mustermann@dhbw.de", "123");
			spielerRepo.save(s1);
			logger.debug("Demospieler eingefügt: {}",spielerRepo.findSpielerEntityByMail("max.mustermann@dhbw.de"));
		};
	}

	/**
	 * Einfügen von Demodaten für Trainer in die Datenbank
	 * Demo Trainer 1: "tim.trainer@dhbw.de", "123"
	 */

	@Bean
	protected CommandLineRunner demoTrainer(TrainerRepo trainerRepo) {
		return(args) -> {
			TrainerEntity s1 = new TrainerEntity("tim.trainer@dhbw.de", "123");
			trainerRepo.save(s1);
			logger.debug("Demotrainer eingefügt: {}",trainerRepo.findTrainerEntityByMail("tim.trainer@dhbw.de"));
		};
	}

}

