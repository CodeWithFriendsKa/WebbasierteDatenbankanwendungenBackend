package de.dhbw.WebbasierteDatenbankanwendungenBackend.user.entity;

import javax.persistence.Column;
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
    @Pattern(regexp = "[\\w|-|.|_]{0,29}[\\w]@\\w[\\w|-]*\\.[a-z]+")
    private String mail;
    //Passwort: Ziffern, Klein- und Großbuchstaben und Punkt-Zeichen (!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~) sind erlaubt
    //Mindestlänge für Passwort: 8 Zeichen, maximal: 40 Zeichen
    @Pattern(regexp = "[\\w|\\p{Punct}]{8,40}")
    private String passwort;

    private int age;
    private String name;
    private String prename;
    private char sex;
    private int trainingCount;
    private int minTrainingTimes;
    @Column(length = Integer.MAX_VALUE)
    private int[] zeiten;
    private int prio;

    private TrainerEntity() {}

    public TrainerEntity(String mail, String passwort) {
        this.mail = mail;
        this.passwort = passwort;
    }

    public TrainerEntity(@Pattern(regexp = "[\\w|-|.|_]{0,29}[\\w]@\\w[\\w|-]*\\.[a-z]+") String mail, @Pattern(regexp = "[\\w|\\p{Punct}]{8,40}") String passwort, int age, String name, String prename, char sex, int trainingCount, int minTrainingTimes, int[] zeiten, int prio) {
        this.mail = mail;
        this.passwort = passwort;
        this.age = age;
        this.name = name;
        this.prename = prename;
        this.sex = sex;
        this.trainingCount = trainingCount;
        this.minTrainingTimes = minTrainingTimes;
        this.zeiten = zeiten;
        this.prio = prio;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getTrainingCount() {
        return trainingCount;
    }

    public void setTrainingCount(int trainingCount) {
        this.trainingCount = trainingCount;
    }

    public int getMinTrainingTimes() {
        return minTrainingTimes;
    }

    public void setMinTrainingTimes(int minTrainingTimes) {
        this.minTrainingTimes = minTrainingTimes;
    }

    public int[] getZeiten() {
        return zeiten;
    }

    public void setZeiten(int[] zeiten) {
        this.zeiten = zeiten;
    }

    public int getPrio() {
        return prio;
    }

    public void setPrio(int prio) {
        this.prio = prio;
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
