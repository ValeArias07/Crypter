package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AESTest {
	
	private AES aes;
	
	private void setup1() {
		aes = new AES("algoritmos");
	}
	
	@Test
	void encryptTest() {
		
		setup1();
		
		String aux;
		aux = aes.encrypt("holaaa");
		assertEquals("elixxx", aux);
		
		aux = aes.encrypt("Algoritmos y programacion dos");
		assertEquals("xidlofqjlp v moldoxjxzflk alp", aux);
	}
	
	@Test
	void decryptTest() {
		setup1();
		
		String aux;
		aux = aes.decrypt("elixxx");
		assertEquals("holaaa", aux);
		
		aux = aes.decrypt("xidlofqjlp v moldoxjxzflk alp");
		assertEquals("algoritmos y programacion dos", aux);
	}
}
