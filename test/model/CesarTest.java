package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CesarTest {

	private Cesar cesar;

	private void setup1() {
		cesar = new Cesar(1, "R");
	}

	private void setup2() {
		cesar = new Cesar(1, "L");
	}

	private void setup3() {
		cesar = new Cesar(54, "R");
	}

	private void setup4() {
		cesar = new Cesar(54, "L");
	}

	private void setup5() {
		cesar = new Cesar(100, "R");
	}

	private void setup6() {
		cesar = new Cesar(100, "L");
	}

	@Test
	void encryptTest() {
		setup1();

		String txt = cesar.encrypt("a");
		assertEquals("b", txt);

		txt = cesar.encrypt("z");
		assertEquals("A", txt);

		txt = cesar.encrypt("Z");
		assertEquals("a", txt);

		txt = cesar.encrypt("hola como estas");
		assertEquals("ipmb dpnp ftubt", txt);

		txt = cesar.encrypt("Hola, ¿como estas?");
		assertEquals("Ipmb, ¿dpnp ftubt?", txt);

		setup2();

		txt = cesar.encrypt("a");
		assertEquals("Z", txt);

		txt = cesar.encrypt("z");
		assertEquals("y", txt);

		txt = cesar.encrypt("Z");
		assertEquals("Y", txt);

		txt = cesar.encrypt("hola como estas");
		assertEquals("gñkZ bñlñ drsZr", txt);

		txt = cesar.encrypt("Hola, ¿como estas?");
		assertEquals("GñkZ, ¿bñlñ drsZr?", txt);

		setup3();

		txt = cesar.encrypt("a");
		assertEquals("a", txt);

		txt = cesar.encrypt("z");
		assertEquals("z", txt);

		txt = cesar.encrypt("Z");
		assertEquals("Z", txt);

		txt = cesar.encrypt("hola como estas");
		assertEquals("hola como estas", txt);

		txt = cesar.encrypt("Hola, ¿como estas?");
		assertEquals("Hola, ¿como estas?", txt);

		setup4();

		txt = cesar.encrypt("a");
		assertEquals("a", txt);

		txt = cesar.encrypt("z");
		assertEquals("z", txt);

		txt = cesar.encrypt("Z");
		assertEquals("Z", txt);

		txt = cesar.encrypt("hola como estas");
		assertEquals("hola como estas", txt);

		txt = cesar.encrypt("Hola, ¿como estas?");
		assertEquals("Hola, ¿como estas?", txt);

		setup5();

		txt = cesar.encrypt("a");
		assertEquals("S", txt);

		txt = cesar.encrypt("z");
		assertEquals("r", txt);

		txt = cesar.encrypt("Z");
		assertEquals("R", txt);

		txt = cesar.encrypt("hola como estas");
		assertEquals("ZhdS Uheh WlmSl", txt);

		txt = cesar.encrypt("Hola, ¿como estas?");
		assertEquals("zhdS, ¿Uheh WlmSl?", txt);

		setup6();

		txt = cesar.encrypt("a");
		assertEquals("i", txt);

		txt = cesar.encrypt("z");
		assertEquals("H", txt);

		txt = cesar.encrypt("Z");
		assertEquals("h", txt);

		txt = cesar.encrypt("hola como estas");
		assertEquals("owsi kwtw mABiA", txt);

		txt = cesar.encrypt("Hola, ¿como estas?");
		assertEquals("Owsi, ¿kwtw mABiA?", txt);
	}

	@Test
	void decryptTest() {
		
		setup1();

		String txt = cesar.decrypt("b");
		assertEquals("a", txt);
		
		txt = cesar.decrypt("A");
		assertEquals("z", txt);

		txt = cesar.decrypt("a");
		assertEquals("Z", txt);

		txt = cesar.decrypt("ipmb dpnp ftubt");
		assertEquals("hola como estas", txt);

		txt = cesar.decrypt("Ipmb, ¿dpnp ftubt?");
		assertEquals("Hola, ¿como estas?", txt);
		
		setup2();

		txt = cesar.decrypt("Z");
		assertEquals("a", txt);

		txt = cesar.decrypt("y");
		assertEquals("z", txt);

		txt = cesar.decrypt("Y");
		assertEquals("Z", txt);

		txt = cesar.decrypt("gñkZ bñlñ drsZr");
		assertEquals("hola como estas", txt);

		txt = cesar.decrypt("GñkZ, ¿bñlñ drsZr?");
		assertEquals("Hola, ¿como estas?", txt);

		setup3();

		txt = cesar.decrypt("a");
		assertEquals("a", txt);

		txt = cesar.decrypt("z");
		assertEquals("z", txt);

		txt = cesar.decrypt("Z");
		assertEquals("Z", txt);

		txt = cesar.decrypt("hola como estas");
		assertEquals("hola como estas", txt);

		txt = cesar.decrypt("Hola, ¿como estas?");
		assertEquals("Hola, ¿como estas?", txt);

		setup4();

		txt = cesar.decrypt("a");
		assertEquals("a", txt);

		txt = cesar.decrypt("z");
		assertEquals("z", txt);

		txt = cesar.decrypt("Z");
		assertEquals("Z", txt);

		txt = cesar.decrypt("hola como estas");
		assertEquals("hola como estas", txt);

		txt = cesar.decrypt("Hola, ¿como estas?");
		assertEquals("Hola, ¿como estas?", txt);

		setup5();

		txt = cesar.decrypt("S");
		assertEquals("a", txt);

		txt = cesar.decrypt("r");
		assertEquals("z", txt);

		txt = cesar.decrypt("R");
		assertEquals("Z", txt);

		txt = cesar.decrypt("ZhdS Uheh WlmSl");
		assertEquals("hola como estas", txt);

		txt = cesar.decrypt("zhdS, ¿Uheh WlmSl?");
		assertEquals("Hola, ¿como estas?", txt);

		setup6();

		txt = cesar.decrypt("i");
		assertEquals("a", txt);

		txt = cesar.decrypt("H");
		assertEquals("z", txt);

		txt = cesar.decrypt("h");
		assertEquals("Z", txt);

		txt = cesar.decrypt("owsi kwtw mABiA");
		assertEquals("hola como estas", txt);

		txt = cesar.decrypt("Owsi, ¿kwtw mABiA?");
		assertEquals("Hola, ¿como estas?", txt);


	}

}
