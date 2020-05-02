package model;

public abstract class Polyalphabetic extends Crypter   {
	protected String encriptionKey;
	protected final String ABC = "abcdefghijklmnopqrstuvwxyz";
	
	public Polyalphabetic(String encriptionKey) {
		this.encriptionKey = encriptionKey;
	}

	public String getEncriptionKey() {
		return encriptionKey;
	}

}
