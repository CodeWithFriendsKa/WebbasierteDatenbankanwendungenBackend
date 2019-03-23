package de.dhbw.WebbasierteDatenbankanwendungenBackend;

import de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.algorithm.algo.SpielerModel;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.algorithm.algo.TestList;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.algorithm.algo.TrainerModel;
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
			/*

			SpielerEntity s1 = new SpielerEntity("max1.mustermann@dhbw.de", "12345678", 21, "max", "mustermann",'m');
			spielerRepo.save(s1);
			logger.debug("Demospieler eingefügt: {}",spielerRepo.findSpielerEntityByMail("max1.mustermann@dhbw.de"));

			SpielerEntity s2 = new SpielerEntity("max2.mustermann@dhbw.de", "12345678", 21, "max", "mustermann",'m');
			spielerRepo.save(s2);
			logger.debug("Demospieler eingefügt: {}",spielerRepo.findSpielerEntityByMail("max2.mustermann@dhbw.de"));

			SpielerEntity s3 = new SpielerEntity("max3.mustermann@dhbw.de", "12345678", 21, "max", "mustermann",'m');
			spielerRepo.save(s3);
			logger.debug("Demospieler eingefügt: {}",spielerRepo.findSpielerEntityByMail("max3.mustermann@dhbw.de"));

			SpielerEntity s4 = new SpielerEntity("max4.mustermann@dhbw.de", "12345678", 21, "max", "mustermann",'m');
			spielerRepo.save(s4);
			logger.debug("Demospieler eingefügt: {}",spielerRepo.findSpielerEntityByMail("max4.mustermann@dhbw.de"));

			SpielerEntity s5 = new SpielerEntity("max5.mustermann@dhbw.de", "12345678", 21, "max", "mustermann",'m');
			spielerRepo.save(s5);
			logger.debug("Demospieler eingefügt: {}",spielerRepo.findSpielerEntityByMail("max5.mustermann@dhbw.de"));

*/

			ArrayList<SpielerModel> spielerModels = new ArrayList<SpielerModel>();

			//	1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24
			int[] data1 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  1,  1,  1,  1,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0,	0, 0,  0,  0,  0,  0,  0,  1,  1,  1,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 };

			int[] data2 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0,	0, 0,  0,  0,  0,  0,  1,  1,  1,  1,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 };

			int[] data3 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0,	0, 0,  0,  0,  0,  0,  1,  1,  1,  1,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 };

			int[] data4 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0,	0, 0,  0,  0,  0,  0,  1,  1,  1,  1,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 1,  1,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 };

			int[] data5 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0,	0, 0,  0,  0,  0,  0,  1,  1,  1,  1,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 };

			int[] data6 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0,	0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 };

			int[] data8 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0,	0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 };

			int[] data7 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0,	0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 };

			int[] data9 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0,	0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 };

			int[] data10 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0,	0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 };

			int[] data11 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0,	0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 };

			int[] data12 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0,	0, 0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  1,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 };

			int[] data13 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0,	0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  1,  1,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 };

			int[] data14 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  1,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0,	0, 0,  0,  1,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  1,  1,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 };

			int[] data15 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0,	0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 };

			int[] data16 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0,	0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  1,  1,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 };

			int[] data17 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0,	0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  1,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  1,  1,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 };

			int[] data18 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0,	0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  1,  1,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 };

			int[] data19 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0,	0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 };

			int[] data20 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0,	0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  1,  1,  1,  1,  1,  1,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 };


			int[] data0 = 	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0 };

			SpielerModel spieler1 = new SpielerModel("Niklas", data1, 16, 'm', 2);
			SpielerModel spieler2 = new SpielerModel("Sascha", data2, 14, 'm', 1);
			SpielerModel spieler3 = new SpielerModel("Kevin", data3, 12, 'm', 1);
			SpielerModel spieler4 = new SpielerModel("Bob", data4, 13, 'm', 1);
			SpielerModel spieler5 = new SpielerModel("Heinz", data5, 16, 'm', 2);
			SpielerModel spieler6 = new SpielerModel("Tobi", data6, 15, 'm', 1);
			SpielerModel spieler7 = new SpielerModel("Flo", data7, 15, 'm', 1);
			SpielerModel spieler8 = new SpielerModel("Rouven", data8, 14, 'm', 2);
			SpielerModel spieler9 = new SpielerModel("Karl", data9, 5, 'm', 1);
			SpielerModel spieler10 = new SpielerModel("Jojo", data10, 6, 'm', 1);


			SpielerModel spieler11 = new SpielerModel("Anna", data11, 16, 'w', 1);
			SpielerModel spieler20 = new SpielerModel("Soraka", data12, 15, 'w', 1);
			SpielerModel spieler12 = new SpielerModel("Anne", data13, 15, 'w', 1);
			SpielerModel spieler13 = new SpielerModel("Lisa", data14, 11, 'w', 2);
			SpielerModel spieler14 = new SpielerModel("Lisandra", data15, 14, 'w', 2);
			SpielerModel spieler15 = new SpielerModel("Diana", data16, 13, 'w', 1);
			SpielerModel spieler16 = new SpielerModel("Sona", data17, 12, 'w', 1);
			SpielerModel spieler17 = new SpielerModel("Kayle", data18, 11, 'w', 1);
			SpielerModel spieler18 = new SpielerModel("Annie", data19, 5, 'w', 1);
			SpielerModel spieler19 = new SpielerModel("Lux", data20, 5, 'w', 1);

			spielerModels.add(spieler1);
			spielerModels.add(spieler2);
			spielerModels.add(spieler3);
			spielerModels.add(spieler4);
			spielerModels.add(spieler5);
			spielerModels.add(spieler6);
			spielerModels.add(spieler7);
			spielerModels.add(spieler8);
			spielerModels.add(spieler9);
			spielerModels.add(spieler10);
			spielerModels.add(spieler11);
			spielerModels.add(spieler12);
			spielerModels.add(spieler13);
			spielerModels.add(spieler14);
			spielerModels.add(spieler15);
			spielerModels.add(spieler16);
			spielerModels.add(spieler17);
			spielerModels.add(spieler18);
			spielerModels.add(spieler19);
			spielerModels.add(spieler20);



			spielerModels.forEach( model -> {
				spielerRepo.save(new SpielerEntity(
						(model.getName() + "@dhbw.de"),
						"12345678",
						model.getAlter(),
						model.getName(),
						model.getName(),
						model.getGeschlecht(),
						model.getTrainingsAnzahl(),
						model.getZeiten()
				));
			});

			SpielerModel.removeAlleSpieler();
			SpielerModel.resetZaehler();






			/*
			List<SpielerModel> models = TestList.testListSpieler();
			logger.debug("TEST_LIST_MODELS_BEGIN");
			models.forEach(m -> {
				logger.debug(m.toString());
			});
			logger.debug("TEST_LIST_MODELS_END");
			models.forEach( model -> {
				spielerRepo.save(new SpielerEntity(
						(model.getName() + "@dhbw.de"),
						"12345678",
						model.getAlter(),
						"Mustermann",
						model.getName(),
						model.getGeschlecht(),
						model.getTrainingsAnzahl(),
						model.getZeiten()
				));
			}); */

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
/*
			TrainerEntity s1 = new TrainerEntity("tim1.trainer@dhbw.de", "12345678");
			trainerRepo.save(s1);
			logger.debug("Demotrainer eingefügt: {}",trainerRepo.findTrainerEntityByMail("tim1.trainer@dhbw.de"));

			TrainerEntity s2 = new TrainerEntity("tim2.trainer@dhbw.de", "12345678");
			trainerRepo.save(s2);
			logger.debug("Demotrainer eingefügt: {}",trainerRepo.findTrainerEntityByMail("tim2.trainer@dhbw.de"));

			TrainerEntity s3 = new TrainerEntity("tim3.trainer@dhbw.de", "12345678");
			trainerRepo.save(s3);
			logger.debug("Demotrainer eingefügt: {}",trainerRepo.findTrainerEntityByMail("tim3.trainer@dhbw.de"));
*/


			ArrayList<TrainerModel> trainerModels = new ArrayList<TrainerModel>();
