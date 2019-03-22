package de.dhbw.WebbasierteDatenbankanwendungenBackend.calculator.algorithm.algo;

public class Hash {

	int hash = 0;

	public Hash(int wert) {
		super();
		this.hash = wert;
	}

	public int getHash() {
		return hash;
	}
	
	public int addHash(int i) {
		hash += i;
		return hash;
	}
	
	public int subHash(Hash var) {
		hash -= var.getHash();
		return hash;
	}
	
	public int mulHash(Hash var) {
		hash *= var.getHash();
		return hash;
	}
	
	public int divHash(Hash var) {
		hash /= var.getHash();
		return hash;
	}
	
}
