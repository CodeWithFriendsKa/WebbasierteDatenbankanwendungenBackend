package de.dhbw.WebbasierteDatenbankanwendungenBackend.spieler;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class SpielerEntity {

    @Id
    @GeneratedValue
    Long id;

    String name;

    String vorname;

    int alter;

    String mail;

    String passwort;

    int leistungsklasse;

    public SpielerEntity(String name, String vorname, int alter, String mail, String passwort) {
        this.name = name;
        this.vorname = vorname;
        this.alter = alter;
        this.mail = mail;
        this.passwort = passwort;
    }

    private SpielerEntity(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVorname() {
        return vorname;
    }

    public int getAlter() {
        return alter;
    }

    public String getMail() {
        return mail;
    }

    public String getPasswort() {
        return passwort;
    }

    public int getLeistungsklasse() {
        return leistungsklasse;
    }

    @Override
    public String toString() {
        return "SpielerEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vorname='" + vorname + '\'' +
                ", alter=" + alter +
                ", mail='" + mail + '\'' +
                ", passwort='" + passwort + '\'' +
                ", leistungsklasse=" + leistungsklasse +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpielerEntity that = (SpielerEntity) o;
        return alter == that.alter &&
                leistungsklasse == that.leistungsklasse &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(vorname, that.vorname) &&
                Objects.equals(mail, that.mail) &&
                Objects.equals(passwort, that.passwort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, vorname, alter, mail, passwort, leistungsklasse);
    }
}
