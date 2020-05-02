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
	
	@Test
	void encrypt() {
		setUp1();
		String message="niño-";
		assertEquals("ywxi-",vigenere.encrypt(message));
		
		setUp2();
		message="valentina";
		assertEquals("aidlpewjn",vigenere.encrypt(message));
		
		setUp3();
		message="alejandro";
		assertEquals("rphqavuis",vigenere.encrypt(message));
	
		setUp4();
		message="jose luis";
		assertEquals("asyk lybg",vigenere.encrypt(message));

	}
	
	@Test
	void decrypt() {
		setUp4();
		String message="asyk lybg";
		assertEquals("jose luis",vigenere.decrypt(message));

		setUp3();
		message="rphqavuis";
		assertEquals("alejandro", vigenere.decrypt(message));
		
		setUp2();
		message="aidlpewjn";
		assertEquals("valentina", vigenere.decrypt(message));
	}
	
	@Test 
	void recursiveSearchFileEncriptedLetterTest(){
		setUp1();
		assertEquals(5,vigenere.recursiveSearchFileEncriptedLetter(10,1,'n'));
		assertEquals(3,vigenere.recursiveSearchFileEncriptedLetter(23,1,'y'));
		assertEquals(5,vigenere.recursiveSearchFileEncriptedLetter(23,1,'a'));
		assertEquals(26, vigenere.recursiveSearchFileEncriptedLetter(26, 1, 'y'));
		assertEquals(13, vigenere.recursiveSearchFileEncriptedLetter(11, 1, 'w'));
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
