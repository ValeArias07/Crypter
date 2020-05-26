package thread;

import javafx.application.Platform;
import ui.CrypterGUI;

public class ShapeThread extends Thread{
	private CrypterGUI gui;
	private boolean type;
	private double sum;
	private boolean jump;
	private int color;
	private boolean work;
	
	public ShapeThread(CrypterGUI g, boolean type, boolean work) {
		gui=g;
		this.type=type;
		sum=gui.getX(type);
		jump=false;
		color=0;
		
		this.work = work;
	}
	
	public void run() {
		while(work) {
			if(type) {
				sum=calculateSumUP();
			}else {
				sum=calculateSumDown();
			}
			updateX(sum);
			sleep();
		}
	}
	
	
	public double calculateSumUP() {
		changeColor();
		if(sum<514 && !jump) {
			sum+=10;
		}else {
			if(sum==60) {
				rotate(0);
				jump=false;
			}else {
			rotate(180.0);
			jump=true;
			sum-=10;
			}
		}
		return sum;
	}
	
	public double calculateSumDown() {
			changeColor();
		if(sum>=70 && !jump) {
			sum-=10;
		}else{
			if(sum<=514) {
				rotate(180.0);
				jump=true;
				sum+=10;
			}else {
				rotate(0);
				jump=false;	
			}	
		}
			return sum;
	}
	
	private void sleep() {
		try {
			Thread.sleep(50);
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
		if(color>=6) {
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
	
	public void stopWork() {
		work = false;
	}
}
