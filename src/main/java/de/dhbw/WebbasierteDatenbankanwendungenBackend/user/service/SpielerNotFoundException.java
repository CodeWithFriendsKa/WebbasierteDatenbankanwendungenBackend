package de.dhbw.WebbasierteDatenbankanwendungenBackend.user.service;

public class SpielerNotFoundException extends Exception {
    public SpielerNotFoundException(String message) {
        super(message);
    }

    public SpielerNotFoundException(String message, Exception e) {
        super(message, e);
    }
}
