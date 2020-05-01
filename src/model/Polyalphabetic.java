package model;

public abstract class Polyalphabetic extends Crypter   {
	private String encriptionKey;
	protected final String ABC = "abcdefghijklmnopqrstuvwxyz";
	
	public Polyalphabetic(String encriptionKey) {
		this.encriptionKey = encriptionKey;
	}

	public String getEncriptionKey() {
		return encriptionKey;
	}

}
