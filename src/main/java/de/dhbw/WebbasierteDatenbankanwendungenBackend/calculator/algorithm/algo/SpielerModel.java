package de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.algorithm.algo;

import java.util.ArrayList;
import java.util.Arrays;

public class SpielerModel {

    private static int zaehler=0;
    private int id;
    private final static int zeitenArraygroesse=168;
    private String name;
    private int zeiten[];
    private int alter;
    private char geschlecht;
    private int trainingsAnzahl;
    private int trainingsAnzahlAktuell;
    private static ArrayList<SpielerModel> alleSpieler = new ArrayList<>();
    private static ArrayList<SpielerModel> alleSpielerMehrTraining = new ArrayList<>();
    private SpielerStaerkeModel spielerStaerkeModel = SpielerStaerkeModel.NICHTVORHANDEN;

    public SpielerModel(String name, int[] zeiten, int alter, char geschlecht, int trainingsAnzahl) {
        this.name = name;
        this.zeiten = zeiten;
        this.alter = alter;
        this.geschlecht = geschlecht;
        this.trainingsAnzahl = trainingsAnzahl;
        this.id=zaehler;
        zaehler++;
        alleSpieler.add(this);
        for (int i = 1; i < trainingsAnzahl; i++) {
            alleSpielerMehrTraining.add(this);
        }
    }

    public Integer verrechneSpielerStaerkeMitAlter() {
        //hier wird das Spieleralter mit der Bewertung der Trainers verrechnet um die Spielerstärke zu erhalten
        if(this.spielerStaerkeModel.Staerke()==null) return this.alter;
        if(this.spielerStaerkeModel.Staerke()==2)return 3 + this.alter;
        return this.spielerStaerkeModel.Staerke() + this.alter;
    }

    public static ArrayList<SpielerModel> getAlleSpieler() {return alleSpieler;}
    public static ArrayList<SpielerModel> getAlleSpielerMehrTraining() {return alleSpielerMehrTraining;}
    public int getTrainingsAnzahlAktuell() {return trainingsAnzahlAktuell;}
    public void setTrainingsAnzahlAktuell(int trainingsAnzahlAktuell) {this.trainingsAnzahlAktuell = trainingsAnzahlAktuell;}
    public void setSpielerStaerkeModel(Integer spielerStaerkeModel) {this.spielerStaerkeModel =  SpielerStaerkeModel.valueOf(spielerStaerkeModel);}
    public void setZeiten(int[] zeiten) {this.zeiten = zeiten;}
    public void setName(String name) {this.name = name;}
    public void setAlter(int alter) {this.alter = alter;}
    public void setGeschlecht(char geschlecht) {this.geschlecht = geschlecht;}
    public void setTrainingsAnzahl(int trainingsAnzahl) {this.trainingsAnzahl = trainingsAnzahl;}
    public String getName() {return this.name;}
    public int[] getZeiten() {return this.zeiten;}
    public int getAlter() {return  this.alter;}
    public char getGeschlecht() {return this.geschlecht;}
    public int getTrainingsAnzahl() {return this.trainingsAnzahl;}
    public int getID() {return id;}
    public static int getZeitenArrayGroesse() {return zeitenArraygroesse;}
    public String getInfo() {String infoString = ""+this.name+" "+this.alter+" "+this.geschlecht;return infoString;}

    @Override
    public String toString() {
        return "SpielerModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", zeiten=" + Arrays.toString(zeiten) +
                ", alter=" + alter +
                ", geschlecht=" + geschlecht +
                ", trainingsAnzahl=" + trainingsAnzahl +
                ", trainingsAnzahlAktuell=" + trainingsAnzahlAktuell +
                ", spielerStaerkeModel=" + spielerStaerkeModel +
                '}';
    }
}

