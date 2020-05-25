package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoutesListTest {

	private RoutesList rl;
	
	void setup1() {
		rl = new RoutesList();
	}
	
	void setup2() {
		rl = new RoutesList();
		
		rl.add("data/encrypt1.txt", true, "hola mundo");
		rl.add("data/encrypt2.txt", true, "chao mundo");
		rl.add("data/encrypt3.txt", true, "punto");
		rl.add("data/decrypt1.txt", false, "hola mundo");
		rl.add("data/decrypt2.txt", false, "chao mundo");
		rl.add("data/decrypt3.txt", false, "punto");
	}
	
	@Test
	void addTest() {
		setup1();
		rl.add("data/encrypt1.txt", true, "hola mundo");
		rl.add("data/encrypt2.txt", true, "chao mundo");
		rl.add("data/encrypt3.txt", true, "punto");
		rl.add("data/decrypt1.txt", false, "hola mundo");
		rl.add("data/decrypt2.txt", false, "chao mundo");
		rl.add("data/decrypt3.txt", false, "punto");
		
		RouteNode aux = rl.getFirst();
		assertEquals("data/encrypt1.txt", aux.getRoute());
		assertEquals(true, aux.getType());
		assertEquals("hola mundo", aux.getText());
		
		aux = aux.getNext();
		assertEquals("data/encrypt2.txt", aux.getRoute());
		assertEquals(true, aux.getType());
		assertEquals("chao mundo", aux.getText());
		
		aux = aux.getNext();
		assertEquals("data/encrypt3.txt", aux.getRoute());
		assertEquals(true, aux.getType());
		assertEquals("punto", aux.getText());
		
		aux = aux.getNext();
		assertEquals("data/decrypt1.txt", aux.getRoute());
		assertEquals(false, aux.getType());
		assertEquals("hola mundo", aux.getText());
		
		aux = aux.getNext();
		assertEquals("data/decrypt2.txt", aux.getRoute());
		assertEquals(false, aux.getType());
		assertEquals("chao mundo", aux.getText());
		
		aux = aux.getNext();
		assertEquals("data/decrypt3.txt", aux.getRoute());
		assertEquals(false, aux.getType());
		assertEquals("punto", aux.getText());
	}
	
	@Test
	void searchTest() {
		setup2();
		String aux;
		
		aux = rl.search("data/encrypt1.txt");
		assertEquals("hola mundo", aux);
		
		aux = rl.search("data/encrypt2.txt");
		assertEquals("chao mundo", aux);
		
		aux = rl.search("data/encrypt3.txt");
		assertEquals("punto", aux);
		
		aux = rl.search("data/decrypt1.txt");
		assertEquals("hola mundo", aux);
		
		aux = rl.search("data/decrypt2.txt");
		assertEquals("chao mundo", aux);
		
		aux = rl.search("data/decrypt3.txt");
		assertEquals("punto", aux);
		
		aux = rl.search("data/decrypt4.txt");
		assertEquals(null, aux);
	}
	
	@Test
	void deleteTest() {
		setup2();
		
		RouteNode aux;
		
		rl.delete("data/encrypt1.txt");
		aux = rl.getFirst();
		assertEquals("chao mundo", aux.getText());
		assertEquals(null, aux.getPrev());
		
		rl.delete("data/encrypt3.txt");
		aux = rl.getFirst();
		aux = aux.getNext();
		assertEquals("hola mundo", aux.getText());
		
		rl.delete("data/decrypt3.txt");
		aux = rl.getFirst();
		aux = aux.getNext();
		aux = aux.getNext();
		assertEquals("chao mundo", aux.getText());
		assertEquals(null, aux.getNext());
	}
}
