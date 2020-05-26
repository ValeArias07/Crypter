package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class RouteManager{

	private int actualNumberEncrypt;
	private int actualNumberDecrypt;

	private RoutesList routeList;
	
	public RouteManager() {
		routeList= new RoutesList();
		actualNumberDecrypt = 1;
		actualNumberEncrypt = 1;
	}

	public ArrayList <String> getRoutes(boolean type) throws InterruptedException {
			return routeList.getRoutes(type);	
	}
	
	public String searchRoute(String route){
		return routeList.search(route);
	}
	
	public void addRoute(String route, boolean type, String text) throws IOException {		
		try {
			String name;
			String aux[] = route.split("\\\\");
			
			if(type) {
				name = "Encrypt-" + aux[aux.length-1];
				actualNumberEncrypt++;
			}else {
				name = "Decrypt-"+ aux[aux.length-1];
				actualNumberDecrypt++;
			}
			
			File file = new File("data/"+name);
			
			if(!file.exists()) {
				file.createNewFile();
			}
			
			PrintWriter pr = new PrintWriter(file);
			
			pr.println(text);
			
			pr.close();
			
			routeList.add("data/"+name, type, text);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void addRoute(boolean type, String text) throws IOException {
		try {
			String name;
			if(type) {
				name = "Encrypt"+actualNumberEncrypt;
				actualNumberEncrypt++;
			}else {
				name = "Decrypt"+actualNumberDecrypt;
				actualNumberDecrypt++;
			}
			
			File file = new File("data/"+name+".txt");
			
			if(!file.exists()) {
				file.createNewFile();
			}
			
			PrintWriter pr = new PrintWriter(file);
			
			pr.println(text);
			
			pr.close();
			routeList.add("data/"+name+".txt", type, text);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteRoute(String route) {
		routeList.delete(route);
		
		File file = new File(route);
		
		if(file.exists()) {
			file.delete();
		}
	}

	public String readRoute(String route) {
		try {
			FileReader fl = new FileReader(route);
			BufferedReader br = new BufferedReader(fl);
			String re = br.readLine();
			br.close();
			
			return re;
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException io) {
			System.out.println(io.getMessage());
		}
		
		return null;
	}
}
