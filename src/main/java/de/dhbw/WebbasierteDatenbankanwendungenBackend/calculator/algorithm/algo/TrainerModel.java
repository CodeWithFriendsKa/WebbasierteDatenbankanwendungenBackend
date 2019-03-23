package de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.algorithm.algo;

import java.util.ArrayList;
import java.util.Arrays;

public class TrainerModel {
	
	private static int zaehler = 0;
	private int id;
	private String name;
	private int zeiten[];
	private int prio;
	private  ArrayList<Integer> minTrainingProTag;
	private int minAnzTraining;
	private int aktAnzTraining;
	private ArrayList<ArrayList<PauseModel>> pauseProTag = new ArrayList<ArrayList<PauseModel>>();
	private static ArrayList<TrainerModel> alleTrainer = new ArrayList<TrainerModel>();
	
	
	public ArrayList<Integer> getMinTrainingProTag() {
		return minTrainingProTag;
	}

	public void setMinTrainingProTag(ArrayList<Integer> minTrainingProTag) {
		this.minTrainingProTag = minTrainingProTag;
	}

	public int getAktAnzTraining() {
		return aktAnzTraining;
	}

	public void setAktAnzTraining(int aktAnzTraining) {
		this.aktAnzTraining = aktAnzTraining;
	}

	public TrainerModel(String name, int[] zeiten, int prio, int minAnzTraining) {
		this.name = name;
		this.zeiten = zeiten;
		this.prio = prio;
		this.id = zaehler;
		this.minAnzTraining = minAnzTraining;
		zaehler++;
		alleTrainer.add(this);
	}
	
	

	public static ArrayList<TrainerModel> getAlleTrainer() {
		return alleTrainer;
	}

	public static void deleteAlleTrainer() {
		while(alleTrainer.size() > 0) {
			alleTrainer.remove(0);
		}
	}

	public static void resetZaehler() {
		zaehler = 0;
	}

	public void setMinAnzTraining(int minAnzTraining) {
		this.minAnzTraining = minAnzTraining;
	}



	public void setZeiten(int[] zeiten) {
		this.zeiten = zeiten;
	}



	public int[] getZeiten() {
		return zeiten;
	}

	public int getMinAnzTraining() {
		return minAnzTraining;
	}



	public String getName() {
		return name;
	}

	public int getPrio() {
		return prio;
	}

	public int getId() {
		return id;
	}

	public static int getZaehler() {
		return zaehler;
	}

	public static void setZaehler(int zaehler) {
		TrainerModel.zaehler = zaehler;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrio(int prio) {
		this.prio = prio;
	}

	public static void setAlleTrainer(ArrayList<TrainerModel> alleTrainer) {
		TrainerModel.alleTrainer = alleTrainer;
	}

	public ArrayList<ArrayList<PauseModel>> getPauseProTag() {
		return pauseProTag;
	}

	public void setPauseProTag(ArrayList<ArrayList<PauseModel>> pauseProTag) {
		this.pauseProTag = pauseProTag;
	}


	@Override
	public String toString() {
		return "TrainerModel{" +
				"id=" + id +
				", name='" + name + '\'' +
				", zeiten=" + Arrays.toString(zeiten) +
				", prio=" + prio +
				", minTrainingProTag=" + minTrainingProTag +
				", minAnzTraining=" + minAnzTraining +
				", aktAnzTraining=" + aktAnzTraining +
				", pauseProTag=" + pauseProTag +
				'}';
	}
}
