package de.dhbw.WebbasierteDatenbankanwendungenBackend.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class TrainerEntity {
    @Id
    @GeneratedValue
    Long id;
    String mail;
    String passwort;

    public TrainerEntity() {
    }

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

    @Override
    public String toString() {
        return "TrainerEntity{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
                ", passwort='" + passwort + '\'' +
                '}';
    }


}
