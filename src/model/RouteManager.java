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
	
	public String searchRoute(String route,  boolean type){
		return routeList.search(route);
	}
	
	public void addRoute(String route, String text, boolean type) {
		routeList.add(route, type, text);
	}
	
	public RouteNode deleteRoute(String route, boolean type) {
		return routeList.delete(route);
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
	
	public void writeRoute(String text, boolean type) throws IOException{
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
			
			addRoute("data/"+name+".txt", text, type);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
