package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoutesListTest {

	private RoutesList rl;
	
	void setup1() {
		rl = new RoutesList();
	}
	
	@Test
	void addTest() {
		setup1();
		rl.add("data/encrypt1.txt", true, "hola mundo");
		rl.add("data/encrypt2.txt", true, "hola mundo");
		rl.add("data/encrypt3.txt", true, "hola mundo");
	}

}
