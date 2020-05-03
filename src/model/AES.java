package model;

public class AES extends Polyalphabetic{
	
	public final String [][] SBOX = {};
	public final int [][] CONSTANTMATRIZ = {{02,03,01,01},{01,02,03,01},{01,01,02,03},{03,01,01,02}};
	
	private String txt;

	public AES(String encriptionKey, String txt) {
		super(encriptionKey);
		this.txt = txt;
	}

	@Override
	public String encrypt(String txt) {
		
		return null;
	}

	@Override
	public String decrypt(String txt) {
		
		return null;
	}
	
	public String [][] subBytes(String [][] state){
		return state;
	}
	
	public String [][] shiftRows(String [][] state){
		return state;
	}
	
	public String [][] mixColums(String [][] state){
		return state;
	}
	
	public String addRoundKey(String [][] state){
		return null;
	}

}
