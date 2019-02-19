package de.dhbw.WebbasierteDatenbankanwendungenBackend.user.authentification;

public class AuthorizationException extends Exception {
    public AuthorizationException(String message) {
        super(message);
    }

    public AuthorizationException(String message, Exception e) {
        super(message, e);
    }
}
