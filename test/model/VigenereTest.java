package model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class VigenereTest {

	private Vigenere vigenere;
	
	private void setUp1() {
		String key="louis";
		vigenere= new Vigenere(key);
	}
	
	private void setUp2() {
		String key="fishclown";
		vigenere= new Vigenere(key);
	}
	
	private void setUp3() {
		String key="redhair";
		vigenere= new Vigenere(key);
	}
	
	private void setUp4() {
		String key="reggaeton";
		vigenere= new Vigenere(key);
	}
	
	private void setUp5() {
		String key="reggaeton";
		vigenere= new Vigenere(key);
	}
	private void setUp6() {
		String key="redhair";
		vigenere= new Vigenere(key);
	}
	
	private void setUp7() {
		String key="fishclown";
		vigenere= new Vigenere(key);
	}
	
	@Test
	void encrypt() {
		setUp1();
		String message="niño";
		assertEquals("ywxi",vigenere.encrypt(message));
		
		setUp2();
		message="valentina";
		assertEquals("aidlpewjn",vigenere.encrypt(message));
		
		setUp3();
		message="jose luis";
		assertEquals("rphqavuis",vigenere.encrypt(message));
		
		setUp4();
		message="alejandro";
		assertEquals("asyk lybg",vigenere.encrypt(message));
	}
	
	@Test
	void decrypt() {
		setUp5();
		String message="asyk lybg";
		assertEquals("jose luis",vigenere.decrypt(message));

		setUp6();
		message="rphqavuis";
		assertEquals("alejandro", vigenere.decrypt(message));
		
		setUp7();
		message="aidlpewjn";
		assertEquals("valentina", vigenere.decrypt(message));
	}
	
	@Test 
	void recursiveSearchFileEncriptedLetterTest(){
		setUp1();
		assertEquals(5,vigenere.recursiveSearchFileEncriptedLetter(10,1,'n'));
		int index=vigenere.recursiveSearchFileEncriptedLetter(10,1,'n');
		assertEquals('n',vigenere.getVigenereMatrix(10,index));
		
		assertEquals(3,vigenere.recursiveSearchFileEncriptedLetter(23,1,'y'));
		index=vigenere.recursiveSearchFileEncriptedLetter(23,1,'y');
		assertEquals('c',vigenere.getVigenereMatrix(0,index));
		
		assertEquals(5,vigenere.recursiveSearchFileEncriptedLetter(23,1,'a'));
		index=vigenere.recursiveSearchFileEncriptedLetter(23,0,'a');
		assertEquals('e',vigenere.getVigenereMatrix(0,index));
	}
	
	@Test
	void recursiveSearchPlaneLetterTest() {
		setUp1();
		int index=1;
		assertEquals(index,vigenere.recursiveSearchPlaneLetter(0, 'a'));
		index=13;
		assertEquals(index,vigenere.recursiveSearchPlaneLetter(0, 'm'));
		index=12;
		assertEquals(index, vigenere.recursiveSearchPlaneLetter(0, 'l'));
		index=26;
		assertEquals(index, vigenere.recursiveSearchPlaneLetter(0, 'z'));
		
	}
	
	@Test
	void recursiveSearchKeyLetter() {
		setUp1();
		int index=7;
		assertEquals(index,vigenere.recursiveSearchKeyLetter(0, 'g'));
		index=10;
		assertEquals(index,vigenere.recursiveSearchKeyLetter(0, 'j'));
		index=16;
		assertEquals(index, vigenere.recursiveSearchKeyLetter(0, 'p'));
		index=26;
		assertEquals(index, vigenere.recursiveSearchKeyLetter(0, 'z'));
	}
	
	@Test
	void getVigenereMatrix() {
		setUp1();
		assertEquals('a', vigenere.getVigenereMatrix(1,1));
		assertEquals('l', vigenere.getVigenereMatrix(7,6));
		assertEquals('e', vigenere.getVigenereMatrix(15,17));
	}
	
	@Test
	 void filledTest() {
		setUp1();
		assertEquals('g',vigenere.getVigenereMatrix(4, 4));
		assertEquals('j',vigenere.getVigenereMatrix(7, 4));
		assertEquals('k',vigenere.getVigenereMatrix(6, 6));
	}
}
