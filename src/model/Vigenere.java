package model;

public class Vigenere extends Polyalphabetic{	

	private char[][] vigenereMatrix;

	public Vigenere(String encriptionKey) {
		super(encriptionKey);
		vigenereMatrix= new char[27][27];
		filled();
	}
	
	@Override
	public String encrypt(String txt) {
	char[] planeWord=txt.toCharArray();	
	String encriptedWord="";
	int k=0;
	for (int i = 0; i < planeWord.length; i++) {
		char currentCharColumn=planeWord[i];
		if(currentCharColumn!=' ' && currentCharColumn!='ñ') {
			char currentCharFile=super.getEncriptionKey().charAt(k);
			k=(k==super.getEncriptionKey().length()-1)?0:k+1;
			
			int indexColumn=recursiveSearchPlaneLetter(0,currentCharColumn);
			int indexFile=recursiveSearchKeyLetter(0,currentCharFile);
		
			if(indexColumn==-1 || indexFile==-1) {
				encriptedWord+=currentCharColumn;
			}else {
				encriptedWord+=vigenereMatrix[indexFile][indexColumn];
			}
			
		}else if(currentCharColumn=='ñ') {
			encriptedWord+="x";
		}else{
			encriptedWord+=" ";
		}
	}
	return encriptedWord;
	}
	
	@Override
	public String decrypt(String planeText) {
		int k=0;
		String decriptedWord="";

		char[] planeWord=planeText.toCharArray();
		for (int i = 0; i < planeWord.length; i++) {
			char currentCharEncripted=planeWord[i];
			if(currentCharEncripted!=' '&& currentCharEncripted!='ñ') {
				
			char currentCharRow=super.getEncriptionKey().charAt(k);
			k=(k==super.getEncriptionKey().length()-1)?0:k+1;
			int indexRow=recursiveSearchKeyLetter(1,currentCharRow);
			int indexColumn=recursiveSearchFileEncriptedLetter(indexRow,1,currentCharEncripted);
			decriptedWord+=vigenereMatrix[0][indexColumn];
			
			}else if(currentCharEncripted==' '){
				decriptedWord+=" ";
			}else {
				decriptedWord+="x";
			}
		}
		return decriptedWord;
	}
	public void filled() {
			///////HEAD COLUMN AND ROW
			int l=0;
			vigenereMatrix[0][0]=' ';
			for (int i = 1; i < vigenereMatrix.length; i++) {
				vigenereMatrix[i][0]=ABC.charAt(l);
				vigenereMatrix[0][i]=ABC.charAt(l);
				l=(l<26)?l+1:0;
			}
			
			//////MIDDLE TRIANGLE
			int plus=-1;
			for (int cont = 1; cont < vigenereMatrix.length; cont++) {
			for (int i = 1; i < vigenereMatrix.length && plus+i<26 ; i++) {
				vigenereMatrix[i][cont]=ABC.charAt(i+plus);
				}
			plus++;
			}
			
			////OTHER MIDDLE TRIANGLE
			plus=0;
			for (int i = vigenereMatrix.length-1; i>0; i--) {
			l=0;
			for (int k = 2+plus; k < vigenereMatrix.length && l<26; k++) {
				vigenereMatrix[i][k]=ABC.charAt(l);
				l++;
			}
			plus++;
			}
	}
	
	public int recursiveSearchFileEncriptedLetter(int fileKey, int currentColumn, char currentChar) {
		if(currentColumn<=26) {
			if(vigenereMatrix[fileKey][currentColumn]==currentChar) {
				return currentColumn;
			}else {
				return recursiveSearchFileEncriptedLetter(fileKey, currentColumn+1,currentChar);
			}
		}
		return -1;
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
