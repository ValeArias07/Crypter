package model;

import java.lang.reflect.Array;

public class Vigenere extends Polyalphabetic{
	private String planeText;
	private char[][] vigenereMatrix;
	public static final char[] abcMinus = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	public Vigenere(String encriptionKey, String planeText) {
		super(encriptionKey);
		this.planeText=planeText;
		vigenereMatrix= new char[27][27];
		filled();
	}
	
	public String encript() {
	char[] planeWord=planeText.toCharArray();	
	String encriptedWord="";
	int k=0;
	/**
	//////Filled of KeyText
	for (int j = 0; j < super.getEncriptionKey().length(); j++) {
		//keyText[j]=super.getEncriptionKey().charAt(k);
		k=(k==super.getEncriptionKey().length())?0:k+1;
	} 
	*/
	/////
	for (int i = 0; i < planeWord.length; i++) {
		char currentCharColumn=planeWord[i];
		char currentCharFile=super.getEncriptionKey().charAt(k);
		k=(k==super.getEncriptionKey().length())?0:k+1;
		int indexColumn=recursiveSearchPlaneLetter(0,currentCharColumn);
		int indexFile=recursiveSearchKeyLetter(0,currentCharFile);
		encriptedWord+=vigenereMatrix[indexFile][indexColumn];
	}
	return encriptedWord;
	}
	
	public void filled() {
	///////HEAD COLUMN AND ROW
			int l=0;
			vigenereMatrix[0][0]='#';
			for (int i = 1; i < vigenereMatrix.length; i++) {
				vigenereMatrix[i][0]=abcMinus[l];
				vigenereMatrix[0][i]=abcMinus[l];
				l=(l<26)?l+1:0;
			}
			
			//////MIDDLE TRIANGLE
			int plus=-1;
			for (int cont = 1; cont < vigenereMatrix.length; cont++) {
			for (int i = 1; i < vigenereMatrix.length && plus+i<26 ; i++) {
				vigenereMatrix[i][cont]=abcMinus[i+plus];
				}
			plus++;
			}
			
			////OTHER MIDDLE TRIANGLE
			plus=0;
			for (int i = vigenereMatrix.length-1; i>0; i--) {
			l=0;
			for (int k = 2+plus; k < vigenereMatrix.length && l<26; k++) {
				vigenereMatrix[i][k]=abcMinus[l];
				l++;
			}
			plus++;
			}
	}
	
	public int recursiveSearchPlaneLetter(int currentColumn, char currentChar) {
		if(currentColumn<=26) {
			if(vigenereMatrix[0][currentColumn]==currentChar) {
				return currentColumn;
			}else {
				return recursiveSearchPlaneLetter(currentColumn+1 , currentChar);
			}
		}
		return -1;
	}
	
	public int recursiveSearchKeyLetter(int currentRow, char currentChar) {
		if(currentRow<=26) {
			if(vigenereMatrix[currentRow][0]==currentChar) {
				return currentRow;
			}else {
				return recursiveSearchKeyLetter(currentRow+1 , currentChar);
			}
		}
		return -1;
		
	}
	
	public char getVigenereMatrix(int column, int file) {
		return vigenereMatrix[file][column];
	}
	
	public void show() {
		for(int i = 0; i<vigenereMatrix.length; i++) {
            for(int j = 0; j<vigenereMatrix.length; j++) {
                System.out.print(vigenereMatrix[i][j] + " ");
            }
            System.out.println("");
        }
	}
	
}
