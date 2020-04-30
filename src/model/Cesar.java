package model;

public class Cesar {
	
	public final String ABC = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";	
	
	private int track; //cantidad de letras a mover
	private String direction; //right(R), left(L)

	public Cesar(int track, String direction) {
		this.track=track;
		this.direction=direction;
	}
	
	public String encrypt(String txt) {
		
		String crypter; 
		
		if(direction.equals("R")) {
			
			crypter = rigthMove(txt);
		
		}else {
			
			crypter = leftMove(txt);
			
		}return crypter;
		
	}
	
	private String leftMove(String txt) {
		
		String crypter = "";
		
		for(int i = 0; i<txt.length(); i++) {
			int ward = ABC.indexOf(txt.charAt(i));

				if(ward>=0) {
					if((ward-track)>=0) {
						crypter = crypter + ABC.charAt(ward-track);
					}else {
						ward = (ward-track)+(ABC.length()-1);
						crypter = crypter + ABC.charAt(ward);					}
						
				}else {
					crypter = crypter + txt.charAt(i);
				}
			
			}return crypter;
	}

	public String rigthMove(String txt) {
		
		String crypter = "";
		
		for(int i = 0; i<txt.length(); i++) {
			int ward = ABC.indexOf(txt.charAt(i));

				if(ward>=0) {
					if((ward+track)<ABC.length()) {
						crypter = crypter + ABC.charAt(ward+track);
					}else {
						ward = (ward+track)-(ABC.length()-1);
						crypter = crypter + ABC.charAt(ward);					}
						
				}else {
					crypter = crypter + txt.charAt(i);
				}
			
			}return crypter;
	}

}
