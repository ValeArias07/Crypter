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
		assertEquals("b>b", txt);

		txt = cesar.encrypt("z");
		assertEquals("A>b", txt);

		txt = cesar.encrypt("Z");
		assertEquals("a>b", txt);

		txt = cesar.encrypt("hola como estas");
		assertEquals("ipmb dpnp ftubt>b", txt);

		txt = cesar.encrypt("Hola, ¿como estas?");
		assertEquals("Ipmb, ¿dpnp ftubt?>b", txt);

		setup2();

		txt = cesar.encrypt("a");
		assertEquals("Z<b", txt);

		txt = cesar.encrypt("A");
		assertEquals("z<b", txt);

		txt = cesar.encrypt("ipmb dpnp ftubt");
		assertEquals("hola como estas<b", txt);

		txt = cesar.encrypt("Ipmb, ¿dpnp ftubt?");
		assertEquals("Hola, ¿como estas?<b", txt);

		setup3();

		txt = cesar.encrypt("a");
		assertEquals("a>Zb", txt);

		txt = cesar.encrypt("z");
		assertEquals("z>Zb", txt);

		txt = cesar.encrypt("Z");
		assertEquals("Z>Zb", txt);

		txt = cesar.encrypt("hola como estas");
		assertEquals("hola como estas>Zb", txt);

		txt = cesar.encrypt("Hola, ¿como estas?");
		assertEquals("Hola, ¿como estas?>Zb", txt);
	}

	@Test
	void decryptTest() {

	}

}
