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
	
	private void setUp2() {
		String key="fishclown";
		String message="valentina";
		vigenere= new Vigenere(key, message);
	}
	
	private void setUp3() {
		String key="redhair";
		String message="alejandro";
		vigenere= new Vigenere(key, message);
	}
	
	private void setUp4() {
		String key="reggaeton";
		String message="jose luis";
		vigenere= new Vigenere(key, message);
	}
	
	private void setUp5() {
		String key="reggaeton";
		String message="asyk lybg";
		vigenere= new Vigenere(key, message);
	}
	private void setUp6() {
		String key="redhair";
		String message="rphqavuis";
		vigenere= new Vigenere(key, message);
	}
	
	private void setUp7() {
		String key="fishclown";
		String message="aidlpewjn";
		vigenere= new Vigenere(key, message);
	}
	@Test
	 void filledTest() {
		setUp1();
		int column=13;
		int file=12;
		assertEquals('x',vigenere.getVigenereMatrix(column, file));
		column=12;
		assertEquals('w',vigenere.getVigenereMatrix(column, file));
	}
	
	@Test
	void encrypt() {
		setUp1();
		assertEquals("scfi",vigenere.encript());
		
		setUp2();
		assertEquals("aidlpewjn",vigenere.encript());
		
		setUp3();
		assertEquals("rphqavuis",vigenere.encript());
		
		setUp4();
		assertEquals("asyk lybg",vigenere.encript());
	}
	
	@Test
	void decrypt() {
		setUp5();
		assertEquals("jose luis",vigenere.decrypt());
		
		vigenere.show();
		setUp6();
		assertEquals("alejandro", vigenere.decrypt());
		
		setUp7();
		assertEquals("valentina", vigenere.decrypt());
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
		
		assertEquals(3,vigenere.recursiveSearchFileEncriptedLetter(23,1,'y'));
		index=vigenere.recursiveSearchFileEncriptedLetter(23,0,'y');
		assertEquals('c',vigenere.getVigenereMatrix(0,index));
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
}
