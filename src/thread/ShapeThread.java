package thread;

import javafx.application.Platform;
import ui.CrypterGUI;

public class ShapeThread extends Thread{
	private CrypterGUI gui;
	private boolean type;
	private double sum;
	private boolean stop;
	private int color;
	
	public ShapeThread(CrypterGUI g, boolean type) {
		gui=g;
		this.type=type;
		sum=gui.getX(type);
		stop=false;
		color=0;
	}
	
	public void run() {
		while(true) {
		if(type) {
			sum=calculateSumUP();
		}else {
			sum=calculateSumDown();
		}
		updateX(sum);
		sleep();
		changeColor();
		}
	}
	
	
	public double calculateSumUP() {
		
		if(sum<440 && !stop) {
			sum+=10;
		}else {
			if(sum==-75) {
				rotate(0);
				stop=false;
			}else {
			rotate(180.0);
			stop=true;
			sum-=10;
			}
		}
		return sum;
	}
	
	public double calculateSumDown() {
		
	if(sum>=-45 && !stop) {
		sum-=10;
	}else{
		if(sum<=460) {
			rotate(180.0);
			stop=true;
			sum+=10;
		}else {
			rotate(0);
			stop=false;	
		}	
	}
		return sum;
	}
	
	private void sleep() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private void updateX(double sum) {
		Platform.runLater(new Thread() {
			public void run() {
				gui.updateX(type, sum);
			}
		});
	}
	private void changeColor() {
		if(color>=2) {
			color=0;
		}else {
			color++;
		}
		Platform.runLater(new Thread() {
			public void run () {
				gui.changeColor(type, color);
			}
		});
	}
	
	private void rotate(double value) {
		Platform.runLater(new Thread() {
			public void run () {
				gui.rotate(type, value);
			}
		});
	}
}
