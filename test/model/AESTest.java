package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AESTest {
	
	private AES aes;
	
	private void setup1() {
		aes = new AES("" ,"");
	}
	
	@Test
	void encryptTest() {
		setup1();
	}
	
	@Test
	void decryptTest() {
		setup1();
	}
	
	@Test
	void subBytesTest() {
		setup1();
	}
	
	@Test
	void shiftRowsTest() {
		setup1();
	}
	
	@Test
	void mixColumsTest() {
		setup1();
	}
	
	@Test
	void addRoundKeyTest() {
		setup1();
	}

}
