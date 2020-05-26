package thread;

import javafx.application.Platform;
import model.Person;
import ui.CrypterGUI;

public class PersonAnimationThread extends Thread {
	
	private CrypterGUI gui;
	private Person person;

	
	public PersonAnimationThread(CrypterGUI crypterGUI, Person person) {
		gui=crypterGUI;
		this.person=person;
	}
	
	public void run() {
		while(person.getMove()) {
			person.advance();
			sentMoves(person.getSteps());	
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void sentMoves(int steps) {
		Platform.runLater(new Thread() {
			public void run() {
				gui.updateImage(steps);
			}
		});
	}

}
