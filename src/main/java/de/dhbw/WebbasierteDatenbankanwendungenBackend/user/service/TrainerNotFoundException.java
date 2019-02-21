package de.dhbw.WebbasierteDatenbankanwendungenBackend.user.service;

public class TrainerNotFoundException extends Exception {
    public TrainerNotFoundException(String message) {
        super(message);
    }

    public TrainerNotFoundException(String message, Exception e) {
        super(message, e);
    }
}
