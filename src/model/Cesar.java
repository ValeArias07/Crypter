package model;

public class Cesar extends Monoalphabetic {

	private String direction; // right(R), left(L)
	private int track;

	public Cesar(int track, String direction) {
		this.track = track;
		this.direction = direction;
	}

	@Override
	public String encrypt(String txt) {
		

		String crypter = null;

		if (direction.equals("R")) {

			crypter = rigthMove(txt);

		} else {
			if (direction.equals("L")) {

				crypter = leftMove(txt);
			}
		}

		return crypter;
	}

	@Override
	public String decrypt(String txt) {

		if (direction.equals("R")) {

			return leftMove(txt);

		} else {
			if (direction.equals("L")) {

				return rigthMove(txt);
			}
		}

		return null;
	}

	private String leftMove(String txt) {

		String crypter = "";

		for (int i = 0; i < txt.length(); i++) {
			int ward = ABC.indexOf(txt.charAt(i));

			if (ward >= 0) {
				if ((ward - track) >= 0) {
					crypter = crypter + ABC.charAt(ward - track);
				} else {
					ward = (ward - track) + ABC.length();
					while(ward<0) {
						ward = ward + ABC.length();
					}
					crypter = crypter + ABC.charAt(ward);
				}

			} else {
				crypter = crypter + txt.charAt(i);
			}

		}
		return crypter;
	}

	private String rigthMove(String txt) {

		String crypter = "";

		for (int i = 0; i < txt.length(); i++) {
			int ward = ABC.indexOf(txt.charAt(i));

			if (ward >= 0) {
				if ((ward + track) < ABC.length()) {
					crypter = crypter + ABC.charAt(ward + track);
				} else {
					ward = (ward + track) - ABC.length();
					while(ward>ABC.length()) {
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
}
