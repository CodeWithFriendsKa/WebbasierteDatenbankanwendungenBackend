package de.dhbw.WebbasierteDatenbankanwendungenBackend.user.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class SpielerEntity {

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
    private int[] trainingTimes;

    private SpielerEntity() {}
    public SpielerEntity(@Pattern(regexp = "[\\w|-|.|_]{0,29}[\\w]@\\w[\\w|-]*\\.[a-z]+") String mail,
                         @Pattern(regexp = "[\\w|\\p{Punct}]{8,40}") String passwort,
                         int age,
                         String name,
                         String prename,
                         char sex) {
        this.mail = mail;
        this.passwort = passwort;
        this.age = age;
        this.name = name;
        this.prename = prename;
        this.sex = sex;
    }

    public SpielerEntity(@Pattern(regexp = "[\\w|-|.|_]{0,29}[\\w]@\\w[\\w|-]*\\.[a-z]+") String mail,
                         @Pattern(regexp = "[\\w|\\p{Punct}]{8,40}") String passwort,
                         int age,
                         String name,
                         String prename,
                         char sex,
                         int trainingCount,
                         int[] trainingTimes) {
        this.mail = mail;
        this.passwort = passwort;
        this.age = age;
        this.name = name;
        this.prename = prename;
        this.sex = sex;
        this.trainingCount = trainingCount;
        this.trainingTimes = trainingTimes;
    }

    public Long getId() {return id;}
    public String getMail() {return mail;}
    public String getPasswort() {return passwort;}
    public int getAge() {return age;}
    public String getName() {return name;}
    public String getPrename() {return prename;}
    public char getSex() {return sex;}
    public int getTrainingCount() {return trainingCount;}
    public int[] getTrainingTimes() {return trainingTimes;}
    public void setId(Long id) {this.id = id;}
    public void setMail(String mail) {this.mail = mail;}
    public void setPasswort(String passwort) {this.passwort = passwort;}
    public void setAge(int age) {this.age = age;}
    public void setName(String name) {this.name = name;}
    public void setPrename(String prename) {this.prename = prename;}
    public void setSex(char sex) {this.sex = sex;}
    public void setTrainingCount(int trainingCount) {this.trainingCount = trainingCount;}
    public void setTrainingTimes(int[] trainingTimes) {this.trainingTimes = trainingTimes;}

    @Override
    public String toString() {
        return "SpielerEntity{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
                ", passwort='" + passwort + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", prename='" + prename + '\'' +
                ", sex=" + sex +
                ", trainingCount=" + trainingCount +
                ", trainingTimes=" + Arrays.toString(trainingTimes) +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpielerEntity that = (SpielerEntity) o;
        return age == that.age &&
                sex == that.sex &&
                trainingCount == that.trainingCount &&
                Objects.equals(id, that.id) &&
                Objects.equals(mail, that.mail) &&
                Objects.equals(passwort, that.passwort) &&
                Objects.equals(name, that.name) &&
                Objects.equals(prename, that.prename) &&
                Arrays.equals(trainingTimes, that.trainingTimes);
    }
    @Override
    public int hashCode() {
        int result = Objects.hash(id, mail, passwort, age, name, prename, sex, trainingCount);
        result = 31 * result + Arrays.hashCode(trainingTimes);
        return result;
    }
}
