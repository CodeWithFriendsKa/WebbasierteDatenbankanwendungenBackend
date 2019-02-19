package de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.service;

public class GruppeNotFoundException extends Exception {

    public GruppeNotFoundException(String message) {
        super(message);
    }

    public GruppeNotFoundException(String message, Exception e) {
        super(message, e);
    }
}
