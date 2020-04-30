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

		String crypter;

		if (direction.equals("R")) {

			crypter = rigthMove(txt);

		} else {

			crypter = leftMove(txt);

		}

		return crypter;
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
					crypter = crypter + ABC.charAt(ward);
					System.out.println(ABC.charAt(26));
				}

			} else {
				crypter = crypter + txt.charAt(i);
			}

		}
		return crypter + "<" + calculateExtends();
	}

	private String leftMove(String txt, int trackParameter) {
		String crypter = "";

		for (int i = 0; i < txt.length(); i++) {
			int ward = ABC.indexOf(txt.charAt(i));

			if (ward >= 0) {
				if ((ward - trackParameter) >= 0) {
					crypter = crypter + ABC.charAt(ward - trackParameter);
				} else {
					ward = (ward - trackParameter) + ABC.length();
					crypter = crypter + ABC.charAt(ward);
				}

			} else {
				crypter = crypter + txt.charAt(i);
			}

		}
		return crypter + "<" + calculateExtends();
	}

	public String rigthMove(String txt) {

		String crypter = "";

		for (int i = 0; i < txt.length(); i++) {
			int ward = ABC.indexOf(txt.charAt(i));

			if (ward >= 0) {
				if ((ward + track) < ABC.length()) {
					crypter = crypter + ABC.charAt(ward + track);
				} else {
					ward = (ward + track) - ABC.length();
					crypter = crypter + ABC.charAt(ward);
				}

			} else {
				crypter = crypter + txt.charAt(i);
			}

		}
		return crypter + ">" + calculateExtends();
	}

	private String rigthMove(String txt, int trackParameter) {
		String crypter = "";

		for (int i = 0; i < txt.length(); i++) {
			int ward = ABC.indexOf(txt.charAt(i));

			if (ward >= 0) {
				if ((ward + trackParameter) < ABC.length()) {
					crypter = crypter + ABC.charAt(ward + trackParameter);
				} else {
					ward = (ward + trackParameter) - ABC.length();
					crypter = crypter + ABC.charAt(ward);
				}

			} else {
				crypter = crypter + txt.charAt(i);
			}

		}
		return crypter + ">" + calculateExtends();
	}

	private String calculateExtends() {
		if (track < ABC.length()) {
			return "" + ABC.charAt(track);
		} else {
			String ex = "";
			while (track >= ABC.length()) {
				ex += ABC.charAt(ABC.length() - 1);
				track -= ABC.length() - 1;
			}

			ex += ABC.charAt(track);

			return ex;
		}
	}

	@Override
	public String decrypt(String txt) {

		int directionParameter = searchNumber(txt);
		int trackParameter = 0;
		if (txt.charAt(directionParameter) == '<') {
			for (int i = directionParameter + 1; i < txt.length(); i++) {
				trackParameter += Integer.parseInt("" + txt.charAt(i));
			}
			return leftMove(txt, trackParameter);

		} else {
			if (txt.charAt(directionParameter) == '>') {
				for (int i = directionParameter + 1; i < txt.length(); i++) {
					trackParameter += Integer.parseInt("" + txt.charAt(i));
				}
				return rigthMove(txt, trackParameter);
			}
		}

		return null;
	}

	private int searchNumber(String txt) {
		for (int i = 0; i < txt.length(); i++) {
			if (txt.charAt(i) == '<' || txt.charAt(i) == '>') {
				return i;
			}
		}

		return -1;
	}
}
