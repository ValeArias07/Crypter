package model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class VigenereTest {

	private Vigenere vigenere;
	
	private void setUp1() {
		String key="louis";
		String message="hola";
		vigenere= new Vigenere(key, message);
	}
	
	@Test
	 void filledTest() {
		setUp1();
		int column=13;
		int file=13;
		assertEquals('y',vigenere.getVigenereMatrix(column, file));
		vigenere.show();
		column=12;
		file=12;
		assertEquals('w',vigenere.getVigenereMatrix(column, file));
	}
	
	@Test
	void encrypt() {
		setUp1();
		assertEquals("scfl",vigenere.encript());
		
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
		int index=1;
		assertEquals(index,vigenere.recursiveSearchKeyLetter(0, 'a'));
		index=13;
		assertEquals(index,vigenere.recursiveSearchKeyLetter(0, 'm'));
		index=12;
		assertEquals(index, vigenere.recursiveSearchKeyLetter(0, 'l'));
		index=26;
		assertEquals(index, vigenere.recursiveSearchKeyLetter(0, 'z'));
		
	}
	
}
