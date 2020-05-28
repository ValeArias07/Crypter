package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@SuppressWarnings("serial")
public class RouteManager implements Serializable {

	public static final String BUBBLE_SORT = "Burble Method";
	public static final String INSERT_SORT = "Insert Method";
	public static final String SELECTION_SORT = "Selection Method";
	public static final String COMPARATOR_SORT = "Comparator Method";
	public static final String COMPARABLE_SORT = "Comparable Method";
	
	public static final String ATTRIBUTE_SORT_1 = "Name";
	public static final String ATTRIBUTE_SORT_2 = "Date";
	
	private int actualNumberEncrypt;
	private int actualNumberDecrypt;
	private String actualSort;
	private String actualAttribute;
	
	private RoutesList routeList;
	
	public RouteManager() {
		routeList= new RoutesList();
		actualNumberDecrypt = 1;
		actualNumberEncrypt = 1;
		actualSort = BUBBLE_SORT;
		actualAttribute = ATTRIBUTE_SORT_1;
	}

	public ArrayList <String> getRoutes(boolean type, String sort, String attribute) throws InterruptedException {
		
		ArrayList<String> routes = routeList.getRoutes(type, null);
		
		actualSort = sort;
		actualAttribute = attribute;
		
		if(routes!=null) {
			if(sort.equals(BUBBLE_SORT)) {
				return burbleSort(routes, type);
			}else if(sort.equals(INSERT_SORT)) {
				return insertSort(routes, type);
			}else if(sort.equals(SELECTION_SORT)) {
				return selectionSort(routes, type);
			}else if(sort.equals(COMPARATOR_SORT)) {
				return comparatorSort(type);
			}else if(sort.equals(COMPARABLE_SORT)) {
				return comparableSort(type);
			}
		}
		return null;
	}
	
	private ArrayList<String> selectionSort(ArrayList<String> sorted, boolean type) {
		
		ArrayList<String> aux = routeList.getRoutes(type, actualAttribute);
		
		for(int i=0; i<sorted.size()-1; i++) {
			String menor = sorted.get(i);
			String menorAux = aux.get(i);
			int cual = i;
			for(int j=i+1; j<sorted.size();j++) {
				if(aux.get(j).compareTo(menorAux)<0) {   
					menorAux = aux.get(j);
					menor = sorted.get(j);
					cual =  j;
				}
			}
			String temp = sorted.get(i);
			String tempAux = aux.get(i);
			
			sorted.set(i, menor);
			aux.set(i, menorAux);
	
			sorted.set(cual, temp);
			aux.set(cual, tempAux);
		}
		
		return sorted;
	}
	
	private ArrayList<String> burbleSort(ArrayList<String> sorted, boolean type) {
		
		ArrayList<String> aux = routeList.getRoutes(type, actualAttribute);
		
		for(int i=sorted.size(); i>0; i--) {
			for(int j=0; j<i-1;j++) {
				if(aux.get(j).compareTo(aux.get(j+1))>0) {//
					String temp = sorted.get(j);
					String tempAux = aux.get(j);
					
					sorted.set(j, sorted.get(j+1));
					sorted.set(j+1, temp);
					
					aux.set(j, aux.get(j+1));
					aux.set(j+1, tempAux);
				}
			}
		}
		
		return sorted;
	}
	
	private ArrayList<String> insertSort(ArrayList<String> sorted, boolean type) {
		
		ArrayList<String> auxList = routeList.getRoutes(type, actualAttribute);
		
		String aux;
		String auxAux;
		
		for(int i = 1; i<sorted.size(); i++) {
			aux = sorted.get(i);
			auxAux = auxList.get(i);
			for(int j = i-1; j>=0 && auxList.get(j).compareTo(auxAux)>0; j--) {
				auxList.set(j+1, auxList.get(j));
				auxList.set(j, auxAux);
				
				sorted.set(j+1, sorted.get(j));
				sorted.set(j, aux);
			}
		}
		return sorted;
	}
	
	private ArrayList<String> comparatorSort(boolean type) {
		ArrayList<RouteNode> aux = routeList.getRoute(type);
		if(actualAttribute.equals(ATTRIBUTE_SORT_1)) {
			Collections.sort(aux, new ComparatorName());
		}else if(actualAttribute.equals(ATTRIBUTE_SORT_2)) {
			Comparator<RouteNode> c = new Comparator<RouteNode>() {
				@Override
				public int compare(RouteNode r1, RouteNode r2) {
					if(r1.getDate().toString().compareTo(r2.getDate().toString())<0)
						return -1;
						
					if(r1.getDate().toString().compareTo(r2.getDate().toString())>0)
						return 1;
						
						return 0;
				}
	        };
	        
			Collections.sort(aux, c);
		}
		
		ArrayList<String> sorted = new ArrayList<String>();
		
		for(int i = 0; i<aux.size(); i++) {
			sorted.add(aux.get(i).toString());
		}
		
		return sorted;
	}
	
	private ArrayList<String> comparableSort(boolean type) {
		ArrayList<RouteNode> aux = routeList.getRoute(type);
		if(actualAttribute.equals(ATTRIBUTE_SORT_1)) {
			Collections.sort(aux, new ComparatorName());
		}else if(actualAttribute.equals(ATTRIBUTE_SORT_2)) {
			Collections.sort(aux);
		}
		
		ArrayList<String> sorted = new ArrayList<String>();
		
		for(int i = 0; i<aux.size(); i++) {
			sorted.add(aux.get(i).toString());
		}
		
		return sorted;
	}
	
	public String searchRoute(String data){
		return routeList.search(routeList.searchRoute(data));
	}
	
	public void addRoute(String route, boolean type, String text) throws IOException {		
		try {
			String name;
			String aux[] = route.split("\\\\");
			
			if(type) {
				name = aux[aux.length-1].split("\\.")[0] + "-Encrypt.txt";
			}else {
				name = aux[aux.length-1].split("\\.")[0] + "-Decrypt.txt";
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
	
	public void deleteRoute(String data) {
		
		File file = new File(routeList.searchRoute(data));
		routeList.delete(routeList.searchRoute(data));
		
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
	
	public String getActualSort() {
		return actualSort;
	}
	
	public String getActualAttribute() {
		return actualAttribute;
	}
}
