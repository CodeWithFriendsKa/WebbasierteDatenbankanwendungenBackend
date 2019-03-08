package de.dhbw.WebbasierteDatenbankanwendungenBackend.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@Entity
public class TrainerEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Pattern(regexp = "[\\w|-|.|_]{0,29}[\\w]@\\w[\\w|-]*\\.[a-z]{2,3}")
    private String mail;
    //Passwort: Ziffern, Klein- und Großbuchstaben und Punkt-Zeichen (!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~) sind erlaubt
    //Mindestlänge für Passwort: 8 Zeichen, maximal: 40 Zeichen
    @Pattern(regexp = "[\\w|\\p{Punct}]{8,40}")
    private String passwort;

    private TrainerEntity() {}

    public TrainerEntity(String mail, String passwort) {
        this.mail = mail;
        this.passwort = passwort;
    }

    public Long getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public String getPasswort() {
        return passwort;
    }

    @Override
    public String toString() {
        return "TrainerEntity{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
                ", passwort='" + passwort + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainerEntity that = (TrainerEntity) o;
        return id.equals(that.id) &&
                mail.equals(that.mail) &&
                passwort.equals(that.passwort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mail, passwort);
    }
}
