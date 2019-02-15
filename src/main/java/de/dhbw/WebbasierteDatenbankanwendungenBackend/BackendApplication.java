package de.dhbw.WebbasierteDatenbankanwendungenBackend;

import de.dhbw.WebbasierteDatenbankanwendungenBackend.spieler.SpielerEntity;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.spieler.SpielerRepo;
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
	 * Einfügen von Demodaten in die Datenbank
	 */
	@Bean
	protected CommandLineRunner demoSpieler(SpielerRepo spielerRepo){
		return (args) -> {
			SpielerEntity spielerEntity = new SpielerEntity("Fischer", "Tamino", 25, "tamino.fischer@outlook.de", "123");
			spielerRepo.save(spielerEntity);
			logger.debug("Einfügen von Spielerdemodaten: {}", spielerEntity);
		};
	}

}

