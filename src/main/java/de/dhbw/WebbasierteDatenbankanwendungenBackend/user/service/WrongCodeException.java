package de.dhbw.WebbasierteDatenbankanwendungenBackend.user.service;

public class WrongCodeException extends Exception {

    public WrongCodeException(String message) {
        super(message);
    }
}
