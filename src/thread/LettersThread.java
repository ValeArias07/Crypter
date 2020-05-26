package thread;

import javafx.application.Platform;
import ui.CrypterGUI;


public class LettersThread extends Thread {
	private CrypterGUI gui;
	private boolean type;
	private double sum;
	private boolean stop;
	private int value;
	private boolean stopLetter;
	private boolean work;
	
	public LettersThread(CrypterGUI g, boolean type, boolean work) {
		gui=g;
		this.type=type;
		sum=gui.getXLetters(type);
		stop=false;
		value=(type)?0:25;
		stopLetter=false;
		
		this.work = work;
	}
	
	public void run() {
		while(work) {
			if(type) {
				sum=calculateSumA();
				value=calculateContentA();
			}else {
				sum=calculateSumB();
				value=calculateContentB();
			}
			updateXLetter(sum);
			updateContent(value);
			sleep();
		}
	}
	public double calculateSumA() {
		
		if(sum<503 && !stop) {
			sum+=10;
		}else {
			if(sum<=14) {
				stop=false;
			}else {
				stop=true;
				sum-=10;
			}
		}
		return sum;
	}
	
	public double calculateSumB() {
	
	if(sum>14 && !stop) {
		sum-=10;
	}else {
		if(sum>=503) {
			stop=false;
		}else {
			stop=true;
			sum+=10;
		}			
	}
		return sum;
	}
	
	
	public int calculateContentA() {
	if(value<=24 && !stopLetter) {
		value++;
	}else {
		if(value==0) 
			stopLetter=false;
		else {
			stopLetter=true;
			value--;
		}
	}
	return value;
	}
	
	public int calculateContentB() {
		if(value>0 && !stopLetter) {
			value--;
		}else{
			if(value>=24) {
				stopLetter=false;
			}else {
				stopLetter=true;
				value++;
			}
		}
		return value;
	}
	
	private void sleep() {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void updateContent(int value) {
		Platform.runLater(new Thread() {
			public void run() {
				gui.updateContent(type, value);
			}
		});
	}
	private void updateXLetter(double sum) {
		Platform.runLater(new Thread() {
			public void run() {
				gui.updateXLetters(type, sum);
			}
		});
	}
	
	public void stopWork() {
		work = false;
	}
}
