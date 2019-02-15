package de.dhbw.WebbasierteDatenbankanwendungenBackend.trainer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TrainerEntity {

    @Id
    @GeneratedValue
    Long id;

    String mail;

    String password;
}
