package model;

import java.lang.reflect.Array;

public class Vigenere extends Polyalphabetic{
	
	private char[][] vigenereMatrix;
	public static final char[] abcMinus = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};
	public Vigenere(String encriptionKey) {
		super(encriptionKey);
		char[][] vigenereMatrix= new char[28][28];
		filled();
	}
	
	public void filled() {
	////HEAD COLUMN & ROW
		int l=0, move=0, j=0;
			vigenereMatrix[0][0]='#';
			for (int i = 1; i < vigenereMatrix.length; i++) {
				vigenereMatrix[i][0]=abcMinus[l];
				vigenereMatrix[0][i]=abcMinus[l];
				l=(l<26)?l+1:0;
			}
			
			for (int i = 1; i < vigenereMatrix.length; i++) {
				for (int fi = 1; fi < vigenereMatrix.length-1; fi++) {
				vigenereMatrix[fi][j]=abcMinus[move];
				move=(move<25)?move+1:0;
				}
			j=(j<abcMinus.length-1)?j+1:0; 	
			}
	}
	
	public String print() {
		String matrix="";
		for (int i = 0; i < vigenereMatrix.length; i++) {
			for (int j = 0; j < vigenereMatrix[0].length; j++) {
				matrix=vigenereMatrix[i][j]+"";
			}
		}
		return matrix;
	}
	
}
