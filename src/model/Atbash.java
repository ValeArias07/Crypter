package model;

public class Atbash extends Monoalphabetic {
	
	public Atbash() {
	}

	@Override
	public String encrypt(String txt) {
		
		String crypter = "";
		int index=0;
		for (int i = 0; i < txt.length(); i++) {
			index=searchLetter(0, txt.charAt(i));
			if(index!=-1) {
				if(index>=27) {
					crypter+=ABC.charAt((ABC.length()-index)+(ABC.length()-1)/2);
				}else {
					crypter+=ABC.charAt(((ABC.length()/2)-1)-index);
				}
			}else {
				crypter+=txt.charAt(i);
			}
		}return crypter;
	}
	
	@Override
	public String decrypt(String txt) {
		return null;
	}
	
	public int searchLetter(int index, char letter){
		
		if(index<=ABC.length()-1) {
			if(ABC.charAt(index)==letter) {
				return index;
			}else {
				return searchLetter(index+1, letter);
			}
		}
		return -1;
	}

}


