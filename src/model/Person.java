package model;

public class Person {
	
	private int position;
	private boolean move;
	
	public Person() {
		position=0;
		move=true;
	}
	
	public void advance() {
		if(position>=6) {
			position=0;
		}else {
			position++;
		}
	}
	
	public void stop() {
		move=false;
	}
	
	public boolean getMove() {
		return move;
	}
	
	public int getSteps() {
		return position;
	}

}
