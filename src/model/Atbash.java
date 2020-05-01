package model;

public class Atbash extends Monoalphabetic {
	
	public Atbash() {
		//Contructor
	}

	@Override
	public String encrypt(String txt) {
		
		String crypter = "";
		
		for (int i = 0; i < txt.length(); i++) {
			for (int j = 0; j<ABC.length(); j++) {
				
				int ward = ABC.indexOf(txt.charAt(j));
				
				if(txt.charAt(i) == ward) {
					
					crypter = crypter + (ABC.length()-(1-j));
				}
			}
		}return crypter;
		
	}

	@Override
	public String decrypt(String txt) {
		return null;
	}
}
