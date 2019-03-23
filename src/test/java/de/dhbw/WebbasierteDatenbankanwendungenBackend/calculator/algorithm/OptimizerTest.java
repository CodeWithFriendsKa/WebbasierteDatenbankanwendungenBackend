package de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.algorithm;

import de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.algorithm.algo.SpielerModel;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.entity.SpielerEntity;
import de.dhbw.WebbasierteDatenbankanwendungenBackend.user.repository.SpielerRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class OptimizerTest {

    @TestConfiguration
    static class OptimizerTestConfiguration {

        @Bean
        public Optimizer optimizer() {
            return new Optimizer();
        }
    }

    private final Logger logger = LoggerFactory.getLogger(OptimizerTest.class);
    SpielerModel spielerModel;
    SpielerEntity spielerEntity;
    int[] times = {0,0,0,1};

    @Autowired
    private Optimizer optimizer;

    @MockBean
    private SpielerRepo spielerRepo;

    @Before
    public void setUp() {
        spielerEntity = new SpielerEntity(
                "max1.mustermann@dhbw.de",
                "12345678",
                21,
                "max",
                "mustermann",
                'm'
        );
        Mockito.when(spielerRepo.findSpielerEntityByMail("max1.mustermann@dhbw.de"))
                .thenReturn(spielerEntity);
    }

    @Test
    public void spielerModelToEntity_Test(){
        //prepare
        spielerModel = new SpielerModel(
                "max1.mustermann@dhbw.de",
                times,
                21,
                'm',
                2
        );
        spielerModel.setZeiten(times);
        spielerModel.setTrainingsAnzahl(2);
        //execute
        SpielerEntity entity = optimizer.spielerModelToEntity(spielerModel);
        logger.debug("spielerModelToEntity_Test Entity: {}", entity);
        logger.debug("spielerModelToEntity_Test Model: {}", spielerModel);
        //verify
        assertEquals(entity.getTrainingCount(), spielerModel.getTrainingsAnzahl());
        assertEquals(entity.getTrainingTimes(), spielerModel.getZeiten());
    }
}