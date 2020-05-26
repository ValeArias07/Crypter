package model;

public class AES extends Polyalphabetic{
	
	public final String [][] SBOX = {};
	public final int [] NUMBERCONSTANT = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103};

	public AES(String encriptionKey) {
		super(encriptionKey);
		
		super.encriptionKey = encriptionKey.toLowerCase();
	}

	@Override
	public String encrypt(String txt) {
		txt = txt.toLowerCase();
		
		int numbers[] = new int[encriptionKey.length()];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = NUMBERCONSTANT[ABC.indexOf(encriptionKey.charAt(i))];
		}
		
		for(int i = 0; i< numbers.length; i++) {
			txt = changeTextR(numbers[i], txt);
		}
		
		return txt;
	}

	private String changeTextR(int n, String txt) {
		String crypter = "";

		for (int i = 0; i < txt.length(); i++) {
			int ward = ABC.indexOf(txt.charAt(i));

			if (ward >= 0) {
				if ((ward + n) < ABC.length()) {
					crypter = crypter + ABC.charAt(ward + n);
				} else {
					ward = (ward + n) - ABC.length();
					while (ward >= ABC.length()) {
						ward = ward - ABC.length();
					}
					crypter = crypter + ABC.charAt(ward);
				}

			} else {
				crypter = crypter + txt.charAt(i);
			}

		}
		
		return crypter;
	}
	
	@Override
	public String decrypt(String txt) {
		
		txt = txt.toLowerCase();
		
		int numbers[] = new int[encriptionKey.length()];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = NUMBERCONSTANT[ABC.indexOf(encriptionKey.charAt(i))];
		}
		
		for(int i = 0; i< numbers.length; i++) {
			txt = changeTextL(numbers[i], txt);
		}
		
		return txt;
	}
	
	private String changeTextL(int n, String txt) {
		String crypter = "";

		for (int i = 0; i < txt.length(); i++) {
			int ward = ABC.indexOf(txt.charAt(i));

			if (ward >= 0) {
				if ((ward - n) >= 0) {
					crypter = crypter + ABC.charAt(ward - n);
				} else {
					ward = (ward - n) + ABC.length();
					while (ward < 0) {
						ward = ward + (ABC.length());
					}
					crypter = crypter + ABC.charAt(ward);
				}

			} else {
				crypter = crypter + txt.charAt(i);
			}

		}
		return crypter;
	}
}
