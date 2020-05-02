package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AtbashTest {

	private Atbash atbash;

	private void setup1() {
		atbash = new Atbash();
	}

	@Test
	void encryptTest() {
		setup1();
		
		String txt = atbash.encrypt("a");
		assertEquals("z", txt);
		
		txt = atbash.encrypt("n");
		assertEquals("n", txt);
		
		txt = atbash.encrypt("A");
		assertEquals("Z", txt);
		
		txt = atbash.encrypt("algoritmos");
		assertEquals("zotlirgñlh", txt);
		
		txt = atbash.encrypt("¡Programacion!");
		assertEquals("¡Kiltizñzxrln!", txt);
	}
	
	@Test
	void decryptTest() {
		setup1();
		
		String txt = atbash.encrypt("z");
		assertEquals("a", txt);
		
		txt = atbash.encrypt("n");
		assertEquals("n", txt);
		
		txt = atbash.encrypt("Z");
		assertEquals("A", txt);
		
		txt = atbash.encrypt("zotlirgñlh");
		assertEquals("algoritmos", txt);
		
		txt = atbash.encrypt("¡Kiltizñzxrln!");
		assertEquals("¡Programacion!", txt);
	}
}