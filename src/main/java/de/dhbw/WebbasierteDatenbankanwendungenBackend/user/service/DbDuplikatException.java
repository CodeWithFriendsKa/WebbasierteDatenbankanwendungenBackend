package de.dhbw.WebbasierteDatenbankanwendungenBackend.user.service;

public class DbDuplikatException extends Exception {

    public DbDuplikatException(String message) {
        super(message);
    }

    public DbDuplikatException(String message, Exception e) {
        super(message, e);
    }
}