/*
			TrainerModel.deleteAlleTrainer();
			TrainerModel.resetZaehler();
*/
			int[] data1 = {
					// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24
					1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, };

			int[] data2 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1,
					1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

			int[] data3 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

			TrainerModel Trainer1 = new TrainerModel("PeterTrainer", data1, 1, 0);
			TrainerModel Trainer2 = new TrainerModel("AronTrainer", data2, 3, 3);
			TrainerModel Trainer3 = new TrainerModel("KarlTrainer", data3, 5, 3);

			trainerModels.add(Trainer1);
			trainerModels.add(Trainer2);
			trainerModels.add(Trainer3);


			trainerModels.forEach( model -> {
				trainerRepo.save(new TrainerEntity(
						(model.getName() + "@dhbw.de"),
						"12345678",
						30,
						model.getName(),
						model.getName(),
						'm',
						model.getAktAnzTraining(),
						model.getMinAnzTraining(),
						model.getZeiten(),
						model.getPrio()
				));
			});

			TrainerModel.deleteAlleTrainer();
			TrainerModel.resetZaehler();




			/*
			List<TrainerModel> trainerModels = TestList.testListTrainer();
            logger.debug("TEST_LIST_MODELS_BEGIN");
            trainerModels.forEach(t -> {
                logger.debug(t.toString());
            });

            logger.debug("TEST_LIST_MODELS_END");

			trainerModels.forEach( model -> {
				trainerRepo.save(new TrainerEntity(
						(model.getName() + "@dhbw.de"),
						"12345678",
						30,
						"MusterTrainer",
						model.getName(),
						'm',
						model.getAktAnzTraining(),
						model.getZeiten(),
						model.getPrio()
				));
			});*/
		};
	}

	/***
	 * Einfügen von Demodaten für Gruppen in die Datenbank
	 * Demo Gruppe 1:
	 * Demo Gruppe 2:
	 */
	//@Bean
	protected CommandLineRunner demoGruppenEinfügen(GruppeRepo gruppeRepo, SpielerRepo spielerRepo, TrainerRepo trainerRepo){
		return args -> {
			List<SpielerEntity> spielerListe1 = new ArrayList<>();
			spielerListe1.add(spielerRepo.findSpielerEntityByMail("max1.mustermann@dhbw.de"));
			spielerListe1.add(spielerRepo.findSpielerEntityByMail("max2.mustermann@dhbw.de"));
			spielerListe1.add(spielerRepo.findSpielerEntityByMail("max3.mustermann@dhbw.de"));
			GruppeEntity g1 = new GruppeEntity(
					"de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.algorithm.algo.Platz 1",
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
					"de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.algorithm.algo.Platz 3",
					"Mittwoch 14:00 - 17:00 Uhr",
					spielerListe2,
					trainerRepo.findTrainerEntityByMail("tim2.trainer@dhbw.de")
			);
			gruppeRepo.save(g2);
			logger.debug("Demogruppe eingefügt: {}", gruppeRepo.findAll());
		};
	}
}

